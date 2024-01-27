package quintoEjercicio;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ModificarRegistro {
    public static void modificarRegistro(int id, String nuevoNombre, String nuevaDescripcion, float nuevoPrecio, String nuevoFabricante, int nuevasUnidades) {
        Connection conexion = CrearTabla.obtenerConexion();
        if (conexion != null) {
            PreparedStatement preparedStatement = null;

            try {
                // Actualizar el registro en la tabla "empresa"
                String actualizarRegistroSQL = "UPDATE producto SET nombre=?, descripcion=?,precio=?, fabricante=?, unidades=? WHERE id=?";
                preparedStatement = conexion.prepareStatement(actualizarRegistroSQL);
                preparedStatement.setString(1, nuevoNombre);
                preparedStatement.setString(2, nuevaDescripcion);
                preparedStatement.setFloat(3, nuevoPrecio);
                preparedStatement.setString(4, nuevoFabricante);
                preparedStatement.setInt(5, nuevasUnidades);
                preparedStatement.setInt(6, id);

                int filasAfectadas = preparedStatement.executeUpdate();

                if (filasAfectadas > 0) {
                    System.out.println("Registro actualizado con �xito.");
                    System.out.println(id+ " , "+nuevoNombre+ " , "+nuevaDescripcion+ " , "+nuevoPrecio+ " , " +nuevoFabricante +" , " +nuevasUnidades);
                    
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
    	 modificarRegistro(1, "Ordenador","pc", 1000.99f, "Newskill", 200);
    	 
    }
}
