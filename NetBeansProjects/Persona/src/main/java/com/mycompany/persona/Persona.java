package com.mycompany.persona;

import java.util.Scanner;

/**
 *
 * @author Mondongo
 */
public class Persona {

    String nombre;
    int edad;
    float altura;

    // Constructor sin parmetros
    public Persona() {
        nombre = "Sonia Salazar";
        edad = 27;
        altura = 1.72f;
    }

    // Constructor con parametros
    public Persona(String nombre, int edad, float altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.altura = altura;
    }

    String consulta_Nombre() {
        return nombre;
    }

    void cambia_Nombre(String nom) {
        nombre = nom;
    }

    int consulta_Edad() {
        return edad;
    }

    void cambia_Edad(int ed) {
        edad = ed;
    }

    float consulta_Altura() {
        return altura;
    }

    void cambia_Altura(float alt) {
        altura = alt;
    }

    // Metodo que comprueba si la persona es mayor de edad
    boolean esMayorDeEdad() {
        return edad >= 18;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Uso del constructor sin parametros
        Persona persona1 = new Persona();
        System.out.println("Persona 1 creada con constructor sin parametros:");
        System.out.println("Nombre: " + persona1.consulta_Nombre());
        System.out.println("Edad: " + persona1.consulta_Edad());
        System.out.println("Altura: " + persona1.consulta_Altura());

        // Modificación de la persona creada con el constructor sin parametros
        System.out.println("\nIntroduce el nuevo nombre para la persona 1:");
        String nombre = scanner.nextLine();
        persona1.cambia_Nombre(nombre);

        System.out.println("Introduce la nueva edad para la persona 1:");
        int edad = scanner.nextInt();
        persona1.cambia_Edad(edad);
        
        System.out.println("Introduce la nueva altura para la persona 1:");
        float altura = scanner.nextFloat();
        persona1.cambia_Altura(altura);

        System.out.println("\nPersona 1 modificada:");
        System.out.println("Nombre: " + persona1.consulta_Nombre());
        System.out.println("Edad: " + persona1.consulta_Edad());
        System.out.println("Altura: " + persona1.consulta_Altura());

        if (persona1.esMayorDeEdad()) {
            System.out.println(persona1.consulta_Nombre() + " es mayor de edad.");
        } else {
            System.out.println(persona1.consulta_Nombre() + " es menor de edad.");
        }

        // Limpiar el buffer del scanner
        scanner.nextLine();

        // Uso del constructor con parametros
        System.out.println("\nIntroduce los datos para la persona 2:");

        System.out.println("Introduce el nombre:");
        String nombre2 = scanner.nextLine();

        System.out.println("Introduce la edad:");
        int edad2 = scanner.nextInt();

        System.out.println("Introduce la altura:");
        float altura2 = scanner.nextFloat();

        // Creación de la persona 2 utilizando el constructor con parametros
        Persona persona2 = new Persona(nombre2, edad2, altura2);

        System.out.println("\nPersona 2 creada con constructor con parametros:");
        System.out.println("Nombre: " + persona2.consulta_Nombre());
        System.out.println("Edad: " + persona2.consulta_Edad());
        System.out.println("Altura: " + persona2.consulta_Altura());

        if (persona2.esMayorDeEdad()) {
            System.out.println(persona2.consulta_Nombre() + " es mayor de edad.");
        } else {
            System.out.println(persona2.consulta_Nombre() + " es menor de edad.");
        }
    }
}
