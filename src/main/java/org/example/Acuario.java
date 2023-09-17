package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Acuario extends JPanel implements ActionListener {
    private final Pez[] peces;

    private JTextArea console;

    public Acuario(int numeroDePeces, int ancho, int alto) {
        peces = new Pez[numeroDePeces];
        Random random = new Random();

        for (int i = 0; i < numeroDePeces; i++) {
            int x = random.nextInt(ancho - 100);
            int y = random.nextInt(alto - 100);
            if (i % 3 == 0){
                peces[i] = new PezGlobo(x, y);
            } else if (i % 5 == 0) {
                peces[i] = new PezCarnivoro(x, y);
            } else{
                peces[i] = new PezPayaso(x, y);
            }
        }
        // Establece el fondo azul claro
        this.setBackground(new Color(173, 216, 230));
        setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 20));

        Timer timer = new Timer(100, this);
        timer.start();
    }

    public void setConsole(JTextArea console) {
        this.console = console;
    }

    private void updateConsole() {
        int totalPeces = 0;
        int pezGloboCount = 0;
        int pezCarnivoroCount = 0;
        int pezPayasoCount = 0;

        for (Pez pez : peces) {
            if (pez != null) {
                totalPeces++;

                if (pez instanceof PezGlobo) {
                    pezGloboCount++;
                } else if (pez instanceof PezCarnivoro) {
                    pezCarnivoroCount++;
                } else if (pez instanceof PezPayaso) {
                    pezPayasoCount++;
                }
            }
        }

        if (console != null) {
            console.setText("Total de peces: " + totalPeces + "\n" +
                    "Pez Globo: " + pezGloboCount + "\n" +
                    "Pez Carnívoro: " + pezCarnivoroCount + "\n" +
                    "Pez Payaso: " + pezPayasoCount);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Pez pez : peces) {
            if (pez != null) {
                pez.dibujar(g);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (Pez pez : peces) {
            if (pez != null) {
                pez.mover();
                if (pez instanceof PezCarnivoro) {
                    ((PezCarnivoro) pez).comer(peces);
                }
            }
        }
        updateConsole();
        repaint();
    }
}