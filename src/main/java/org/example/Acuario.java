package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class Acuario extends JPanel implements ActionListener {
    private final Pez[] peces;

    private final ArrayList<Comida> comidaList = new ArrayList<>();
    private final Random random = new Random();

    private JTextArea console;


    public Acuario(int numeroDePeces, int ancho, int alto) {
        peces = new Pez[numeroDePeces];
        Random random = new Random();

        for (int i = 0; i < numeroDePeces; i++) {
            int x = random.nextInt(ancho - 100);
            int y = random.nextInt(alto - 100);
            if (i % 4 == 0){
                peces[i] = new PezGlobo(x, y);
            } else if (i % 13 == 0) {
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

    public void anadirComida() {
        for (int i = 0; i < 5; i++) {
            int x = random.nextInt(getWidth());
            comidaList.add(new Comida(x, 0)); // Añadir en la parte superior con posición x aleatoria
        }
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
                    "   > Pez Globo: " + pezGloboCount + "\n" +
                    "   > Pez Carnívoro: " + pezCarnivoroCount + "\n" +
                    "   > Pez Payaso: " + pezPayasoCount + "\n" +
                    "Comida: " + comidaList.size());
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
        for (Comida comida : comidaList) {
            comida.dibujar(g);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (Pez pez : peces) {
            if (pez != null) {
                pez.mover();
                if (!(pez instanceof PezCarnivoro)) {
                    pez.comerComida(comidaList);
                }
                if (pez instanceof PezCarnivoro) {
                    pez.comerPez(peces);
                }
            }
        }

        for (int i = 0; i < comidaList.size(); i++) {
            Comida comida = comidaList.get(i);
            comida.mover();
            if (comida.getY() >= getHeight()) {
                comidaList.remove(i);
                i--;
            }
        }
        updateConsole();
        repaint();
    }
}