package aed;

import java.sql.*;

public class InsertBichadoTallerEmpleado {

    public static void main(String[] args) {
        Connection con;
        String url = "jdbc:mariadb://localhost:3306/taller";
        try {
            con = DriverManager.getConnection(url, "root", "");
            System.out.println("Conexión realizada con éxito.");

            String insertQuery = "INSERT INTO empleados (dni, nombre, fecha_ingreso) VALUES (?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(insertQuery);
            pst.setInt(1, 7777);
            pst.setString(2, "Juan Perez");
            pst.setDate(3, Date.valueOf("2023-10-01"));
            pst.executeUpdate();

            System.out.println("Empleado insertado con éxito.");

            con.close();
            System.out.println("Conexión cerrada.");
        } catch (SQLException ex) {
            System.out.println("Ha ocurrido algún error." + ex.getMessage());
        }
    }
}