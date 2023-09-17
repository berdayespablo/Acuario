package org.example;

import javax.swing.*;

/**
 * Clase que crea la ventana donde corre la aplicación
 */
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
        frame.add(new Acuario(numPeces, ancho, alto));
        frame.setVisible(true);
    }
}