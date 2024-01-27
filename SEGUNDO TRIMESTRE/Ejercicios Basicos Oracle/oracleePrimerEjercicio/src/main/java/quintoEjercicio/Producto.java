package quintoEjercicio;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Producto {
	@Id
	private int id;
    private String nombre;
    private String descripcion;
    private float precio;
    private String fabricante;
    private int unidades;

    public Producto() {
    	
    }
    
    public Producto(int id, String nombre, String descripcion, float precio, String fabricante, int unidades) {
    	super();
    	this.id=id;
    	this.nombre=nombre;
    	this.descripcion=descripcion;
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

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
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
    
    

}



