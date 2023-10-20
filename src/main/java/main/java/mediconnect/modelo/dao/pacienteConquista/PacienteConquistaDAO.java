package main.java.mediconnect.modelo.dao.pacienteConquista;

import java.util.List;

import main.java.mediconnect.modelo.entidade.conquista.Conquista;
import main.java.mediconnect.modelo.entidade.pacienteConquista.PacienteConquista;

public interface PacienteConquistaDAO {
	void inserirPacienteConquista(PacienteConquista paciente_conquista);
	void deletarPacienteConquista(PacienteConquista paciente_conquista);
	void atualizarPacienteConquista(PacienteConquista paciente_conquista);
	List<Conquista> recuperarConquistaPacientePorId(Integer id);
	List<PacienteConquista> recuperarPacienteConquista();
}
