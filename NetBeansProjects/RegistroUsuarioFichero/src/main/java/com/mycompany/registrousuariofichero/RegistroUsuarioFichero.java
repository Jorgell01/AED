package com.mycompany.registrousuariofichero;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author Mondongo
 */
public class RegistroUsuarioFichero {

    public static void main (String[] args) {
        File user = new File ("usuarios.txt");
        
        try {
            if (user.createNewFile()) {
                System.out.println("Se creo el txt de usuario correctamente");
            } else {
                System.out.println("El archivo ya existe");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        Scanner scanner = new Scanner (System.in);
        
        agregarUser(scanner);
        mostrarUsers();
        
        scanner.close();
    }
    
    private static void agregarUser (Scanner scanner) {
        System.out.println("Introduzca el nombre: ");
        String nombre = scanner.nextLine();
        
        System.out.println("Introduzca la edad: ");
        String edad = scanner.nextLine();
        
        System.out.println("Introduzca el correo: ");
        String correo = scanner.nextLine();
        
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("usuarios.txt", true))) {
            bufferedWriter.write("Nombre: " + nombre);
            bufferedWriter.newLine();
            bufferedWriter.write("Edad: " + edad);
            bufferedWriter.newLine();
            bufferedWriter.write("Correo: " + correo);
            bufferedWriter.newLine();
            bufferedWriter.newLine(); //Línea en blanco para separar los registros
        } catch (IOException e) {
            System.out.println("Ocurrió un error al escribir el archivo" + e.getMessage());
        }
    }
    
    private static void mostrarUsers() {
        try (BufferedReader reader = new BufferedReader(new FileReader("usuarios.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
