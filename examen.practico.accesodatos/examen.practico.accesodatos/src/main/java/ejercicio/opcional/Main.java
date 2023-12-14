package ejercicio.opcional;

import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String dbURL = "jdbc:mysql://localhost/dbgametop"; 
        String dbUser = "root"; 
        String dbPassword = "";
        
        try {
			VideojuegoController controller= new VideojuegoController(dbURL, dbUser, dbPassword);
			controller.mostrarVideojuegos();
			controller.cerrarConexion();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
