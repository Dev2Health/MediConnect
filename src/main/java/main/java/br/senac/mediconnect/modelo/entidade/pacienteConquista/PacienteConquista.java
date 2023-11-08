package main.java.br.senac.mediconnect.modelo.entidade.pacienteConquista;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import main.java.br.senac.mediconnect.modelo.entidade.conquista.Conquista;
import main.java.br.senac.mediconnect.modelo.entidade.usuario.Usuario;
import main.java.br.senac.mediconnect.modelo.enumeracao.conquista.StatusConquista;

@Entity
@Table(name = "paciente_conquista")
public class PacienteConquista implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// ATRIBUTOS
	@EmbeddedId
	private PacienteConquistaId id = new PacienteConquistaId();

	@ManyToOne
	@MapsId("id_paciente")
	private Usuario usuario;

	@ManyToOne
	@MapsId("id_conquista")
	private Conquista conquista;
	
	@Column(name = "eh_ativo_usuario", nullable = false)
	private boolean ehAtivo;

	@Column(name = "nivel_conquista", length = 30, nullable = false, unique = false)
	private byte nivel;
	/* Banco usará small int - possível conflito com tipo primitivo */

	@Column(name = "status_conquista", length = 70, nullable = false, unique = false)
	@Enumerated(EnumType.STRING)
	private StatusConquista status;

	// CONSTRUTOR

	public PacienteConquista() {
	}

	public PacienteConquista(Integer idPaciente, Integer idConquista) {
		setNivel(nivel);
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
	
	//ehAtivo
	public boolean isEhAtivo() {
		return ehAtivo;
	}

	public void setEhAtivo(boolean ehAtivo) {
		this.ehAtivo = ehAtivo;
	}

	public Conquista getConquista() {
		return conquista;
	}

	public void setConquista(Conquista conquista) {
		this.conquista = conquista;
	}

	public byte getNivel() {
		return nivel;
	}

	public void setNivel(byte nivel) {
		this.nivel = nivel;
	}

	// Status
	public StatusConquista getStatus() {
		return status;
	}

	public void setStatus(StatusConquista status) {
		this.status = status;
	}
}
