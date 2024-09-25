package com.mycompany.filtroproductos;

/**
 *
 * @author Mondongo
 */
public class Producto {
    private String id_producto;
    private String nombre;
    private double precio;
    private String categoria;
    
    public Producto(String id_producto, String nombre, double precio, String categoria) {
        this.id_producto = id_producto;
        this.categoria = categoria;
        this.nombre = nombre;
        this.precio = precio;
    }
    
    public String getId_Producto () {
        return id_producto;
    }
    
   public void setId_Producto (String id_producto) {
       this.id_producto = id_producto;
   }
   
   public String getNombre () {
       return nombre;
   }
   
   public void setNombre (String nombre) {
       this.nombre = nombre;
   }
   
   public double getPrecio () {
       return precio;
   }
   
   public void setPrecio (double precio) {
       this.precio = precio;
   }
   
   public String getCategoria () {
       return categoria;
   }
   
   public void setCategorua (String categoria) {
       this.categoria = categoria;
   }
   
   @Override
   public String toString() {
       return id_producto + "," + nombre + "," + precio + "," + categoria;
   }
}
            

