package com.mycompany.vehiculo;

/**
 *
 * @author Mondongo
 */
public class Vehiculo {
    // Atributos de la clase
    private String modelo;
    private double potencia;
    private boolean cRuedas;

    // Constructor que recibe el modelo como argumento
    public Vehiculo(String modelo) {
        this.modelo = modelo;
        this.potencia = 0.0; // Valor por defecto para potencia
        this.cRuedas = false; // Valor por defecto para tracción a las cuatro ruedas
    }

    // Método para obtener el modelo
    public String getModelo() {
        return modelo;
    }

    // Método para obtener la potencia
    public double getPotencia() {
        return potencia;
    }

    // Método para establecer la potencia
    public void setPotencia(double potencia) {
        this.potencia = potencia;
    }

    // Método para obtener la tracción a las cuatro ruedas
    public boolean iscRuedas() {
        return cRuedas;
    }

    // Método para establecer la tracción a las cuatro ruedas
    public void setCRuedas(boolean cRuedas) {
        this.cRuedas = cRuedas;
    }

    // Método para imprimir los datos del vehículo
    public String imprimir() {
        String traccion = iscRuedas() ? "Si" : "No";
        return "Modelo: " + modelo + "\n" +
               "Potencia: " + potencia + " CV\n" +
               "Traccion a las cuatro ruedas: " + traccion;
    }

    // Método principal para probar la clase
    public static void main(String[] args) {
        Vehiculo miVehiculo = new Vehiculo("Toyota Corolla");
        miVehiculo.setPotencia(120.0);
        miVehiculo.setCRuedas(true);

        System.out.println(miVehiculo.imprimir());
    }
}

