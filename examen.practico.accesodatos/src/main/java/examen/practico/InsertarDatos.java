package examen.practico;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertarDatos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conexion=null;
		Statement stmt=null;
		//Creamos una variable para introducir los datos de la tabla
		String sql="INSERT INTO tvideojuegos (idjuego, nombre, anio, compania, precio, sinopsis, plataforma) VALUES"
				+"(1,'The Legend of Zelda: Breath of the Wild', 2017, 'Nintendo', 59.99, 'Aventura épica','Nintendo Switch'),"
				+"(2,'Read Dead Redemption 2', 2018, 'Rockstar Games', 49.99, 'Aventura del viejo oeste', 'PlayStation 4'),"
				+"(3,'Minecraft',2011,'Mojang', 29.99, 'Mundo abierto y construcción', 'Multiplataforma')";
		
		try {
			//Establecemos conexion
			conexion=DriverManager.getConnection("jdbc:mysql://localhost/dbgametop","root","");
			stmt=conexion.createStatement();
			stmt.executeUpdate(sql);
			//Creamos un syso para asegurarnos que haya hecho bien la introduccion de datos
			System.out.println("Insertado correctamente los datos a la tabla tvideojuegos");
			//Ceramos conexion y stmt
			conexion.close();
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
