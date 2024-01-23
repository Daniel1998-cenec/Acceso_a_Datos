package Modulo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table (name ="producto")

public class Productos {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="codigo")
	private int codigo;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="precio")
	private int precio;
	
	
	@ManyToOne
	@JoinColumn(name="codigo_fabricante", nullable=false)
	
	private Fabricante codigo_Fabricante;
	
	public Productos(String nombre, int precio, Fabricante fabricante ) {
		this.nombre=nombre;
		this.precio=precio;
		this.codigo_Fabricante=fabricante;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
	public Fabricante getFabricante() {
		return codigo_Fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.codigo_Fabricante = fabricante;
	}

	public String toString() {
		
		return "Alumno{"+
				"codigo="+codigo+
				", nombre='"+nombre+
				", precio='"+precio+
				", codigo_fabricante='"+codigo_Fabricante+'\''+
				'}';
	}
	
	
}
