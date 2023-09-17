package org.example;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal {
    public static void main(String[] args) {

        Configuracion config = new Configuracion();
        int ancho = config.getVentanaAncho();
        int alto = config.getVentanaAlto();
        int numPeces = config.getNumPeces();
        String titulo = config.getTitulo();

        JFrame frame = new JFrame(titulo);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(ancho, alto);

        Acuario acuario = new Acuario(numPeces, ancho, alto);
        frame.add(acuario, BorderLayout.CENTER);

        JTextArea console = new JTextArea();
        console.setBackground(Color.BLACK);
        console.setForeground(Color.GREEN);
        console.setFont(new Font("Consolas", Font.PLAIN, 12));
        frame.add(new JScrollPane(console), BorderLayout.SOUTH);
        acuario.setConsole(console);

        frame.setVisible(true);

    }
}