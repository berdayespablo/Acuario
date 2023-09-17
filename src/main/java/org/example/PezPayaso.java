package org.example;

import java.awt.*;

public class PezPayaso extends Pez {

    public PezPayaso(int x, int y) {
        super(x, y, Color.ORANGE);
    }

    @Override
    public void dibujar(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, 20, 10);

        int[] xPoints = {x + 30, x + 20, x + 30};
        int[] yPoints = {y, y + 5, y + 10};
        g.fillPolygon(xPoints, yPoints, 3);
    }
}
