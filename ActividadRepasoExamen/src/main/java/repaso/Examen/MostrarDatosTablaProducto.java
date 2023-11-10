package repaso.Examen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MostrarDatosTablaProducto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn= null;
		Statement stmt=null;
		
		String sql= "SELECT * FROM producto";
		
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost/simulacro","root","");
			stmt= conn.createStatement();
			ResultSet rs= stmt.executeQuery(sql);
			while(rs.next()) {
				int id=rs.getInt("id");
				String nombre=rs.getString("nombre");
				String descripcion=rs.getString("descripcion");
				String fabricante=rs.getString("fabricante");
				float precio=rs.getFloat("precio");
				int nº_serie=rs.getInt("nº_serie");
				System.out.println("id: " + id + ", nombre: " + nombre + 
                        ", descripcion: " + descripcion + ", fabricante: " + fabricante + ", precio: " + 
						precio + ", nº_serie: " + nº_serie);
			}
			rs.close();
			conn.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}

}
