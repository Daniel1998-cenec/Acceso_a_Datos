package conexionmysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class EliminarTablaProducto {

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        
        try {
            conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/tiendaPc", "root", "");
            stmt = conn.createStatement();
            
            // Reemplaza "productos" con el nombre de la tabla que deseas eliminar
            String tablaAEliminar = "productos";
            String sql = "DROP TABLE " + tablaAEliminar;
            
            stmt.execute(sql);
            System.out.println("Eliminada la tabla " + tablaAEliminar);
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