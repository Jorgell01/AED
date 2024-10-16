package aed.tiendaonline;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class Cliente extends Pedidos {
    private String nombre;
    private String direccion;
    private List<Pedidos> pedidos;

    public Cliente() {
        super();
        this.pedidos = new ArrayList<>();
    }

    public Cliente(String nombre, String direccion, String productoNombre, double productoPrecio, String productoCategoria, List<Pedidos> pedidos) {
        super(productoNombre, productoPrecio, productoCategoria, new ArrayList<>(), null);
        this.nombre = nombre;
        this.direccion = direccion;
        this.pedidos = pedidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @XmlElement
    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void agregarPedido(Pedidos pedidos) {
        this.pedidos.add(pedidos);
    }
}
