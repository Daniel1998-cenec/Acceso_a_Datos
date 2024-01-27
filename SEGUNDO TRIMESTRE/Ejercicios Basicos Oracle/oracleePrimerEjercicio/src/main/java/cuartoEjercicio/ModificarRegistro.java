package cuartoEjercicio;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ModificarRegistro {
    public static void modificarRegistro(int id, String nuevoNombre, String nuevoapellido1) {
        Connection conexion = CrearTabla.obtenerConexion();
        if (conexion != null) {
            PreparedStatement preparedStatement = null;

            try {
                // Actualizar el registro en la tabla "empresa"
                String actualizarRegistroSQL = "UPDATE alumno SET nombre=?, apellido1=? WHERE id=?";
                preparedStatement = conexion.prepareStatement(actualizarRegistroSQL);
                preparedStatement.setString(1, nuevoNombre);
                preparedStatement.setString(2, nuevoapellido1);
                preparedStatement.setInt(3, id);

                int filasAfectadas = preparedStatement.executeUpdate();

                if (filasAfectadas > 0) {
                    System.out.println("Registro actualizado con �xito.");
                    System.out.println(id+ " , "+nuevoNombre+ " , "+nuevoapellido1);
                    
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
            System.out.println("No se pudo establecer la conexi�n.");
        }
       
    }

    public static void main(String[] args) {
        // Ejemplo de uso
    	 modificarRegistro(6, "Cristina", "Lopez");
    	 
    }
}
