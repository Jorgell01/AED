package com.mycompany.ficherosecuencial02;

import java.io.*;

/**
 *
 * @author Mondongo
 */
public class FicheroSecuencial02 {

    public static void main (String[] args) {
        String[] nombres = {"Juan", "Ana", "Carlos", "Lucía", "Pepe"};
        
        try (BufferedWriter writer = new BufferedWriter (new FileWriter ("nombres.txt"))) {
            for (String nombre : nombres) {
                writer.write(nombre);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}
