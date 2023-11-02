package conexionmysql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class EliminarDatosProductos {

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/tiendaPc", "root", "");
            stmt = conn.createStatement();

            // Reemplaza la condición en el WHERE con tu criterio de eliminación
            String sql = "DELETE FROM productos WHERE nombreProducto = 'portatil'";

            int filasEliminadas = stmt.executeUpdate(sql);

            System.out.println("Se eliminaron " + filasEliminadas + " filas de la tabla productos.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
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