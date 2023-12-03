package main.java.br.senac.mediconnect.modelo.dao.selo;

import java.util.List;

import main.java.br.senac.mediconnect.modelo.entidade.selo.Selo;

public interface SeloDAO {
	void inserirSelo(Selo selo);
	void deletarSelo(Selo selo);
	void atualizarSelo(Selo selo);
	List<Selo> recuperarSelos();
}
