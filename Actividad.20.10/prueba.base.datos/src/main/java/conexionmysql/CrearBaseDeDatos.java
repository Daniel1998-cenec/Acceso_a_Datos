package conexionmysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CrearBaseDeDatos {
	public static void main(String[] args) throws SQLException {
		// TODO Esbozo de método generado automáticamente
		Connection conn = null;
		Statement stmt = null;  	
		String sql="CREATE DATABASE empresa;";  	 

		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/","root","");
			stmt = conn.createStatement();
			stmt.execute(sql);
			System.out.println("Creada la base de datos empresa");
				
			conn.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
	}
}