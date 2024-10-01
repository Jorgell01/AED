package ficheroaleatorio;

import java.io.RandomAccessFile;
import java.io.IOException;

public class FicheroAleatorio {
    private static final int TAMANO_REGISTRO = 10; // Tamaño de cada registro en bytes

    public static void main(String[] args) {
        try (RandomAccessFile file = new RandomAccessFile("ejemplo_fichero.bin", "r")) {
            // Mostrar la cabecera de la tabla
            System.out.printf("%-10s %-10s %-10s%n", "ID", "Edad", "Salario");
            System.out.println("-----------------------------------");

            // Leer y mostrar todos los registros
            mostrarRegistros(file);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para leer y mostrar los registros del archivo
    public static void mostrarRegistros(RandomAccessFile file) throws IOException {
        // Calcular el número total de registros
        long totalRegistros = file.length() / TAMANO_REGISTRO;

        // Recorrer cada registro
        for (int i = 0; i < totalRegistros; i++) {
            file.seek(i * TAMANO_REGISTRO); // Posicionarse en el registro actual

            int id = file.readInt();         // Leer ID (4 bytes)
            short edad = file.readShort();   // Leer Edad (2 bytes)
            float salario = file.readFloat(); // Leer Salario (4 bytes)

            // Mostrar el registro en formato tabular
            System.out.printf("%-10d %-10d %-10.2f%n", id, edad, salario);
        }
    }
}

