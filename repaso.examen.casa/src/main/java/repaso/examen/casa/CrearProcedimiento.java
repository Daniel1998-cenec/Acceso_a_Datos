package repaso.examen.casa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CrearProcedimiento {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement presta=null;
		
		String dropProcedure="DROP PROCEDURE IF EXISTS CalculaDescuentoIva";
		String createProcedure="CREATE PROCEDURE CalculaDescuentoIva(in precioBase float, out iva float, out descuento float, out total float) "+
		"BEGIN "+
		"SET descuento=precioBase * 0.10;"+
		"SET iva=precioBase * 0.21;"+
		"SET total=precioBase-descuento+iva;"+
		"END";
		
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost/simulacro","root","");
			
			presta=conn.prepareStatement(dropProcedure);
			presta.executeUpdate(dropProcedure);
			
			presta= conn.prepareStatement(createProcedure);
			presta.executeUpdate();
			
			System.out.println("Creado procedimiento prueba");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
