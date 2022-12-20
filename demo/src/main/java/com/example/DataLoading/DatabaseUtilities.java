package com.example.DataLoading;

import java.sql.*;
import java.util.Scanner;
import java.io.Console;

public class DatabaseUtilities {

    /**
     * Establishes a connection to the database. Asks for user credentials.
     * 
     * @return Connection
     */
    public static Connection connect() {
        Scanner scan = new Scanner(System.in);
        Console console = System.console();

        String username;
        String password;
        Connection connection = null;
        boolean connectionSuccess = false;

        while (!connectionSuccess) {
            try {
                System.out.println("Enter your username.");
                username = scan.nextLine();
                password = new String(console.readPassword("Enter your password: "));

                connection = getConnection(username, password);
                connectionSuccess = true;
                System.out.println("Connection established.");
            } catch (SQLException e) {
                connectionSuccess = false;
                System.out.println("Connection unsuccessful. Retry connecting.");
            }
        }
        scan.close();
        return connection;

    }

    /**
     * Connects to the database
     * 
     * @param username
     * @param password
     * @return connection
     * @throws SQLException
     */
    public static Connection getConnection(String username, String password) throws SQLException {
        // TODO
        Connection connection = DriverManager.getConnection(
                "database link", username, password);
        return connection;
    }
}
