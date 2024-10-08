package com.mycompany.crudaleatoriodat;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoCRUD {

    private static final String FILE_PATH = "AleatorioEmple.dat";

    // Método para agregar un empleado
    public static void agregarEmpleado(Empleado empleado) throws IOException, ClassNotFoundException {
        List<Empleado> empleados = leerEmpleados();
        empleados.add(empleado);
        guardarEmpleados(empleados);
        System.out.println("Empleado agregado exitosamente.");
    }

    // Método para eliminar un empleado
    public static void eliminarEmpleado(String dni) throws IOException, ClassNotFoundException {
        List<Empleado> empleados = leerEmpleados();
        boolean encontrado = empleados.removeIf(emp -> emp.getDni().equals(dni));
        guardarEmpleados(empleados);
        if (encontrado) {
            System.out.println("Empleado eliminado exitosamente.");
        } else {
            System.out.println("Empleado no encontrado.");
        }
    }

    // Método para buscar un empleado por DNI
    public static Empleado buscarEmpleado(String dni) throws IOException, ClassNotFoundException {
        List<Empleado> empleados = leerEmpleados();
        for (Empleado emp : empleados) {
            if (emp.getDni().equals(dni)) {
                return emp;
            }
        }
        return null;
    }
    
    //Método para mostrar todos los empleados
    public static void mostrarTodosLosEmpleados() throws IOException, ClassNotFoundException {
    List<Empleado> empleados = leerEmpleados();
    if (empleados.isEmpty()) {
        System.out.println("No hay empleados registrados.");
    } else {
        System.out.println("\n=== Lista de empleados ===");
        for (Empleado empleado : empleados) {
            System.out.println(empleado);
        }
    }
}

    // Método para editar un empleado
    public static void editarEmpleado(String dni, Empleado nuevoEmpleado) throws IOException, ClassNotFoundException {
        List<Empleado> empleados = leerEmpleados();
        boolean encontrado = false;
        for (int i = 0; i < empleados.size(); i++) {
            if (empleados.get(i).getDni().equals(dni)) {
                empleados.set(i, nuevoEmpleado);
                encontrado = true;
                break;
            }
        }
        guardarEmpleados(empleados);
        if (encontrado) {
            System.out.println("Empleado editado exitosamente.");
        } else {
            System.out.println("Empleado no encontrado.");
        }
    }

    // Método para leer todos los empleados del archivo binario
    public static List<Empleado> leerEmpleados() throws IOException, ClassNotFoundException {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            return new ArrayList<>();
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (List<Empleado>) ois.readObject();
        }
    }

    // Método para guardar la lista de empleados en el archivo binario
    private static void guardarEmpleados(List<Empleado> empleados) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(empleados);
        }
    }
}
