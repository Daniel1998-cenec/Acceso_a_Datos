package phoneland;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelovistacontrolador.Cliente;

public class ProductoModel {
	
	private Connection conn;

    
    public ProductoModel(String dbURL, String dbUser, String dbPassword) throws SQLException {
        // Establece la conexión con la base de datos
        conn = DriverManager.getConnection(dbURL, dbUser, dbPassword);
    }

   
    public List<Producto> getAllProducto() throws SQLException {
        List<Producto> productos = new ArrayList<>(); 
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM productos"); 

        
        ResultSet rs = stmt.executeQuery();

        
        while (rs.next()) {
            int id = rs.getInt("id");
            String idFabricante = rs.getString("idfabricante");
            String nombre = rs.getString("nombre");
            String precio = rs.getString("precio");
            productos.add(new Producto(id, idFabricante, nombre, precio)); 
        }

        stmt.close(); 
        rs.close(); 
        return productos; 
    }

    
    public void close() throws SQLException {
        conn.close();
    }
}