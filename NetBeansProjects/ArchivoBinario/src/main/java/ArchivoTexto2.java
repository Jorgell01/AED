import java.io.*;

public class ArchivoTexto2 {
    public static void main(String[] args) {
        File archivo = new File("datos.txt");
        FileReader fr = null;
        BufferedReader br = null;

        try{
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (FileNotFoundException e) {
            System.out.print("El archivo no existe: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        } finally {
            try {
                if (br != null) br.close();
                if (fr != null) br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
