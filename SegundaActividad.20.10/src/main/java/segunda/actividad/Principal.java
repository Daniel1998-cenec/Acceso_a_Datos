package segunda.actividad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Principal {

	public static void main(String[] args) {
		Connection conect=null;
		
		try {
			conect=DriverManager.getConnection("jbdc:mysql://localhost/phoneland","root","");
			if(conect!=null){
				System.out.println("Conexión a base de datos ok");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
