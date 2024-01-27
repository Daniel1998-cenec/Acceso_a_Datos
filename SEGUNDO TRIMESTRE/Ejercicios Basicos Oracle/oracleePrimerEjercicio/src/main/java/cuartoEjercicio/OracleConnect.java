package cuartoEjercicio;

import java.sql.Connection;
import java.sql.Date;
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
            String sql = "SELECT id, nombre, apellido1, apellido2, fecha_nacimiento, es_repetidor, teléfono FROM alumno";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
            	int id_alumno = rs.getInt("id");
                String nombre_alumno = rs.getString("nombre");
                String apellido1_alumno = rs.getString("apellido1");
                String apellido2_alumno = rs.getString("apellido2");
                Date fecha_nacimiento_alumno = rs.getDate("fecha_nacimiento");
                String es_repetidor_alumno = rs.getString("es_repetidor");
                String telefono_alumno = rs.getString("teléfono");
                
                // Procesar los datos aqu�
                System.out.println("id: " + id_alumno + ", nombre: " + nombre_alumno + ", apellido 1: " + apellido1_alumno
                					+ ", apellido 2: "+apellido2_alumno+ ", fecha nacimiento: "+ fecha_nacimiento_alumno
                					+ ", es repetidor: "+ es_repetidor_alumno+ ", teléfono"+telefono_alumno);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

