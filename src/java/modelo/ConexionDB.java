/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author acer
 */

// Esta clase es para conectarse a la base de datos //
public class ConexionDB {
    
    //Creamos una conexión llamada "conexión"//
    public Connection conexion;
    
    //Cadenas de caracteres para la dirección url de la base de datos y los datos de inicio de sesión de la base de datos//
    private final String url = "jdbc:derby://localhost:1527/BaseDeCultura";
    private final String username = "Josue";
    private final String password = "josue";
    private final String driverName = "org.apache.derby.jdbc.ClientDriver";
    
    
    //Abre una conexión con la base de datos//
    public void abrirConexion() throws SQLException{
        
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        conexion = DriverManager.getConnection(url, username, password);
    }
    
    //Cierra la conexión a la base de datos. Esto sirve para evitar el desperdicio de recursos//
    public void cerrarConexion() throws SQLException{
        conexion.close();
    }
    
    //d
    public Connection obtenerConexion(){
        return conexion;
    }
    
}
