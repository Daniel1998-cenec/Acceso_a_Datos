package tercerEjercicio;

import javax.persistence.*;

@Entity
public class Fabricante {

	@Id
	private int codigo;
	private String nombre;
	
	//Constructor por defecto requerido por Hibernate
	public Fabricante() {
		
	}
	
	//Constructor para crear un objeto de tipo Clientes con un nombre y una ciudad
	
	public Fabricante(int codigo,String nombre) {
		this.nombre=nombre;
		this.codigo=codigo;
	}
	
	//Getter y setter para el atributo id
	
	public int getId() {
		return codigo;
	}
	
	public void setId(int id) {
		this.codigo=id;
	}
	
	//Getter y setter para el atributo nombre
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	
	//Método para imprimir informacion del objeto fabricante
}
