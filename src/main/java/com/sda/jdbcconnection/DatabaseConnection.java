package com.sda.jdbcconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static com.sda.jdbcconnection.ConnectionDetails.*;

public class DatabaseConnection {
    private Connection connection;
    private boolean isConnected;

    public DatabaseConnection() {
        this.isConnected = initConnection();
    }

    private boolean initConnection() {
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Connected to test database");
            return true;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isConnected() {
        return isConnected;
    }

    public Connection getConnection() {
        return connection;
    }
}
