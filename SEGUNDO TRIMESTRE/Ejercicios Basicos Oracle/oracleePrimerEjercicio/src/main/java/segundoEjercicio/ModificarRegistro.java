package segundoEjercicio;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ModificarRegistro {
    public static void modificarRegistro(int id, String nuevoCategoria, String nuevoSubcategoria) {
        Connection conexion = CrearTabla.obtenerConexion();
        if (conexion != null) {
            PreparedStatement preparedStatement = null;

            try {
                // Actualizar el registro en la tabla "empresa"
                String actualizarRegistroSQL = "UPDATE categorias SET categoria=?, subcategoria=? WHERE id=?";
                preparedStatement = conexion.prepareStatement(actualizarRegistroSQL);
                preparedStatement.setString(1, nuevoCategoria);
                preparedStatement.setString(2, nuevoSubcategoria);
                preparedStatement.setInt(3, id);

                int filasAfectadas = preparedStatement.executeUpdate();

                if (filasAfectadas > 0) {
                    System.out.println("Registro actualizado con exito.");
                    System.out.println(id+ " , "+nuevoCategoria+ " , "+nuevoSubcategoria);
                    
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
    	 modificarRegistro(5, "Pescado", "sushi");
    	 
    }
}
