package dad.apicoches;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;

class Coche {
    private int id;
    private String marca_coche;
    private String modelo_coche;
    private int año_fabricación;
    private String email_compañía;

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca_coche() {
        return marca_coche;
    }

    public void setMarca_coche(String marca_coche) {
        this.marca_coche = marca_coche;
    }

    public String getModelo_coche() {
        return modelo_coche;
    }

    public void setModelo_coche(String modelo_coche) {
        this.modelo_coche = modelo_coche;
    }

    public int getAño_fabricación() {
        return año_fabricación;
    }

    public void setAño_fabricación(int año_fabricación) {
        this.año_fabricación = año_fabricación;
    }

    public String getEmail_compañía() {
        return email_compañía;
    }

    public void setEmail_compañía(String email_compañía) {
        this.email_compañía = email_compañía;
    }

    @Override
    public String toString() {
        return "Coche{" +
                "id=" + id +
                ", marca_coche='" + marca_coche + '\'' +
                ", modelo_coche='" + modelo_coche + '\'' +
                ", año_fabricación=" + año_fabricación +
                ", email_compañía='" + email_compañía + '\'' +
                '}';
    }
}

public class ConexionApiCoches {

    public static void main(String[] args) {
        // Tu API de Mockaroo
        String apiUrl = "https://my.api.mockaroo.com/Api_coches.json?key=1f395f20";
        String filePath = "coches_data.bin";

        try {
            // Paso 1: Obtener los registros de la API de Mockaroo
            String jsonResponse = fetchDataFromAPI(apiUrl);

            // Parsear la respuesta y almacenar los registros en un JSONArray
            JSONArray cochesArray = new JSONArray(jsonResponse);

            // Paso 2: Guardar los datos en un fichero binario
            try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filePath))) {
                for (int i = 0; i < cochesArray.length(); i++) {
                    JSONObject coche = cochesArray.getJSONObject(i);
                    int id = coche.getInt("id");
                    String marcaCoche = coche.getString("marca_coche");
                    String modeloCoche = coche.getString("modelo_coche");
                    int añoFabricacion = coche.getInt("año_fabricación");
                    String emailCompania = coche.getString("email_compañía");

                    // Escribir cada campo en el fichero binario
                    dos.writeInt(id);

                    // Escribir la marca del coche con longitud fija de 50 caracteres
                    String fixedMarcaCoche = String.format("%-50s", marcaCoche);
                    dos.writeUTF(fixedMarcaCoche);

                    // Escribir el modelo del coche con longitud fija de 50 caracteres
                    String fixedModeloCoche = String.format("%-50s", modeloCoche);
                    dos.writeUTF(fixedModeloCoche);

                    // Escribir el año de fabricación
                    dos.writeInt(añoFabricacion);

                    // Escribir el correo de la compañía con longitud fija de 100 caracteres
                    String fixedEmailCompania = String.format("%-100s", emailCompania);
                    dos.writeUTF(fixedEmailCompania);
                }
            }
            System.out.println("Datos almacenados correctamente en " + filePath);

            // Paso 3: Leer los datos almacenados para confirmar
            readBinaryFile(filePath);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Método para realizar la solicitud HTTP GET a la API y obtener la respuesta en formato String
    private static String fetchDataFromAPI(String apiUrl) throws IOException {
        URL url = new URL(apiUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");

        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("Error HTTP: " + conn.getResponseCode());
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            response.append(line);
        }
        conn.disconnect();
        return response.toString();
    }

    // Método para leer el archivo binario y mostrar su contenido
    private static void readBinaryFile(String filePath) throws IOException {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(filePath))) {
            System.out.println("=== Contenido del Archivo Binario ===");
            while (dis.available() > 0) {
                int id = dis.readInt();
                String marcaCoche = dis.readUTF().trim();
                String modeloCoche = dis.readUTF().trim();
                int añoFabricacion = dis.readInt();
                String emailCompania = dis.readUTF().trim();

                // Mostrar la información del coche
                System.out.println("ID: " + id + ", Marca: " + marcaCoche + ", Modelo: " + modeloCoche +
                        ", Año: " + añoFabricacion + ", Email Compañía: " + emailCompania);
            }
            System.out.println("=====================================");
        }
    }
}
