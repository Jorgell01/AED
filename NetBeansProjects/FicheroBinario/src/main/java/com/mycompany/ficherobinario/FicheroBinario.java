package com.mycompany.ficherobinario;

/**
 *
 * @author Mondongo
 */
import java.io.RandomAccessFile;
import java.io.IOException;

public class FicheroBinario {
    public static void main(String[] args) {
        try (RandomAccessFile file = new RandomAccessFile("ejemplo_fichero.bin", "r")) {
            // Leer y mostrar todos los registros
            mostrarRegistros(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para leer y mostrar los registros del archivo
    public static void mostrarRegistros(RandomAccessFile file) throws IOException {
        //file.seek(0);  // Posicionarse al inicio del archivo ( no es necesario en este caso)
        // se recorre de forma secuencial
        while (file.getFilePointer() < file.length()) {
            int id = file.readInt();         // Leer ID (4 bytes)
            short edad = file.readShort();   // Leer Edad (2 bytes)
            float salario = file.readFloat();// Leer Salario (4 bytes)

            // Mostrar el registro
            System.out.println("ID: " + id + ", Edad: " + edad + ", Salario: " + salario);
        }
    }
}