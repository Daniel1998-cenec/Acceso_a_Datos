package modulo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pacientes")
public class Paciente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDPaciente")
	private int IDPaciente;

	@Column(name = "Nombre")
	private String nombre;

	@Column(name = "Apellidos")
	private String apellidos;
	
	@Column(name = "Ciudad")
	private String ciudad;
	
	@Column(name = "Direccion")
	private String direccion;
	
	@Column(name = "Telefono")
	private int telefono;
	
	@Column(name = "Edad")
	private int edad;
	
	@Column(name = "Historial")
	private String historial;
	
	
	
	public Paciente() {
	}

	public Paciente(String nombre, String apellidos, String ciudad, String direccion,int telefono,  int edad, String historial) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.ciudad=ciudad;
		this.direccion=direccion;
		this.telefono=telefono;
		this.edad=edad;
		this.historial=historial;
	}
	
	public int getIDPaciente() {
		return IDPaciente;
	}

	public void setIDPaciente(int iDPaciente) {
		IDPaciente = iDPaciente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getHistorial() {
		return historial;
	}

	public void setHistorial(String historial) {
		this.historial = historial;
	}

	@Override
	public String toString() {
		return "Paciente{"+
				"IDPaciente="+IDPaciente+
				", Nombre='"+nombre+
				", Apellidos="+apellidos+
				", Ciudad="+ciudad+
				", Telefono="+telefono+
				", Edad="+edad+
				", Historial="+historial+'\''+
				'}';
	}
	
}