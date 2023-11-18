package simulacro;

import java.util.List;

public class ProductoView {
	//id, nombre, descripción, fabricante, precio, nº_serie
	public void monstrarProducto(List<Producto> productos) {
		
		for(Producto producto:productos) {
			System.out.println("ID: "+producto.getId());
			System.out.println("Nombre: "+ producto.getNombre());
			System.out.println("Descripcion: "+producto.getDescripcion());
			System.out.println("Fabricante: "+producto.getFabricante());
			System.out.println("Precio: "+producto.getPrecio());
			System.out.println("Nª_Serie"+producto.getnSerie());
		}
		
	}
	
}
