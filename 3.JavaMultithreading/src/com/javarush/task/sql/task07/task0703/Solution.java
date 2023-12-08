package com.javarush.task.sql.task07.task0703;

import java.sql.*;

/* 
task0703
*/

public class Solution {
    private static final String ADDRESS = "jdbc:mysql://localhost:3306/test";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) throws Exception {
        try (Connection connection = DriverManager.getConnection(ADDRESS, LOGIN, PASSWORD);
             Statement statement = connection.createStatement();) {
            statement.executeQuery("SELECT * FROM employee");
        }
    }

}

