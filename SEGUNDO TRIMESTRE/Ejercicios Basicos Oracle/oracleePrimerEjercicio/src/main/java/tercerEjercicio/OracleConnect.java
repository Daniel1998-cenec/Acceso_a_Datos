package tercerEjercicio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OracleConnect {

    public static void main(String[] args) {
        try {
            String url = "jdbc:oracle:thin:@//localhost:1521/xe";
            String username = "SYSTEM";
            String password = "1234";
            Connection conn = DriverManager.getConnection(url, username, password);
            String sql = "SELECT codigo, nombre FROM fabricante";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int codigo = rs.getInt("codigo");
                String nombre = rs.getString("nombre");
                // Procesar los datos aquí
                System.out.println("codigo: " + codigo + ", nombre: " + nombre);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

