package aed;

import java.math.BigDecimal;
import java.sql.*;

public class CRUDGestion_Empleados {
    public static void main(String[] args) {
        CRUDGestion_Empleados gestionEmpleados = new CRUDGestion_Empleados();
        gestionEmpleados.readEmpleadoById(1);
    }

    public void createEmpleado(int id, String nombre, String apellido, String email, BigDecimal salario, Date fechaContratacion) {
        String insertQuery = "INSERT INTO empleados (id, nombre, apellido, email, salario, fecha_contratacion) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/gestion_empleados", "root", "")) {
            System.out.println("Conexión establecida correctamente.");
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setInt(1, id);
                preparedStatement.setString(2, nombre);
                preparedStatement.setString(3, apellido);
                preparedStatement.setString(4, email);
                preparedStatement.setBigDecimal(5, salario);
                preparedStatement.setDate(6, fechaContratacion);

                int filasAfectadas = preparedStatement.executeUpdate();
                System.out.println("Filas afectadas: " + filasAfectadas);
            }
        } catch (SQLException e) {
            System.err.println("Error al insertar empleado: " + e.getMessage());
        }
    }

    public void readAllEmpleados() {
        String query = "SELECT * FROM empleados";
        try (Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/gestion_empleados", "root", "")) {
            System.out.println("Conexión establecida correctamente.");
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(query)) {
                while (resultSet.next()) {
                    System.out.println("ID: " + resultSet.getInt("id"));
                    System.out.println("Nombre: " + resultSet.getString("nombre"));
                    System.out.println("Apellido: " + resultSet.getString("apellido"));
                    System.out.println("Email: " + resultSet.getString("email"));
                    System.out.println("Salario: " + resultSet.getBigDecimal("salario"));
                    System.out.println("Fecha de contratación: " + resultSet.getDate("fecha_contratacion"));
                    System.out.println("=====================================");
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al leer empleados: " + e.getMessage());
        }
    }

    public void readEmpleadoById(int id) {
        String query = "SELECT * FROM empleados WHERE id = ?";
        try (Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/gestion_empleados", "root", "")) {
            System.out.println("Conexión establecida correctamente.");
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    System.out.println("ID: " + resultSet.getInt("id"));
                    System.out.println("Nombre: " + resultSet.getString("nombre"));
                    System.out.println("Apellido: " + resultSet.getString("apellido"));
                    System.out.println("Email: " + resultSet.getString("email"));
                    System.out.println("Salario: " + resultSet.getBigDecimal("salario"));
                    System.out.println("Fecha de contratación: " + resultSet.getDate("fecha_contratacion"));
                    System.out.println("=====================================");
                } else {
                    System.out.println("No se encontró ningún empleado con ID: " + id);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al leer empleado por ID: " + e.getMessage());
        }
    }

    public void updateEmpleado(int id, String nombre, String apellido, String email, BigDecimal salario, Date fechaContratacion) {
        String updateQuery = "UPDATE empleados SET nombre = ?, apellido = ?, email = ?, salario = ?, fecha_contratacion = ? WHERE id = ?";
        try (Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/gestion_empleados", "root", "")) {
            System.out.println("Conexión establecida correctamente.");
            try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
                preparedStatement.setString(1, nombre);
                preparedStatement.setString(2, apellido);
                preparedStatement.setString(3, email);
                preparedStatement.setBigDecimal(4, salario);
                preparedStatement.setDate(5, fechaContratacion);
                preparedStatement.setInt(6, id);

                int filasAfectadas = preparedStatement.executeUpdate();
                System.out.println("Empleado actualizado. Filas afectadas: " + filasAfectadas);
            }
        } catch (SQLException e) {
            System.err.println("Error al actualizar empleado: " + e.getMessage());
        }
    }

    public void deleteEmpleado(int id) {
        String deleteQuery = "DELETE FROM empleados WHERE id = ?";
        try (Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/gestion_empleados", "root", "")) {
            System.out.println("Conexión establecida correctamente.");
            try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
                preparedStatement.setInt(1, id);

                int filasAfectadas = preparedStatement.executeUpdate();
                System.out.println("Empleado eliminado. Filas afectadas: " + filasAfectadas);
            }
        } catch (SQLException e) {
            System.err.println("Error al eliminar empleado: " + e.getMessage());
        }
    }

    public void buscarEmpleado(String campo, String valor) {
        String query = "SELECT * FROM empleados WHERE " + campo + " = ?";
        try (Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/gestion_empleados", "root", "")) {
            System.out.println("Conexión establecida correctamente.");
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, valor);
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    System.out.println("ID: " + resultSet.getInt("id"));
                    System.out.println("Nombre: " + resultSet.getString("nombre"));
                    System.out.println("Apellido: " + resultSet.getString("apellido"));
                    System.out.println("Email: " + resultSet.getString("email"));
                    System.out.println("Salario: " + resultSet.getBigDecimal("salario"));
                    System.out.println("Fecha de contratación: " + resultSet.getDate("fecha_contratacion"));
                    System.out.println("=====================================");
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar empleado: " + e.getMessage());
        }
    }
}