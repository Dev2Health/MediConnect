package main.java.mediconnect.modelo.entidade.endereco;

import javax.persistence.*;

import main.java.mediconnect.modelo.entidade.instituicao.Instituicao;

import java.io.Serializable;

@Entity
@Table(name = "endereco", uniqueConstraints = {@UniqueConstraint(columnNames = {"logradouro_endereco", "numero_endereco"})})
public class Endereco implements Serializable {
	private static final long serialVersionUID = 7162558336861584742L;

	// ATRIBUTOS
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_endereco")
	private Integer id;
	
	@Column(name = "cep_endereco", length = 9, nullable = false, unique = false)
	private String cep;
	
	@Column(name = "numero_endereco", nullable = false, unique = false)
	private int numero;
	
	@Column(name = "logradouro_endereco", length = 70, nullable = false, unique = false)
	private String logradouro;
	
	@Column(name = "cidade_endereco", length = 35, nullable = false, unique = false)
	private String cidade;
	
	@Column(name = "estado_endereco", length = 35, nullable = false, unique = false)
	private String estado;
	
	@Column(name = "bairro_endereco", length = 45, nullable = false, unique = false)
	private String bairro;
	
	@OneToOne(mappedBy = "endereco")
	private Instituicao instituicao;
	

	// CONSTRUTOR
	
	public Endereco() {}
	
	public Endereco(Integer id, String cep,int numero, String logradouro, String cidade, String estado, String bairro, Instituicao instituicao) {
		setId(id);
		setCep(cep);
		setNumero(id);
		setNumero(numero);
		setLogradouro(logradouro);
		setCidade(cidade);
		setEstado(estado);
		setBairro(bairro);	
		setInstituicao(instituicao);
	}
	
	public Endereco(String cep, int numero, String logradouro, String cidade, String estado, String bairro) {
		setCep(cep);
		setNumero(numero);
		setLogradouro(logradouro);
		setCidade(cidade);
		setEstado(estado);
		setBairro(bairro);	
	}

	// MÉTODOS DE ACESSO

	

	// Id
	public int getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	// CEP
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}

	// Número
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}

	// Logradouro
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	// Cidade
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	// Estado
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

	// Bairro
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	// Instituicao
	public Instituicao getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}
	
}
