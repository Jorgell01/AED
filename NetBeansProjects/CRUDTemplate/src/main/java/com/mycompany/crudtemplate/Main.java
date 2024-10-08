package com.mycompany.crudtemplate;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Mondongo
 */
public class Main {
    private static CRUDTemplate<Usuario> crud = new CRUDTemplate<>("usuarios.bin");
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String opcion;

        while (true) {
            mostrarMenu();
            opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    agregarUsuario();
                    break;
                case "2":
                    eliminarUsuario();
                    break;
                case "3":
                    buscarUsuario();
                    break;
                case "4":
                    editarUsuario();
                    break;
                case "5":
                    System.out.println("Saliendo del programa...");
                    return;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
                    break;
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("\n=== Menú CRUD ===");
        System.out.println("1. Agregar usuario");
        System.out.println("2. Eliminar usuario");
        System.out.println("3. Buscar usuario");
        System.out.println("4. Editar usuario");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void agregarUsuario() throws IOException, ClassNotFoundException {
        System.out.print("Ingrese el DNI: ");
        String dni = scanner.nextLine();
        System.out.print("Ingrese el nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese los apellidos: ");
        String apellidos = scanner.nextLine();
        System.out.print("Ingrese el correo electrónico: ");
        String correo = scanner.nextLine();

        Usuario usuario = new Usuario(dni, nombre, apellidos, correo);
        crud.agregar(usuario);
    }

    private static void eliminarUsuario() throws IOException, ClassNotFoundException {
        System.out.print("Ingrese el DNI del usuario a eliminar: ");
        String dni = scanner.nextLine();

        crud.eliminar(u -> u.getDni().equals(dni));
    }

    private static void buscarUsuario() throws IOException, ClassNotFoundException {
        System.out.print("Ingrese el DNI del usuario a buscar: ");
        String dni = scanner.nextLine();

        Usuario usuario = crud.buscar(u -> u.getDni().equals(dni));
        if (usuario != null) {
            System.out.println("Usuario encontrado: " + usuario);
        }
    }

    private static void editarUsuario() throws IOException, ClassNotFoundException {
        System.out.print("Ingrese el DNI del usuario a editar: ");
        String dni = scanner.nextLine();
        System.out.print("Ingrese el nuevo nombre: ");
        String nuevoNombre = scanner.nextLine();
        System.out.print("Ingrese los nuevos apellidos: ");
        String nuevosApellidos = scanner.nextLine();
        System.out.print("Ingrese el nuevo correo electrónico: ");
        String nuevoCorreo = scanner.nextLine();

        Usuario nuevoUsuario = new Usuario(dni, nuevoNombre, nuevosApellidos, nuevoCorreo);
        crud.editar(u -> u.getDni().equals(dni), nuevoUsuario);
    }
}
