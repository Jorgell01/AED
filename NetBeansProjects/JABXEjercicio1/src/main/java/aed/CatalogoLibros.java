package aed;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CatalogoLibros {
    private List<Libro> libros = new ArrayList<>();

    @XmlElement
    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    public void eliminarLibro(String titulo) {
        libros.removeIf(libro -> libro.getTitulo().equalsIgnoreCase(titulo));
    }

    public void listarLibros() {
        libros.forEach(System.out::println);
    }
}

