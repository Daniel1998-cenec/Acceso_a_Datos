package examen.practico;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InvocarProcedimiento {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conexion = null;
        CallableStatement cstmt = null;
        
        try {
        	//Establecemos conexion
			conexion=DriverManager.getConnection("jdbc:mysql://localhost/dbgametop","root","");
			//Llamamos el procedimiento
			cstmt= conexion.prepareCall("call nombrejuego()");
			//lo ejecutamos
			cstmt.execute();
			
			//Creamos la variable rs para que nos muestre todo el contenido de la taba
			ResultSet rs = cstmt.getResultSet();
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
			//Nos aseguramos que el procedimiento se ha hecho correctamente
			System.out.println("Procedimiento invocado");
			//Establecemos un if en el que la conexion sea distinto para cuando lo sea pong la conexion a BD ok
			if(conexion != null) {
            	System.out.println("Conexion a BD ok");
            	conexion.close();	
            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}

}
