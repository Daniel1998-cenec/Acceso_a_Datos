package modulo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="asignaturas")

public class Asignaturas {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column (name="nombre")
	private String nombre;
	
	@Column(name="codigo")
	private String codigo;
	
	@Column (name="departamento")
	private String departamento;
	
	@Column(name="creditos")
	private int creditos;
	
	@Column (name="descripcion")
	private String descripcion;
	
	//Constructor por defecto requerido por Hibernate
	public Asignaturas() {
		
	}
	
	//Constructor para crear un objeto de tipo Clientes con un nombre y una ciudad
	
	public Asignaturas(String nombre, String codigo, String departamento, int creditos, String descripcion) {
		this.nombre=nombre;
		this.codigo=codigo;
		this.departamento=departamento;
		this.creditos=creditos;
		this.descripcion=descripcion;
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

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public int getCreditos() {
		return creditos;
	}

	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
public String toString() {
		
		return "Asignaturas{"+
				"id="+id+
				", nombre='"+nombre+
				", codigo="+codigo+
				", departamento="+departamento+
				", creditos="+creditos+
				", descripcion="+descripcion+'\''+
				'}';
	}

}
