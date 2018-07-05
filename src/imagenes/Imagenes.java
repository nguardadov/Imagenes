/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagenes;

import Gui.Ventana;
import datos.Conexion;
import entidades.Foto;
import java.util.ArrayList;
import modelo.Dao;

/**
 *
 * @author Nelson
 */
public class Imagenes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Dao d =new Dao();
       //d.GuardarImagen("C:\\test\\pic.png");
        /*ArrayList<Foto> imagenes = d.imagenes();
        
        for(Foto f : imagenes)
        {
            System.out.println(f);
        }*/
        
       // System.out.println(d.read(1));
       new Ventana().setVisible(true);
    }
    
}
