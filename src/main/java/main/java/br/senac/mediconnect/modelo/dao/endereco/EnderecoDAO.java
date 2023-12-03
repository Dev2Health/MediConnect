package main.java.br.senac.mediconnect.modelo.dao.endereco;

import java.util.List;

import main.java.br.senac.mediconnect.modelo.entidade.endereco.Endereco;
import main.java.br.senac.mediconnect.modelo.entidade.instituicao.Instituicao;

public interface EnderecoDAO {
	void inserirEndereco(Endereco endereco);
	void deletarEndereco(Endereco endereco);
	void atualizarEndereco(Endereco endereco);
	Endereco recuperarEnderecoPorInstituicao(Instituicao instituicao);
	Endereco recuperarEnderecoPorInstituicao(Integer idInstituicao);
	List<Endereco> recuperarListaDeEnderecos();
	Endereco recuperarEnderecoPorId(Integer idEndereco);
}
