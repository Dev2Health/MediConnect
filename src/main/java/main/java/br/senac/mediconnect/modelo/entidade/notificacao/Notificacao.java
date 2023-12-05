package main.java.br.senac.mediconnect.modelo.entidade.notificacao;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import main.java.br.senac.mediconnect.modelo.entidade.usuario.Usuario;
import main.java.br.senac.mediconnect.modelo.enumeracao.notificacao.StatusNotificacao;

@Entity
@Table(name = "notificacao")
public class Notificacao implements Serializable{
	
	private static final long serialVersionUID = 7280381824614243508L;
	
	// ATRIBUTOS
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_notificacao")
	private Integer id;
	
	@Column(name = "titulo_notificacao", length = 45, nullable = false, unique = false)
	private String titulo;
	
	@Column(name = "descricao_notificacao", length = 200, nullable = false, unique = false)
	private String descricao;
	
	@Column(name = "data_notificacao", length = 10, nullable = false, unique = false)
	private LocalDate data;
	
	@Column(name = "horario_notificacao", length = 10, nullable = false, unique = false)
	private LocalTime horario;
	
	@Column(name = "status_notificacao", length = 25, nullable = false, unique = false)
	@Enumerated(EnumType.STRING)
	private StatusNotificacao status = StatusNotificacao.ENVIADA;
	
	@Column(name = "periodicidade_notificacao", length = 10, nullable = false, unique = false)
	private int periodicidade;
	
    @ManyToOne
    @JoinColumn(name = "id_usuario") // Nome da coluna que mantém a chave estrangeira para Usuario
    private Usuario usuario;
   
	// CONSTRUTOR
    
    public Notificacao() {}
    
	public Notificacao(Integer id, String titulo, String descricao, LocalDate data, LocalTime horario, StatusNotificacao status, int periodicidade) {
		setId(id);
		setTitulo(titulo);
		setDescricao(descricao);
		setData(data);
		setHorario(horario);
		setStatus(status);
		setPeriodicidade(periodicidade);
	}

	// MÉTODOS DE ACESSO

	// Id
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	// Título
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	// Descrição
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	// Data
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}

	// Horário 
	public LocalTime getHorario() {
		return horario;
	}
	public void setHorario(LocalTime horario) {
		this.horario = horario;
	}
	
	// Status
	public StatusNotificacao getStatus() {
		return status;
	}
	public void setStatus(StatusNotificacao status) {
		this.status = status;
	}

	// Periodicidade 
	public int getPeriodicidade() {
		return periodicidade;
	}
	public void setPeriodicidade(int periodicidade) {
		this.periodicidade = periodicidade;
	}
	
	// Usuário
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}