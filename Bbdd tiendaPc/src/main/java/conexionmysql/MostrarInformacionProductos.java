package conexionmysql;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MostrarInformacionProductos {
	static String login="root";
	static String password="";
	static String url="jdbc:mysql://localhost/tiendaPc";

	public static void main(String[] args) {
		Connection conn = null;
		try {
			//Desde aqui se encarga del driver JDBC
		Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url,login,password);
			if (conn != null) {

				System.out.println("Conexión a BBDD "+url+" ...Ok");
				DatabaseMetaData meta=conn.getMetaData();
				System.out.println("Versión del driver JDBC " +meta.getDriverVersion());
				System.out.println("Nombre "+meta.getDatabaseProductName());
				System.out.println("Versión "+meta.getDatabaseProductVersion());
				ResultSet columnas=meta.getColumns("tiendaPc", null, "productos", null);
				System.out.println("Consulta realizada");
				System.out.println("BBDD empresa");
				System.out.println("Columna   tipo    tamaño");
				System.out.println(". . . . . . . . . .. . . . . . . . .");
				while(columnas.next()) {
					String nombrecol=columnas.getString("COLUMN_NAME");
					String tipo=columnas.getString("TYPE_NAME");
					String tamco1=columnas.getString("COLUMN_SIZE");
					System.out.println(nombrecol+" "+tipo+" "+tamco1);
				}
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
