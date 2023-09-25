package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Acuario extends JPanel implements ActionListener {

    // TODO declarar un array de peces vacío
	
	public Pez[] peces;
	
    public Acuario(int numeroDePeces, int ancho, int alto) {
        // TODO reasignar el array con el número de peces
        Random random = new Random();
        peces = new Pez [numeroDePeces];

        /** TODO crear un bucle que itere el array y vaya creando instancias de peces
         * Necesitarás usar estas variables para las posiciones iniciales de cada pez:
         *      int x = random.nextInt(ancho - 30);
         *      int y = random.nextInt(alto - 30);
         * Inicialemente, crea peces de tipo PezGlobo
         */
        
        for(int i = 0; i < peces.length; i ++) {
        	int x = random.nextInt(ancho - 30);
        	int y = random.nextInt(alto - 30);
        	int tipoPez = random.nextInt(3); // Se genera un número aleatorio para decidir el tipo de pez
            if(tipoPez == 0) {
            	peces[i] = new PezGlobo (x,y); // Si el número generado es 0 se crea un tipo Globo
            }else if(tipoPez == 1) {
            	peces[i] = new PezPayaso (x,y); // Si es 1, se crea un tipo Payaso
            }else {
            	peces[i] = new PezCarnivoro (x,y);
            }
        }
        
        /** Probé así a ver si conseguía que apareciesen los dos tipos de pez a la vez pero solo se superponían
  
        	for(int i = 0; i < peces.length; i ++) {
        	int x = random.nextInt(ancho - 30);
        	int y = random.nextInt(alto - 30);
            peces[i] = new PezGlobo(x,y);
            peces[i] = new PezPayaso(x,y);
        }
        */
        
        

        // Propiedades del acuario
        this.setBackground(new Color(173, 216, 230));
        setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 20));

        // Tiempo que transcurre entre evento y evento
        Timer timer = new Timer(100, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(Pez pez : peces) {
        	if(pez !=null) {
        		pez.dibujar(g);
        	}
        }
       
        /**
         * TODO crea un bucle for reducido para recorrer el array de peces que creaste al principio.
         * El cuerpo del bucle solo tiene que tener esto:
         *      if (pez != null) {
         *          pez.dibujar(g);
         *      }
         */
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	for(Pez pez : peces) {
    		if(pez !=null) {
    			pez.mover();
    		}
    	}
        /**
         * TODO crea un bucle for reducido para recorrer el array de peces que creaste al principio.
         * El cuerpo del bucle solo tiene que tener esto:
         *       if (pez != null) {
         *          pez.mover();
         *       }
         */
        repaint();
    }
}