package modulo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medicos")
public class Medico {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDMedico")
	private int IDPaciente;

	@Column(name = "Nombre")
	private String nombre;

	@Column(name = "Apellidos")
	private String apellidos;

	@Column(name = "Especialidad")
	private String especialidad;
	
	public Medico() {
	}

	public Medico(String nombre, String apellidos, String especialidad) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.especialidad=especialidad;
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

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	
	@Override
	public String toString() {
		return "Medico{"+
				"IDMedico="+IDPaciente+
				", Nombre='"+nombre+
				", Apellidos="+apellidos+
				", Especialidad="+especialidad+'\''+
				'}';
	}

}
