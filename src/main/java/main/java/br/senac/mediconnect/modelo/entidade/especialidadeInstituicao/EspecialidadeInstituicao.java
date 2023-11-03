package main.java.br.senac.mediconnect.modelo.entidade.especialidadeInstituicao;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import main.java.br.senac.mediconnect.modelo.entidade.especialidadeProfissional.EspecialidadeProfissional;
import main.java.br.senac.mediconnect.modelo.entidade.usuario.Usuario;

@Entity
@Table(name = "especialidade_instituicao")
public class EspecialidadeInstituicao implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// ATRIBUTOS
	@EmbeddedId
	private EspecialidadeInstituicaoId id = new EspecialidadeInstituicaoId();

	@ManyToOne
	@MapsId("id_especialidade")
	private EspecialidadeProfissional especialidade;

	@ManyToOne
	@MapsId("id_instituicao")
	private Usuario usuario;
	
	// CONSTRUTOR

	public EspecialidadeInstituicao() {
	}

	// MÉTODOS DE ACESSO

	public EspecialidadeProfissional getEspecialidadeProfissional() {
		return especialidade;
	}
	public void setEspecialidadeProfissional(EspecialidadeProfissional especialidade) {
		this.especialidade = especialidade;
	}
	public Usuario getInstituicao() {
		return usuario;
	}
	public void setInstituicao(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
