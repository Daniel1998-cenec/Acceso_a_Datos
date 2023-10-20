package conexionmysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CrearTablaProductos {
	public static void main(String[] args) throws Exception {
		// TODO Esbozo de método generado automáticamente
		Connection conn = null;
		Statement stmt = null;  	
		String sql="CREATE TABLE productos (id INT PRIMARY KEY,"
				+ "idfabricante int NOT NULL,"
				+ "nombre_producto VARCHAR(60) NOT NULL, "
				+ "precio double)";   	 
		try {
		  conn = DriverManager.getConnection(
             "jdbc:mysql://localhost/empresa1","root","");
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
