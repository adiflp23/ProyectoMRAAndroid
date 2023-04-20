package com.example.mesonrafaelalberti;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class conexionMYSQL {
    public Connection conexion;
    public Statement sentencia;
    public ResultSet resultado;
    public void ConectarBasedeDatos() {
        try {
            final String Controlador = "com.mysql.cj.jdbc.Driver";
            Class.forName(Controlador);
            String url_bd = "jdbc:mysql://localhost:3306/restaurante";
            conexion = DriverManager.getConnection(url_bd, "root", "");
            sentencia = conexion.createStatement();
        } catch (ClassNotFoundException | SQLException ex) {
        }
    }

    public void DesconectarBasedeDatos() {
        try {
            if (conexion != null) {
                if (sentencia != null) {
                    sentencia.close();
                }
                conexion.close();
            }
        } catch (SQLException ex) {
            System.exit(1);
        }
    }

    public Connection getConnection() {
        return conexion;
    }
}
