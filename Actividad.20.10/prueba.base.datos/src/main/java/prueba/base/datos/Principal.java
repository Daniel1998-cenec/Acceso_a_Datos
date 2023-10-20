package prueba.base.datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Principal {

	public static void main(String[] args) {
		
		Connection conect=null;
		try {
			conect=DriverManager.getConnection("jdbc:mysql://localhost/phoneland","root","");	
			if (conect!=null) {
				System.out.println("Conexión a base de datos ok");
				conect.close();
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
