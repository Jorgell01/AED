package com.mycompany.crearyverificarfichero;

import java.util.Scanner;
import java.io.*;

/**
 *
 * @author Mondongo
 */
public class CrearYVerificarFichero {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre del archivo: ");
        String nombreArchivo = scanner.nextLine() + ".txt";

        File archivo = new File(nombreArchivo);

        try {
            if (archivo.createNewFile()) {
                System.out.println("Archivo creado: " + archivo.getName());
            } else {
                System.out.println("El archivo ya existe");
            }

            OutputStreamWriter escribir = new OutputStreamWriter(new FileOutputStream(archivo, true), "UTF-8");
            System.out.println("Escribe en el archivo (Escribe 'salir' para cerrarlo): ");

            while (true) {
                String linea = scanner.nextLine();
                if (linea.equalsIgnoreCase("salir")) {
                    break;
                }

                escribir.write(linea + "\n");
            }

            escribir.close();
            System.out.println("Escritura finalizada. Archivo cerrado.");

        } catch (IOException e) {
            System.out.println("Ocurrió un error");
            e.printStackTrace();
        
            scanner.close();
        }
    }
}    
