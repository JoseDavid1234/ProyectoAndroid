package com.usmp.proyectofinalandroid.entidades;

public class Pedido {

    private int idImagen;
    private String nombre, ingredientes, adicional;
    private double precio;
    private int codigo,id,idCli;

    public Pedido(){
    }

    public Pedido(int idImagen, String nombre, String ingredientes, String adicional, double precio, int codigo, int id,int idCli) {
        this.idImagen = idImagen;
        this.nombre = nombre;
        this.ingredientes = ingredientes;
        this.adicional = adicional;
        this.precio = precio;
        this.codigo = codigo;
        this.id = id;
        this.idCli = idCli;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCli() {
        return idCli;
    }

    public void setIdCli(int idCli) {
        this.idCli = idCli;
    }
}
