package main.java.br.senac.mediconnect.modelo.dao.instituicao;

import java.util.List;

import main.java.br.senac.mediconnect.modelo.entidade.instituicao.Instituicao;

public interface InstituicaoDAO {
	void inserirInstituicao(Instituicao instituicao);
	void deletarInstituicao(Instituicao instituicao);
	void atualizarInstituicao(Instituicao instituicao);
	List<Instituicao> recuperarInstituicao();
	List<Instituicao> recuperarInstituicoesRecentesPorIdPaciente(Integer idPaciente);
	Instituicao recuperarInstituicaoPorId(Integer idInstituicao);
	
}
