package main.java.mediconnect.modelo.entidade.notificacaoConsulta;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import main.java.mediconnect.modelo.entidade.consulta.Consulta;
import main.java.mediconnect.modelo.entidade.notificacao.Notificacao;

@Entity
@Table(name = "notificacao_consulta")
public class NotificacaoConsulta implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// ATRIBUTOS
	@EmbeddedId
	private NotificacaoConsultaId id = new NotificacaoConsultaId();

	@ManyToOne
	@MapsId("id_notificacao")
	private Notificacao notificacao;

	@ManyToOne
	@MapsId("id_consulta")
	private Consulta consulta;
	
	// CONSTRUTOR

	public NotificacaoConsulta() {
	}

	// MÉTODOS DE ACESSO

	public Notificacao getNotificacao() {
		return notificacao;
	}
	public void setNotificacao(Notificacao notificacao) {
		this.notificacao = notificacao;
	}
	public Consulta getConsulta() {
		return consulta;
	}
	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}
	
}
