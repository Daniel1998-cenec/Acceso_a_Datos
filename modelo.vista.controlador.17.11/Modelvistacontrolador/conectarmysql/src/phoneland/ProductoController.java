package phoneland;

import java.sql.SQLException;
import java.util.List;

import modelovistacontrolador.Cliente;

public class ProductoController {
	private ProductoModel model;
	private ProductoView view;

	public ProductoController(String dbURL, String dbUser, String dbPassword)throws SQLException {
		model = new ProductoModel(dbURL, dbUser, dbPassword);
		view = new ProductoView();
	}
		public void mostrarProducto() throws SQLException {
	        List<Producto> productos = model.getAllProducto(); 
	        view.mostrarProducto(productos); 
	    }

	    // Método para cerrar la conexión a la base de datos
	    public void cerrarConexion() throws SQLException {
	        model.close(); // Cierra la conexión en el modelo
	    }
}
