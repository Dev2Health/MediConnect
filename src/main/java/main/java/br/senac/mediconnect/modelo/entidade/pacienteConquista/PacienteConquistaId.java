package main.java.br.senac.mediconnect.modelo.entidade.pacienteConquista;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PacienteConquistaId implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	// ATRIBUTOS
	
	@Column(name = "id_paciente")
	private Integer id_paciente;
	
	@Column(name = "id_conquista")
	private Integer id_conquista;

	// CONSTRUTOR
	
	public PacienteConquistaId() {}
	
	public PacienteConquistaId(Integer id_paciente, Integer id_conquista) {
		setIdConquista(id_conquista);
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

	public Integer getIdConquista() {
		return id_conquista;
	}

	public void setIdConquista(Integer id_conquista) {
		this.id_conquista = id_conquista;
	}
	
	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((id_paciente == null) ? 0 : id_paciente.hashCode());
        result = prime * result
                + ((id_conquista == null) ? 0 : id_conquista.hashCode());
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
        PacienteConquistaId other = (PacienteConquistaId) obj;
        return Objects.equals(getIdPaciente(), other.getIdPaciente()) && Objects.equals(getIdConquista(), other.getIdConquista());
    }
}

