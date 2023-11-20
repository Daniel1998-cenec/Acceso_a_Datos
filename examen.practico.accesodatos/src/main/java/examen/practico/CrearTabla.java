package examen.practico;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CrearTabla {

	public static void main(String[] args) {
		Connection conexion=null;
		Statement stmt=null;
		//Creacion de la tabla
		String sql="CREATE TABLE tvideojuegos ("
		+"idjuego INT PRIMARY KEY,"
		+"nombre VARCHAR(50) NOT NULL,"
		+"anio INT,"
		+"compania VARCHAR(50),"
		+"precio DECIMAL(10,2),"
		+"sinopsis VARCHAR(150),"
		+"plataforma VARCHAR(50))";
		
		try {
			
			//Establecemos la conexion
			conexion=DriverManager.getConnection("jdbc:mysql://localhost/dbgametop","root","");
			stmt=conexion.createStatement();
			stmt.execute(sql);
			//Con este syso nos aseguramos que todo lo anterior realizado está bien hecho. 
			System.out.println("Creada la tabla de tvideojuegos");
			conexion.close();
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
