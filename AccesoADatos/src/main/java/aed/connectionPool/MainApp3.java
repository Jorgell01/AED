package aed.connectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainApp3 {

    public static void main(String[] args) {
        // Crear un pool de threads para simular múltiples conexiones concurrentes
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        // Ejecutar varias tareas que solicitan conexiones del pool
        for (int i = 0; i < 20; i++) {
            executorService.submit(() -> {
                try (Connection connection = HikariDataSource.getConnection()) {
                    String query = "SELECT * FROM libros LIMIT 2"; // Cambia "tu_tabla" por el nombre real de tu tabla
                    try (PreparedStatement preparedStatement = connection.prepareStatement(query);
                         ResultSet resultSet = preparedStatement.executeQuery()) {
                        while (resultSet.next()) {
                            System.out.println("Resultado: " + resultSet.getString("titulo")); // Cambia "columna_ejemplo" por el nombre de la columna real
                        }
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });
        }

        // Cierra el servicio de ejecución después de que todas las tareas hayan terminado
        executorService.shutdown();

        // Cerrar el pool de conexiones al finalizar el programa
        Runtime.getRuntime().addShutdownHook(new Thread(HikariDataSource::close));
    }
}
