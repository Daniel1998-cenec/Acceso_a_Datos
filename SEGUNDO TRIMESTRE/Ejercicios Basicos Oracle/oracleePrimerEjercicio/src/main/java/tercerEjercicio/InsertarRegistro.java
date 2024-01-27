package tercerEjercicio;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
            int codigo = 6;
            String nombre = "Alberto";
            
            
            // Insertar el objeto en la tabla empresa
            String sql = "INSERT INTO fabricante (codigo, nombre) VALUES (?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1,codigo);
            stmt.setString(2, nombre);
            stmt.executeUpdate();

            // Mostrar todos los datos de la tabla empresa
            sql = "SELECT * FROM fabricante";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_alumno = rs.getInt("codigo");
                String nombre_alumno = rs.getString("nombre");
                System.out.println("codigo: " + id_alumno + " | Nombre: " + nombre_alumno);
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
