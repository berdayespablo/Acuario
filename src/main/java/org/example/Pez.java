package org.example;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public abstract class Pez {
    protected int x, y;
    protected boolean haComido = false;
    protected Color color;
    protected Random random = new Random();

    public Pez(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public void mover() {
        Configuracion config = new Configuracion();
        int ancho = config.getVentanaAncho();
        int alto = config.getVentanaAlto();

        x += random.nextInt(7) - 3;
        y += random.nextInt(7) - 3;

        // Restricciones para mantener los peces dentro del límite de la ventana
        if (x < 50) {
            x = 50;
        }
        if (x > (ancho - 100)) {
            x =  ancho - 100;
        }
        if (y < 50) {
            y = 50;
        }
        if (y > (alto - 100)) {
            y = alto - 100;
        }
    }

    public void comerComida(ArrayList<Comida> comidas) {
        for (int i = 0; i < comidas.size(); i++) {
            Comida comida = comidas.get(i);
            if (Math.abs(comida.getX() - this.x) < 10 && Math.abs(comida.getY()  - this.y) < 10) {
                comidas.remove(i);
                haComido = true;
                break;
            }
        }
    }

    public void comerPez(Pez[] peces) {}

    public void dibujar(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, 20, 10);
    }

}