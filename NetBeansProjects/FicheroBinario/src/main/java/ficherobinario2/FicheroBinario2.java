package ficherobinario2;

import java.io.RandomAccessFile;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Mondongo
 */

public class FicheroBinario2 {
    private static final int TAMANO_REGISTRO = 10; // Tamaño de cada registro en bytes (4 bytes ID + 2 bytes Edad + 4 bytes Salario)

    public static void main(String[] args) {
        try (RandomAccessFile file = new RandomAccessFile("ejemplo_fichero.bin", "r");
             Scanner scanner = new Scanner(System.in)) {
            
            // Leer y mostrar todos los registros secuencialmente
            System.out.println("Leyendo todos los registros secuencialmente:");
            mostrarRegistros(file);

            // Solicitar al usuario el número de registro que desea leer
            System.out.print("\nIntroduce el número del registro que deseas leer: ");
            int numeroRegistro = scanner.nextInt();
            
            // Leer el registro indicado por el usuario usando acceso aleatorio
            saltarYLeerRegistro(file, numeroRegistro);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para leer y mostrar los registros del archivo secuencialmente
    public static void mostrarRegistros(RandomAccessFile file) throws IOException {
        file.seek(0);  // Posicionarse al inicio del archivo

        while (file.getFilePointer() < file.length()) {
            int id = file.readInt();         // Leer ID (4 bytes)
            short edad = file.readShort();   // Leer Edad (2 bytes)
            float salario = file.readFloat();// Leer Salario (4 bytes)

            // Mostrar el registro
            System.out.println("ID: " + id + ", Edad: " + edad + ", Salario: " + salario);
        }
    }

    // Método para saltar a un registro específico y leerlo usando acceso aleatorio
    public static void saltarYLeerRegistro(RandomAccessFile file, int numeroRegistro) throws IOException {
        // Calcular la posición del registro en bytes y mover el puntero a esa posición
        long posicion = TAMANO_REGISTRO * (numeroRegistro - 1);  // Ejemplo: segundo registro -> 10 * (2 - 1) = 10 bytes
        file.seek(posicion);  // Mover el puntero a la posición del registro deseado

        // Leer y mostrar el registro actual en la posición especificada
        int id = file.readInt();          // Leer ID (4 bytes)
        short edad = file.readShort();    // Leer Edad (2 bytes)
        float salario = file.readFloat(); // Leer Salario (4 bytes)

        // Mostrar el registro leído
        System.out.println("ID: " + id + ", Edad: " + edad + ", Salario: " + salario);
    }
}
