package repaso.examen.casa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CrearDatabasePruebaExamenCasa {
	public static void main(String[] args) {
		
		Connection conn=null;
		Statement stmt=null;
		
		String sql="CREATE DATABASE PruebaExamenCasa";
		
		try {
			
			conn=DriverManager.getConnection("jdbc:mysql://localhost/","root","");
			stmt=conn.createStatement();
			stmt.execute(sql);
			
			System.out.println("La base de datos Prueba Examen casa creada");
			conn.close();
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
