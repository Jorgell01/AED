package aed.tiendaonline;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class Pedidos extends Productos {
    private List<Productos> productos;
    private Cliente cliente;

    public Pedidos() {
        super();
        this.productos = new ArrayList<>();
    }

    public Pedidos(String nombre, double precio, String categoria) {
        super(nombre, precio, categoria);
        this.productos = new ArrayList<>();
    }

    @XmlElement
    public List<Productos> getProductos() {
        return productos;
    }

    public void agregarProducto(Productos producto) {
        this.productos.add(producto);
    }

    @XmlElement
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
