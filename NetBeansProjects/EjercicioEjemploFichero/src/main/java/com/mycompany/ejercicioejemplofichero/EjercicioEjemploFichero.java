package com.mycompany.ejercicioejemplofichero;


import java.io.File;
import java.io.IOException;
/**
 *
 * @author Mondongo
 */
public class EjercicioEjemploFichero {

    public static void main(String[] args) {
        //Crear una instancia de la clase File
        File nuevoArchivo = new File ("ejemplo.txt");
        
        try {
        //Comprobar si el archivo existe
        if (nuevoArchivo.createNewFile()) {
            System.out.println("Archivo creado: " + nuevoArchivo.getName());
        } else {
            System.out.println("El archivo ya existe.");
        }
      } catch (IOException e) {
          System.out.println("Ocurrió un error.");
          e.printStackTrace();
      } 
    }
}
