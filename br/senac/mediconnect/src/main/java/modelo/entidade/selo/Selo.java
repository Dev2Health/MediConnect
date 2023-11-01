package main.java.mediconnect.modelo.entidade.selo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import main.java.mediconnect.modelo.entidade.paciente.Paciente;

@Entity
@Table(name = "selo")
public class Selo implements Serializable {

	private static final long serialVersionUID = 6894661383096753944L;

	// ATRIBUTOS
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_selo")
	private Integer id;
	
	@Column(name = "nome_selo", length = 45, nullable = false, unique = true)
	private String nome;
	
	@Column(name = "descricao_selo", length = 100, nullable = false, unique = false) // A descrição é única?
	private String descricao;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario")
	private Paciente paciente;
	
	// CONSTRUTOR
	
	public Selo() {}
	
	public Selo (Integer id, String nome, String descricao) {
		setId(id);
		setNome(nome);
		setDescricao(descricao);
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

	// Descrição
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Paciente getPaciente() {
		return paciente;
		
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
}
