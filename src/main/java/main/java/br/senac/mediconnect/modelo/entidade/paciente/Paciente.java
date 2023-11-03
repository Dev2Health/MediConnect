package main.java.br.senac.mediconnect.modelo.entidade.paciente;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import main.java.br.senac.mediconnect.modelo.entidade.consulta.Consulta;
import main.java.br.senac.mediconnect.modelo.entidade.pessoa.Pessoa;
import main.java.br.senac.mediconnect.modelo.entidade.selo.Selo;

@Entity
@Table(name = "paciente")
public class Paciente extends Pessoa implements Serializable {

	private static final long serialVersionUID = 1290946171577071803L;

	// ATRIBUTOS
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "id_paciente")
//	private Integer id;

	@Column(name = "data_nascimento_paciente", nullable = false)
	private LocalDate dataNascimento;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "paciente", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Consulta> consultas = new ArrayList<Consulta>();
	/* Um paciente terá várias consultas | Uma consulta terá um paciente */

//	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
//	@JoinTable(name = "paciente_conquista", joinColumns = @JoinColumn(name = "id_usuario"), inverseJoinColumns = @JoinColumn(name = "id_conquista"))
//	private List<Conquista> conquistas = new ArrayList<Conquista>();
	/* Um paciente terá várias conquistas | Uma conquista terá vários pacientes */

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "paciente", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Selo> selos = new ArrayList<Selo>();
	/* Um paciente possui vários selos | Um selo está em um paciente */

	@Column(name = "telefone_paciente", length = 16, nullable = false)
	private String telefone;

	// CONSTRUTOR

	public Paciente() {
	}

	public Paciente(Integer id, String email, String senha, boolean ehAtivo, String nome, String sobrenome, String cpf,
			LocalDate dataNascimento, String telefone, byte[] fotoPerfil) {

		super(id, email, senha, ehAtivo, nome, sobrenome, cpf, fotoPerfil);
		setDataNascimento(dataNascimento);
		setTelefone(telefone);

	}
	
	public Paciente(String email, String senha, boolean ehAtivo, String nome, String sobrenome, String cpf,
			LocalDate dataNascimento, String telefone, byte[] fotoPerfil) {
		super(email, senha, ehAtivo, nome, sobrenome, cpf, fotoPerfil);
		setDataNascimento(dataNascimento);
		setTelefone(telefone);

	}
	
	public Paciente(String nome, String sobrenome, String email, String telefone, String senha) {
			
		setNome(nome);
		setSobrenome(sobrenome);
		setEmail(email);
		setTelefone(telefone);
		setSenha(senha);

	}


	// MÉTODOS DE ACESSO
		
	
	// Data de Nascimento
	public LocalDate getDataNasciento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	// Consulta
	public List<Consulta> getConsultas() {
		return consultas;
	}

	public void adicionarConsulta(Consulta consulta) {
		this.consultas.add(consulta);
	}

//	// Conquista
//	public List<Conquista> getConquista() {
//		return conquistas;
//
//	}
//
//	public void adicionarConquista(Conquista conquista) {
//		this.conquistas.add(conquista);
//
//	}

	// Selos
	public List<Selo> getSelos() {
		return selos;
	}

	public void adicionarSelo(Selo selos) {
		this.selos.add(selos);
	}

	// Telefone
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}
