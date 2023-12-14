package examen.practico;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class CrearProcedimiento {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conexion=null;
		PreparedStatement pstmt=null;
		//Creamos una variable que elime el procedimiento
		String dropProcedure="DROP PROCEDURE IF EXISTS nombrejuego";
		//Creamos una variable que crea el procedimiento
		String createProcedure="CREATE PROCEDURE nombrejuego() "+
		"BEGIN "+
		"SELECT * FROM tvideojuegos;"+
		"END;";
		
		try {
			conexion=DriverManager.getConnection("jdbc:mysql://localhost/dbgametop","root","");
			
			//Primero se elimina el procedimiento si existe.
			pstmt=conexion.prepareStatement(dropProcedure);
			pstmt.executeUpdate();
			
			//Luego Crea el procedimieto
			
			pstmt=conexion.prepareStatement(createProcedure);
			pstmt.executeUpdate();
			
			System.out.println("Creado Procedimiento");
			
			//Se cierra la conexion
			conexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
