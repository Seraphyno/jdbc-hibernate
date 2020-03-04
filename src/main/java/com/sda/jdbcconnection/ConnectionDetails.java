package com.sda.jdbcconnection;

class ConnectionDetails {

    static final String USER = "root";
    static final String PASS = "root";
    static final String DATABASE = "test";
    static final String URL = String.format("jdbc:mysql://localhost:3306/%s", DATABASE);

    static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS products (\n" +
            "     productID    INT UNSIGNED  NOT NULL AUTO_INCREMENT PRIMARY KEY,\n" +
            "     productCode  CHAR(3)       NOT NULL DEFAULT '',\n" +
            "     name         VARCHAR(30)   NOT NULL DEFAULT '',\n" +
            "     quantity     INT UNSIGNED  NOT NULL DEFAULT 0,\n" +
            "     price        DECIMAL(7,2)  NOT NULL DEFAULT 99999.99\n" +
            ")";

    private ConnectionDetails() {
        throw new IllegalAccessError("Utility class");
    }
}
