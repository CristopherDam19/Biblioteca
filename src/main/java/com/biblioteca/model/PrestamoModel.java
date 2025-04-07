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




}