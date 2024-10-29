package aed;

import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class AccesoDatos_Conectores_Ant_02 {

    public static void main(String[] args) {
        Connection con;
        String url = "jdbc:mariadb://localhost:3306/animales";
        try {

            con = DriverManager.getConnection(url, "root", "");
            System.out.println("Conexión realizada con éxito.");

            String query = "SELECT * FROM animales";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt("id");
                String propietario = rs.getString("propietario");
                String animal = rs.getString("animal");
                String raza = rs.getString("raza");
                System.out.println(id + " " + propietario + " " + animal + " " + raza + " ");
            }

            con.close();

            System.out.println("Conexión cerrada.");
        } catch (SQLException ex) {
            System.out.println("Ha ocurrido algún error." + ex.getMessage());
        }
    }
}
