package com.mycompany.ejercicioejemplofichero;


import java.io.File;
/**
 *
 * @author Mondongo
 */
public class EjercicioEjemploFichero {

    public static void main(String[] args) {
        //Crear una instancia de la clase File
        File archivo = new File ("miArchivo.txt");

        //Comprobar si el archivo existe
        if (archivo.exists()) {
            System.out.println("El archivo SI existe.");
        } else {
            System.out.println("El archivo NO existe.");
        }
    }
}