package org.example;

import java.sql.*;

public class DatabaseConnector {
    public static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    public static final String DB_USER = "postgres";
    public static final String DB_PASSWORD = "123";

    public Connection connect() {
        Connection connection = null;

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (Exception exception) {
            System.out.println(exception);
        }

        return connection;
    }

    public void execute (String sql) {
        Connection connection = this.connect();
        try {
            Statement stm = connection.createStatement();
            stm.execute(sql);
            System.out.println("Sukces");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void selectData(String sql) {
        Connection connection = this.connect();
        try {
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                Long id = rs.getLong("id");
                String title = rs.getString("title");
                String author = rs.getString("author");

                System.out.println(id + ", " + title + ", " + author);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
