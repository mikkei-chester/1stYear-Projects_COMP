
package DBC;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.SQLException;


// ============================================================
// DatabaseConnection.java
// ============================================================

//public class DatabaseConnection {
//
//    private static final String URL      = "jdbc:mysql://localhost:3306/banking_system";
//    private static final String USER     = "root";
//    private static final String PASSWORD = "";
//
//    private static Connection connection = null;
//
//    private DatabaseConnection() {}
//
//    public static Connection getConnection() {
//        try {
//            if (connection == null || connection.isClosed() || !connection.isValid(2)) {
//                Class.forName("com.mysql.cj.jdbc.Driver");
//                connection = DriverManager.getConnection(URL, USER, PASSWORD);
//                System.out.println("[DBC] Connection opened.");
//            }
//        } catch (ClassNotFoundException e) {
//            System.err.println("[DBC] Driver not found: " + e.getMessage());
//        } catch (SQLException e) {
//            System.err.println("[DBC] Connection error: " + e.getMessage());
//        }
//        return connection;
//    }
//
//    public static void closeConnection() {
//        try {
//            if (connection != null && !connection.isClosed()) {
//                connection.close();
//                System.out.println("[DBC] Connection closed.");
//            }
//        } catch (SQLException e) {
//            System.err.println("[DBC] Error closing connection: " + e.getMessage());
//        }
//    }
//}



// ============================================================
// DatabaseConnection.java
// ============================================================

public class DatabaseConnection {

    private static final String URL      = "jdbc:mysql://localhost:3306/banking_system";
    private static final String USER     = "root";
    private static final String PASSWORD = "";

    private static Connection connection = null;

    private DatabaseConnection() {}

    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed() || !connection.isValid(2)) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("[DBC] Connection opened.");
            }
        } catch (ClassNotFoundException e) {
            System.err.println("[DBC] Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("[DBC] Connection error: " + e.getMessage());
        }
        return connection;
    }

    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("[DBC] Connection closed.");
            }
        } catch (SQLException e) {
            System.err.println("[DBC] Error closing connection: " + e.getMessage());
        }
    }
}