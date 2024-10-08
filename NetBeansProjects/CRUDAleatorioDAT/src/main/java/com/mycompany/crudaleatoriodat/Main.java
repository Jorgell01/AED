package com.mycompany.crudaleatoriodat;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        String opcion;

        while (true) {
            mostrarMenu();
            opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    agregarEmpleadoMenu(scanner);
                    break;
                case "2":
                    eliminarEmpleadoMenu(scanner);
                    break;
                case "3":
                    buscarEmpleadoMenu(scanner);
                    break;
                case "4":
                    editarEmpleadoMenu(scanner);
                    break;
                case "5":
                    mostrarTodosLosEmpleadosMenu();
                    break;
                case "6":
                    System.out.println("Saliendo del programa...");
                    return;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
                    break;
            }
        }
    }

    // Mostrar el menú
    private static void mostrarMenu() {
        System.out.println("\n=== Menú CRUD ===");
        System.out.println("1. Agregar empleado");
        System.out.println("2. Eliminar empleado");
        System.out.println("3. Buscar empleado");
        System.out.println("4. Editar empleado");
        System.out.println("5. Mostrar todos los empleados");
        System.out.println("6. Salir");
        System.out.print("Seleccione una opción: ");
    }

    // Menú para mostrar todos los empleados
    private static void mostrarTodosLosEmpleadosMenu() throws IOException, ClassNotFoundException {
        EmpleadoCRUD.mostrarTodosLosEmpleados();
    }

    // (Los métodos de agregar, eliminar, buscar y editar siguen igual)
    private static void agregarEmpleadoMenu(Scanner scanner) throws IOException, ClassNotFoundException {
        System.out.print("Ingrese el DNI: ");
        String dni = scanner.nextLine();
        System.out.print("Ingrese el nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese los apellidos: ");
        String apellidos = scanner.nextLine();
        System.out.print("Ingrese el correo electrónico: ");
        String correo = scanner.nextLine();

        Empleado empleado = new Empleado(dni, nombre, apellidos, correo);
        EmpleadoCRUD.agregarEmpleado(empleado);
    }

    private static void eliminarEmpleadoMenu(Scanner scanner) throws IOException, ClassNotFoundException {
        System.out.print("Ingrese el DNI del empleado a eliminar: ");
        String dni = scanner.nextLine();
        EmpleadoCRUD.eliminarEmpleado(dni);
    }

    private static void buscarEmpleadoMenu(Scanner scanner) throws IOException, ClassNotFoundException {
        System.out.print("Ingrese el DNI del empleado a buscar: ");
        String dni = scanner.nextLine();
        Empleado empleado = EmpleadoCRUD.buscarEmpleado(dni);
        if (empleado != null) {
            System.out.println("Empleado encontrado: " + empleado);
        } else {
            System.out.println("Empleado no encontrado.");
        }
    }

    private static void editarEmpleadoMenu(Scanner scanner) throws IOException, ClassNotFoundException {
        System.out.print("Ingrese el DNI del empleado a editar: ");
        String dni = scanner.nextLine();
        System.out.print("Ingrese el nuevo nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese los nuevos apellidos: ");
        String apellidos = scanner.nextLine();
        System.out.print("Ingrese el nuevo correo electrónico: ");
        String correo = scanner.nextLine();

        Empleado nuevoEmpleado = new Empleado(dni, nombre, apellidos, correo);
        EmpleadoCRUD.editarEmpleado(dni, nuevoEmpleado);
    }
}
