import java.io.IOException;
import java.io.RandomAccessFile;

public class ArchivoBinario {
    public static void main (String[] args) {
        try (RandomAccessFile raf = new RandomAccessFile("datos.bin", "rw")) {
            raf.writeInt(10);
            raf.writeInt(20);
            raf.writeInt(30);

            raf.seek(8); //Mover al último entero
            int numero1 = raf.readInt();

            raf.seek(4); //Mover al segundo entero
            int numero2 = raf.readInt();

            raf.seek(0); //Mover al primer entero
            int numero3 = raf.readInt();

            System.out.println("Numero 1: " + numero1);
            System.out.println("Numero 2: " + numero2);
            System.out.println("Numero 3: " + numero3);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
