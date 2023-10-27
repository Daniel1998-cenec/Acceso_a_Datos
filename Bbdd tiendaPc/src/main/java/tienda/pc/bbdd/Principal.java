package tienda.pc.bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Principal {

	public static void main(String[] args) {
		Connection conect=null;
		try {
			conect=DriverManager.getConnection("jdbc:mysql://localhost/tiendaPc","root","");	
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
