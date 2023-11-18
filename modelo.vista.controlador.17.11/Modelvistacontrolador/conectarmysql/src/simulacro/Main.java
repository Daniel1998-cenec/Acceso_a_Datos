package simulacro;

import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String dbURL = "jdbc:mysql://localhost/simulacro";
		String dbUser = "root";
		String dbPassword = "";
		
		try {
			ProductoController controller = new ProductoController(dbURL, dbUser, dbPassword);
			controller.mostrarProducto();
			controller.cerrarConexion();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
