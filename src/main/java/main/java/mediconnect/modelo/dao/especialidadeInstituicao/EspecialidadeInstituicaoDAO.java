package main.java.mediconnect.modelo.dao.especialidadeInstituicao;

import java.util.List;

import main.java.mediconnect.modelo.entidade.especialidadeInstituicao.EspecialidadeInstituicao;

public interface EspecialidadeInstituicaoDAO {
	void inserirEspecialidadeInstituicao(EspecialidadeInstituicao especialidade_instituicao);
	void deletarEspecialidadeInstituicao(EspecialidadeInstituicao especialidade_instituicao);
	void atualizarEspecialidadeInstituicao(EspecialidadeInstituicao especialidade_instituicao);
	List<EspecialidadeInstituicao> recuperarEspecialidadeInstituicao();
}
