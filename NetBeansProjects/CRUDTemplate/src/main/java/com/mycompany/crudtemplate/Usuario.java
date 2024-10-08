/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crudtemplate;

import java.io.Serializable;

/**
 *
 * @author Mondongo
 */
public class Usuario implements Serializable {
    private String dni;
    private String nombre;
    private String apellidos;
    private String correoElectronico;

    public Usuario(String dni, String nombre, String apellidos, String correoElectronico) {
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
        return dni + ", " + nombre + ", " + apellidos + ", " + correoElectronico;
    }
}

