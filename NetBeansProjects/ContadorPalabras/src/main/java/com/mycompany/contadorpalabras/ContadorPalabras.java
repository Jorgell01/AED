package com.mycompany.contadorpalabras;

import java.io.*;

/**
 *
 * @author Mondongo
 */
public class ContadorPalabras {
    
    public static void main (String[] args) {
        String path = "C:\\Users\\Mondongo\\Desktop\\AED\\NetBeansProjects\\texto_largo.txt";
        
        int contador = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(path))){          
            String linea;
            while ((linea = reader.readLine()) !=null) {
                String[] partes = linea.split("\\s+");
                contador += partes.length;
            }
            System.out.println("Total de palabras: " + contador);
        } catch (IOException e) {
        System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    } 
}
