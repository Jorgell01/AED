package com.mycompany.filtroproductos;

import java.io.*;
import java.util.*;

public class FiltroProductos {

    public static void main(String[] args) {
           
        String path = "C:\\Users\\Mondongo\\Desktop\\AED\\NetBeansProjects\\productos.txt"; 
        List<Producto> productosElectronica = new ArrayList<>();
        List<Producto> productosCalzado = new ArrayList<>();
        List<Producto> productosRopa = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String linea;

            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 4) {
                    String idProducto = partes[0];
                    String nombre = partes[1];
                    double precio = Double.parseDouble(partes[2]);
                    String categoria = partes[3];

                    Producto producto = new Producto(idProducto, nombre, precio, categoria);

                    if (categoria.equalsIgnoreCase("Electrónica")) {
                        productosElectronica.add(producto);
                    } else if (categoria.equalsIgnoreCase("Calzado")) {
                        productosCalzado.add(producto);
                    } else if (categoria.equalsIgnoreCase("Ropa")) {
                        productosRopa.add(producto);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        escribirArchivo("Electrónica.txt", productosElectronica);
        escribirArchivo("Calzado.txt", productosCalzado);
        escribirArchivo("Ropa.txt", productosRopa);
    }

    public static void escribirArchivo(String nombreArchivo, List<Producto> productos) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (Producto producto : productos) {
                writer.write(producto.toString()); 
                writer.newLine();
            }
            System.out.println("Archivo creado: " + nombreArchivo);
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo " + nombreArchivo + ": " + e.getMessage());
        }
    }
}
