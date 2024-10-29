import java.io.*;

public class ArchivoTexto {
    public static void main(String[] args) {
        File archivo = new File("datos.txt");
        File archivoSalida = new File("filtrado.txt");  // Archivo de salida
        FileReader fr = null;
        BufferedReader br = null;
        BufferedWriter bw = null;
        StringBuilder sb = new StringBuilder();  // StringBuilder para almacenar las líneas que cumplen la condición
        int numCaracteres = 14;  // Número específico de caracteres deseado

        try {
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            bw = new BufferedWriter(new FileWriter(archivoSalida));
            String linea;

            while ((linea = br.readLine()) != null) {
                if (linea.length() == numCaracteres) {  // Filtrar por el número de caracteres
                    sb.append(linea).append(System.lineSeparator());  // Añadir la línea al StringBuilder con un salto de línea
                }
            }

            // Escribir todo el contenido del StringBuilder en el archivo de salida
            bw.write(sb.toString());

        } catch (FileNotFoundException e) {
            System.out.println("El archivo no existe: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error al leer o escribir el archivo: " + e.getMessage());
        } finally {
            try {
                if (br != null) br.close();
                if (fr != null) fr.close();
                if (bw != null) bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
