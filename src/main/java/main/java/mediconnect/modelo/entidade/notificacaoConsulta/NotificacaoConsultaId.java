package main.java.mediconnect.modelo.entidade.notificacaoConsulta;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class NotificacaoConsultaId implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	// ATRIBUTOS
	
	@Column(name = "id_notificacao")
	private Integer id_notificacao;
	
	@Column(name = "id_consulta")
	private Integer id_consulta;

	// CONSTRUTOR
	
	public NotificacaoConsultaId() {}
	
	// MÉTODOS DE ACESSO
	private Integer getIdConsulta() {
		return id_consulta;
	}
	
	public void setIdConsulta(Integer id_consulta) {
		this.id_consulta = id_consulta;
	}
	
	private Integer getIdNotificacao() {
		return id_notificacao;
	}
	public void setIdNotificacao(Integer id_notificacao) {
		this.id_notificacao = id_notificacao;
	}
	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((id_notificacao == null) ? 0 : id_notificacao.hashCode());
        result = prime * result
                + ((id_consulta == null) ? 0 : id_consulta.hashCode());
        return result;
    }
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        NotificacaoConsultaId other = (NotificacaoConsultaId) obj;
        return Objects.equals(getIdNotificacao(), other.getIdNotificacao()) && Objects.equals(getIdConsulta(), other.getIdConsulta());
    }

}

