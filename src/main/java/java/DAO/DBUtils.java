/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Safirahhadi
 */
public class DBUtils {

    public static Connection getConnection() {
        String JDBC_URL = System.getenv("DB_URL");
        String JDBC_USERNAME = System.getenv("DB_USER");
        String JDBC_PASSWORD = System.getenv("DB_PASS");

        Connection conn = null;

        try {
            if (JDBC_URL == null || JDBC_USERNAME == null || JDBC_PASSWORD == null) {
                throw new IllegalStateException("Environment variables DB_URL, DB_USER, or DB_PASS are not set.");
            }

            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
        } catch (SQLException | ClassNotFoundException | IllegalStateException ex) {
            Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE, "Failed to connect to DB", ex);
        }

        return conn;
    }
}
