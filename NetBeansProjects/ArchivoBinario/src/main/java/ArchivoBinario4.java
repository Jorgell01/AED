import java.io.IOException;
import java.io.RandomAccessFile;

public class ArchivoBinario4 {
    public static void main (String[] args) {
        int [] numeros = {1, 2, 3, 4, 5};
        try (RandomAccessFile raf = new RandomAccessFile("datos.bin", "rw")) {
            for (int numero : numeros) {
                raf.writeInt(numero);
            }

            raf.seek(0); // Volver al inicio para leer los valores
            for (int i = 0; i < numeros.length; i++) {
                int leido = raf.readInt();
                System.out.println("Numero leido: " + leido);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
