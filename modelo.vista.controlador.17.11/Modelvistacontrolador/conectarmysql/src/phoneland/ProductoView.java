package phoneland;

import java.util.List;

public class ProductoView {
	
	public void mostrarProducto(List<Producto> productos) {
		for (Producto producto: productos) {
			System.out.println("ID: " + producto.getId()); 
            System.out.println("IDFabricante: " + producto.getIdFabricante()); 
            System.out.println("Nombre: " + producto.getNombre()); 
            System.out.println("Precio: " + producto.getPrecio()); 
            System.out.println();
		}
	}
	
}
