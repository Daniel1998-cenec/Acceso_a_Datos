package conexionmysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CrearProcedimientoEjercicioRepaso {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn =null;
		PreparedStatement presta=null;
		String dropProcedure="DROP PROCEDURE IF EXISTS ObtenerClientes";
		String createProcedure="Create Procedure calcula_edad(IN fecha_nacimiento int,OUT edad INT)" +
				"BEGIN "+
				"DECLARE actual DECIMAL(4,0) DEFAULT 2023;"+
				"SET edad := actual - fechaNacimiento;"+
				"END;";
		
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost/empresa", "root", "");
			
			presta =conn.prepareStatement(dropProcedure);
			presta.executeUpdate();
			
			presta= conn.prepareStatement(createProcedure);
			presta.executeUpdate();
			
			System.out.println("Procedimiento creado");
			
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
