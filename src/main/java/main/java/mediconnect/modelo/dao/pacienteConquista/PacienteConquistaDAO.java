package main.java.mediconnect.modelo.dao.pacienteConquista;

import java.util.List;

import main.java.mediconnect.modelo.entidade.pacienteConquista.PacienteConquista;

public interface PacienteConquistaDAO {
	void inserirPacienteConquista(PacienteConquista paciente_conquista);
	void deletarPacienteConquista(PacienteConquista paciente_conquista);
	void atualizarPacienteConquista(PacienteConquista paciente_conquista);
	List<PacienteConquista> recuperarPacienteConquista();
}
