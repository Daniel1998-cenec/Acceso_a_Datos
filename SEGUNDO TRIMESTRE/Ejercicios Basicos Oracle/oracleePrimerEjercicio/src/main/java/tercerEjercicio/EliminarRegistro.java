package tercerEjercicio;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EliminarRegistro {
    public static void eliminarRegistro(int id) {
        Connection conexion = CrearTabla.obtenerConexion();

        if (conexion != null) {
            PreparedStatement preparedStatement = null;

            try {
                
                String eliminarRegistroSQL = "DELETE FROM fabricante WHERE codigo=?";
                preparedStatement = conexion.prepareStatement(eliminarRegistroSQL);
                preparedStatement.setInt(1, id);

                int filasAfectadas = preparedStatement.executeUpdate();

                if (filasAfectadas > 0) {
                    System.out.println("Registro con codigo " + id + " eliminado con exito.");
                } else {
                    System.out.println("No se encontron el registro con codigo: " + id);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (preparedStatement != null) {
                        preparedStatement.close();
                    }
                    if (conexion != null) {
                        conexion.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("No se pudo establecer la conexion.");
        }
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        eliminarRegistro(1);
    }
}
