package main.java.br.senac.mediconnect.modelo.entidade.especialidadeInstituicao;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EspecialidadeInstituicaoId implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	// ATRIBUTOS
	
	@Column(name = "id_especialidade")
	private Integer id_especialidade;
	
	@Column(name = "id_instituicao")
	private Integer id_instituicao;

	// CONSTRUTOR
	
	public EspecialidadeInstituicaoId() {}
	
	// MÉTODOS DE ACESSO
	private Integer getIdInstituicao() {
		return id_instituicao;
	}
	
	public void setIdInstituicao(Integer id_instituicao) {
		this.id_instituicao = id_instituicao;
	}
	
	private Integer getIdEspecialidade() {
		return id_especialidade;
	}
	public void setIdEspecialidade(Integer id_especialidade) {
		this.id_especialidade = id_especialidade;
	}
	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((id_especialidade == null) ? 0 : id_especialidade.hashCode());
        result = prime * result
                + ((id_instituicao == null) ? 0 : id_instituicao.hashCode());
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
        EspecialidadeInstituicaoId other = (EspecialidadeInstituicaoId) obj;
        return Objects.equals(getIdEspecialidade(), other.getIdEspecialidade()) && Objects.equals(getIdInstituicao(), other.getIdInstituicao());
    }

}

