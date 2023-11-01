package main.java.mediconnect.modelo.entidade.pacienteSelo;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PacienteSeloId implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	// ATRIBUTOS
	
	@Column(name = "id_paciente")
	private Integer id_paciente;
	
	@Column(name = "id_conquista")
	private Integer id_selo;

	// CONSTRUTOR
	
	public PacienteSeloId() {}
	
	public PacienteSeloId(Integer id_paciente, Integer id_selo) {
		setIdConquista(id_selo);
		setIdPaciente(id_paciente);
	}

	// MÉTODOS DE ACESSO 

	// Nível

	public Integer getIdPaciente() {
		return id_paciente;
	}

	public void setIdPaciente(Integer id_paciente) {
		this.id_paciente = id_paciente;
	}

	public Integer getIdSelo() {
		return id_selo;
	}

	public void setIdConquista(Integer id_selo) {
		this.id_selo = id_selo;
	}
	
	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((id_paciente == null) ? 0 : id_paciente.hashCode());
        result = prime * result
                + ((id_selo == null) ? 0 : id_selo.hashCode());
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
        PacienteSeloId other = (PacienteSeloId) obj;
        return Objects.equals(getIdPaciente(), other.getIdPaciente()) && Objects.equals(getIdSelo(), other.getIdSelo());
    }
}

