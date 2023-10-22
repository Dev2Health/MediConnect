package main.java.mediconnect.modelo.dao.paciente;

import java.util.List;

import main.java.mediconnect.modelo.entidade.instituicao.Instituicao;
import main.java.mediconnect.modelo.entidade.paciente.Paciente;

public interface PacienteDAO {
	void inserirPaciente(Paciente paciente);
	void deletarPaciente(Paciente paciente);
	void atualizarPaciente(Paciente paciente);
	List<Paciente> recuperarPaciente();
	List<Paciente> recuperarPacientesCadastradosPorId(Integer id, Instituicao instituicao);
	Paciente recuperarPacientePorId(Integer id);
}