package conexionmysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MostrarDatosProductos {
  public static void main(String[] args) {
    Connection conn = null;
    Statement stmt = null;
    String sql = "SELECT * FROM productos";
    try {
      conn = DriverManager.getConnection(
             "jdbc:mysql://localhost/empresa1","root","");
      stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(sql);
      while (rs.next()) {
        int id = rs.getInt("id");
        String fabricante = rs.getString("idfabricante");
        String nombre = rs.getString("nombre_producto");
        int precio = rs.getInt("precio");
        System.out.println("id: " + id + ", idfabricante: " + fabricante + 
                           ", nombre_producto: " + nombre + ", edad: " + precio);
      }
      rs.close();
      conn.close();
      stmt.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
