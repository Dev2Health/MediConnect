package main.java.mediconnect.modelo.dao.endereco;

import java.util.List;

import main.java.mediconnect.modelo.entidade.endereco.Endereco;
import main.java.mediconnect.modelo.entidade.instituicao.Instituicao;

public interface EnderecoDAO {
	void inserirEndereco(Endereco endereco);
	void deletarEndereco(Endereco endereco);
	void atualizarEndereco(Endereco endereco);
	Endereco recuperarEnderecoPorInstituicao(Instituicao instituicao);
	Endereco recuperarEnderecoPorInstituicao(Integer idInstituicao);
	List<Endereco> recuperarListaDeEnderecos();
}
