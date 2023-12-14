package examen.practico;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MostrarDatos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conexion=null;
		Statement stmt=null;
		//Creamos una variable para el select de la tabla tvideojuegos
		String sql="SELECT * FROM tvideojuegos";
		
		try {
			//Establecemos la conexion
			conexion=DriverManager.getConnection("jdbc:mysql://localhost/dbgametop","root","");
			stmt=conexion.createStatement();
			//Creamos la variable rs para que nos muestre todo el contenido de la taba
			ResultSet rs = stmt.executeQuery(sql);
			//Usamos un bucle while para que haga toda la vuelta necesario para que muestre ese contenido.
			while(rs.next()) {
				int idVideojuego=rs.getInt("idjuego");
				String nombre=rs.getString("Nombre");
				int anio=rs.getInt("anio");
				String compania=rs.getString("compania");
				BigDecimal precio=rs.getBigDecimal("precio");
				String sinopsis=rs.getString("sinopsis");
				String plataforma=rs.getString("plataforma");
				System.out.println("IDVideojuego: "+idVideojuego+", Nombre: "+nombre+", Año: "+anio
						+(", Compañía: "+compania+", precio: "+precio+", Sinopsis: "+sinopsis
								+", Plataforma: "+plataforma));
				
			}
			//Cerramos rs, conexion y stmt
			rs.close();
			conexion.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
