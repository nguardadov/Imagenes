/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Nelson
 */
public class Foto {
    private int id;
    private byte[] imagen;

    public Foto() {
    }

    
    public Foto(byte[] imagen) {
        this.imagen = imagen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "Foto{" + "id=" + id + ", imagen=" + imagen + '}';
    }
    
    
}
