package com.biblioteca.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class LibroModel {

        private Long id;
        private String titulo;
        private String autor;
        private String editorial;
        private LocalDate fechaPublicacion;
        private int numeroPaginas;
        private static Long ultimoId = 0L;
        private String estadoDisponibilidad = "";

        private static List<LibroModel> listaLibros = new ArrayList<>();;

    public LibroModel() {
        this.id = ++ultimoId;
        this.estadoDisponibilidad = "Disponible"; // Default value
    }
    public LibroModel(String titulo, String autor, String editorial, LocalDate fechaPublicacion, int numeroPaginas) {
        this();
        this.titulo = Objects.requireNonNull(titulo, "Título no puede ser nulo");
        this.autor = Objects.requireNonNull(autor, "Autor no puede ser nulo");
        this.editorial = Objects.requireNonNull(editorial, "Editorial no puede ser nula");
        setFechaPublicacion(fechaPublicacion);
        setNumeroPaginas(numeroPaginas);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        Objects.requireNonNull(fechaPublicacion, "Fecha de publicación no puede ser nula");
        if (fechaPublicacion.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Fecha de publicación no puede ser futura");
        }
        this.fechaPublicacion = fechaPublicacion;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        if (numeroPaginas <= 0) {
            throw new IllegalArgumentException("Número de páginas debe ser positivo");
        }
        this.numeroPaginas = numeroPaginas;
    }
    public String getDisponible() {
        return estadoDisponibilidad;
    }

    public void setEstadoDisponibilidad(String estadoDisponibilidad) {
        this.estadoDisponibilidad = estadoDisponibilidad;
    }

    public boolean getEstadoDisponibilidad() {
        return "Disponible".equalsIgnoreCase(this.estadoDisponibilidad);
    }

    public void marcarDisponible() {
        this.estadoDisponibilidad = "Disponible";
    }

    public void marcarNoDisponible(String razon) {
        this.estadoDisponibilidad = "No disponible: " + Objects.requireNonNull(razon);
    }

    public static  void agregarLibro(LibroModel libro) {
        listaLibros.add(libro);
    }

    public static List<LibroModel> listarLibros() {
        return listaLibros;
    }
    public String detalle (){
        return  "ID: " + String.valueOf(this.getId()) +"\n"+
                "Titulo: "+ this.getTitulo()+"\n"+
                "Autor(a): "+this.getAutor() +"\n"+
                "Fecha de Publicacion: " + this.fechaPublicacion +"\n"+
                "Editorial: " + this.getEditorial() +"\n"+
                "Numero de Paginas: " + this.getNumeroPaginas() +"\n"+
                "Estado: " + this.estadoDisponibilidad ;
    }

    private void createUIComponents() {

    }




}
