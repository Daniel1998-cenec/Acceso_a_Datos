package repaso.Examen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CrearTablaProducto {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Connection conn=null;
		Statement stmt=null;
		
		String sql="CREATE TABLE producto ("
				+ "id INT PRIMARY KEY NOT NULL,"
				+ "nombre VARCHAR(60) NOT NULL,"
				+ "descripcion VARCHAR(50),"
				+ "fabricante VARCHAR(50),"
				+ "precio FLOAT(3),"
				+ "nº_serie INT)";
		
		conn=DriverManager.getConnection("jdbc:mysql://localhost/simulacro","root","");
		stmt = conn.createStatement();
		stmt.execute(sql);
		System.out.println("Creada la tabla productos");
		conn.close();
		stmt.close();
	}

}
