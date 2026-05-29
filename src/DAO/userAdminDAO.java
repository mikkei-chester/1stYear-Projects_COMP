package DAO;
import DBC.*;
import Objects.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class userAdminDAO {

    private Connection conn() {
        return DatabaseConnection.getConnection();
    }

    public List<user> readAllUsers() {
        List<user> list = new ArrayList<>();
        String sql = "SELECT * FROM users_account_data ORDER BY ID ASC";
        try {
            PreparedStatement ps = conn().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                user u = new user();
                u.setId        (rs.getLong  ("ID"));
                u.setFname     (rs.getString("FIRSTNAME"));
                u.setMname     (rs.getString("MIDDLENAME"));
                u.setLname     (rs.getString("SURNAME"));
                u.setAge       (rs.getInt   ("AGE"));
                u.setGender    (rs.getString("GENDER"));
                u.setDateCreated(rs.getDate ("BIRTHDATE"));
                u.setContactNum(rs.getString("CONTACTNUM"));
                u.setUsername  (rs.getString("USERNAME"));
                u.setPassword  (rs.getString("PASSWORD"));
                u.setPin       (rs.getString("PIN"));
                list.add(u);
            }
        } catch (SQLException e) {
            System.err.println("[UserAdminDAO] readAllUsers error: " + e.getMessage());
        }
        return list;
    }

    public List<transaction> readUserHistory(long uid) {
        List<transaction> list = new ArrayList<>();
        String sql = "SELECT t.* FROM transaction_history t " +
                     "JOIN users_account_data a ON a.USERNAME = t.SENDER OR a.USERNAME = t.RECEIVER " +
                     "WHERE a.ID = ? ORDER BY t.DATETIME DESC";
        try {
            PreparedStatement ps = conn().prepareStatement(sql);
            ps.setLong(1, uid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) list.add(mapTransaction(rs));
        } catch (SQLException e) {
            System.err.println("[UserAdminDAO] readUserHistory error: " + e.getMessage());
        }
        return list;
    }

    public List<transaction> getAllTransactions() {
        List<transaction> list = new ArrayList<>();
        String sql = "SELECT * FROM transaction_history ORDER BY DATETIME DESC";
        try {
            PreparedStatement ps = conn().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) list.add(mapTransaction(rs));
        } catch (SQLException e) {
            System.err.println("[UserAdminDAO] getAllTransactions error: " + e.getMessage());
        }
        return list;
    }

    public boolean validateAdmin(String username, String password) {
        String sql = "SELECT USERNAME FROM admin_account_data WHERE USERNAME = ? AND PASSWORD = ?";
        try {
            PreparedStatement ps = conn().prepareStatement(sql);
            ps.setString(1, username); ps.setString(2, password);
            return ps.executeQuery().next();
        } catch (SQLException e) {
            System.err.println("[UserAdminDAO] validateAdmin error: " + e.getMessage());
        }
        return false;
    }

    public boolean createAdmin(String username, String password) {
        String sql = "INSERT INTO admin_account_data (USERNAME, PASSWORD) VALUES (?, ?)";
        try {
            PreparedStatement ps = conn().prepareStatement(sql);
            ps.setString(1, username); ps.setString(2, password);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("[UserAdminDAO] createAdmin error: " + e.getMessage());
        }
        return false;
    }

    public Long getIdByUsername(String username) {
        String sql = "SELECT ID FROM users_account_data WHERE USERNAME = ?";
        try {
            PreparedStatement ps = conn().prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return rs.getLong("ID");
        } catch (SQLException e) {
            System.err.println("[UserAdminDAO] getIdByUsername error: " + e.getMessage());
        }
        return null;
    }


    public boolean updateUser(String oldUsername, String newUsername, String newPassword) {
        if (newUsername.isEmpty() && newPassword.isEmpty()) return false;
        StringBuilder sql = new StringBuilder("UPDATE users_account_data SET ");
        List<String> parts = new ArrayList<>();
        if (!newUsername.isEmpty()) parts.add("USERNAME = ?");
        if (!newPassword.isEmpty()) parts.add("PASSWORD = ?");
        sql.append(String.join(", ", parts)).append(" WHERE USERNAME = ?");
        try {
            PreparedStatement ps = conn().prepareStatement(sql.toString());
            int i = 1;
            if (!newUsername.isEmpty()) ps.setString(i++, newUsername);
            if (!newPassword.isEmpty()) ps.setString(i++, newPassword);
            ps.setString(i, oldUsername);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("[UserAdminDAO] updateUser error: " + e.getMessage());
        }
        return false;
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