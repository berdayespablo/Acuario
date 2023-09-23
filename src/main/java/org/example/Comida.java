package org.example;

import java.awt.*;

public class Comida {
    private int x, y;

    public Comida(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void mover() {
        y += 2; // Mover hacia abajo
    }

    public void dibujar(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(x, y, 5, 5);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}