package com.romantupikov.hw6.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlDB {

    private Connection conn;

    public MysqlDB() {
        createConnection();
    }

    private void createConnection() {
        try {
            conn = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/patterns?user=root&password=1234&useSSL=false");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return this.conn;
    }

    public void close() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
