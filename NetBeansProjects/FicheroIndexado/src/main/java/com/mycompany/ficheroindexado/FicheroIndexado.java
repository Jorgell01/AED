package com.mycompany.ficheroindexado;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
Author Mondongo
*/

public class FicheroIndexado {
    public static void main(String[] args) {
        // Ruta al fichero indexado
        String filePath = "fichero_indexado.csv";
        
        // ID a buscar
        String idToFind = "3"; // Cambiar valor según el ID a buscar
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int position = 0;
            boolean found = false;
            
            // Leer el fichero línea por línea
            while ((line = br.readLine()) != null) {
                position++;
                
                // Dividir la línea en campos
                String[] fields = line.split(",");
                
                // Comprobar si el ID coincide con el ID buscado
                if (fields[0].equals(idToFind)) {
                    found = true;
                    System.out.println("Registro encontrado en la posición: " + position);
                    System.out.println("ID: " + fields[0]);
                    System.out.println("Apellido: " + fields[1]);
                    System.out.println("Nombre: " + fields[2]);
                    System.out.println("Teléfono: " + fields[3]);
                    System.out.println("Dirección: " + fields[4]);
                    break;
                }
            }
            
            if (!found) {
                System.out.println("No se encontró el ID: " + idToFind);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
