package main.java.mediconnect.modelo.entidade.pessoa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import main.java.mediconnect.modelo.entidade.usuario.Usuario;

@Entity
@Table(name = "pessoa")
public abstract class Pessoa extends Usuario{

	private static final long serialVersionUID = -2936104128949540114L;

	// ATRIBUTOS
	@Column(name = "nome_pessoa", length = 60, nullable = false)
	private String nome;
	@Column(name = "sobrenome_pessoa", length = 60, nullable = false)
	private String sobrenome;
	@Column(name = "cpf_pessoa", length = 14, nullable = false, unique = true)
	private String cpf;

	// CONSTRUTOR

	public Pessoa() {}

	public Pessoa(Integer id, String email, String senha, boolean ehAtivo) {
		super(id, email, senha, ehAtivo);
	}

	public Pessoa(Integer id, String email, String senha, boolean ehAtivo, String nome, String sobrenome, String cpf) {

		super(id, email, senha, ehAtivo);
		setNome(nome);
		setSobrenome(sobrenome);
		setCpf(cpf);
	}
	
	public Pessoa(String email, String senha, boolean ehAtivo, String nome, String sobrenome, String cpf) {

		super(email, senha, ehAtivo);
		setNome(nome);
		setSobrenome(sobrenome);
		setCpf(cpf);
	}

	// MÉTODOS DE ACESSO


	// Nome
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	// Sobrenome
	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	// Cpf
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}
