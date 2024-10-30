package aed;

import java.sql.*;

public class AccesoDatos_Conectores_Ant_03 {

    public static void main(String[] args) {
        Connection con;
        String url = "jdbc:mariadb://localhost:3306/taller";
        try {
            con = DriverManager.getConnection(url, "root", "");
            System.out.println("Conexión realizada con éxito.");

            // Potentially malicious input
            String InyeccionChunga = "1111 OR '1'='1'";
            String query = "SELECT * FROM empleados WHERE dni = '" + InyeccionChunga + "'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                int dni = rs.getInt("dni");
                String nombre = rs.getString("nombre");
                Date fecha_ingreso = rs.getDate("fecha_ingreso");
                System.out.println(dni + " " + nombre + " " + fecha_ingreso);
            }

            con.close();
            System.out.println("Conexión cerrada.");
        } catch (SQLException ex) {
            System.out.println("Ha ocurrido algún error." + ex.getMessage());
        }
    }
}