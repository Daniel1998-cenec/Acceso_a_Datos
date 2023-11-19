package repaso.examen.casa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class IntroducirDatosEmpleado {

	public static void main(String[] args) {
		
		Connection conn=null;
		Statement stmt=null;
		
		String sql="INSERT INTO Empleado (empleadoId, nombre, apellido, fecha, salario) VALUES "
				+ "(1,'Jesus','Alava','2000-01-22', 1500),"
				+ "(2,'Robert','Pezon','2005-12-15', 1250),"
				+ "(3,'Daniel','Vargas','2013-05-29', 1750),"
				+ "(4,'Pedro','Azuhaga','2022-12-01', 1000);";
		
	try {
		conn=DriverManager.getConnection("jdbc:mysql://localhost/PruebaExamenCasa","root","");
		stmt=conn.createStatement();
		stmt.execute(sql);
		
		System.out.println("Datos insertados en la tabla empleado");
		conn.close();
		stmt.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
}
