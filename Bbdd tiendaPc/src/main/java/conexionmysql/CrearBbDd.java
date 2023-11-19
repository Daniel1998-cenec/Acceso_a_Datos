package conexionmysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CrearBbDd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Esbozo de método generado automáticamente
		Connection conn = null;
		Statement stmt = null;
		String sql = "CREATE DATABASE tiendaPc";

		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/", "root", "");
			stmt = conn.createStatement();
			stmt.execute(sql);
			System.out.println("Creada la base de datos tiendaPc");

			conn.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
	}

}
