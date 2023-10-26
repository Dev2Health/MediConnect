package main.java.mediconnect.modelo.entidade.profissionalDeSaude;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import main.java.mediconnect.modelo.entidade.consulta.Consulta;
import main.java.mediconnect.modelo.entidade.especialidadeProfissional.EspecialidadeProfissional;
import main.java.mediconnect.modelo.entidade.instituicao.Instituicao;

@Entity
@Table (name = "profissional_de_saude")
public class ProfissionalDeSaude implements Serializable {

	private static final long serialVersionUID = 8339863513219563222L;
	
	// ATRIBUTOS
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_profissional_de_saude")
	private Integer id;
	
	@Column(name = "nome_profissional_de_saude", length = 120, nullable = false, unique = false)
	private String nome;
	
	@Column(name = "sobrenome_profissional_de_saude", length = 120, nullable = false, unique = false)
	private String sobrenome;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_especialidade_profissional")
	private EspecialidadeProfissional especialidade_profissional;
	/* Um profissional terá uma Especialidade | Cada especialidade possuirá vários Profissionais */
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_instituicao")
	private Instituicao instituicao;
	/* Um Profissional está em uma Instituição | Uma Instituição possuirá vários Profissionais */
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "profissional_de_saude", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Consulta> consultas = new ArrayList<Consulta> ();
	/* Um Profissional terá várias consultas | Uma consulta só poderá ter um profissional */
	
	@Column(name = "eh_ativo_profissional_de_saude", nullable = false)
	@Type(type="true_false")
	private boolean ehAtivo = true;
	
	// CONSTRUTOR
	
	public ProfissionalDeSaude() {}
	
	public ProfissionalDeSaude(Integer id, String nome, String sobrenome, EspecialidadeProfissional especialidade_profissional, Instituicao instituicao, boolean ehAtivo) {
		super();
		setId(id);
		setNome(nome);
		setSobrenome(sobrenome);
		setEspecialidadeProfissional(especialidade_profissional);
		setInstituicao(instituicao);
		setEhAtivo(ehAtivo);
	}
	
	public ProfissionalDeSaude(String nome, String sobrenome, EspecialidadeProfissional especialidade_profissional, Instituicao instituicao) {
		super();
		setNome(nome);
		setSobrenome(sobrenome);
		setEspecialidadeProfissional(especialidade_profissional);
		setInstituicao(instituicao);
	}
	
	// MÉTODOS DE ACESSO
	
	public ProfissionalDeSaude(String nome, String sobrenome) {
		setNome(nome);
		setSobrenome(sobrenome);
	}

	// Id
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	// Nome completo
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getSobrenome() {
		return sobrenome;
	}
	
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}	
	
	// Especialidade profissional
	public EspecialidadeProfissional getEspecialidade() {
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
	
	// Consultas
	public List<Consulta> getConsultas() {
		return consultas;
	}
	public void adicionarConsulta(Consulta consulta) {
		this.consultas.add(consulta);
	}
	
	// Ativo/Inativo
	public boolean isEhAtivo() {
		return ehAtivo;
	}
	public void setEhAtivo(boolean ehAtivo) {
		this.ehAtivo = ehAtivo;
	}			
}
