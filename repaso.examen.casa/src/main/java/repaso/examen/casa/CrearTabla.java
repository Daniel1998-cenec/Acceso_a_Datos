package repaso.examen.casa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CrearTabla {
	
	public static void main(String[] args) throws Exception {
	
		Connection conn=null;
		Statement stmt=null;
		
		String sql="CREATE TABLE Empleado ("
				+ "empleadoId INT PRIMARY KEY NOT NULL,"
				+ "nombre VARCHAR(50),"
				+ "apellido VARCHAR(50),"
				+ "fecha DATE,"
				+ "salario float(4))";
		
		conn=DriverManager.getConnection("jdbc:mysql://localhost/PruebaExamenCasa","root","");
		stmt=conn.createStatement();
		stmt.execute(sql);
		
		System.out.println("Creada la tabla empleado");
		
		conn.close();
		stmt.close();
	}
}
