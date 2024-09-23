package com.mycompany.ficherosecuencial04;

import java.io.*;

/**
 *
 * @author Mondongo
 */
public class FicheroSecuencial04 {

    public static void main(String[] args) {
        int contador = 0;
        float suma = 0;
        int totalNumeros = 0;
        
        try (BufferedReader reader = new BufferedReader(new FileReader("numeros.txt"))) {
            String linea;
            
            while ((linea = reader.readLine()) != null) {
                try {
                    float numero = Float.parseFloat(linea);
                    contador++;
                    suma += numero;
                } catch (NumberFormatException e) {
                    System.out.println("Error al convertir el número: " + linea);
                }
            }
            
            if (contador > 0) {
                float promedio = suma / contador;
                System.out.println("El promedio de los números es: " + promedio);
            } else {
                System.out.println("No se encontraron números válidos en el archivo.");
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
