package com.axelfernandez.pedidosnuevageneracion_prestaciones;

import java.io.Serializable;

/**
 * Created by axelfernandez on 29/8/17.
 */

public class Productos implements Serializable {
    String nombre;
int cantidad;
    int precio;
    String foto;
    public Productos(){}

    public Productos(String foto, int precio, int cantidad, String nombre){
        this.foto = foto;
        this.precio = precio;
        this.nombre = nombre;
        this.cantidad= cantidad;


    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

}
