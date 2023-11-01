package main.java.mediconnect.modelo.dao.instituicao;

import java.util.List;

import main.java.mediconnect.modelo.entidade.instituicao.Instituicao;

public interface InstituicaoDAO {
	void inserirInstituicao(Instituicao instituicao);
	void deletarInstituicao(Instituicao instituicao);
	void atualizarInstituicao(Instituicao instituicao);
	List<Instituicao> recuperarInstituicao();
	List<Instituicao> recuperarInstituicoesRecentesPorIdPaciente(Integer id);
	Instituicao recuperarInstituicaoPorId(Integer id);
	
}
