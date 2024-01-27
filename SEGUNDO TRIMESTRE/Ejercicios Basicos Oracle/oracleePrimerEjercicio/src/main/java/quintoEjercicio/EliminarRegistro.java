package quintoEjercicio;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EliminarRegistro {
    public static void eliminarRegistro(int id) {
        Connection conexion = CrearTabla.obtenerConexion();

        if (conexion != null) {
            PreparedStatement preparedStatement = null;

            try {
                // Eliminar el registro de la tabla "empresa"
                String eliminarRegistroSQL = "DELETE FROM producto WHERE id=?";
                preparedStatement = conexion.prepareStatement(eliminarRegistroSQL);
                preparedStatement.setInt(1, id);

                int filasAfectadas = preparedStatement.executeUpdate();

                if (filasAfectadas > 0) {
                    System.out.println("Registro con ID " + id + " eliminado con exito.");
                } else {
                    System.out.println("No se encontron el registro con ID: " + id);
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
