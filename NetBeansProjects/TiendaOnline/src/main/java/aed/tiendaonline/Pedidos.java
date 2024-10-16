package aed.tiendaonline;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedidos extends Productos{
    private List<Productos> productos;
    private Date realizacion_pedido;

    public Pedidos() {
        super();
        this.productos = new ArrayList<>();
    }

    public Pedidos(String nombre, double precio, String categoria, List<Productos> productos, Date realizacion_pedido) {
        super(nombre, precio, categoria);
        this.productos = productos;
        this.realizacion_pedido = realizacion_pedido;
    }

    @XmlElement
    public List<Productos> getProductos() {
        return productos;
    }

    public void setProductos(List<Productos> productos) {
        this.productos = productos;
    }

    @XmlElement
    public Date getRealizacion_pedido() {
        return realizacion_pedido;
    }

    public void setRealizacion_pedido(Date realizacion_pedido) {
        this.realizacion_pedido = realizacion_pedido;
    }
}
