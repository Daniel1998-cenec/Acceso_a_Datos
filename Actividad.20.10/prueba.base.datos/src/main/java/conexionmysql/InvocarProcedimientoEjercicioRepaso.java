package conexionmysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class InvocarProcedimientoEjercicioRepaso {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn= null;
		CallableStatement cstmt=null;
		
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost/empresa", "root", "");
			cstmt=conn.prepareCall("call calcula_edad(?,?)");
			cstmt.setInt(1, 1977);
			cstmt.registerOutParameter(12, Types.INTEGER);
			cstmt.execute();
			
			int edad=cstmt.getInt(2);
			System.out.println("Procedimiento invocado");
			System.out.println("la edad es "+edad);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
