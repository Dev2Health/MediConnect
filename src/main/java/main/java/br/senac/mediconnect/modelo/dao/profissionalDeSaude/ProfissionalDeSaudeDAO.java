package main.java.br.senac.mediconnect.modelo.dao.profissionalDeSaude;

import java.util.List;

import main.java.br.senac.mediconnect.modelo.entidade.especialidadeProfissional.EspecialidadeProfissional;
import main.java.br.senac.mediconnect.modelo.entidade.profissionalDeSaude.ProfissionalDeSaude;

public interface ProfissionalDeSaudeDAO {
	void inserirProfissionalDeSaude(ProfissionalDeSaude ProfissionalDeSaude);
	void deletarProfissionalDeSaude(ProfissionalDeSaude ProfissionalDeSaude);
	void atualizarProfissionalDeSaude(ProfissionalDeSaude ProfissionalDeSaude);
	List<ProfissionalDeSaude> recuperarProfissionaisDeSaude();
	List<ProfissionalDeSaude> recuperarProfissionalPorIdInstituicao(Integer idInstituicao);
	List<ProfissionalDeSaude> recuperarProfissionaisDeSaudePorEspecialidade(EspecialidadeProfissional especialidade);
	ProfissionalDeSaude recuperarProfissionalPorId(Integer idProfissional);

}
