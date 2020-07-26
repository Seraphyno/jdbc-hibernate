package com.sda.jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static com.sda.jdbc.connection.ConnectionDetails.*;

public class DatabaseConnection {
    private Connection connection;
    private final boolean isConnected;

    public DatabaseConnection() {
        this.isConnected = initConnection();
    }

    private boolean initConnection() {
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Connected to test database");

            Statement statement = connection.createStatement();
            statement.executeUpdate(CREATE_TABLE);
            statement.close();

            System.out.println("Created the products table\n\n");

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
