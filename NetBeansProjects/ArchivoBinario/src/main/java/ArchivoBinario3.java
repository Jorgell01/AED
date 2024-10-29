import java.io.IOException;
import java.io.RandomAccessFile;

public class ArchivoBinario3 {
    public static void main(String[] args) {
        try (RandomAccessFile raf = new RandomAccessFile("datos.bin", "rw")) {
            raf.writeDouble(12.34);
            raf.writeDouble(56.78);

            raf.seek(0); //Volver al inicio para leer los doubles

            double valor1 = raf.readDouble();
            double valor2 = raf.readDouble();
            System.out.println("Valor 1: " + valor1);
            System.out.println("Valor 1: " + valor2);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
