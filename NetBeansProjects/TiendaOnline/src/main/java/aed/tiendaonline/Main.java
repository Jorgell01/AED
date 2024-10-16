package aed.tiendaonline;

import javax.swing.*;
import java.util.Scanner;

public class Main {
    public static void main(String [] args) {
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

            int opcion = scanner.nextInt();
            scanner.nextLine();

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
                    ListarPedidosCliente(tienda, scanner);
                    break;

                case 5:
                    guardarTiendaXML(tienda, scanner);
                    break;

                case 6:
                    tienda = cargarTiendaXML(tienda, scanner);
                    break;

                case 7:
                    continuar = false;
                    break;

                default:
                    System.out.println("Opción no válida");
            }
        }
        scanner.close();
    }

    private static void agregarCliente(Tienda tienda, Scanner scanner) {

    }

}
