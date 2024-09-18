package com.mycompany.creardirectorios;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
/**
 *
 * @author Mondongo
 */
public class CrearDirectorios {
    public static void main(String[] args) {
        // Especifica la ruta del directorio a crear
        String rutaDirectorio = "C:\\Users\\Mondongo\\Desktop\\AED\\NetBeansProjects\\CrearDirectorios\\Mondongo2";
        
        // Crea un objeto Path a partir de la ruta especificada
        Path directorio = Paths.get(rutaDirectorio);
        
        try {
            // Crea el directorio y cualquier subdirectorio que no exista
            Files.createDirectories(directorio);
            System.out.println("Directorio creado en: " + rutaDirectorio);
        } catch (IOException e) {
            System.err.println("Error al crear el directorio: " + e.getMessage());
        }
    }
}
