/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.caja;

/**
 *
 * @author Jorge
 */
public final class Caja {
    private final int ancho;
    private final int alto;
    private final int fondo;
    private String etiqueta;
    
    public Caja(int ancho, int alto, int fondo, Unidad unidad) {
        if (unidad == Unidad.CM) {
            this.ancho = ancho / 100;
            this.alto = alto / 100;
            this.fondo = fondo / 100;
        } else {
            this.ancho = ancho;
            this.alto = alto;
            this.fondo = fondo;
        }
        this.etiqueta = "";
    }
    
    public double getVolumen() {
        return ancho * alto * fondo;
    }
    
    public void setEtiqueta(String etiqueta) {
        if (etiqueta.length() <= 30) {
            this.etiqueta = etiqueta;
        } else {
            throw new IllegalArgumentException("La etiqueta no puede tener más de 30 caracteres.");
        }
    }
    
    public String getEtiqueta() {
        return etiqueta;
    }
    
    @Override
    public String toString() {
        return String.format("Caja [ancho=%d m, alto=%d m, fondo=%d m, volumen=%.2f m³, etiqueta=%s]",
                             ancho, alto, fondo, getVolumen(), etiqueta);
    }

    public static void main(String[] args) {
        // Crear una caja en centímetros
        Caja caja1 = new Caja(100, 200, 300, Unidad.CM);
        System.out.println(caja1);

        // Crear una caja en metros
        Caja caja2 = new Caja(1, 2, 3, Unidad.M);
        System.out.println(caja2);

        // Modificar y mostrar etiqueta
        caja1.setEtiqueta("Envío urgente");
        System.out.println("Etiqueta de caja1: " + caja1.getEtiqueta());
        
        // Mostrar volumen de caja1
        System.out.println("Volumen de caja1: " + caja1.getVolumen() + " m³");
        
        // Modificar y mostrar etiqueta
        caja2.setEtiqueta("Contenido Frágil, cuidado.");
        System.out.println("Etiqueta de caja1: " + caja2.getEtiqueta());
        
        // Mostrar volumen de caja2
        System.out.println("Volumen de caja2: " + caja2.getVolumen() + " m³");
    }
}
