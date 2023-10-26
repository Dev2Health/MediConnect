package main.java.mediconnect.modelo.dao.atendente;

import java.time.LocalDate;
import java.util.List;

import main.java.mediconnect.modelo.entidade.atendente.Atendente;
import main.java.mediconnect.modelo.entidade.instituicao.Instituicao;

public interface AtendenteDAO {
	void inserirAtendente(Atendente atendente);
	void deletarAtendente(Atendente atendente);
	void atualizarAtendente(Atendente atendente);
	Atendente recuperarAtendentePorId(Integer id);
	List<Atendente> recuperarListaDeAtendentes();
	Atendente filtrarAtendenteViaInstituicaoPorId(Integer id);
	List<Atendente> filtrarAtendenteViaInstituicaoPorNomeCompleto(String nomeCompleto, Instituicao instituicao);
	List<Atendente> filtrarAtendenteViaInstituicaoPorNomeCompleto(String nomeCompleto, Integer idInstituicao);
	List<Atendente> filtrarAtendenteViaInstituicaoPorCpf(String cpf, Instituicao instituicao);
	List<Atendente> filtrarAtendenteViaInstituicaoPorCpf(String cpf, Integer idInstituicao);
	List<Atendente> filtrarAtendenteViaInstituicaoPorCtps(String ctps, Instituicao instituicao);
	List<Atendente> filtrarAtendenteViaInstituicaoPorCtps(String ctps, Integer idInstituicao);
	List<Atendente> filtrarAtendenteViaInstituicaoPorDataCadastro(LocalDate dataCadastro, Instituicao instituicao);
	List<Atendente> filtrarAtendenteViaInstituicaoPorDataCadastro(LocalDate dataCadastro, Integer idInstituicao);
	List<Atendente> filtrarAtendenteViaInstituicaoPorCadastro(Integer cadastro, Instituicao instituicao);
	List<Atendente> filtrarAtendenteViaInstituicaoPorCadastro(Integer cadastro, Integer idInstituicao);
}