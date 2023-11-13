package main.java.br.senac.mediconnect.modelo.dao.paciente;

import java.util.List;

import main.java.br.senac.mediconnect.modelo.entidade.atendente.Atendente;
import main.java.br.senac.mediconnect.modelo.entidade.paciente.Paciente;

public interface PacienteDAO {
	void inserirPaciente(Paciente paciente);
	void deletarPaciente(Paciente paciente);
	void atualizarPaciente(Paciente paciente);
	List<Paciente> recuperarPaciente();
	List<Paciente> recuperarPacientesCadastradosViaInstituicaoPorIdAtendente(Atendente atendente);
	Paciente recuperarPacientePorId(Integer id);
}