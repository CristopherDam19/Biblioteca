package com.biblioteca.model;

public class AdminModel {
    protected String nombreUsuario;
    protected String contrasena;

    public AdminModel() {
    }

    public AdminModel(String nombreUsuario, String contrasena) {
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public boolean autenticar(String contrasenaIngresada) {
        return this.contrasena.equals(contrasenaIngresada);
    }

    public  boolean esAdmin() {
        return true;
    }
}
