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
	List<Notificacao> filtrarNotificacoesViaAtendentePorIdConsulta(Integer idConsulta, Instituicao instituicao);
	List<Notificacao> filtrarNotificacoesViaAtendentePorIdConsulta(Integer idConsulta, Integer idInstituicao);
	List<Notificacao> filtrarNotificacoesViaAtendentePorCPFPaciente(String cpf, Instituicao instituicao);
	List<Notificacao> filtrarNotificacoesViaAtendentePorCPFPaciente(String cpf, Integer idInstituicao);
	List<Notificacao> filtrarNotificacoesViaAtendentePorData(LocalDate dataInicial, LocalDate dataFinal, Instituicao instituicao);
	List<Notificacao> filtrarNotificacoesViaAtendentePorData(LocalDate dataInicial, LocalDate dataFinal, Integer idInstituicao);
	List<Notificacao> filtrarNotificacoesViaInstituicaoPorData(LocalDate dataInicial, LocalDate dataFinal, Paciente paciente);
	List<Notificacao> filtrarNotificacoesViaInstituicaoPorData(LocalDate dataInicial, LocalDate dataFinal, Integer idPaciente);
	List<Notificacao> filtrarNotificacoesViaPacientePorInstituicao(Instituicao instituicao, Paciente paciente);
	List<Notificacao> filtrarNotificacoesViaPacientePorInstituicao(Instituicao instituicao, Integer idPaciente);
	List<Notificacao> filtrarNotificacoesViaPacientePorIdConsulta(Consulta consulta, Paciente paciente);
	List<Notificacao> filtrarNotificacoesViaPacientePorIdConsulta(Integer idConsulta, Integer idPaciente);
	List<Notificacao> filtrarNotificacoesViaPacientePorData(LocalDate dataInicial, LocalDate dataFinal, Paciente paciente);
	List<Notificacao> filtrarNotificacoesViaPacientePorData(LocalDate dataInicial, LocalDate dataFinal, Integer idPaciente);
	Notificacao filtrarNotificacaoViaAtendentePorTitulo(Integer idNotificacao, Integer idAtendente);
	Notificacao recuperarNotificacaoPorId(Integer idNotificao);
}
