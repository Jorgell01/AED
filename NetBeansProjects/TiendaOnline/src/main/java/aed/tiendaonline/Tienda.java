package aed.tiendaonline;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class Tienda {
    private List<Cliente> clientes;
    private List<Productos> productos;
    private List<Pedidos> pedidos;

    public Tienda() {
        this.clientes = new ArrayList<>();
        this.productos = new ArrayList<>();
        this.pedidos = new ArrayList<>();
    }

    @XmlElement
    public List<Cliente> getClientes() {
        return clientes;
    }

    public void agregarCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }

    @XmlElement
    public List<Productos> getProductos() {
        return productos;
    }

    public void agregarProductos(Productos productos) {
        this.productos.add(productos);
    }

    @XmlElement
    public List<Pedidos> getPedidos() {
        return pedidos;
    }

    public void agregarPedidos(Pedidos pedidos) {
        this.pedidos.add(pedidos);
    }
}
