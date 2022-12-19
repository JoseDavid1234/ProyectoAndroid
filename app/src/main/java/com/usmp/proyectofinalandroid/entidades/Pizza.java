package com.usmp.proyectofinalandroid.entidades;

import java.io.Serializable;

public class Pizza implements Serializable {

    private int idImagen;
    private String nombre, ingredientes, adicional;
    private double precio;
    private int codigo;

    public Pizza(int idImagen, String nombre, String ingredientes, String adicional, double precio, int codigo) {
        this.idImagen = idImagen;
        this.nombre = nombre;
        this.ingredientes = ingredientes;
        this.adicional = adicional;
        this.precio = precio;
        this.codigo = codigo;
    }

    public Pizza() {

    }

    public int getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(int idImagen) {
        this.idImagen = idImagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getAdicional() {
        return adicional;
    }

    public void setAdicional(String adicional) {
        this.adicional = adicional;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}
