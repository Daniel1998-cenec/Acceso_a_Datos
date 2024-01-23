package Modulo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table (name ="fabricante")

public class Fabricante {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="codigo")
	private int codigo;
	
	@Column (name="nombre")
	private String nombre;
	
	@OneToMany(mappedBy="fabricante", cascade= CascadeType.ALL)
	private List<Productos> productos=new ArrayList<>();
	
	public List<Productos> getProductos() {
		return productos;
	}

	public void setProductos(List<Productos> productos) {
		this.productos = productos;
	}

	//Constructor por defecto requerido por Hibernate
	public Fabricante() {
		
	}
	
	//Constructor para crear un objeto de tipo Clientes con un nombre y una ciudad
	
	public Fabricante(String nombre) {
		this.nombre=nombre;
	}
	
	//Getter y setter para el atributo id
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo=codigo;
	}
	
	//Getter y setter para el atributo nombre
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	
	//Método para imprimir informacion del objeto fabricante
	
	public String toString() {
		
		return "Alumno{"+
				"id="+codigo+
				", nombre='"+nombre+'\''+
				'}';
	}
}
