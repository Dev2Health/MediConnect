package main.java.br.senac.mediconnect.modelo.entidade.pacienteSelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import main.java.br.senac.mediconnect.modelo.entidade.selo.Selo;
import main.java.br.senac.mediconnect.modelo.entidade.usuario.Usuario;
import main.java.br.senac.mediconnect.modelo.enumeracao.selo.StatusSelo;

@Entity
@Table(name = "paciente_selo")
public class PacienteSelo implements Serializable{

	private static final long serialVersionUID = 1L;

	// ATRIBUTOS
	@EmbeddedId
	private PacienteSeloId id = new PacienteSeloId();

	@ManyToOne
	@MapsId("id_paciente")
	private Usuario usuario;

	@ManyToOne
	@MapsId("id_selo")
	private Selo selo;

	@Column(name = "status_selo", length = 5, nullable = false, unique = false)
	@Enumerated(EnumType.STRING)
	private StatusSelo status;

	// CONSTRUTOR

	public PacienteSelo() {
	}

	public PacienteSelo(Integer idPaciente, Integer idSelo) {
		setStatus(status);
	}

	// MÉTODOS DE ACESSO

	// Nível
	public Usuario getPaciente() {
		return usuario;
	}

	public void setPaciente(Usuario usuario) {
		this.usuario = usuario;
	}

	public Selo getSelo() {
		return selo;
	}

	public void setSelo(Selo Selo) {
		this.selo = Selo;
	}

	// Status
	public StatusSelo getStatus() {
		return status;
	}

	public void setStatus(StatusSelo status) {
		this.status = status;
	}
}
