package com.mycompany.creardirectorioficheros;

import java.io.*;

/**
 *
 * @author Mondongo
 */
public class CrearDirectorioFicheros {

    public static void main (String [] args) {
        File d = new File ("NuevoDIR"); //Creo directorio a partir del actual
        File f1 = new File (d, "Fichero1.txt");
        File f2 = new File (d, "Fichero2.txt");
        
        d.mkdir(); //Crear directorio
        
        try {
            if (f1.createNewFile()) {
                System.out.println("Fichero1 creado correctamente...");
            } else {
                System.out.println("No se ha podido crear Fichero1...");
            }
            
            if (f2.createNewFile()) {
                System.out.println("Fichero2 creado correctamente...");
            } else {
                System.out.println ("No se ha podido crear Fichero2...");
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        
        f1.renameTo (new File(d, "Fichero1Nuevo.txt")); //cambiar el nombre de Fichero 1
        
        try {
            File f3 = new File("NuevoDIR/Fichero3.txt");
            f3.createNewFile(); //crear fichero3 en nuevoDir
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}