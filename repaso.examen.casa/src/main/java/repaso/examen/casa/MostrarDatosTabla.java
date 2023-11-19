package repaso.examen.casa;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MostrarDatosTabla {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn=null;
		Statement stmt=null;
		
		String sql="SELECT * FROM Empleado";
		
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost/PruebaExamenCasa","root","");
			stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			
			while(rs.next()) {
				int id=rs.getInt("empleadoId");
				String nombre=rs.getString("nombre");
				String apellido=rs.getString("apellido");
				Date fecha=rs.getDate("fecha");
				float salario=rs.getFloat("salario");
				
				System.out.println("id: "+id+", nombre: "+nombre+", apellido: "+apellido+", fecha: "+fecha+", salario: "+salario);
			}
			
			rs.close();
			conn.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
