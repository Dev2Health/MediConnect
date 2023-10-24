package main.java.mediconnect.modelo.dao.profissionalDeSaude;

import java.util.List;

import main.java.mediconnect.modelo.entidade.profissionalDeSaude.ProfissionalDeSaude;

public interface ProfissionalDeSaudeDAO {
	void inserirProfissionalDeSaude(ProfissionalDeSaude ProfissionalDeSaude);
	void deletarProfissionalDeSaude(ProfissionalDeSaude ProfissionalDeSaude);
	void atualizarProfissionalDeSaude(ProfissionalDeSaude ProfissionalDeSaude);
	List<ProfissionalDeSaude> recuperarProfissionaisDeSaude();
	ProfissionalDeSaude recuperarProfissionalPorIdInstituicao(Integer id);
}
