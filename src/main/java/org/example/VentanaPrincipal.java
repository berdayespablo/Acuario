package org.example;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal {
    public static void main(String[] args) {

        Configuracion config = new Configuracion();
        int ancho = config.getVentanaAncho();
        int alto = config.getVentanaAlto();
        String titulo = config.getTitulo();
        String textoBotonComida = config.getTextButtonAnadirComida();

        JFrame frame = new JFrame(titulo);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        Acuario acuario = new Acuario(config.getNumPeces(), ancho, alto);
        frame.add(acuario, BorderLayout.CENTER);

        /**
         * Parte de opciones
         */
        JPanel panelDerecho = new JPanel();
        panelDerecho.setLayout(new BoxLayout(panelDerecho, BoxLayout.Y_AXIS));
        panelDerecho.setBackground(Color.GRAY);

        JButton btnAnadirComida = new JButton(textoBotonComida);
        btnAnadirComida.addActionListener(e -> acuario.anadirComida());
        panelDerecho.add(btnAnadirComida);

        frame.add(panelDerecho, BorderLayout.EAST);

        /**
         * Consola
         */
        JTextArea console = new JTextArea();
        console.setBackground(Color.BLACK);
        console.setForeground(Color.GREEN);
        console.setFont(new Font("Consolas", Font.PLAIN, 12));
        frame.add(new JScrollPane(console), BorderLayout.SOUTH);
        acuario.setConsole(console);

        frame.setSize(ancho + 200, alto);
        frame.setVisible(true);

    }
}