package main.java.mediconnect.modelo.dao.pacienteSelo;

import java.util.List;

import main.java.mediconnect.modelo.entidade.pacienteSelo.PacienteSelo;

public interface PacienteSeloDAO {
	void inserirPacienteSelo(PacienteSelo paciente_selo);
	void deletarPacienteSelo(PacienteSelo paciente_selo);
	void atualizarPacienteSelo(PacienteSelo paciente_selo);
	List<PacienteSelo> recuperarPacienteSelo();
}
