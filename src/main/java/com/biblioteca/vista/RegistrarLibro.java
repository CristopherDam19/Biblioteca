package com.biblioteca.vista;

import com.biblioteca.model.LibroModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class RegistrarLibro extends JDialog {
    private JTextField txtTitulo;
    private JTextField txtAuthor;
    private JTextField txtEditorial;
    private JTextField txtPaginas;
    private JTextField txtAño;
    private JTextField txtMes;
    private JTextField txtDia;
    private JButton agregar;
    private JPanel mainRegistro;
    private JTable table1;
    private LibroModel libro;

    public RegistrarLibro() {
        setTitle("Registrar Libro");
        setContentPane(mainRegistro);
        setModal(true);
        setSize(900,700);
        setLocationRelativeTo(null);

        // Initialize the libro object
        libro = new LibroModel();

        agregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    libro.setTitulo(txtTitulo.getText());
                    libro.setAutor(txtAuthor.getText());
                    libro.setEditorial(txtEditorial.getText());
                    libro.setNumeroPaginas(Integer.parseInt(txtPaginas.getText()));


                    int year = Integer.parseInt(txtAño.getText());
                    int month = Integer.parseInt(txtMes.getText());
                    int day = Integer.parseInt(txtDia.getText());

                    LocalDate fechaTemporal = LocalDate.of(year, month, day);
                    libro.setFechaPublicacion(fechaTemporal);

                    LibroModel.agregarLibro(libro);

                    DefaultTableModel model = new DefaultTableModel();
                    model.addColumn("Titulo");
                    model.addColumn("Autor");
                    model.addColumn("Editorial");
                    model.addColumn("Numero Paginas");
                    model.addColumn("Fecha Publicacion");

                    if (LibroModel.listarLibros() != null) {
                        for (LibroModel libro : LibroModel.listarLibros()) {
                            model.addRow(new Object[]{
                                    libro.getTitulo(),
                                    libro.getAutor(),
                                    libro.getEditorial(),
                                    libro.getNumeroPaginas(),
                                    libro.getFechaPublicacion()
                            });
                        }
                    }
                    table1.setModel(model);

                    // Create a new libro object for the next entry
                    libro = new LibroModel();

                    txtTitulo.setText("");
                    txtAuthor.setText("");
                    txtEditorial.setText("");
                    txtPaginas.setText("");
                    txtAño.setText("");
                    txtMes.setText("");
                    txtDia.setText("");



                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(RegistrarLibro.this,
                            "Por favor ingrese valores válidos",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(RegistrarLibro.this,
                            "Error: " + ex.getMessage(),
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });


    }

    public static void main(String[] args) {

        RegistrarLibro dialog = new RegistrarLibro();
        dialog.setVisible(true);

    }
}
