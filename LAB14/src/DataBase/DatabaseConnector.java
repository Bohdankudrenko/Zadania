package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnector {

    private static final String DB_URL = "jdbc:sqlite:bankdb.sql";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }

    public static void initializeDatabase() {
        String sqlUser = "CREATE TABLE users ("
                + " id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + " login VARCHAR(50) UNIQUE NOT NULL,"
                + " pin VARCHAR(255) NOT NULL,"
                + " role ENUM('ADMIN', 'USER') NOT NULL,"
                + " balance DECIMAL(15,2) DEFAULT 0.0"
                + ");";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {

            stmt.execute(sqlUser);
            System.out.println("Database has been initialized successfully.");

        } catch (SQLException e) {
            System.err.println("Critical error during database initialization: " + e.getMessage());
            System.exit(1);
        }
    }
}
