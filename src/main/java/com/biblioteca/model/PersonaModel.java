package com.biblioteca.model;

import java.time.LocalDate;
import java.time.Period;
;

public class PersonaModel {

        private Long id;
        private String nombre ;
        private String apellido ;
        private int telefono ;
        private String direccion ;
        private LocalDate fechaNacimiento;
        private static Long ultimoId = 0L;

        public PersonaModel() {
            this.id = ++ultimoId;
        }

        public PersonaModel( String nombre, String apellido, int telefono, String direccion, LocalDate fechaNacimiento) {
            this();
            this.nombre = nombre;
            this.apellido = apellido;
            this.telefono = telefono;
            this.direccion = direccion;
            this.fechaNacimiento = fechaNacimiento;
        }

        public Long getId() {
            return id;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getApellido() {
            return apellido;
        }

        public void setApellido(String apellido) {
            this.apellido = apellido;
        }

        public int getTelefono() {
            return telefono;
        }

        public void setTelefono(int telefono) {
            this.telefono = telefono;
        }

        public String getDireccion() {
            return direccion;
        }

        public void setDireccion(String direccion) {
            this.direccion = direccion;
        }

        public LocalDate getFechaNacimiento() {
            return fechaNacimiento;
        }

        public void setFechaNacimiento(LocalDate fechaNacimiento) {
            this.fechaNacimiento = fechaNacimiento;
        }

        public int  getEdad(){
            LocalDate actualFecha = LocalDate.now();
            Period edad = Period.between(fechaNacimiento,actualFecha);
            return edad.getYears();
        }

        public String detalle(){
            return  "ID: "+this.id + "\n"+
                    "Nombre Completo: " +this.nombre+ " " +this.apellido + "\n"+
                    "Telefono : " +this.telefono+ "\n" +
                    "Direccion: "+this.direccion + "\n" +
                    "Edad: "+this.getEdad();
        }
}
