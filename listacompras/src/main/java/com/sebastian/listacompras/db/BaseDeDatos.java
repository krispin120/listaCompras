package com.sebastian.listacompras.db;

import java.sql.*;

import org.springframework.stereotype.Component;

@Component
public class BaseDeDatos {
    
    private final String url = "jdbc:postgresql://localhost/Prueba";
    private final String user = "postgres";
    private final String password = "prueba1";

    /**
     * Connect to the PostgreSQL database
     *
     * @return a Connection object
     */
    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);

            if (conn != null) {
                System.out.println("Connected to the PostgreSQL server successfully.");
            } else {
                System.out.println("Failed to make connection!");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }
}
