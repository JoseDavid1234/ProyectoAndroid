package com.usmp.proyectofinalandroid.entidades;

import java.io.Serializable;

public class Cliente implements Serializable {
    private int codigoImagen,edad,id;
    private String nombre,apellidoMa,apellidoPa,usuario,contra,genero,fechaNac,tipoP;

    public Cliente() {
    }

    public Cliente(int codigoImagen, int edad, String nombre, String apellidoMa, String apellidoPa, String usuario, String contra, String genero, String fechaNac, String tipoP) {
        this.codigoImagen = codigoImagen;
        this.edad = edad;
        this.nombre = nombre;
        this.apellidoMa = apellidoMa;
        this.apellidoPa = apellidoPa;
        this.usuario = usuario;
        this.contra = contra;
        this.genero = genero;
        this.fechaNac = fechaNac;
        this.tipoP = tipoP;
    }

    public Cliente(int codigoImagen, int edad, int id, String nombre, String apellidoMa, String apellidoPa, String usuario, String contra, String genero, String fechaNac, String tipoP) {
        this.codigoImagen = codigoImagen;
        this.edad = edad;
        this.id = id;
        this.nombre = nombre;
        this.apellidoMa = apellidoMa;
        this.apellidoPa = apellidoPa;
        this.usuario = usuario;
        this.contra = contra;
        this.genero = genero;
        this.fechaNac = fechaNac;
        this.tipoP = tipoP;
    }

    public int getCodigoImagen() {
        return codigoImagen;
    }

    public void setCodigoImagen(int codigoImagen) {
        this.codigoImagen = codigoImagen;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoMa() {
        return apellidoMa;
    }

    public void setApellidoMa(String apellidoMa) {
        this.apellidoMa = apellidoMa;
    }

    public String getApellidoPa() {
        return apellidoPa;
    }

    public void setApellidoPa(String apellidoPa) {
        this.apellidoPa = apellidoPa;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getTipoP() {
        return tipoP;
    }

    public void setTipoP(String tipoP) {
        this.tipoP = tipoP;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
