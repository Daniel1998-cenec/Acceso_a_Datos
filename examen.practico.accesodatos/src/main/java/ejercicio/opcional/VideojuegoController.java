package ejercicio.opcional;

import java.sql.SQLException;
import java.util.List;


public class VideojuegoController {
	
	private VideojuegoModel model;
	private VideojuegoView view;
	
	public VideojuegoController(String dbURL, String dbUser, String dbPassword) throws SQLException {
        model = new VideojuegoModel(dbURL, dbUser, dbPassword); 
        view = new VideojuegoView();
    }
	
	public void mostrarVideojuegos() throws SQLException {
        List<Videojuego> videojuegos = model.getAllVideojuego(); 
        view.mostrarVideojuego(videojuegos);
    }
	
	public void cerrarConexion() throws SQLException {
        model.close(); 
    }
	
}
