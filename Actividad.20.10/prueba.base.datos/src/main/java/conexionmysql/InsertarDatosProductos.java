package conexionmysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class InsertarDatosProductos {
	public static void main(String[] args) throws SQLException {
		// TODO Esbozo de método generado automáticamente
		Connection conn = null;
		Statement stmt = null;  	
		String sql = "INSERT INTO productos (id, idfabricante, nombre_producto, precio) " +
	             "VALUES (1, '001', 'PlayStation_5', 550)";
	try {
	  conn = DriverManager.getConnection(
	         "jdbc:mysql://localhost/empresa1","root","");
	  stmt = conn.createStatement();
	  stmt.executeUpdate(sql);
	  System.out.println("Datos insertados en la tabla productos");
	  conn.close();
	  stmt.close();
	} catch (SQLException e) {
	  e.printStackTrace();
	}
	}
}