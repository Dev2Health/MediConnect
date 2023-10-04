package main.java.mediconnect.modelo.dao.endereco;

import java.util.List;

import main.java.mediconnect.modelo.entidade.endereco.Endereco;

public interface EnderecoDAO {
	void inserirEndereco(Endereco endereco);
	void deletarEndereco(Endereco endereco);
	void atualizarEndereco(Endereco endereco);
	List<Endereco> recuperarListaDeEnderecos();
}
