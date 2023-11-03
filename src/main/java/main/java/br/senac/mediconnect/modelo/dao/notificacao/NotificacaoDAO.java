package main.java.br.senac.mediconnect.modelo.dao.notificacao;

import java.time.LocalDate;
import java.util.List;

import main.java.br.senac.mediconnect.modelo.entidade.consulta.Consulta;
import main.java.br.senac.mediconnect.modelo.entidade.instituicao.Instituicao;
import main.java.br.senac.mediconnect.modelo.entidade.notificacao.Notificacao;
import main.java.br.senac.mediconnect.modelo.entidade.paciente.Paciente;

public interface NotificacaoDAO {
	void inserirNotificacao(Notificacao notificacao);
	void deletarNotificacao(Notificacao notificacao);
	void atualizarNotificacao(Notificacao notificacao);
	List<Notificacao> recuperarNotificacao();
	List<Notificacao> filtrarNotificacaoViaAtendentePorIdConsulta(Integer id, Instituicao instituicao);
	List<Notificacao> filtrarNotificacaoViaAtendentePorIdConsulta(Integer id, Integer idInstituicao);
	List<Notificacao> filtrarNotificacaoViaAtendentePorCPFPaciente(String cpf, Instituicao instituicao);
	List<Notificacao> filtrarNotificacaoViaAtendentePorCPFPaciente(String cpf, Integer idInstituicao);
	List<Notificacao> filtrarNotificacaoViaAtendentePorData(LocalDate dataInicial, LocalDate dataFinal, Instituicao instituicao);
	List<Notificacao> filtrarNotificacaoViaAtendentePorData(LocalDate dataInicial, LocalDate dataFinal, Integer idInstituicao);
	List<Notificacao> filtrarNotificacaoViaInstituicaoPorData(LocalDate dataInicial, LocalDate dataFinal, Paciente paciente);
	List<Notificacao> filtrarNotificacaoViaInstituicaoPorData(LocalDate dataInicial, LocalDate dataFinal, Integer idPaciente);
	List<Notificacao> filtrarNotificacaoViaPacientePorInstituicao(Instituicao instituicao, Paciente paciente);
	List<Notificacao> filtrarNotificacaoViaPacientePorInstituicao(Instituicao instituicao, Integer idPaciente);
	List<Notificacao> filtrarNotificacaoViaPacientePorIdConsulta(Consulta consulta, Paciente paciente);
	List<Notificacao> filtrarNotificacaoViaPacientePorIdConsulta(Integer idConsulta, Integer idPaciente);
	List<Notificacao> filtrarNotificacaoViaPacientePorData(LocalDate dataInicial, LocalDate dataFinal, Paciente paciente);
	List<Notificacao> filtrarNotificacaoViaPacientePorData(LocalDate dataInicial, LocalDate dataFinal, Integer idPaciente);
	Notificacao filtrarNotificacaoViaAtendentePorTitulo(Integer idNotificacao, Integer idAtendente);
}
