package org.example;

import java.awt.*;
import java.util.Random;

/**
 * Clase Pez
 */
public abstract class Pez {

    // TODO crea 2 variables x e y para almacenar la posición del pez
    protected Color color;
    protected Random random = new Random();
    int x;
    int y;
     
    // TODO crea un constructor de la clase Pez con las posiciones y el color como parámetros
    
    public Pez(int x, int y, Color color) {
    	this.color = color;
    	this.x = x;
    	this.y = y;
    }
    
    public void mover() {
        Configuracion config = new Configuracion();
        int ancho = config.getVentanaAncho();
        int alto = config.getVentanaAlto();

        x += random.nextInt(7) - 3;
        y += random.nextInt(7) - 3;

        // Restricciones para mantener los peces dentro del límite de la ventana
        if (x < 0) {
            x = 0;
        }
        if (x > (ancho - 80)) {
            x =  ancho - 80;
        }
        if (y < 0) {
            y = 0;
        }
        if (y > (alto - 80)) {
            y = alto - 80;
        }
    }

    public void dibujar(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, 20, 10);
    }
}