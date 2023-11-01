package main.java.mediconnect.modelo.entidade.atendente;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import main.java.mediconnect.modelo.entidade.consulta.Consulta;
import main.java.mediconnect.modelo.entidade.instituicao.Instituicao;
import main.java.mediconnect.modelo.entidade.pessoa.Pessoa;

@Entity
@Table(name = "atendente")
public class Atendente extends Pessoa implements Serializable {

	private static final long serialVersionUID = -5334546095579392837L;

	// ATRIBUTOS

	@Column(name = "data_cadastro_atendente", length = 50, nullable = false, unique = false)
	private LocalDate dataCadastro;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_instituicao")
	private Instituicao instituicao;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "atendente_consulta", joinColumns = @JoinColumn(name = "id_usuario"), inverseJoinColumns = @JoinColumn(name = "id_consulta"))
	private List<Consulta> consultas = new ArrayList<Consulta>();
	/*
	 * Um atendente terá várias consultas | Uma consulta estará com vários
	 * atendentes
	 */

	@Column(name = "ctps_atendente", length = 11, nullable = false, unique = true)
	private String ctps;

	// CONSTRUTOR

	public Atendente() {}

	public Atendente(Integer id, String email, String senha, boolean ehAtivo, String nome, String sobrenome, String cpf,
			int cadastro, LocalDate dataCadastro, Instituicao instituicao, String ctps, byte[] fotoPerfil) {
		super(id, email, senha, ehAtivo, nome, sobrenome, cpf, fotoPerfil);
		setDataCadastro(dataCadastro);
		setInstituicao(instituicao);
		setCtps(ctps);
	}
	
	public Atendente( String email, String senha, boolean ehAtivo, String nome, String sobrenome, String cpf,
			int cadastro, LocalDate dataCadastro, Instituicao instituicao, String ctps, byte[] fotoPerfil) {
		super(email, senha, ehAtivo, nome, sobrenome, cpf, fotoPerfil);
		setDataCadastro(dataCadastro);
		setInstituicao(instituicao);
		setCtps(ctps);
	}
	public Atendente( String email, String senha, boolean ehAtivo, String nome, String sobrenome, String cpf,
			LocalDate dataCadastro, Instituicao instituicao, String ctps, byte[] fotoPerfil) {
		super(email, senha, ehAtivo, nome, sobrenome, cpf, fotoPerfil);
		setDataCadastro(dataCadastro);
		setInstituicao(instituicao);
		setCtps(ctps);
	}
	// MÉTODOS DE ACESSO

	// Data de Cadastro
	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	// Instituicao

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

	// CTPS
	public String getCtps() {
		return ctps;
	}

	public void setCtps(String ctps) {
		this.ctps = ctps;
	}
}
