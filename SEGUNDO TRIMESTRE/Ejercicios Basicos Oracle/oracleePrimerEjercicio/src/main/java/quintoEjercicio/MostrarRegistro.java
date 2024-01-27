package quintoEjercicio;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MostrarRegistro {
    public static void mostrarRegistros() {
        Connection conexion = CrearTabla.obtenerConexion();

        if (conexion != null) {
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;

            try {
                // Consultar todos los registros de la tabla "empresa"
                String consultarRegistrosSQL = "SELECT * FROM producto";
                preparedStatement = conexion.prepareStatement(consultarRegistrosSQL);
                resultSet = preparedStatement.executeQuery();

                // Imprimir los resultados
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String nombre = resultSet.getString("nombre");
                    String descripcion = resultSet.getString("descripcion");
                    float precio= resultSet.getFloat("precio");
                    String fabricante = resultSet.getString("fabricante");
                    int unidades = resultSet.getInt("unidades");
                    System.out.println("ID: " + id + ", Nombre: " + nombre + ", Descripcion: " + descripcion
                    		+ ", Precio: " + precio+ ", Fabricante: " + fabricante+ ", Unidades: " + unidades);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (resultSet != null) {
                        resultSet.close();
                    }
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
        mostrarRegistros();
    }
}

