package main.java.mediconnect.modelo.entidade.conquista;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "conquista")
public class Conquista implements Serializable {

	private static final long serialVersionUID = 6898763453096753944L;

	// ATRIBUTOS
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_conquista")
	private Integer id;
	
	@Column(name = "nome_conquista", length = 45, nullable = false, unique = true)
	private String nome;
	
	@Column(name = "descricao_conquista", length = 100, nullable = false, unique = false)
	private String descricao;
	
	// CONSTRUTOR
	
	public Conquista() {}
	
	public Conquista(Integer id, String nome, String descricao) {
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
}
