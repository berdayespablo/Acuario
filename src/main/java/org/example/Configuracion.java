package org.example;

import java.io.InputStream;
import java.util.Properties;

public class Configuracion {

    private Properties properties = new Properties();

    public Configuracion() {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                System.out.println("No se pudo encontrar el archivo config.properties");
                return;
            }
            properties.load(input);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public int getVentanaAncho() {
        return Integer.parseInt(properties.getProperty("ventana.ancho", "800"));
    }

    public int getVentanaAlto() {
        return Integer.parseInt(properties.getProperty("ventana.alto", "600"));
    }

    public int getNumPeces() {
        return Integer.parseInt(properties.getProperty("acuario.numPeces", "10"));
    }

    public String getTitulo() {
        return properties.getProperty("acuario.titulo", "No title");
    }

    // Añade más constructores si usas más propiedades
}
