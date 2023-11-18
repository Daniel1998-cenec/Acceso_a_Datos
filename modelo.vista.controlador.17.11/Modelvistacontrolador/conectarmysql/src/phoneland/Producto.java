package phoneland;

public class Producto {
	
	private int id;
	private String idFabricante;
	private String nombre;
	private String precio;
	
	public Producto(int id, String idFabricante, String nombre, String precio) {
		this.id=id;
		this.idFabricante=idFabricante;
		this.nombre=nombre;
		this.precio=precio;
		
	}

	public int getId() {
		return id;
	}

	public String getIdFabricante() {
		return idFabricante;
	}

	public String getNombre() {
		return nombre;
	}

	public String getPrecio() {
		return precio;
	}
	
}
