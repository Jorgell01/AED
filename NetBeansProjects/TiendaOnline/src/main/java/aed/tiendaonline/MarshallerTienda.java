package aed.tiendaonline;

import aed.tiendaonline.Cliente;
import aed.tiendaonline.Pedidos;
import aed.tiendaonline.Productos;
import aed.tiendaonline.Tienda;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MarshallerTienda {
    public static void main(String[] args) {
        try {

            // Crear un objeto Tienda
            Tienda tienda = new Tienda();

            // Crear un cliente y agregarlo a la tienda
            Cliente cliente = new Cliente("Tomas Turbado", "123 Main St", "", 0.0, "", new ArrayList<Pedidos>());
            tienda.agregarCliente(cliente);

            // Crear un producto y agregarlo a la tienda
            Productos producto = new Productos("Portatil", 1000.00, "Electrónica");
            tienda.agregarProductos(producto);

            // Crear un pedido con una lista de productos y agregarlo al cliente y a la tienda
            List<Productos> productos = new ArrayList<>();
            productos.add(producto);
            Pedidos pedido = new Pedidos("", 0, "", productos, new Date());
            cliente.agregarPedido(pedido);
            tienda.agregarPedidos(pedido);

            // Crear el contexto de JAXB para la clase Tienda
            JAXBContext context = JAXBContext.newInstance(Tienda.class);

            // Crear el marshaller para convertir el objeto en XML
            javax.xml.bind.Marshaller marshaller = context.createMarshaller();

            // Formatear el XML con sangrías
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            // Guardar el objeto Tienda como archivo XML
            marshaller.marshal(tienda, new File("tienda.xml"));

            System.out.println("Archivo XML creado correctamente: tienda.xml");
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
