package Modulo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table (name="productos")

public class Productos {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column (name="nombre")
	private String nombre;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="precio")
	private Double precio;
	
	@Column (name="fabricante")
	private String fabricante;
	
	@Column(name="unidades")
	private int unidades;
	
	@OneToMany(mappedBy="fabricante", cascade= CascadeType.ALL)
	private List<Productos> productos=new ArrayList<>();
	
	public Productos() {
		
	}
	
	public Productos(String nombre, String descripcion, Double precio, String fabricante, int unidades) {
		
		this.nombre=nombre;
		this.descripcion=descripcion;
		this.precio=precio;
		this.precio=precio;
		this.fabricante=fabricante;
		this.unidades=unidades;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public int getUnidades() {
		return unidades;
	}

	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}
	
public String toString() {
		
		return "Productos{"+
				"id="+id+
				", nombre='"+nombre+
				", precio="+precio+
				", fabricante="+fabricante+
				", unidades="+unidades+'\''+
				'}';
	}
}
