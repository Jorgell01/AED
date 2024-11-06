package aed.bibliotecaDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CRUDBiblioteca {
    //CRUD (Create, Read, Update, Delete) operations

    //Create
    public static void agregarLibro(Libro libro) {
        String sql = "INSERT INTO libros (titulo, autor, anio_publicacion, genero) VALUES (?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, libro.getTitulo());
            preparedStatement.setString(2, libro.getAutor());
            preparedStatement.setInt(3, libro.getAnioPublicacion());
            preparedStatement.setString(4, libro.getGenero());
            preparedStatement.executeUpdate();

            System.out.println("Libro agregado correctamente");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Read
    public List<Libro> obtenerLibros() {
        List<Libro> libros = new ArrayList<>();
        String sql = "SELECT * FROM libros";
        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String titulo = resultSet.getString("titulo");
                String autor = resultSet.getString("autor");
                int anioPublicacion = resultSet.getInt("anio_publicacion");
                String genero = resultSet.getString("genero");
                Libro libro = new Libro(id, titulo, autor, anioPublicacion, genero);
                libros.add(libro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return libros;
    }

    //Update
    public void actualizarLibro(Libro libro) {
        String sql = "UPDATE libros SET titulo = ?, autor = ?, anio_publicacion = ?, genero = ? WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, libro.getTitulo());
            preparedStatement.setString(2, libro.getAutor());
            preparedStatement.setInt(3, libro.getAnioPublicacion());
            preparedStatement.setString(4, libro.getGenero());
            preparedStatement.setInt(5, libro.getId());
            preparedStatement.executeUpdate();

            System.out.println("Libro actualizado correctamente");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Delete
    public void eliminarLibro(int id) {
        String sql = "DELETE FROM libros WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            System.out.println("Libro eliminado correctamente");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

