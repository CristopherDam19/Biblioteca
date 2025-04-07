package com.biblioteca.model;

import java.time.LocalDate;

public class ClienteModel extends PersonaModel {


    public ClienteModel() {
    }


    public ClienteModel(String nombre, String apellido, int telefono, String direccion, LocalDate fechaNacimiento) {
        super(nombre, apellido, telefono, direccion, fechaNacimiento);
    }

}
