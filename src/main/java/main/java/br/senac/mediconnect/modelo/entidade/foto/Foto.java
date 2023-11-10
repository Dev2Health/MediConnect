package main.java.br.senac.mediconnect.modelo.entidade.foto;

import java.io.Serializable;
import java.util.Base64;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "foto")
public class Foto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_foto", nullable = false)
	private int idFoto;
	
	@Lob
	@Column(name = "binario_foto")
	private byte[] binario;
	
	@Column(name = "extensao_foto")
	private String extensao;
	
	public Foto(){
		
	}
	
	public Foto(byte[] binario, String extensao){
		setBinario(binario);
		setExtensao(extensao);
	}

	public byte[] getBinario() {
		return binario;
	}

	public void setBinario(byte[] binario) {
		this.binario = binario;
	}

	public String getExtensao() {
		return extensao;
	}

	public void setExtensao(String extensao) {
		this.extensao = extensao;
	}
	
	public String urlFoto() {
			String urlFoto =("data:" + this.extensao + ";base64," + Base64.getEncoder().encodeToString(this.binario));
			return urlFoto;
		}
	
}
