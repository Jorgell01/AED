package com.mycompany.crudaleatoriodat;


import java.io.Serializable;

public class Empleado implements Serializable {
    private String dni;
    private String nombre;
    private String apellidos;
    private String correoElectronico;

    public Empleado(String dni, String nombre, String apellidos, String correoElectronico) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correoElectronico = correoElectronico;
    }

    public String getDni() {
        return dni;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", correoElectronico='" + correoElectronico + '\'' +
                '}';
    }
}
