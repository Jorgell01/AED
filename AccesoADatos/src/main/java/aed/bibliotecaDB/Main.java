package aed.bibliotecaDB;

import java.util.Scanner;

public class Main {
    private static final CRUDBiblioteca crudBiblioteca = new CRUDBiblioteca();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main (String[] args) {
        int opcion;
        do {
            System.out.println("---Sistema Gestor Biblioteca---");
            System.out.println("1. Agregar libro");
            System.out.println("2. Mostrar libros");
            System.out.println("3. Actualizar libro");
            System.out.println("4. Eliminar libro");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    agregarLibro();
                    break;
                case 2:
                    mostrarLibros();
                    break;
                case 3:
                    actualizarLibro();
                    break;
                case 4:
                    eliminarLibro();
                    break;
                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        } while (opcion != 5);
    }

    public static void agregarLibro() {
        System.out.print("Ingrese el título del libro: ");
        String titulo = scanner.nextLine();
        System.out.print("Ingrese el autor del libro: ");
        String autor = scanner.nextLine();
        System.out.print("Ingrese el año de publicación del libro: ");
        int anioPublicacion = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese el género del libro: ");
        String genero = scanner.nextLine();

        Libro libro = new Libro(0, titulo, autor, anioPublicacion, genero);
        crudBiblioteca.agregarLibro(libro);

        System.out.println("Libro agregado correctamente");
        System.out.println("=====================================");
    }

    public static void mostrarLibros() {
        System.out.println("Listado de libros");
        crudBiblioteca.obtenerLibros().forEach(libro -> {
            System.out.println("ID: " + libro.getId());
            System.out.println("Título: " + libro.getTitulo());
            System.out.println("Autor: " + libro.getAutor());
            System.out.println("Año de publicación: " + libro.getAnioPublicacion());
            System.out.println("Género: " + libro.getGenero());
            System.out.println("=====================================");
        });
    }

    public static void actualizarLibro() {
        System.out.print("Ingrese el ID del libro a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese el nuevo título del libro: ");
        String titulo = scanner.nextLine();
        System.out.print("Ingrese el nuevo autor del libro: ");
        String autor = scanner.nextLine();
        System.out.print("Ingrese el nuevo año de publicación del libro: ");
        int anioPublicacion = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese el nuevo género del libro: ");
        String genero = scanner.nextLine();

        Libro libro = new Libro(id, titulo, autor, anioPublicacion, genero);
        crudBiblioteca.actualizarLibro(libro);

        System.out.println("Libro actualizado correctamente");
        System.out.println("=====================================");
    }

    public static void eliminarLibro() {
        System.out.print("Ingrese el ID del libro a eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        crudBiblioteca.eliminarLibro(id);
        System.out.println("Libro eliminado correctamente");
        System.out.println("=====================================");
    }
}
