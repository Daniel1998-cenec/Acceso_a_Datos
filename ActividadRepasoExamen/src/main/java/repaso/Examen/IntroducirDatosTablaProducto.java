package repaso.Examen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class IntroducirDatosTablaProducto  {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection conn=null;
		Statement stmt=null;
		
		String sql="INSERT INTO producto (id, nombre, descripcion, fabricante, precio, nº_serie) VALUES "
				+ "(1,'portatil 1', 'portatil gama alta', 'HP', 1500, 111),"
				+ "(2,'portatil 2', 'portatil gama baja', 'APPLE', 10000, 222),"
				+ "(3,'monitor 1', 'monitor gama alta', 'LG', 800, 333),"
				+ "(4,'monitor 2', 'monitor gama baja', 'HP', 200, 444);";
		
		try {
			conn= DriverManager.getConnection("jdbc:mysql://localhost/simulacro","root","");
			stmt= conn.createStatement();
			stmt.executeUpdate(sql);
			System.out.println("Datos insertados en la tabla producto");
			conn.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
