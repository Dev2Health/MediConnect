package main.java.br.senac.mediconnect.modelo.dao.paciente;

import java.util.List;

import main.java.br.senac.mediconnect.modelo.entidade.atendente.Atendente;
import main.java.br.senac.mediconnect.modelo.entidade.paciente.Paciente;

public interface PacienteDAO {
	void inserirPaciente(Paciente paciente);
	void deletarPaciente(Paciente paciente);
	void atualizarPaciente(Paciente paciente);
	List<Paciente> recuperarPacientes();
	List<Paciente> recuperarPacientesCadastradosViaInstituicaoPorIdAtendente(Atendente atendente);
	Paciente recuperarPacientePorId(Integer idPaciente);
	Paciente recuperarPacientePorIdComConsultas(Integer idPaciente);

}