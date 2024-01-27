package cuartoEjercicio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CrearTabla {
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe"; // URL de la base de datos
    private static final String USUARIO = "SYSTEM";
    private static final String CONTRASENA = "1234";

    public static Connection obtenerConexion() {
        Connection conexion = null;
        try {
            // Cargar el controlador JDBC de Oracle
            Class.forName("oracle.jdbc.driver.OracleDriver");
            
            // Obtener la conexi�n
            conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
            System.out.println("Conexion establecida con exito.");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conexion;
    }
    public static void main(String[] args) {
    	 Connection conexion = CrearTabla.obtenerConexion();
        if (conexion != null) {
            Statement statement = null;

            try {
                statement = conexion.createStatement();

                String crearTablaSQL = "CREATE TABLE alumno ("
                        + "id INT PRIMARY KEY,"
                        + "nombre VARCHAR(100),"
                        + "apellido1 VARCHAR(100),"
                        + "apellido2 VARCHAR(100),"
                        + "fecha_nacimiento DATE,"
                        + "es_repetidor VARCHAR(2),"
                        + "teléfono VARCHAR(9)"
                        + ")";
                
                statement.executeUpdate(crearTablaSQL);

                System.out.println("Tabla 'alumno' creada con exito.");
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (statement != null) {
                        statement.close();
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
}
