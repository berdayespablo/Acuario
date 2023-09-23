package org.example;

import java.awt.*;

public class Simbolo {
    private final int x;
    private final int y;
    private final String tipo;
    private final long tiempoCreacion;
    private static final int DURACION = 3000; // 3 segundos

    public Simbolo(int x, int y, String tipo) {
        this.x = x;
        this.y = y;
        this.tipo = tipo;
        this.tiempoCreacion = System.currentTimeMillis();
    }

    public void dibujar(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        if ("cruz".equals(tipo)) {
            g2d.setColor(Color.RED);
            g2d.setStroke(new BasicStroke(3)); // Define el grosor de la línea

            int size = 10; // Define el tamaño de la "X"
            g2d.drawLine(x - size, y - size, x + size, y + size);
            g2d.drawLine(x + size, y - size, x - size, y + size);
        }
    }

    public boolean haExpirado() {
        return System.currentTimeMillis() - tiempoCreacion > DURACION;
    }
}
