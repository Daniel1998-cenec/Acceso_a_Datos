package segundoEjercicio;

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
            String sql = "SELECT id, categoria, subcategoria FROM categorias";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre_categoria = rs.getString("categoria");
                String subcategoria = rs.getString("subcategoria");
                // Procesar los datos aqu�
                System.out.println("id: " + id + ", nombre: " + nombre_categoria + ", subcategoria: " + subcategoria);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

