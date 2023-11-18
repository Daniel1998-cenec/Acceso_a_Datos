package simulacro;

public class Producto {
	//id, nombre, descripción, fabricante, precio, nº_serie
	private int id;
	private String nombre;
	private String descripcion;
	private String fabricante;
	private String precio;
	private int nSerie;
	
	public Producto(int id, String nombre,String descripcion, String fabricante, String precio, int nSerie) {
		this.id=id;
		this.nombre=nombre;
		this.descripcion=descripcion;
		this.fabricante=fabricante;
		this.precio=precio;
		this.nSerie=nSerie;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getFabricante() {
		return fabricante;
	}

	public String getPrecio() {
		return precio;
	}

	public int getnSerie() {
		return nSerie;
	}
	
}
