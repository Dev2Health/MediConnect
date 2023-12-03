package main.java.br.senac.mediconnect.modelo.dao.atendente;

import java.time.LocalDate;
import java.util.List;

import main.java.br.senac.mediconnect.modelo.entidade.atendente.Atendente;
import main.java.br.senac.mediconnect.modelo.entidade.instituicao.Instituicao;

public interface AtendenteDAO {
	void inserirAtendente(Atendente atendente);
	void deletarAtendente(Atendente atendente);
	void atualizarAtendente(Atendente atendente);
	Atendente recuperarAtendentePorId(Integer id);
	List<Atendente> recuperarListaDeAtendentes();
	List<Atendente> recuperarListaDeAtendentesViaInstituicao(Integer idInstituicao);
	Atendente filtrarAtendenteViaInstituicaoPorId(Integer idInstituicao);
	List<Atendente> filtrarAtendentesViaInstituicaoPorNomeCompleto(String nomeCompleto, Instituicao instituicao);
	List<Atendente> filtrarAtendentesViaInstituicaoPorNomeCompleto(String nomeCompleto, Integer idInstituicao);
	List<Atendente> filtrarAtendentesViaInstituicaoPorCpf(String cpf, Instituicao instituicao);
	List<Atendente> filtrarAtendentesViaInstituicaoPorCpf(String cpf, Integer idInstituicao);
	List<Atendente> filtrarAtendentesViaInstituicaoPorCtps(String ctps, Instituicao instituicao);
	List<Atendente> filtrarAtendentesViaInstituicaoPorCtps(String ctps, Integer idInstituicao);
	List<Atendente> filtrarAtendentesViaInstituicaoPorDataCadastro(LocalDate dataCadastro, Instituicao instituicao);
	List<Atendente> filtrarAtendentesViaInstituicaoPorDataCadastro(LocalDate dataCadastro, Integer idInstituicao);
	List<Atendente> filtrarAtendentesViaInstituicaoPorCadastro(Integer cadastro, Instituicao instituicao);
	List<Atendente> filtrarAtendentesViaInstituicaoPorCadastro(Integer cadastro, Integer idInstituicao);
}