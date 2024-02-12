package modulo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "citas")
public class Cita {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDCitas")
	private int IDCitas;

	@Column(name = "Fecha")
	private Date fecha;

	@Column(name = "Hora")
	private String hora;
	
	@ManyToOne
	@JoinColumn(name = "IDPaciente", nullable = false)
	private Paciente IDPaciente;
	
	@ManyToOne
	@JoinColumn(name = "IDMedico", nullable = false)
	private Medico IDMedico;
	
	public Cita() {
	}

	public Cita(Date fecha, String hora, Paciente IDPaciente, Medico IDMedico) {
		this.fecha = fecha;
		this.hora = hora;
		this.IDPaciente=IDPaciente;
		this.IDMedico=IDMedico;
	}

	public int getIDCitas() {
		return IDCitas;
	}

	public void setIDCitas(int iDCitas) {
		this.IDCitas = iDCitas;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public Paciente getIDPaciente() {
		return IDPaciente;
	}

	public void setIDPaciente(Paciente iDPaciente) {
		IDPaciente = iDPaciente;
	}

	public Medico getIDMedico() {
		return IDMedico;
	}

	public void setIDMedico(Medico iDMedico) {
		IDMedico = iDMedico;
	}
	
	@Override
	public String toString() {
		return "Cita {"+
				"IDCitas="+IDCitas+
				", Fecha='"+fecha+
				", Hora='"+hora+
				", IDPaciente='"+IDPaciente+
				", IDMedico='"+IDMedico+'\''+
				'}';
	}

}
