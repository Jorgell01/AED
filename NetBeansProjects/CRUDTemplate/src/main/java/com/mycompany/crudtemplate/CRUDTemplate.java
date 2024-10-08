package com.mycompany.crudtemplate;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mondongo
 */
public class CRUDTemplate<T extends Serializable> {

    private final String filePath;

    public CRUDTemplate(String filePath) {
        this.filePath = filePath;
    }

    // Método para agregar un objeto al fichero
    public void agregar(T objeto) throws IOException, ClassNotFoundException {
        List<T> objetos = leerTodos();
        objetos.add(objeto);
        guardarTodos(objetos);
        System.out.println("Objeto agregado exitosamente.");
    }

    // Método para eliminar un objeto del fichero
    public void eliminar(CriterioBusqueda<T> criterio) throws IOException, ClassNotFoundException {
        List<T> objetos = leerTodos();
        boolean encontrado = objetos.removeIf(criterio::cumpleCriterio);
        guardarTodos(objetos);
        if (encontrado) {
            System.out.println("Objeto eliminado exitosamente.");
        } else {
            System.out.println("Objeto no encontrado.");
        }
    }

    // Método para buscar un objeto en el fichero
    public T buscar(CriterioBusqueda<T> criterio) throws IOException, ClassNotFoundException {
        List<T> objetos = leerTodos();
        for (T objeto : objetos) {
            if (criterio.cumpleCriterio(objeto)) {
                System.out.println("Objeto encontrado: " + objeto);
                return objeto;
            }
        }
        System.out.println("Objeto no encontrado.");
        return null;
    }

    // Método para editar un objeto en el fichero
    public void editar(CriterioBusqueda<T> criterio, T nuevoObjeto) throws IOException, ClassNotFoundException {
        List<T> objetos = leerTodos();
        boolean encontrado = false;

        for (int i = 0; i < objetos.size(); i++) {
            if (criterio.cumpleCriterio(objetos.get(i))) {
                objetos.set(i, nuevoObjeto);
                encontrado = true;
                break;
            }
        }

        guardarTodos(objetos);

        if (encontrado) {
            System.out.println("Objeto editado exitosamente.");
        } else {
            System.out.println("Objeto no encontrado.");
        }
    }

    // Método para leer todos los objetos del fichero
    public List<T> leerTodos() throws IOException, ClassNotFoundException {
        File file = new File(filePath);
        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (List<T>) ois.readObject();
        }
    }

    // Método para guardar todos los objetos en el fichero
    private void guardarTodos(List<T> objetos) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(objetos);
        }
    }

    // Interfaz para definir el criterio de búsqueda
    public interface CriterioBusqueda<T> {
        boolean cumpleCriterio(T objeto);
    }
}

