package ChanningBabb_SharedLogger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    // database final variables
    // credentials and database url
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/favorite_students";
    private static final String JDBC_USER = "jbaarsch";
    private static final String JDBC_PASSWORD = "adrianna-naya-channing123";

    // Singleton instance
    private static Database instance;

    // Database connection
    private Connection connection;

    // constructor is private to prevent direct instantiation
    private Database() {
        try {
            // load the driver for MySQL
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        } catch (SQLException e) { // if the connection fails, throw a runtime exception
            e.printStackTrace();
            throw new RuntimeException("Failed to connect to the database");
        }
    }

    // Get the Singleton instance
    public static synchronized Database getInstance() {
        if (instance == null) {
            instance = new Database(); // instance is only created if it doesn't exist
        }
        return instance; // return if it does exist
    }

    // return the connection
    public Connection getConnection() {
        return connection;
    }
}
