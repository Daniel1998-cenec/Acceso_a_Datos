package ejercicio.opcional;

public class Videojuego {

	private int idjuego;
	private String nombre;
	private int anio;
	private String compania;
	private float precio;
	private String sinopsis;
	private String plataforma;
	
	public Videojuego(int idjuego, String nombre, int anio, String compania, float precio, String sinopsis, String plataforma) {
		this.idjuego=idjuego;
		this.nombre=nombre;
		this.anio=anio;
		this.compania=compania;
		this.precio=precio;
		this.sinopsis=sinopsis;
		this.plataforma=plataforma;
	}

	public int getIdjuego() {
		return idjuego;
	}

	public String getNombre() {
		return nombre;
	}

	public int getAnio() {
		return anio;
	}

	public String getCompania() {
		return compania;
	}

	public float getPrecio() {
		return precio;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public String getPlataforma() {
		return plataforma;
	}
	
	
}
