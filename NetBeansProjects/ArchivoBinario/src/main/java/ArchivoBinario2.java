import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;

public class ArchivoBinario2 {
    public static void main(String[] args) {
        try (RandomAccessFile raf = new RandomAccessFile("datos.bin", "rw")) {
            raf.writeInt(10);
            raf.writeDouble(3.14);
            raf.writeChar('X');

            raf.seek(0); //Volver al inicio para leer los datos

            int numero = raf.readInt();
            double decimal = raf.readDouble();
            char letra = raf.readChar();
            System.out.println("Entero: " + numero);
            System.out.println("Double: " + decimal);
            System.out.println("Caracter: " + letra);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
