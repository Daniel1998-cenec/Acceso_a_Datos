package conector.mysql;

import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String dbURL = "jdbc:mysql://localhost/instituto";;
		String dbUser = "root";
		String password = "";
		try {
			AlumnoController controller = new AlumnoController(dbURL, dbUser, password); // Crea una instancia del
																							// controlador
			controller.mostrarAlumnos(); // Llama al método del controlador para mostrar los clientes
			controller.cerrarConexion(); // Llama al método del controlador para cerrar la conexión a la base de datos
		} catch (SQLException e) {
			e.printStackTrace(); // Maneja las excepciones de SQL imprimiendo el error
		}
	}

}
