package aed;

import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class AccesoDatos_Conectores_Ant_01 {

    public static void main(String[] args) {
        Connection con;
        String url = "jdbc:mariadb://localhost:3306/instituto";
        try {

            con = DriverManager.getConnection(url, "root", "");
            System.out.println("Conexión realizada con éxito.");

            String query = "SELECT * FROM alumnos";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                int num = rs.getInt("num");
                String nombre = rs.getString("nombre");
                Date fnac = rs.getDate("fnac");
                double media = rs.getDouble("media");
                String curso = rs.getString("curso");
                System.out.println(num + " " + nombre + " " + fnac + " " + media + " " + curso);
            }

            con.close();

            System.out.println("Conexión cerrada.");
        } catch (SQLException ex) {
            System.out.println("Ha ocurrido algún error.");
        }
    }
}