package main.java.mediconnect.modelo.dao.pessoa;

import java.util.List;

import main.java.mediconnect.modelo.entidade.pessoa.Pessoa;

public interface PessoaDAO {
	void inserirPessoa(Pessoa pessoa);
	void deletarPessoa(Pessoa pessoa);
	void atualizarPessoa(Pessoa pessoa);
	List<Pessoa> recuperarPessoa();
}
