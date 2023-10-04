package main.java.mediconnect.modelo.entidade.consulta;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import main.java.mediconnect.modelo.entidade.especialidadeProfissional.EspecialidadeProfissional;
import main.java.mediconnect.modelo.entidade.instituicao.Instituicao;
import main.java.mediconnect.modelo.entidade.paciente.Paciente;
import main.java.mediconnect.modelo.entidade.profissionalDeSaude.ProfissionalDeSaude;
import main.java.mediconnect.modelo.enumeracao.consulta.StatusConsulta;


@Entity
@Table(name = "consulta")
public class Consulta implements Serializable {

	private static final long serialVersionUID = -3442054462063366299L;
	
	// ATRIBUTOS
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_consulta")
	private Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_especialidade_profissional")
	private EspecialidadeProfissional especialidade_profissional;
	/* Uma consulta poderá ter uma Especialidade | Uma especialidade poderá estar em várias consultas */
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_instituicao")
	private Instituicao instituicao;
	/* Uma Consulta estará em uma Instituição | Uma Instituição terá várias Consultas */
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_profissional_de_saude")
	private ProfissionalDeSaude profissional_de_saude;
	/* Uma consulta poderá ter um profissional | Um profissional poderá ter várias consultas */
	
	@Column(name = "descricao_consulta", length = 300, nullable = false, unique = false)
	private String descricao;
	
	@Column(name = "data_consulta", length = 10, nullable = false, unique = false)
	private LocalDate data;
	
	@Column(name = "horario_consulta", length = 10, nullable = false, unique = false)
	private LocalTime horario;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_paciente")
	private Paciente paciente;
	/* Várias consultas para um paciente */
	
	@Column(name = "status_consulta", length = 25, nullable = false, unique = false)
	@Enumerated(EnumType.STRING)
	private StatusConsulta status = StatusConsulta.AGENDADA;

	// CONSTRUTOR
	public Consulta() {}
	
	public Consulta(Integer id, EspecialidadeProfissional especialidade_profissional, Instituicao instituicao,
			ProfissionalDeSaude profissional_de_saude, LocalDate data, LocalTime horario, Paciente paciente,
			StatusConsulta status) {
		setId(id);
		setEspecialidadeProfissional(especialidade_profissional);
		setInstituicao(instituicao);
		setProfissionalDeSaude(profissional_de_saude);
		setData(data);
		setHorario(horario);
		setPaciente(paciente);
		setStatus(status);
	}

	// MÉTODOS DE ACESSO

	// Id
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	// Especialidade Profissional
	public EspecialidadeProfissional getEspecialidadeProfissional() {
		return especialidade_profissional;
	}

	public void setEspecialidadeProfissional(EspecialidadeProfissional especialidade_profissional) {
		this.especialidade_profissional = especialidade_profissional;
	}

	// Instituição
	public Instituicao getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}

	// Profissional de Saúde
	public ProfissionalDeSaude getProfissionalDeSaude() {
		return profissional_de_saude;
	}

	public void setProfissionalDeSaude(ProfissionalDeSaude profissionalDeSaude) {
		this.profissional_de_saude = profissionalDeSaude;
	}

	// Descrição
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}	
	
	// Data
	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	// Horário
	public LocalTime getHorario() {
		return horario;
	}

	public void setHorario(LocalTime horario) {
		this.horario = horario;
	}

	// Paciente
	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	// Status
	public StatusConsulta getStatus() {
		return status;
	}

	public void setStatus(StatusConsulta status) {
		this.status = status;
	}

}