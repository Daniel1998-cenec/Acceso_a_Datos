package Modulo;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table (name="Tvideojuegos")

public class Tvideojuegos {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="idjuego")
	private int idjuego;
	
	@Column (name="nombre")
	private String nombre;
	
	@Column(name="anio")
	private int anio;
	
	@Column (name="compania")
	private String compania;
	
	@Column(name="precio")
	private Double precio;
	
	@Column (name="sinopsis")
	private String sinopsis;
	
	@Column(name="plataforma")
	private String plataforma;
	
	public Tvideojuegos(){
		
	}
	
	public Tvideojuegos(String nombre, int anio, 
		      String compania, Double precio, String sinopsis, String plataforma) {
		
		this.nombre=nombre;
		this.anio=anio;
		this.compania=compania;
		this.precio=precio;
		this.sinopsis=sinopsis;
		this.plataforma=plataforma;
	}

	public int getId() {
		return idjuego;
	}

	public void setId(int idjuego) {
		this.idjuego = idjuego;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public String getCompania() {
		return compania;
	}

	public void setCompania(String compania) {
		this.compania = compania;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}
	
public String toString() {
		
		return "Tvideojuegos{"+
				"id="+idjuego+
				", nombre='"+nombre+
				", anio="+anio+
				", compania="+compania+
				", precio="+precio+
				", sinopsis="+sinopsis+
				", plataforma="+plataforma+'\''+
				'}';
	}
}


