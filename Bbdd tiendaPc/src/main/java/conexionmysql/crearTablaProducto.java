package conexionmysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class crearTablaProducto {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;  	
		String sql="CREATE TABLE productos ("
				+ "id INT PRIMARY KEY,"
				+ "nombreProducto VARCHAR(10) NOT NULL,"
				+ "fabricante VARCHAR(60) NOT NULL)";   	 
		try {
		  conn = DriverManager.getConnection(
             "jdbc:mysql://localhost/tiendaPc","root","");
		  stmt = conn.createStatement();
		  stmt.execute(sql);
		  System.out.println("Creada la tabla productos");
		  conn.close();
		  stmt.close();
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}

	}

}
