package com.mycompany.ficherossecuencial01;

import java.io.*;

/**
 *
 * @author Mondongo
 */
public class FicherosSecuencial01 {

    public static void main (String[] args) {
        try (BufferedReader reader = new BufferedReader (new FileReader ("frases.txt"))) {
           String linea;
           while ((linea = reader.readLine()) != null) {
               System.out.println(linea);
           }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
