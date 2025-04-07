package com.biblioteca;


import com.biblioteca.model.LibroModel;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String seguir = "y";

        System.out.println("======================BIBLIOTECA VIRTUAL======================");
        System.out.println("WORK's!");

        do {
            LocalDate fechaPublicacion = null; // Declare fechaPublicacion here

            System.out.println("Ingrese el nombre del libro");
            String titulo = sc.nextLine();
            System.out.println("Ingrese el nombre del autor");
            String nombreAuthor = sc.nextLine();
            System.out.println("Ingrese el nombre de la editorial");
            String nombreEditorial = sc.nextLine();

            int year = 0;
            int month = 0;
            int day = 0;
            boolean fechaValida = false;

            while (!fechaValida) {
                try {
                    System.out.println("Ingrese el año de publicación (YYYY):");
                    year = Integer.parseInt(sc.nextLine());
                    System.out.println("Ingrese el mes de publicación (MM):");
                    month = Integer.parseInt(sc.nextLine());
                    System.out.println("Ingrese el día de publicación (DD):");
                    day = Integer.parseInt(sc.nextLine());
                    fechaPublicacion = LocalDate.of(year, month, day);
                    fechaValida = true;
                } catch (NumberFormatException e) {
                    System.out.println("Error: Ingrese números válidos para el año, mes y día.");
                } catch (DateTimeParseException e) {
                    System.out.println("Error: Formato de fecha inválido.");
                }
            }

            int pagina = 0;
            boolean paginaValida = false;
            while (!paginaValida) {
                try {
                    System.out.println("Ingrese las paginas del libro");
                    pagina = Integer.parseInt(sc.nextLine());
                    if (pagina > 0) {
                        paginaValida = true;
                    } else {
                        System.out.println("Error: El número de páginas debe ser un valor positivo.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Error: Ingrese un número válido para las páginas.");
                }
            }

            LibroModel libro = new LibroModel(titulo, nombreAuthor, nombreEditorial, fechaPublicacion, pagina);
            LibroModel.agregarLibro(libro);

            System.out.println("Desea seguir ingresando libros (Y/N)?");
            seguir = sc.nextLine().trim().toLowerCase(); // Trim whitespace and convert to lowercase

        } while (seguir.equals("y")); // Use .equals() for precise String comparison

        LibroModel.listarLibros();
    }
}
