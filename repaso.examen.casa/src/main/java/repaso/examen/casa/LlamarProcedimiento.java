package repaso.examen.casa;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class LlamarProcedimiento {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn=null;
		CallableStatement cstmt=null;
		float precioBase=100.0f;
		
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost/simulacro", "root", "");
			
			cstmt=conn.prepareCall("CALL CalculaDescuentoIva(?,?,?,?)");
			cstmt.setDouble(1, precioBase);
			cstmt.registerOutParameter(2, Types.FLOAT);
			cstmt.registerOutParameter(3, Types.FLOAT);
			cstmt.registerOutParameter(4, Types.FLOAT);
			
			cstmt.execute();
			
			float iva=cstmt.getFloat(2);
			float descuento= cstmt.getFloat(3);
			float total=cstmt.getFloat(4);
			
			System.out.println("Procedimiento invocado");
			System.out.println("El importe con "+precioBase+", IVA: "+iva+" , Descuento: "+descuento+" , Total: "+total);
			
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
