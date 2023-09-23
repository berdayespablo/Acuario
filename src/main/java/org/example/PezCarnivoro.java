package org.example;

import java.awt.*;

public class PezCarnivoro extends Pez {
    private final Acuario acuario;
    public PezCarnivoro(int x, int y, Acuario acuario) {
        super(x, y, Color.BLUE);
        this.acuario = acuario;
    }

    @Override
    public void dibujar(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, 50, 10);

        int[] xPoints = {x + 27, x + 20, x + 27};
        int[] yPoints = {y - 5, y, y + 5};
        g.fillPolygon(xPoints, yPoints, 3);
    }

    @Override
    public void comerPez(Pez[] peces) {
        for (int i = 0; i < peces.length; i++) {
            Pez pez = peces[i];
            if (pez != null && !(pez instanceof PezCarnivoro) &&
                    Math.abs(pez.x - this.x) < 10 && Math.abs(pez.y - this.y) < 10) {
                peces[i] = null;
                haComido = true;
                acuario.agregarSimbolo(new Simbolo(x, y, "cruz"));
            }
        }
    }
}
