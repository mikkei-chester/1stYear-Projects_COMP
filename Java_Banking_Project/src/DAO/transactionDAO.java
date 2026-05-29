package DAO;


import Objects.transaction;
import Objects.userWallet;
import DBC.DatabaseConnection;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class transactionDAO {

    private Connection conn() {
        return DatabaseConnection.getConnection();
    }

    // ----------------------------------------------------------
    // READ BALANCE
    // ----------------------------------------------------------
    public userWallet readBalance(long uid) {
        String sql = "SELECT * FROM users_wallet WHERE ID = ?";
        try {
            PreparedStatement ps = conn().prepareStatement(sql);
            ps.setLong(1, uid);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new userWallet(
                    rs.getLong      ("ID"),
                    rs.getBigDecimal("REGULARWALLET"),
                    rs.getBigDecimal("SAVINGSWALLET")
                );
            }
        } catch (SQLException e) {
            System.err.println("[TransactionDAO] readBalance error: " + e.getMessage());
        }
        return null;
    }
    
    
    public transaction showBalance(long uid) {
        String sql = "SELECT * FROM transaction_history WHERE ID = ?";
        try (PreparedStatement ps = conn().prepareStatement(sql)) {
            ps.setLong(1, uid);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new transaction(
                        rs.getBigDecimal("AMOUNT"),
                        rs.getBigDecimal("BALANCE")
                    );
                }
            }
        } catch (SQLException e) {
            System.err.println("[TransactionDAO] showBalance error: " + e.getMessage());
        }
        return null;
    }

    // ----------------------------------------------------------
    // READ TRANSACTION HISTORY
    // ----------------------------------------------------------
    public List<transaction> readBalHistory(long uid) {
        List<transaction> list = new ArrayList<>();
        String sql = "SELECT t.* FROM transaction_history t " +
                     "JOIN users_account_data a ON a.USERNAME = t.SENDER OR a.USERNAME = t.RECEIVER " +
                     "WHERE a.ID = ? ORDER BY t.DATETIME DESC";
        try {
            PreparedStatement ps = conn().prepareStatement(sql);
            ps.setLong(1, uid);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(mapTransaction(rs));
            }
        } catch (SQLException e) {
            System.err.println("[TransactionDAO] readBalHistory error: " + e.getMessage());
        }
        return list;
    }

    
    // WITHDRAW — REGULAR WALLET
    public boolean withdrawRegWallet(long uid, BigDecimal amount) {
        String updateWallet = "UPDATE users_wallet SET REGULARWALLET = REGULARWALLET - ? WHERE ID = ?";
        String insertLog    = "INSERT INTO transaction_history" +
                              " (ID, DATETIME, BALANCE, AMOUNT, SENDER, RECEIVER) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            conn().setAutoCommit(false);

            PreparedStatement psW = conn().prepareStatement(updateWallet);
            psW.setBigDecimal(1, amount); psW.setLong(2, uid); psW.executeUpdate();

            BigDecimal newBalance = readBalance(uid).getRegularWallet();
            String username = getUsernameById(uid);

            PreparedStatement psL = conn().prepareStatement(insertLog);
            psL.setLong(1, uid);
            psL.setTimestamp (2, new Timestamp(System.currentTimeMillis()));
            psL.setBigDecimal(3, newBalance);
            psL.setBigDecimal(4, amount);
            psL.setString    (5, username);
            psL.setString    (6, "WITHDRAW");
            psL.executeUpdate();

            conn().commit();
            return true;
        } catch (SQLException e) {
            System.err.println("[TransactionDAO] withdrawRegWallet error: " + e.getMessage());
            try { conn().rollback(); } catch (SQLException ex) { ex.printStackTrace(); }
            return false;
        } finally {
            try { conn().setAutoCommit(true); } catch (SQLException ignored) {}
        }
    }
    
    
    // TRANSFER REGULAR → SAVINGS (same account)
    public boolean transferToSavings(long uid, BigDecimal amount) {
        String debit  = "UPDATE users_wallet SET REGULARWALLET = REGULARWALLET - ? WHERE ID = ?";
        String credit = "UPDATE users_wallet SET SAVINGSWALLET = SAVINGSWALLET + ? WHERE ID = ?";
        String log    = "INSERT INTO transaction_history" +
                        " (ID, DATETIME, BALANCE, AMOUNT, SENDER, RECEIVER) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            conn().setAutoCommit(false);

            PreparedStatement psD = conn().prepareStatement(debit);
            psD.setBigDecimal(1, amount); psD.setLong(2, uid); psD.executeUpdate();

            PreparedStatement psC = conn().prepareStatement(credit);
            psC.setBigDecimal(1, amount); psC.setLong(2, uid); psC.executeUpdate();

            BigDecimal newBal = readBalance(uid).getRegularWallet();
            String username = getUsernameById(uid);

            PreparedStatement psL = conn().prepareStatement(log);
            
            psL.setLong(1, uid);
            psL.setTimestamp (2, new Timestamp(System.currentTimeMillis()));
            psL.setBigDecimal(3, newBal);
            psL.setBigDecimal(4, amount);
            psL.setString    (5, username);
            psL.setString    (6, "TRANSFER_TO_SAVINGS");
            psL.executeUpdate();

            conn().commit();
            return true;
        } catch (SQLException e) {
            System.err.println("[TransactionDAO] transferToSavings error: " + e.getMessage());
            try { conn().rollback(); } catch (SQLException ex) { ex.printStackTrace(); }
            return false;
        } finally {
            try { conn().setAutoCommit(true); } catch (SQLException ignored) {}
        }
    }
    
    
    // ----------------------------------------------------------
    // DEPOSIT — REGULAR WALLET
    // ----------------------------------------------------------
    public boolean depositRegWallet(long uid, BigDecimal amount) {
        String updateWallet = "UPDATE users_wallet SET REGULARWALLET = REGULARWALLET + ? WHERE ID = ?";
        String insertLog    = "INSERT INTO transaction_history " +
                              "(ID, DATETIME, BALANCE, AMOUNT, SENDER, RECEIVER) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            conn().setAutoCommit(false);

            PreparedStatement psW = conn().prepareStatement(updateWallet);
            psW.setBigDecimal(1, amount);
            psW.setLong      (2, uid);
            psW.executeUpdate();

            BigDecimal newBalance = readBalance(uid).getRegularWallet();
            String     username   = getUsernameById(uid);

            PreparedStatement psL = conn().prepareStatement(insertLog);
            psL.setLong(1, uid);
            psL.setTimestamp (2, new Timestamp(System.currentTimeMillis()));
            psL.setBigDecimal(3, newBalance);
            psL.setBigDecimal(4, amount);
            psL.setString    (5, username);
            psL.setString    (6, "DEPOSIT");
            psL.executeUpdate();

            conn().commit();
            return true;

        } catch (SQLException e) {
            System.err.println("[TransactionDAO] depositRegWallet error: " + e.getMessage());
            try { conn().rollback(); } catch (SQLException ex) { ex.printStackTrace(); }
            return false;
        } finally {
            try { conn().setAutoCommit(true); } catch (SQLException ignored) {}
        }
    }

    // ----------------------------------------------------------
    // DEPOSIT — SAVINGS WALLET
    // ----------------------------------------------------------
    public boolean depositSavWallet(long uid, BigDecimal amount) {
        String updateWallet = "UPDATE users_wallet SET SAVINGSWALLET = SAVINGSWALLET + ? WHERE ID = ?";
        String insertLog    = "INSERT INTO transaction_history " +
                              "(ID, DATETIME, BALANCE, AMOUNT, SENDER, RECEIVER) VALUES (?, ?, ?, ?, ?)";
        try {
            conn().setAutoCommit(false);

            PreparedStatement psW = conn().prepareStatement(updateWallet);
            psW.setBigDecimal(1, amount);
            psW.setLong      (2, uid);
            psW.executeUpdate();

            BigDecimal newBalance = readBalance(uid).getSavingsWallet();
            String     username   = getUsernameById(uid);

            PreparedStatement psL = conn().prepareStatement(insertLog);
            psL.setLong(1, uid);
            psL.setTimestamp (2, new Timestamp(System.currentTimeMillis()));
            psL.setBigDecimal(3, newBalance);
            psL.setBigDecimal(4, amount);
            psL.setString    (5, username);
            psL.setString    (6, "DEPOSIT_SAVINGS");
            psL.executeUpdate();

            conn().commit();
            return true;

        } catch (SQLException e) {
            System.err.println("[TransactionDAO] depositSavWallet error: " + e.getMessage());
            try { conn().rollback(); } catch (SQLException ex) { ex.printStackTrace(); }
            return false;
        } finally {
            try { conn().setAutoCommit(true); } catch (SQLException ignored) {}
        }
    }

    // ----------------------------------------------------------
    // TRANSFER FUNDS (sender REGULAR → receiver REGULAR)
    // ----------------------------------------------------------
    public boolean transferFunds(long senderUid, String receiverUsername, BigDecimal amount) {
        String checkBalance  = "SELECT REGULARWALLET FROM users_wallet WHERE ID = ?";
        String debitSender   = "UPDATE users_wallet SET REGULARWALLET = REGULARWALLET - ? WHERE ID = ?";
        String creditReceiver= "UPDATE users_wallet SET REGULARWALLET = REGULARWALLET + ? " +
                               "WHERE ID = (SELECT ID FROM users_account_data WHERE USERNAME = ?)";
        String insertLog     = "INSERT INTO transaction_history " +
                               "(ID, DATETIME, BALANCE, AMOUNT, SENDER, RECEIVER) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            conn().setAutoCommit(false);

            // 1. Check sufficient balance
            PreparedStatement psCheck = conn().prepareStatement(checkBalance);
            psCheck.setLong(1, senderUid);
            ResultSet rs = psCheck.executeQuery();
            if (!rs.next() || rs.getBigDecimal("REGULARWALLET").compareTo(amount) < 0) {
                conn().rollback();
                return false;
            }

            String senderUsername = getUsernameById(senderUid);

            // 2. Debit sender
            PreparedStatement psDebit = conn().prepareStatement(debitSender);
            psDebit.setBigDecimal(1, amount);
            psDebit.setLong      (2, senderUid);
            psDebit.executeUpdate();

            // 3. Credit receiver
            PreparedStatement psCredit = conn().prepareStatement(creditReceiver);
            psCredit.setBigDecimal(1, amount);
            psCredit.setString   (2, receiverUsername);
            psCredit.executeUpdate();

            // 4. Log transaction
            BigDecimal senderBalance = readBalance(senderUid).getRegularWallet();

            PreparedStatement psLog = conn().prepareStatement(insertLog);
            psLog.setLong(1, senderUid);  
            psLog.setTimestamp (2, new Timestamp(System.currentTimeMillis()));
            psLog.setBigDecimal(3, senderBalance);
            psLog.setBigDecimal(4, amount);
            psLog.setString    (5, senderUsername);
            psLog.setString    (6, receiverUsername);
            psLog.executeUpdate();

            conn().commit();
            return true;

        } catch (SQLException e) {
            System.err.println("[TransactionDAO] transferFunds error: " + e.getMessage());
            try { conn().rollback(); } catch (SQLException ex) { ex.printStackTrace(); }
            return false;
        } finally {
            try { conn().setAutoCommit(true); } catch (SQLException ignored) {}
        }
    }
    
    
    

    // ----------------------------------------------------------
    // INTERNAL HELPERS
    // ----------------------------------------------------------
    private String getUsernameById(long uid) {
        String sql = "SELECT USERNAME FROM users_account_data WHERE ID = ?";
        try {
            PreparedStatement ps = conn().prepareStatement(sql);
            ps.setLong(1, uid);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return rs.getString("USERNAME");
        } catch (SQLException e) {
            System.err.println("[TransactionDAO] getUsernameById error: " + e.getMessage());
        }
        return "UNKNOWN";
    }

    private transaction mapTransaction(ResultSet rs) throws SQLException {
        transaction t = new transaction();
        t.setTransactId(rs.getLong      ("TRANSACTIONID"));
        t.setDateTime  (rs.getTimestamp ("DATETIME"));
        t.setAmount    (rs.getBigDecimal("AMOUNT"));
        t.setBalance   (rs.getBigDecimal("BALANCE"));
        t.setSender    (rs.getString    ("SENDER"));
        t.setReceiver  (rs.getString    ("RECEIVER"));
        return t;
    }
}