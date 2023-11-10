package repaso.Examen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CrearDatabaseSimulacro {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn=null;
		Statement stmt=null;
		
		String sql="CREATE DATABASE simulacro";
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/","root","");
			stmt=conn.createStatement();
			stmt.execute(sql);
			
			System.out.println("la base de datos simulacro ok");
			conn.close();
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
