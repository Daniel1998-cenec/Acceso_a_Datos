package examen.practico;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CrearBbdd {
	public static void main(String[] args) {
		Connection conexion=null;
		Statement stmt=null;
		//Creacion de la bbdd
		String sql="CREATE DATABASE dbgametop";
		
		try {
			
			//Establecemos la conexion con la bbdd;
			conexion=DriverManager.getConnection("jdbc:mysql://localhost/","root","");
			stmt=conexion.createStatement();
			stmt.execute(sql);
			//Con este syso nos aseguramos que lo anterior realizado esta bien hecho
			System.out.println("La base dbgametop creada correctamente");
			//Cerramos conexion y stmt
			conexion.close();
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
