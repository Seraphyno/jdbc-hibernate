package com.sda.jdbcconnection;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        DatabaseConnection connection = new DatabaseConnection();

        if (connection.isConnected()) {
            readData(connection.getConnection());
        } else {
            System.out.println("Database not connected");
        }
    }

    private static void printResults(ResultSet resultSet) {
        try {
            if (resultSet.next()) {
                System.out.println("productID | productCode | name | quantity | price");
            }
            while (resultSet.next()) {
                int productID = resultSet.getInt("productID");
                int quantity = resultSet.getInt("quantity");
                String productCode = resultSet.getString("productCode");
                String name = resultSet.getString("name");
                BigDecimal price = resultSet.getBigDecimal("price");
                System.out.println(productID + " | " + productCode + " | " + name + " | " +
                        quantity + " | " + price);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void readData(Connection connection) {
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM products");
            printResults(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
