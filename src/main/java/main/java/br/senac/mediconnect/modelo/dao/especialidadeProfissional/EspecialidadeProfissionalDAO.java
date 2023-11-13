package main.java.br.senac.mediconnect.modelo.dao.especialidadeProfissional;

import java.util.List;

import main.java.br.senac.mediconnect.modelo.entidade.especialidadeProfissional.EspecialidadeProfissional;

public interface EspecialidadeProfissionalDAO {
	void inserirEspecialidadeProfissionalDaInstituicao(EspecialidadeProfissional especialidadeProfissional);
	void deletarEspecialidadeProfissionalDaInstituicao(EspecialidadeProfissional especialidadeProfissional);
	void atualizarEspecialidadeProfissionalDaInstituicao(EspecialidadeProfissional especialidadeProfissional);
	List<EspecialidadeProfissional> recuperarEspecialidadesProfissionais();
	EspecialidadeProfissional recuperarEspecialidadeDaInstituicaoPorId(Integer id);
	List<EspecialidadeProfissional> recuperarEspecialidadesProfissionaisDaInstituicaoPorId(Integer id);
}
