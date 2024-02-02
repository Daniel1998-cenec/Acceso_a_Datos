package modelo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Empresa {
    @Id
    private int id;
    private String nombre;
    private String pais;

    // Constructor sin argumentos requerido por Hibernate
    public Empresa() {
    }
    
    public Empresa(int id, String nombre, String pais) {
    	this.id=id;
    	this.nombre=nombre;
    	this.pais=pais;
    }

    // Otros constructores y métodos getter/setter

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

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}