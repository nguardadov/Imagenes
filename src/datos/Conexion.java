/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nelson
 */
public class Conexion {
    private String user;
    private String pass;
    private String driver;
    private String url;
    
    private Connection cnx; 
    
    public static Conexion instance;
    
    
     public synchronized static Conexion conectar()
    {
        if(instance == null)
        {
            return new Conexion();
        }
        return instance;
    }
     
     
      private Conexion() {
        cargarCredenciales();
        
        try {
            //le enviamos el driver que usara para la conexion a la base de datos
            Class.forName(this.driver);
            cnx = (Connection) DriverManager.getConnection(this.url,this.user, this.pass);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
      
    //credenciales de mi servidor de bases de datos
    private void cargarCredenciales() {
        user = "postgres";
        pass="guardado6051993";
        driver = "org.postgresql.Driver";
        url = "jdbc:postgresql://localhost:5432/imagenes";
    }

    public Connection getCnx() {
        return cnx;
    }
    
    public void cerrarConexion()
    {
        instance = null;
    }
      
}
