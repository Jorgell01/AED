package com.mycompany.ficherosecuencial03;

import java.io.*;

/**
 *
 * @author Mondongo
 */
public class FicheroSecuencial03 {

    public static void main (String[] args) {
        int contador = 0;
        
        try (BufferedReader reader = new BufferedReader(new FileReader("poema.txt"))) {
            while (reader.readLine() != null) {
                contador ++;
            }
            System.out.println("El archivo tiene " + contador + " lineas");
        } catch (IOException e) {
            System.out.println("Error al leer el archiv: " + e.getMessage());
        }
    }
}
