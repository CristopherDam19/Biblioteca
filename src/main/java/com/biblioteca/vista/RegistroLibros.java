package com.biblioteca.vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistroLibros  extends  JDialog{
    private JPanel mainLibros;
    private JTextField txtTitulo;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JButton registrarButton;

    public RegistroLibros() {
        setTitle("Registro Libros");
        setContentPane(mainLibros);
        setModal(true);
        setSize(800,600);
        setLocationRelativeTo(null);

        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
    public static void main(String[] args) {
        RegistroLibros registroLibros = new RegistroLibros();
        registroLibros.setVisible(true);
    }

}
