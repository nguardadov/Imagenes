/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import datos.Conexion;
import entidades.Foto;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nelson
 */
public class Dao {
    private static final Conexion conn = Conexion.conectar();
    private static final String INSERT = "insert into foto(img) values (?)";
    private static final String READALL="select * from foto";
    private static final String READ="select * from foto where id=?";
    
    public boolean GuardarImagen(String ruta)
    {
        boolean estado=false;
        File file = new File(ruta);
        try {
            //convertir a binario
            FileInputStream fis = new FileInputStream(file);
              ////////////////////////////////////////////////////////////
            PreparedStatement ps = conn.getCnx().prepareStatement(INSERT);
            ps.setBinaryStream(1, fis,(int) file.length());
            if(ps.executeUpdate() > 0)
            {
                estado = true;
            }
        } catch (FileNotFoundException | SQLException ex) {
            estado=false;
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return estado;
    }
    
    public ArrayList<Foto> imagenes()
    {
        ArrayList<Foto> f = new ArrayList<>();
        
        try {
            Statement ps = conn.getCnx().createStatement();
            ResultSet rs = ps.executeQuery(READALL);
            
            while(rs.next())
            {
                f.add(new Foto(rs.getBytes(2)));
            }
            rs.close();
            
            
        } catch (SQLException ex) {
            f=null;
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            conn.cerrarConexion();
        }
        
        return f;
    }
    
    public Foto read(Object key)
    {
        Foto f=null;
        
        try {
            PreparedStatement ps = conn.getCnx().prepareStatement(READ);
            ps.setInt(1, (int)key);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                f = new Foto(rs.getBytes(2));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }finally
        {
            conn.cerrarConexion();
        }
        
        return f;
    }
}
