package main.java.mediconnect.modelo.dao.especialidadeProfissional;

import java.util.List;

import main.java.mediconnect.modelo.entidade.especialidadeProfissional.EspecialidadeProfissional;

public interface EspecialidadeProfissionalDAO {
	void inserirEspecialidadeProfissional(EspecialidadeProfissional especialidadeProfissional);
	void deletarEspecialidadeProfissional(EspecialidadeProfissional especialidadeProfissional);
	void atualizarEspecialidadeProfissional(EspecialidadeProfissional especialidadeProfissional);
	List<EspecialidadeProfissional> recuperarEspecialidadeProfissional();
	EspecialidadeProfissional recuperarEspecialidadePorId(Integer id);
	List<EspecialidadeProfissional> recuperarEspecialidadesProfissionaisPorId(Integer id);
}
