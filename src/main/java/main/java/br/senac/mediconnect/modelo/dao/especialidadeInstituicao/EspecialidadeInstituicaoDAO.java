package main.java.br.senac.mediconnect.modelo.dao.especialidadeInstituicao;

import java.util.List;

import main.java.br.senac.mediconnect.modelo.entidade.especialidadeInstituicao.EspecialidadeInstituicao;

public interface EspecialidadeInstituicaoDAO {
	void inserirEspecialidadeInstituicao(EspecialidadeInstituicao especialidadeInstituicao);
	void deletarEspecialidadeInstituicao(EspecialidadeInstituicao especialidadeInstituicao);
	void atualizarEspecialidadeInstituicao(EspecialidadeInstituicao especialidadeInstituicao);
	List<EspecialidadeInstituicao> recuperarEspecialidadesInstituicao();
}
