package quintoEjercicio;

import java.sql.Connection;
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
            int id = 1;
            String nombre = "Monitor gaming de alta calidad";
            String descripcion="Monitor gaming de alta calidad";
            float precio=999.99f;
            String fabricante="Asus";
            int unidades=50;

            // Insertar el objeto en la tabla empresa
            String sql = "INSERT INTO producto (id, nombre, descripcion, precio, fabricante, unidades) VALUES (?, ?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.setString(2, nombre);
            stmt.setString(3, descripcion);
            stmt.setFloat(4, precio);
            stmt.setString(5, fabricante);
            stmt.setInt(6, unidades);
            stmt.executeUpdate();

            // Mostrar todos los datos de la tabla empresa
            sql = "SELECT * FROM producto";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_producto = rs.getInt("id");
                String nombre_producto = rs.getString("nombre");
                String descripcion_producto  = rs.getString("descripcion");
                float precio_producto= rs.getFloat("precio");
                String fabricante_producto= rs.getString("fabricante");
                int unidades_producto=rs.getInt("unidades");
                
                System.out.println("ID: " + id_producto + " | Nombre: " + nombre_producto + " | Descripcion: " + descripcion_producto
                		+" | Precio: " + precio_producto+ " | Fabricante: " + fabricante_producto+ " | Unidades: " + unidades_producto);
            }

            // Hacer commit de la transacci�n
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
