package simulacro;

import java.sql.SQLException;
import java.util.List;

public class ProductoController {
	
	private ProductoModel model;
	private ProductoView view;
	
	public ProductoController(String dbURL, String dbUser, String dbPassword)throws SQLException {
		model = new ProductoModel(dbURL, dbUser, dbPassword);
		view = new ProductoView();
	}
	
	public void mostrarProducto() throws SQLException {
        List<Producto> producto = model.getAllProducto(); 
        view.monstrarProducto(producto); 
    }

    // Método para cerrar la conexión a la base de datos
    public void cerrarConexion() throws SQLException {
        model.close(); // Cierra la conexión en el modelo
    }
	
}
