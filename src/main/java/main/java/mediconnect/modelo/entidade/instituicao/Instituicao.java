package main.java.mediconnect.modelo.entidade.instituicao;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import main.java.mediconnect.modelo.entidade.atendente.Atendente;
import main.java.mediconnect.modelo.entidade.consulta.Consulta;
import main.java.mediconnect.modelo.entidade.endereco.Endereco;
import main.java.mediconnect.modelo.entidade.especialidadeProfissional.EspecialidadeProfissional;
import main.java.mediconnect.modelo.entidade.profissionalDeSaude.ProfissionalDeSaude;
import main.java.mediconnect.modelo.entidade.usuario.Usuario;

@Entity
@Table(name = "instituicao")
public class Instituicao extends Usuario implements Serializable {

	private static final long serialVersionUID = 3210572883654045486L;

	// ATRIBUTOS
	
	@Column(name = "cnpj_instituicao", length = 18, nullable = false, unique = true)
	private String cnpj;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_instituicao", referencedColumnName = "id_endereco")
	private Endereco endereco;
	
	@Column(name = "razao_social_instituicao", length = 150, nullable = false, unique = true)
	private String razaoSocial;
	
	@Column(name = "nome_fantasia_instituicao", length = 150, nullable = false, unique = true)
	private String nomeFantasia;

//	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
//	@JoinTable(name = "especialidade_profissional_instituicao", joinColumns = @JoinColumn(name = "id_usuario"), inverseJoinColumns = @JoinColumn(name = "id_especialidade_profissional"))
//	private List<EspecialidadeProfissional> especialidades = new ArrayList<EspecialidadeProfissional>();
//	/* Uma instituição possuirá diversas Especialidades | Uma especialidade pode estar presente em diversas Instituições */
//	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "instituicao", cascade = CascadeType.ALL)
	private List<Consulta> consultas = new ArrayList<Consulta>();
	/* Uma Instituição possuirá várias Consultas | Uma Consulta estará em uma Instituição */
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "instituicao", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Atendente> atendentes = new ArrayList<Atendente>();
	/* Uma Instituição possuirá vários Atendentes | Um Atendente estará em uma Instituição */
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "instituicao", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ProfissionalDeSaude> profissionaisDeSaude = new ArrayList<ProfissionalDeSaude>();
	/* Uma Instituição terá vários Profissionais | Um Profissional estará em uma Instituição */
	
	@Column(name = "horario_inicio_atendimento_instituicao", length = 50, nullable = true, unique = false)
	private LocalTime horarioInicioAtendimento;
	
	@Column(name = "horario_fim_atendimento_instituicao", length = 50, nullable = true, unique = false)
	private LocalTime horarioFimAtendimento;

	// CONSTRUTOR
	
	public Instituicao() {}
	
	public Instituicao(String cnpj, Endereco endereco, String razaoSocial, String nomeFantasia, String email, String senha) {
		super(email, senha);
		setCnpj(cnpj);
		setEndereco(endereco);
		setRazaoSocial(razaoSocial);
		setNomeFantasia(nomeFantasia);

	}
	
	public Instituicao(String cnpj, Endereco endereco, String razaoSocial, String nomeFantasia, LocalTime horarioInicioAtendimento, LocalTime horarioFimAtendimento, Integer id, String email, String senha, boolean ehAtivo) {
		super(id, email, senha, ehAtivo);
		setCnpj(cnpj);
		setEndereco(endereco);
		setRazaoSocial(razaoSocial);
		setNomeFantasia(nomeFantasia);
		setHorarioInicioAtendimento(horarioInicioAtendimento);
		setHorarioFimAtendimento(horarioFimAtendimento);
	}
	
	public Instituicao(String cnpj, Endereco endereco, String razaoSocial, String nomeFantasia, String email, String senha, boolean ehAtivo) {
		super(email, senha, ehAtivo);
		setCnpj(cnpj);
		setEndereco(endereco);
		setRazaoSocial(razaoSocial);
		setNomeFantasia(nomeFantasia);
	}

	// MÉTODOS DE ACESSO

	// Cnpj
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	// Endereço
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	// Razão Social
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	// Nome Fantasia
	public String getNomeFantasia() {
		return nomeFantasia;
	}
	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

//	// Especialidade Profissional
//	public List<EspecialidadeProfissional> getEspecialidades() {
//		return especialidades;
//	}
//	public void adicionarEspecialidadeProfissional(EspecialidadeProfissional especialidade) {
//		this.especialidades.add(especialidade);
//	}

	// Consultas
	public List<Consulta> getConsultas() {
		return consultas;
	}
	public void adicionarConsulta(Consulta consulta) {
		this.consultas.add(consulta);
	}

	// Atendentes
	public List<Atendente> getAtendentes() {
		return atendentes;
	}
	public void adicionarAtendente(Atendente atendente) {
		this.atendentes.add(atendente);
	}

	// Profissioais De Saude
	public List<ProfissionalDeSaude> getProfissionaisDeSaude() {
		return profissionaisDeSaude;
	}
	public void adicionarProfissionalDeSaude(ProfissionalDeSaude profissionalDeSaude) {
		this.profissionaisDeSaude.add(profissionalDeSaude);
	}

	// Horario Inicio Atendimento
	public LocalTime getHorarioInicioAtendimento() {
		return horarioInicioAtendimento;
	}
	public void setHorarioInicioAtendimento(LocalTime horarioInicioAtendimento) {
		this.horarioInicioAtendimento = horarioInicioAtendimento;
	}

	// Horario Fim Atendimento
	public LocalTime getHorarioFimAtendimento() {
		return horarioFimAtendimento;
	}
	public void setHorarioFimAtendimento(LocalTime horarioFimAtendimento) {
		this.horarioFimAtendimento = horarioFimAtendimento;
	}

}
