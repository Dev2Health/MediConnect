package main.java.mediconnect.modelo.dao.consulta;

import java.time.LocalDate;
import java.util.List;


import main.java.mediconnect.modelo.entidade.consulta.Consulta;
import main.java.mediconnect.modelo.entidade.especialidadeProfissional.EspecialidadeProfissional;
import main.java.mediconnect.modelo.entidade.instituicao.Instituicao;
import main.java.mediconnect.modelo.entidade.paciente.Paciente;
import main.java.mediconnect.modelo.entidade.profissionalDeSaude.ProfissionalDeSaude;
import main.java.mediconnect.modelo.enumeracao.consulta.StatusConsulta;

public interface ConsultaDAO {
	void inserirConsulta(Consulta consulta);
	void deletarConsulta(Consulta consulta);
	void atualizarConsulta(Consulta consulta);
	List<Consulta> recuperarListaDeConsultas();
	List<Consulta> filtrarConsultaViaInstituicaoPorPaciente(Paciente paciente, Instituicao instituicao);
	List<Consulta> filtrarConsultaViaInstituicaoPorPaciente(Integer idPaciente, Integer idInstituicao);
	List<Consulta> filtrarConsultaViaInstituicaoPorProfissionalDeSaude(ProfissionalDeSaude profisisonalDeSaude, Instituicao instituicao);
	List<Consulta> filtrarConsultaViaInstituicaoPorProfissionalDeSaude(Integer idProfisisonalDeSaude, Integer idInstituicao);
	List<Consulta> filtrarConsultaViaInstituicaoPorEspecialidadeProfissional(EspecialidadeProfissional especialidade, Instituicao instituicao);
	List<Consulta> filtrarConsultaViaInstituicaoPorEspecialidadeProfissional(Integer idEspecialidade, Integer idInstituicao);
	List<Consulta> filtrarConsultaViaInstituicaoPorStatus(StatusConsulta status, Instituicao instituicao);
	List<Consulta> filtrarConsultaViaInstituicaoPorStatus(StatusConsulta status, Integer idInstituicao);
	List<Consulta> filtrarConsultaViaInstituicaoPorData(LocalDate dataInicial, LocalDate dataFinal, Instituicao instituicao);
	List<Consulta> filtrarConsultaViaInstituicaoPorData(LocalDate dataInicial, LocalDate dataFinal, Integer idInstituicao);
	Consulta filtrarConsultasViaAtendentePorTitulo(Integer id, Integer idInstituicao);
	List<Consulta> filtrarConsultasViaAtendentePorIdDoPaciente(Integer id, Integer idInstituicao);
	List<Consulta> filtrarConsultaViaPacientePorProfissionalDeSaude(ProfissionalDeSaude profissionalDeSaude, Paciente paciente);
	List<Consulta> filtrarConsultaViaPacientePorProfissionalDeSaude(Integer IdProfissionalDeSaude, Integer IdPaciente);
	List<Consulta> filtrarConsultaViaPacientePorEspecialidade(EspecialidadeProfissional especialidadeProfissional, Paciente paciente);
	List<Consulta> filtrarConsultaViaPacientePorEspecialidade(Integer idEspecialidadeProfissional, Integer idPaciente);
	List<Consulta> filtrarConsultaViaPacientePorInstituicao(Integer idInstituicao, Integer idPaciente);
	List<Consulta> filtrarConsultaViaPacientePorStatus(StatusConsulta status, Integer idPaciente);
	List<Consulta> recuperarConsultasAgendadasViaPacientePorId(Integer id);
	List<Consulta> filtrarConsultaViaPacientePorData(LocalDate dataInicial, LocalDate dataFinal, Integer idPaciente);
	List<Consulta> recuperarConsultasViaPacientePorId(Integer id);

}
