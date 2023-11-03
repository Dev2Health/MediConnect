package main.java.br.senac.mediconnect.modelo.entidade.usuario;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

import main.java.br.senac.mediconnect.modelo.entidade.notificacao.Notificacao;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)

public abstract class Usuario implements Serializable {

	private static final long serialVersionUID = 6105691777746622269L;

	// ATRIBUTOS
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private Integer id;
	
	@Column(name = "email_usuario", length = 100, nullable = false, unique = true)
	private String email;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Notificacao> notificacoes = new ArrayList<Notificacao> ();
	/* Um Usuário terá várias Notificações | Uma Notificação será de um Usuário */
	
	@Column(name = "senha_usuario", length = 100, nullable = false)
	private String senha;
	
	@Column(name = "eh_ativo_usuario", nullable = false)
	private boolean ehAtivo;
	
	@Lob
	@Column(name="foto_perfil_usuario", nullable = true, unique = false)
	private byte[] fotoPerfil;
	
	// CONSTRUTOR
	
	public Usuario() {}
	
	public Usuario (String email, String senha) {
		super();
		setEmail(email);
		setSenha(senha);
	}
	
	public Usuario (Integer id, String email, String senha, boolean ehAtivo) {
		super();
		setId(id);
		setEmail(email);
		setSenha(senha);
		setEhAtivo(ehAtivo);
	}
	
	public Usuario (String email, String senha, boolean ehAtivo) {
		super();
		setEmail(email);
		setSenha(senha);
		setEhAtivo(ehAtivo);
	}
	
	public Usuario (Integer id, String email, String senha, boolean ehAtivo,  byte[] fotoPerfil) {
		super();
		setId(id);
		setEmail(email);
		setSenha(senha);
		setEhAtivo(ehAtivo);
		setFotoPerfil(fotoPerfil);
	}
	
	public Usuario (String email, String senha, boolean ehAtivo,  byte[] fotoPerfil) {
		super();
		setEmail(email);
		setSenha(senha);
		setEhAtivo(ehAtivo);
		setFotoPerfil(fotoPerfil);
	}
	
	// MÉTODOS DE ACESSO
	
	// Id
	public Integer getId() {
		return id;
	}
	public void setId (Integer id) {
		this.id = id;
	}
	
	// E-mail
	public String getEmail() {
		return email;
	}
	public void setEmail (String email) {
		this.email = email;
	}
	
	// Notificações
	public List<Notificacao> getNotificacoes() {
		return notificacoes;
	}
	
	public void adicionarNotificacao (Notificacao notificacao) {
		this.notificacoes.add(notificacao);
	}
	
	// Senha
	public String getSenha() {
		return senha;
	}
	public void setSenha (String senha) {
		this.senha = senha;
	}

	// Ativo/Inativo
	public boolean getEhAtivo() {
		return ehAtivo;
	}
	
	public void setEhAtivo (boolean ehAtivo) {
		this.ehAtivo = ehAtivo;
	}
	
	// Imagem
	public byte[] getfotoPerfil() {
		return getFotoPerfil();
	}
	
	public void setFotoPerfil(byte[] fotoPerfil) {
		this.fotoPerfil = fotoPerfil;
	}
	
	public String urlFoto() {
		String urlFoto =("data:image/jpeg;base64," + Base64.getEncoder().encodeToString(this.getFotoPerfil()));
		return urlFoto;
	}

	public byte[] getFotoPerfil() {
		return fotoPerfil;
	}
}
