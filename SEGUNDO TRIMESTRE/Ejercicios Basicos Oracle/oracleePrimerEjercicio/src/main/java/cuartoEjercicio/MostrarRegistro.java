package cuartoEjercicio;


import java.sql.Connection;
import java.sql.Date;
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
                
                String consultarRegistrosSQL = "SELECT * FROM Alumno";
                preparedStatement = conexion.prepareStatement(consultarRegistrosSQL);
                resultSet = preparedStatement.executeQuery();

                // Imprimir los resultados
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String nombre = resultSet.getString("nombre");
                    String apellido1 = resultSet.getString("apellido1");
                    String apellido2 = resultSet.getString("apellido2");
                    Date fecha_nacimiento = resultSet.getDate("fecha_nacimiento");
                    String es_repetidor = resultSet.getString("es_repetidor");
                    String teléfono = resultSet.getString("teléfono");

                    System.out.println("ID: " + id + ", Nombre: " + nombre + ", apellido1: " + apellido1
                    		+ ", apellido2: " + apellido2+ ", fecha_nacimiento: " + fecha_nacimiento
                    		+ ", es_repetidor: " + es_repetidor+ ", teléfono: " + teléfono);
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

