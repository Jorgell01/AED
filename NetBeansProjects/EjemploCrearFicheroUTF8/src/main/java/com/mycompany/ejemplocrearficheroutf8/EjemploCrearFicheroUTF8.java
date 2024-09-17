package com.mycompany.ejemplocrearficheroutf8;

import java.io.*;
import java.nio.charset.StandardCharsets;
/**
 *
 * @author Mondongo
 */
public class EjemploCrearFicheroUTF8 {

    public static void main (String[] args) {
        try (Writer writer = new OutputStreamWriter (new FileOutputStream ("ejemplo_utf8.txt"),
            StandardCharsets.UTF_8)) {
            writer.write("¡Hola, mundo! ejemplo de codificación UTF8");
        }   catch (Exception e) {
            e.printStackTrace();
        }
    }
}
