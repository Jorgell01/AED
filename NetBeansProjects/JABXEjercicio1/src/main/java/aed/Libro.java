package aed;

import javax.xml.bind.annotation.XmlElement;

public class Libro {
    private String titulo;
    private String autor;
    private int anio_publicacion;
    private String genero;

    public Libro(String titulo, String autor, int anio_publicacion, String genero) {
        this.titulo = titulo;
        this.autor = autor;
        this.anio_publicacion = anio_publicacion;
        this.genero = genero;
    }

    @XmlElement
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @XmlElement
    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @XmlElement
    public int getAnio_publicacion() {
        return anio_publicacion;
    }

    public void setAnio_publicacion(int anio_publicacion) {
        this.anio_publicacion = anio_publicacion;
    }

    @XmlElement
    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}

