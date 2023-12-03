package main.java.br.senac.mediconnect.modelo.dao.consulta;

import java.time.LocalDate;
import java.util.List;

import main.java.br.senac.mediconnect.modelo.entidade.consulta.Consulta;
import main.java.br.senac.mediconnect.modelo.entidade.especialidadeProfissional.EspecialidadeProfissional;
import main.java.br.senac.mediconnect.modelo.entidade.instituicao.Instituicao;
import main.java.br.senac.mediconnect.modelo.entidade.paciente.Paciente;
import main.java.br.senac.mediconnect.modelo.entidade.profissionalDeSaude.ProfissionalDeSaude;
import main.java.br.senac.mediconnect.modelo.enumeracao.consulta.StatusConsulta;

public interface ConsultaDAO {
	void inserirConsulta(Consulta consulta);
	void deletarConsulta(Consulta consulta);
	void atualizarConsulta(Consulta consulta);
	List<Consulta> recuperarListaDeConsultas();
	List<Consulta> filtrarConsultasViaInstituicaoPorPaciente(Paciente paciente, Instituicao instituicao);
	List<Consulta> filtrarConsultasViaInstituicaoPorPaciente(Integer idPaciente, Integer idInstituicao);
	List<Consulta> filtrarConsultasViaInstituicaoPorProfissionalDeSaude(ProfissionalDeSaude profisisonalDeSaude, Instituicao instituicao);
	List<Consulta> filtrarConsultasViaInstituicaoPorProfissionalDeSaude(Integer idProfisisonalDeSaude, Integer idInstituicao);
	List<Consulta> filtrarConsultasViaInstituicaoPorEspecialidadeProfissional(EspecialidadeProfissional especialidade, Instituicao instituicao);
	List<Consulta> filtrarConsultasViaInstituicaoPorEspecialidadeProfissional(Integer idEspecialidade, Integer idInstituicao);
	List<Consulta> filtrarConsultasViaInstituicaoPorStatus(StatusConsulta status, Instituicao instituicao);
	List<Consulta> filtrarConsultasViaInstituicaoPorStatus(StatusConsulta status, Integer idInstituicao);
	List<Consulta> filtrarConsultasViaInstituicaoPorData(LocalDate dataInicial, LocalDate dataFinal, Instituicao instituicao);
	List<Consulta> filtrarConsultasViaInstituicaoPorData(LocalDate dataInicial, LocalDate dataFinal, Integer idInstituicao);
	Consulta filtrarConsultaViaAtendentePorTitulo(Integer idConsulta, Integer idAtendente);
	List<Consulta> filtrarConsultasViaAtendentePorInstituicao(Integer id, Integer idInstituicao);
	List<Consulta> filtrarConsultasViaPacientePorProfissionalDeSaude(ProfissionalDeSaude profissionalDeSaude, Paciente paciente);
	List<Consulta> filtrarConsultasViaPacientePorProfissionalDeSaude(Integer idProfissionalDeSaude, Integer IdPaciente);
	List<Consulta> filtrarConsultasViaPacientePorEspecialidade(EspecialidadeProfissional especialidadeProfissional, Paciente paciente);
	List<Consulta> filtrarConsultasViaPacientePorEspecialidade(Integer idEspecialidadeProfissional, Integer idPaciente);
	List<Consulta> filtrarConsultasViaPacientePorInstituicao(Integer idInstituicao, Integer idPaciente);
	List<Consulta> filtrarConsultasViaPacientePorStatus(StatusConsulta status, Integer idPaciente);
	List<Consulta> recuperarConsultasAgendadasViaPacientePorId(Integer idPaciente);
	List<Consulta> filtrarConsultasViaPacientePorData(LocalDate dataInicial, LocalDate dataFinal, Integer idPaciente);
	List<Consulta> recuperarConsultasViaPacientePorId(Integer idPaciente);
	Consulta filtrarConsultaViaPacientePorIdDaConsulta(Integer idConsulta, Integer idPaciente);
	Consulta recuperarConsultaPorId(Integer idConsulta);
}
