/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

/**
 *
 * @author desarrollo
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class coneccion {

    public String puerto = "5432";
    public String host = "localhost";
    public String db = "huellas";
    public String username = "root";
    public String password = "root";
    Connection conn = null;
    
    public Connection conectar(){
        try {
            String ruta = "jdbc:mysql://";
            String servidor = host + ":" + "puerto" + "/";
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(ruta + servidor + db + username + password);
            if (conn != null){
                System.out.println("Conexion a base de datos");
            } else if (conn == null){
                throw new SQLException();
            }
            return conn;
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error Bd: " + e.getMessage());
            return null;
        }
    }
    
    public void desconectar(){
        try {
            conn = null;
            System.out.println("La coneccion a la base de datos se termino...");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error Bd: " + e.getMessage());
        }
    }

    
}
