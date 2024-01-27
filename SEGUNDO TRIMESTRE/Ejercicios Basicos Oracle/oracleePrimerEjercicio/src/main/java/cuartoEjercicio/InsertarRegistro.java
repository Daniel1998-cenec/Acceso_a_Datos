package cuartoEjercicio;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;

public class InsertarRegistro {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // Registrar el driver JDBC
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Establecer la conexi�n con la base de datos
            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            String usuario = "SYSTEM";
            String contrasena = "1234";
            conn = DriverManager.getConnection(url, usuario, contrasena);

            // Iniciar la transacci�n
            conn.setAutoCommit(false);

            // Crear el objeto Empresa con los datos a insertar
            int id = 6;
            String nombre = "Alberto";
            String apellido1 = "España";
            String apellido2 = "Lopez";
            Date fecha_nacimiento = Date.valueOf("1975-05-05");
            String es_repetidor ="si";
            String teléfono ="765321098";
            
            
            // Insertar el objeto en la tabla empresa
            String sql = "INSERT INTO alumno (id, nombre, apellido1, apellido2, fecha_nacimiento, es_repetidor, teléfono) VALUES (?, ?, ?,?,?,?,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.setString(2, nombre);
            stmt.setString(3, apellido1);
            stmt.setString(4, apellido2);
            stmt.setDate(5, fecha_nacimiento);
            stmt.setString(6, es_repetidor);
            stmt.setString(7, teléfono);
            stmt.executeUpdate();

            // Mostrar todos los datos de la tabla empresa
            sql = "SELECT * FROM alumno";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_alumno = rs.getInt("id");
                String nombre_alumno = rs.getString("nombre");
                String apellido1_alumno = rs.getString("apellido1");
                String apellido2_alumno = rs.getString("apellido2");
                Date fecha_nacimiento_alumno = rs.getDate("fecha_nacimiento");
                String es_repetidor_alumno = rs.getString("es_repetidor");
                String telefono_alumno = rs.getString("teléfono");
                System.out.println("ID: " + id_alumno + " | Nombre: " + nombre_alumno + " | Apellido: " + apellido1_alumno
                					+"| Apellido 2: " + apellido2_alumno + " | Fecha nacimiento: " + fecha_nacimiento_alumno 
                					+" | ¿Es repetidor?: " + es_repetidor_alumno  +" | Teléfono: " + telefono_alumno);
            }

            // Hacer commit de la transaccion
            conn.commit();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            // Si ocurre alg�n error, hacer rollback de la transacci�n
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            // Cerrar la conexi�n y los recursos
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
