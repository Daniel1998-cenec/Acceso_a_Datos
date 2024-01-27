package tercerEjercicio;


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
                String consultarRegistrosSQL = "SELECT * FROM Fabricante";
                preparedStatement = conexion.prepareStatement(consultarRegistrosSQL);
                resultSet = preparedStatement.executeQuery();

                // Imprimir los resultados
                while (resultSet.next()) {
                    int codigo = resultSet.getInt("codigo");
                    String nombre = resultSet.getString("nombre");

                    System.out.println("codigo: " + codigo + ", nombre: " + nombre);
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
            System.out.println("No se pudo establecer la conexion.");
        }
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        mostrarRegistros();
    }
}

