package org.example;

import java.awt.*;

public class PezGlobo extends Pez {

    public PezGlobo(int x, int y) {
        super(x, y, Color.YELLOW);
    }

    @Override
    public void dibujar(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, 20, 20);

        int[] xPoints = {x + 27, x + 20, x + 27};
        int[] yPoints = {y + 5, y + 10, y + 15};
        g.fillPolygon(xPoints, yPoints, 3);
    }
}