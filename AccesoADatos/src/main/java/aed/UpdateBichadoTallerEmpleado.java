package aed;

import java.sql.*;

public class UpdateBichadoTallerEmpleado {

    public static void main(String[] args) {
        Connection con;
        String url = "jdbc:mariadb://localhost:3306/taller";
        try {
            con = DriverManager.getConnection(url, "root", "");
            System.out.println("Conexión realizada con éxito.");

            String updateQuery = "UPDATE empleados SET nombre = ?, fecha_ingreso = ? WHERE dni = ?";
            PreparedStatement pst = con.prepareStatement(updateQuery);
            pst.setString(1, "Juan Perez");
            pst.setDate(2, Date.valueOf("2023-10-01"));
            pst.setInt(3, 1111); // Update the existing record with dni 1111
            pst.executeUpdate();

            System.out.println("Empleado actualizado con éxito.");

            con.close();
            System.out.println("Conexión cerrada.");
        } catch (SQLException ex) {
            System.out.println("Ha ocurrido algún error." + ex.getMessage());
        }
    }
}