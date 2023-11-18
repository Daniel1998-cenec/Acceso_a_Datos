package simulacro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class ProductoModel {
	//id, nombre, descripción, fabricante, precio, nº_serie
	private Connection conn;

	public ProductoModel(String dbURL, String dbUser, String dbPassword) throws SQLException {
		// Establece la conexión con la base de datos
		conn = DriverManager.getConnection(dbURL, dbUser, dbPassword);
	}

	public List<Producto> getAllProducto() throws SQLException {
		List<Producto> producto = new ArrayList<>();
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM producto");

		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			int id = rs.getInt("id");
			String nombre = rs.getString("nombre");
			String descripcion = rs.getString("descripcion");
			String fabricante = rs.getString("fabricante");
			String precio= rs.getString("precio");
			int nSerie=rs.getInt("nº_serie");
			producto.add(new Producto(id, nombre, descripcion, fabricante,precio,nSerie));
		}

		stmt.close();
		rs.close();
		return producto;
	}

	public void close() throws SQLException {
		conn.close();
	}
}
