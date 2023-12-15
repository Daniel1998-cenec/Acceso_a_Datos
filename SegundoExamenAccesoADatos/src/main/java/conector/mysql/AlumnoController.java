package conector.mysql;

import java.sql.SQLException;
import java.util.List;

public class AlumnoController {

	private AlumnoModel model;
	private AlumnoView view;

	public AlumnoController(String dbURL, String dbUser, String dbPassword) throws SQLException {
		model = new AlumnoModel(dbURL, dbUser, dbPassword); // Inicializa el modelo con la conexión a la base de datos
		view = new AlumnoView(); // Inicializa la vista
	}

	public void mostrarAlumnos() throws SQLException {
		List<Alumno> alumnos = model.getAllAlumno(); // Obtiene la lista de clientes desde el modelo
		view.mostrarAlumnos(alumnos);
	}

	public void cerrarConexion() {
		// TODO Auto-generated method stub
		
	}
}
