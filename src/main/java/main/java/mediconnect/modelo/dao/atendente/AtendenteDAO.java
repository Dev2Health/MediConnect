package main.java.mediconnect.modelo.dao.atendente;

import java.time.LocalDate;
import java.util.List;

import main.java.mediconnect.modelo.entidade.atendente.Atendente;
import main.java.mediconnect.modelo.entidade.instituicao.Instituicao;

public interface AtendenteDAO {
	void inserirAtendente(Atendente atendente);
	void deletarAtendente(Atendente atendente);
	void atualizarAtendente(Atendente atendente);
	List<Atendente> recuperarListaDeAtendentes();
	List<Atendente> filtrarAtendenteViaInstituicaoPorNomeCompleto(String nomeCompleto, Instituicao instituicao);
	List<Atendente> filtrarAtendenteViaInstituicaoPorCpf(String cpf, Instituicao instituicao);
	List<Atendente> filtrarAtendenteViaInstituicaoPorCtps(String ctps, Instituicao instituicao);
	List<Atendente> filtrarAtendenteViaInstituicaoPorDataCadastro(LocalDate dataCadastro, Instituicao instituicao);
	List<Atendente> filtrarAtendenteViaInstituicaoPorCadastro(int cadastro, Instituicao instituicao);
}