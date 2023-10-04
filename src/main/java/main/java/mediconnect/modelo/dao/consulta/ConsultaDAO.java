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
	List<Consulta> filtrarConsultaViaInstituicaoPorProfissionalDeSaude(ProfissionalDeSaude profisisonalDeSaude, Instituicao instituicao);
	List<Consulta> filtrarConsultaViaInstituicaoPorEspecialidadeProfissional(EspecialidadeProfissional especialidade, Instituicao instituicao);
	List<Consulta> filtrarConsultaViaInstituicaoPorStatus(StatusConsulta status, Instituicao instituicao);
	List<Consulta> filtrarConsultaViaInstituicaoPorData(LocalDate dataInicial, LocalDate dataFinal, Instituicao instituicao);
	List<Consulta> filtrarConsultaViaPacientePorProfissionalDeSaude(ProfissionalDeSaude profissionalDeSaude, Paciente paciente);
	List<Consulta> filtrarConsultaViaPacientePorEspecialidade(EspecialidadeProfissional especialidadeProfissional, Paciente paciente);
	List<Consulta> filtrarConsultaViaPacientePorInstituicao(Instituicao instituicao, Paciente paciente);
	List<Consulta> filtrarConsultaViaPacientePorStatus(StatusConsulta status, Paciente paciente);
	List<Consulta> filtrarConsultaViaPacientePorData(LocalDate dataInicial, LocalDate dataFinal, Paciente paciente);
}
