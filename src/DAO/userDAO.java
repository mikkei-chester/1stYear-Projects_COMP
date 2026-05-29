package DAO;

import Objects.user;
import DBC.DatabaseConnection;

import java.math.BigDecimal;
import java.sql.*;

public class userDAO {

    private Connection conn() {
        return DatabaseConnection.getConnection();
    }

    // TABLE NAME — use ONE consistent name throughout
    private static final String TABLE = "users_account_data";

    public boolean createUser(user user, BigDecimal initialDeposit) {
        String insertUser   = "INSERT INTO " + TABLE +
                              " (FIRSTNAME, MIDDLENAME, SURNAME, AGE, GENDER, BIRTHDATE," +
                              " CONTACTNUM, USERNAME, PASSWORD, PIN)" +
                              " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        String insertWallet = "INSERT INTO users_wallet (ID, REGULARWALLET, SAVINGSWALLET)" +
                              " VALUES (?, ?, 0.00)";
        try {
            conn().setAutoCommit(false);

            PreparedStatement psUser = conn().prepareStatement(
                    insertUser, Statement.RETURN_GENERATED_KEYS);
            psUser.setString(1, user.getFname());
            psUser.setString(2, user.getMname());
            psUser.setString(3, user.getLname());
            psUser.setInt   (4, user.getAge());
            psUser.setString(5, user.getGender());
            psUser.setDate  (6, user.getDateCreated());
            psUser.setString(7, user.getContactNum());
            psUser.setString(8, user.getUsername());
            psUser.setString(9, user.getPassword());
            psUser.setString(10, user.getPin());
            psUser.executeUpdate();

            ResultSet keys = psUser.getGeneratedKeys();
            if (!keys.next()) { conn().rollback(); return false; }
            long newId = keys.getLong(1);

            PreparedStatement psWallet = conn().prepareStatement(insertWallet);
            psWallet.setLong      (1, newId);
            psWallet.setBigDecimal(2, initialDeposit);
            psWallet.executeUpdate();

            conn().commit();
            return true;

        } catch (SQLException e) {
            System.err.println("[UserDAO] createUser error: " + e.getMessage());
            try { conn().rollback(); } catch (SQLException ex) { ex.printStackTrace(); }
            return false;
        } finally {
            try { conn().setAutoCommit(true); } catch (SQLException ignored) {}
        }
    }

    public user confirmLogin(String username, String password) {
        String sql = "SELECT * FROM " + TABLE + " WHERE USERNAME = ? AND PASSWORD = ?";
        try {
            PreparedStatement ps = conn().prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return mapUser(rs);
        } catch (SQLException e) {
            System.err.println("[UserDAO] confirmLogin error: " + e.getMessage());
        }
        return null;
    }

    public user viewDetails(long uid) {
        String sql = "SELECT * FROM " + TABLE + " WHERE ID = ?";
        try {
            PreparedStatement ps = conn().prepareStatement(sql);
            ps.setLong(1, uid);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return mapUser(rs);
        } catch (SQLException e) {
            System.err.println("[UserDAO] viewDetails error: " + e.getMessage());
        }
        return null;
    }

    // Returns the account ID for a given username, -1 if not found
    public long getIdByUsername(String username) {
        String sql = "SELECT ID FROM " + TABLE + " WHERE USERNAME = ?";
        try {
            PreparedStatement ps = conn().prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return rs.getLong("ID");
        } catch (SQLException e) {
            System.err.println("[UserDAO] getIdByUsername error: " + e.getMessage());
        }
        return -1;
    }

    public boolean deleteAccount(long uid) {
        String deleteWallet = "DELETE FROM users_wallet WHERE ID = ?";
        String deleteUser   = "DELETE FROM " + TABLE + " WHERE ID = ?";
        try {
            conn().setAutoCommit(false);
            PreparedStatement psW = conn().prepareStatement(deleteWallet);
            psW.setLong(1, uid); psW.executeUpdate();
            PreparedStatement psU = conn().prepareStatement(deleteUser);
            psU.setLong(1, uid); psU.executeUpdate();
            conn().commit();
            return true;
        } catch (SQLException e) {
            System.err.println("[UserDAO] deleteAccount error: " + e.getMessage());
            try { conn().rollback(); } catch (SQLException ex) { ex.printStackTrace(); }
            return false;
        } finally {
            try { conn().setAutoCommit(true); } catch (SQLException ignored) {}
        }
    }

    public boolean verifyPin(long uid, String pin) {
        String sql = "SELECT ID FROM " + TABLE + " WHERE ID = ? AND PIN = ?";
        try {
            PreparedStatement ps = conn().prepareStatement(sql);
            ps.setLong(1, uid); ps.setString(2, pin);
            return ps.executeQuery().next();
        } catch (SQLException e) {
            System.err.println("[UserDAO] verifyPin error: " + e.getMessage());
        }
        return false;
    }

    // Returns true if username is AVAILABLE (not taken)
    public static boolean usernameConfirmation(String username) {
        try {
            String sql = "SELECT ID FROM users_account_data WHERE USERNAME = ?";
            PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(sql);
            ps.setString(1, username);
            return !ps.executeQuery().next(); // true = not found = available
        } catch (Exception e) { e.printStackTrace(); }
        return false;
    }

    // Returns true if contact number is ALREADY TAKEN
    public static boolean contactNumConfirmation(String contactNum) {
        try {
            String sql = "SELECT ID FROM users_account_data WHERE CONTACTNUM = ?";
            PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(sql);
            ps.setString(1, contactNum);
            return ps.executeQuery().next(); // true = exists
        } catch (Exception e) { e.printStackTrace(); }
        return false;
    }

    
    public String getContactByUid(long uid) {
        String sql = "SELECT CONTACTNUM FROM users_account_data WHERE ID = ?";
        try {
            PreparedStatement ps = conn().prepareStatement(sql);
            ps.setLong(1, uid);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return rs.getString("CONTACTNUM");
        } catch (SQLException e) {
            System.err.println("[UserDAO] getContactByUid error: " + e.getMessage());
        }
        return "";
    }
    
    
    public String getContactByUsername(String username) {
        String sql = "SELECT CONTACTNUM FROM users_account_data WHERE USERNAME = ?";
        try {
            PreparedStatement ps = conn().prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return rs.getString("CONTACTNUM");
        } catch (SQLException e) {
            System.err.println("[UserDAO] getContactByUsername error: " + e.getMessage());
        }
        return "";
    }
    
    
    public String getUsernameByUid(long uid) {
    String sql = "SELECT USERNAME FROM users_account_data WHERE ID = ?";
    try {
        PreparedStatement ps = conn().prepareStatement(sql);
        ps.setLong(1, uid);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) return rs.getString("USERNAME");
    } catch (SQLException e) {
        System.err.println("[UserDAO] getUsernameByUid error: " + e.getMessage());
    }
    return "";
}
    
    // FIXED: now sets id
    private user mapUser(ResultSet rs) throws SQLException {
        user u = new user();
        u.setId        (rs.getLong  ("ID"));          // <-- was missing
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
        return u;
    }
}