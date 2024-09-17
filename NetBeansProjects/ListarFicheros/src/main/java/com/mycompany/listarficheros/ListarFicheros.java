package com.mycompany.listarficheros;

import java.io.*;
/**
 *
 * @author Mondongo
 */
public class ListarFicheros {

    public static void main (String[] args) {
        File directorioActual = new File (".");
        String [] listaArchivos = directorioActual.list();
        
        if (listaArchivos != null) {
            System.out.println("Archivos y directorios en el directorio actual: ");
            for (String nombre : listaArchivos) {
                System.out.println(nombre);
            }
        } else {
            System.out.println("No se pudo obtener la lista de archivos.");
        }
    }
}
