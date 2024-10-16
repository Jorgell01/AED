package aed.tiendaonline;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class UnmarshallerTienda {

    public static void main(String[] args) {
        try {
            // Crear el contexto de JAXB para la clase Tienda
            JAXBContext context = JAXBContext.newInstance(Tienda.class);

            // Crear el Unmarshaller para convertir el XML a un objeto Tienda
            Unmarshaller unmarshaller = context.createUnmarshaller();

            // Leer el archivo XML y convertirlo a un objeto Tienda
            Tienda tienda = (Tienda) unmarshaller.unmarshal(new File("tienda.xml"));

            // Mostrar la información de la tienda cargada
            System.out.println("Tienda cargada desde XML:");
            System.out.println("Clientes: " + tienda.getClientes().size());
            System.out.println("Productos: " + tienda.getProductos().size());
            System.out.println("Pedidos: " + tienda.getPedidos().size());

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
