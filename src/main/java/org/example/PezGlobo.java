package org.example;

import java.awt.Color;
import java.awt.Graphics;

public class PezGlobo extends Pez{
	public PezGlobo(int x, int y) {
        super(x, y, Color.RED);
    }

    @Override
    public void dibujar(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, 20, 17);

        int[] xPoints = {x + 28, x + 15, x + 28};
        int[] yPoints = {y, y + 5, y + 10};
        g.fillPolygon(xPoints, yPoints, 3);
    }
}
