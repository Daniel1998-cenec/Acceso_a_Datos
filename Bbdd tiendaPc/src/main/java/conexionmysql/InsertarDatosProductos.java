package conexionmysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertarDatosProductos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement stmt = null;  	
		String sql = "INSERT INTO productos (id, nombreProducto, fabricante) " +
	             "VALUES (1, 'portatil', 'hp'),"+
				"(2, 'Tablet', 'Lenovo')";
	try {
	  conn = DriverManager.getConnection(
	         "jdbc:mysql://localhost/tiendaPc","root","");
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
