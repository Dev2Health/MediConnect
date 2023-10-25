package main.java.mediconnect.modelo.entidade.especialidadeProfissional;

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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import main.java.mediconnect.modelo.entidade.instituicao.Instituicao;
import main.java.mediconnect.modelo.entidade.profissionalDeSaude.ProfissionalDeSaude;

@Entity
@Table(name = "especialidade_profissional")
public class EspecialidadeProfissional implements Serializable {
	private static final long serialVersionUID = 1L;


	// ATRIBUTOS
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_especialidade_profissional")
	private Integer id;
	
	
	@Column(name = "nome_especialidade_profissional", length = 60, nullable = false)
	private String nome;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "especialidade_profissional", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ProfissionalDeSaude> profissionalDeSaude = new ArrayList<ProfissionalDeSaude>();
	/* Uma Especialidade contém vários Profissionais | Um Profissional terá uma Especialidade */

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "instituicao_especialidade_profissional", joinColumns = @JoinColumn(name = "id_especialidade_profissional"), inverseJoinColumns = @JoinColumn(name = "id_usuario"))
	private List<Instituicao> instituicao = new ArrayList<Instituicao>();
	/* Uma instituição possuirá diversas Especialidades | Uma especialidade pode estar presente em diversas Instituições */
	
	
	// CONSTRUTOR
	public EspecialidadeProfissional() {}
	
	public EspecialidadeProfissional(Integer id, String nome) {
		setId(id);
		setNome(nome);
	}
	
	public EspecialidadeProfissional(String nome) {
		setNome(nome);
	}

	// MÉTODOS DE ACESSO

	// Id
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	// Nome
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	// Profissionais De Saúde
	public List<ProfissionalDeSaude> getProfissionalDeSaude() {
		return profissionalDeSaude;
	}

	public void adicionarProfissional(ProfissionalDeSaude profissionalDeSaude) {
		this.profissionalDeSaude.add(profissionalDeSaude);
	}
}
