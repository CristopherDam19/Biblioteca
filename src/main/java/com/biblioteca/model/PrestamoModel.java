package com.biblioteca.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class PrestamoModel {

    private Long id;
    private LibroModel libro;
    private ClienteModel cliente;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
    private LocalDate fechaLimite;
    private boolean devuelto;
    private static Long ultimoId = 0L;


    // Listas para control general
    private static List<PrestamoModel> todosLosPrestamos = new ArrayList<>();
    private static List<LibroModel> librosDisponibles = new ArrayList<>();
    private static List<ClienteModel> todosLosClientes = new ArrayList<>();

    public PrestamoModel() {
        this.id = ultimoId++;
    }

    public PrestamoModel(LibroModel libro, ClienteModel cliente) {
        this();
        this.libro = libro;
        this.cliente = cliente;
        this.fechaPrestamo = LocalDate.now();
        this.fechaLimite = this.fechaPrestamo.plusMonths(2); // 2 meses para devolver
        this.devuelto = false;

        // Registrar el préstamo
        todosLosPrestamos.add(this);

        // Marcar libro como no disponible
        librosDisponibles.remove(libro);
    }


    public String generarRecibo() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "=== COMPROBANTE DE PRÉSTAMO ===\n" +
                "ID Préstamo: " + id + "\n" +
                "Cliente: " + cliente.getNombre() + " " + cliente.getApellido() +
                " (ID: " + cliente.getId() + ")\n" +
                "Libro: " + libro.getTitulo() + " (ID: " + libro.getId() + ")\n" +
                "Fecha préstamo: " + fechaPrestamo.format(fmt) + "\n" +
                "Fecha límite: " + fechaLimite.format(fmt) + "\n" +
                "=================================";
    }

    // Método para registrar devolución
    public void registrarDevolucion(LocalDate fecha) {
        this.fechaDevolucion = fecha;
        this.devuelto = true;
        librosDisponibles.add(this.libro);
    }


    // Métodos de consulta estáticos (versión sin streams)
    public static List<LibroModel> getLibrosPrestados() {
        List<LibroModel> prestados = new ArrayList<>();
        for (PrestamoModel prestamo : todosLosPrestamos) {
            if (!prestamo.devuelto) {
                prestados.add(prestamo.libro);
            }
        }
        return prestados;
    }

    public static List<LibroModel> getLibrosDisponibles() {
        return new ArrayList<>(librosDisponibles); // Retorna copia para evitar modificaciones externas
    }

    public static List<ClienteModel> getClientesConPrestamos() {
        List<ClienteModel> clientes = new ArrayList<>();
        for (PrestamoModel prestamo : todosLosPrestamos) {
            if (!prestamo.devuelto && !clientes.contains(prestamo.cliente)) {
                clientes.add(prestamo.cliente);
            }
        }
        return clientes;
    }

    public static List<ClienteModel> getClientesConMora() {
        List<ClienteModel> enMora = new ArrayList<>();
        LocalDate hoy = LocalDate.now();

        for (PrestamoModel prestamo : todosLosPrestamos) {
            if (!prestamo.devuelto && hoy.isAfter(prestamo.fechaLimite)) {
                if (!enMora.contains(prestamo.cliente)) {
                    enMora.add(prestamo.cliente);
                }
            }
        }
        return enMora;
    }

    // Métodos para inicializar datos
    public static void agregarLibroDisponible(LibroModel libro) {
        if (!librosDisponibles.contains(libro)) {
            librosDisponibles.add(libro);
        }
    }

    public static boolean estaDisponible(LibroModel libro) {
        return librosDisponibles.contains(libro);
    }


    public static void registrarCliente(ClienteModel cliente) {
        if (!todosLosClientes.contains(cliente)) {
            todosLosClientes.add(cliente);
        }
    }

    // Getters
    public LibroModel getLibro() {
        return libro;
    }

    public ClienteModel getCliente() {
        return cliente;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public LocalDate getFechaLimite() {
        return fechaLimite;
    }

    public boolean isDevuelto() {
        return devuelto;
    }
}