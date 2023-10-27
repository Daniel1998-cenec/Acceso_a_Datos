package conexionmysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MostrarDatosProductos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
	    Statement stmt = null;
	    String sql = "SELECT * FROM productos";
	    try {
	      conn = DriverManager.getConnection(
	             "jdbc:mysql://localhost/tiendaPc","root","");
	      stmt = conn.createStatement();
	      ResultSet rs = stmt.executeQuery(sql);
	      while (rs.next()) {
	        int id = rs.getInt("id");
	        String nombreProducto = rs.getString("nombreProducto");
	        String fabricante = rs.getString("fabricante");
	        System.out.println("id: " + id + ", nombreProducto: " + nombreProducto + 
	                           ", fabricante: " + fabricante);
	      }
	      rs.close();
	      conn.close();
	      stmt.close();
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
	}

}
