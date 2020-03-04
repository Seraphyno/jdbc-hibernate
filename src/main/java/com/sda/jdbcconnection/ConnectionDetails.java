package com.sda.jdbcconnection;

class ConnectionDetails {

    static final String USER = "root";
    static final String PASS = "root";
    static final String DATABASE = "test";
    static final String URL = String.format("jdbc:mysql://localhost:3306/%s", DATABASE);

    private ConnectionDetails() {
        throw new IllegalAccessError("Utility class");
    }
}
