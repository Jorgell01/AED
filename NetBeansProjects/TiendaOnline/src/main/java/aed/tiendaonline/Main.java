package aed.tiendaonline;

import javax.swing.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tienda tienda = new Tienda();

        boolean continuar = true;
        while (continuar) {
            System.out.println("1. Agregar cliente");
            System.out.println("2. Agregar producto");
            System.out.println("3. Realizar pedido");
            System.out.println("4. Listar todos los pedidos de un cliente");
            System.out.println("5. Guardar tienda en XML");
            System.out.println("6. Cargar tienda desde XML");
            System.out.println("7. Salir");
            System.out.print("Elija una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    agregarCliente(tienda, scanner);
                    break;
                case 2:
                    agregarProducto(tienda, scanner);
                    break;
                case 3:
                    realizarPedido(tienda, scanner);
                    break;
                case 4:
                    listarPedidosDeCliente(tienda, scanner);
                    break;
                case 5:
                    guardarTiendaEnXML(tienda);
                    break;
                case 6:
                    tienda = cargarTiendaDesdeXML();
                    break;
                case 7:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
        scanner.close();
    }

    public static void agregarCliente(Tienda tienda, Scanner scanner) {
        System.out.print("Ingrese el nombre del cliente: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la dirección del cliente: ");
        String direccion = scanner.nextLine();

        Cliente cliente = new Cliente();
        cliente.setNombre(nombre);
        cliente.setDireccion(direccion);

        tienda.agregarCliente(cliente);
        System.out.println("Cliente agregado con éxito.");
    }

    public static void agregarProducto(Tienda tienda, Scanner scanner) {
        System.out.print("Ingrese el nombre del producto: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el precio del producto: ");
        double precio = scanner.nextDouble();
        scanner.nextLine(); // Consumir salto de línea
        System.out.print("Ingrese la categoría del producto: ");
        String categoria = scanner.nextLine();

        Productos producto = new Productos(nombre, precio, categoria);
        tienda.agregarProductos(producto);
        System.out.println("Producto agregado con éxito.");
    }

    public static void realizarPedido(Tienda tienda, Scanner scanner) {
        System.out.print("Ingrese el nombre del cliente: ");
        String nombreCliente = scanner.nextLine();

        Cliente cliente = tienda.getClientes().stream()
                .filter(c -> c.getNombre().equalsIgnoreCase(nombreCliente))
                .findFirst()
                .orElse(null);

        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        System.out.print("Ingrese el nombre del producto para el pedido: ");
        String nombreProducto = scanner.nextLine();

        Productos producto = tienda.getProductos().stream()
                .filter(p -> p.getNombre().equalsIgnoreCase(nombreProducto))
                .findFirst()
                .orElse(null);

        if (producto == null) {
            System.out.println("Producto no encontrado.");
            return;
        }

        Pedidos pedido = new Pedidos(producto.getNombre(), producto.getPrecio(), producto.getCategoria());
        cliente.agregarPedido(pedido);
        tienda.agregarPedidos(pedido);

        System.out.println("Pedido realizado con éxito.");
    }

    public static void listarPedidosDeCliente(Tienda tienda, Scanner scanner) {
        System.out.print("Ingrese el nombre del cliente: ");
        String nombreCliente = scanner.nextLine();

        Cliente cliente = tienda.getClientes().stream()
                .filter(c -> c.getNombre().equalsIgnoreCase(nombreCliente))
                .findFirst()
                .orElse(null);

        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        System.out.println("Pedidos del cliente " + cliente.getNombre() + ":");
        for (Pedidos pedido : cliente.getPedidos()) {
            System.out.println("- Producto: " + pedido.getNombre() + " | Precio: " + pedido.getPrecio() + " | Categoría: " + pedido.getCategoria());
        }
    }

    public static void guardarTiendaEnXML(Tienda tienda) {
        try {
            MarshallerTienda.marshall(tienda, "tienda.xml");
            System.out.println("Tienda guardada en XML con éxito.");
        } catch (Exception e) {
            System.out.println("Error al guardar la tienda en XML: " + e.getMessage());
        }
    }

    public static Tienda cargarTiendaDesdeXML() {
        try {
            Tienda tienda = UnmarshallerTienda.unmarshall("tienda.xml");
            System.out.println("Tienda cargada desde XML con éxito.");
            return tienda;
        } catch (Exception e) {
            System.out.println("Error al cargar la tienda desde XML: " + e.getMessage());
            return new Tienda();
        }
    }
}
