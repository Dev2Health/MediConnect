package main.java.br.senac.mediconnect.modelo.dao.foto;

import main.java.br.senac.mediconnect.modelo.entidade.foto.Foto;

public interface FotoDAO {
	
	void inserirFoto(Foto foto);
	void deletarFoto(Integer idFoto);
	void atualizarFoto(Foto foto);
}
