package aed;

import javax.xml.bind.*;
import java.io.File;
import java.util.Scanner;

public class Main {
    private static final String CATALOGO_XML = "catalogo.xml";
    private static CatalogoLibros catalogoLibros = new CatalogoLibros();

    public static void main(String[] args) {
        cargarCatalogo();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Menú del Catálogo de Libros");
            System.out.println("1. Agregar libro");
            System.out.println("2. Eliminar libro");
            System.out.println("3. Listar libros");
            System.out.println("4. Guardar catálogo");
            System.out.println("5. Cargar catálogo");
            System.out.println("6. Salir");
            System.out.println("Elige una opción:");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    agregarLibro(scanner);
                    break;
                case 2:
                    eliminarLibro(scanner);
                    break;
                case 3:
                    catalogoLibros.listarLibros();
                    break;
                case 4:
                    guardarCatalogo();
                    break;
                case 5:
                    cargarCatalogo();
                    break;
                case 6:
                    System.out.println("Cerrando programa...");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (opcion != 6);

        scanner.close();
    }

    // Métodos ahora dentro de la clase Main

    private static void agregarLibro(Scanner scanner) {
        System.out.print("Introduce el título: ");
        String titulo = scanner.nextLine();
        System.out.print("Introduce el autor: ");
        String autor = scanner.nextLine();
        System.out.print("Introduce el año de publicación: ");
        int anioPublicacion = scanner.nextInt();
        scanner.nextLine();  // Limpiar buffer
        System.out.print("Introduce el género: ");
        String genero = scanner.nextLine();

        Libro libro = new Libro(titulo, autor, anioPublicacion, genero);
        catalogoLibros.agregarLibro(libro);
        System.out.println("Libro añadido al catálogo");
    }

    private static void eliminarLibro(Scanner scanner) {
        System.out.print("Introduce el título del libro a eliminar: ");
        String titulo = scanner.nextLine();
        catalogoLibros.eliminarLibro(titulo);
        System.out.println("Libro eliminado (si existía).");
    }

    private static void guardarCatalogo() {
        try {
            JAXBContext context = JAXBContext.newInstance(CatalogoLibros.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(catalogoLibros, new File(CATALOGO_XML));  // Aquí usamos catalogoLibros
            System.out.println("Archivo XML creado exitosamente: catalogo.xml");
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    private static void cargarCatalogo() {
        try {
            File archivo = new File(CATALOGO_XML);
            if (archivo.exists()) {
                JAXBContext context = JAXBContext.newInstance(CatalogoLibros.class);
                Unmarshaller unmarshaller = context.createUnmarshaller();
                catalogoLibros = (CatalogoLibros) unmarshaller.unmarshal(archivo);
                System.out.println("Catálogo cargado desde " + CATALOGO_XML);
            } else {
                System.out.println("No se encontró el archivo " + CATALOGO_XML + ", se creará un catálogo nuevo.");
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
