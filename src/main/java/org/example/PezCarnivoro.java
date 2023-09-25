package org.example;

import java.awt.Color;
import java.awt.Graphics;

public class PezCarnivoro  extends Pez{
	
	public PezCarnivoro(int x, int y) {
        super(x, y, Color.GREEN);
    }

    @Override
    public void dibujar(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, 20, 14);

        int[] xPoints = {x + 0, x + 0, x + 40};
        int[] yPoints = {y, y + 7, y + 10};
        g.fillPolygon(xPoints, yPoints, 3);
    }
    
    public void comer(Pez[] peces) {
    	for(int i = 0; i < peces.length; i++) {
    		if (peces[i] != null && peces[i] != this) {
                double distancia = calcularDistancia(peces[i]);
                if (distancia < DISTANCIA_COMER) {
                    peces[i] = null; // No sirve lo siento
                }
    		}
    	}
    }
    
    private static final int DISTANCIA_COMER = 20; // 20 píxeles

    private double calcularDistancia(Pez otroPez) {
        int deltaX = this.x - otroPez.x;
        int deltaY = this.y - otroPez.y;
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }
}

