package main.java.br.senac.mediconnect.modelo.dao.conquista;

import java.util.List;

import main.java.br.senac.mediconnect.modelo.entidade.conquista.Conquista;
import main.java.br.senac.mediconnect.modelo.entidade.paciente.Paciente;
import main.java.br.senac.mediconnect.modelo.enumeracao.consulta.StatusConsulta;

public interface ConquistaDAO {
	void inserirConquista(Conquista conquista);
	void deletarConquista(Conquista conquista);
	void atualizarConquista(Conquista conquista);
	List<Conquista> recuperarListaDeConquistas();
	List<Conquista> filtrarConquistasViaPacienteDoPacientePorStatus(StatusConsulta status, Paciente paciente);
	List<Conquista> filtrarConquistasViaPacienteDoPacientePorStatus(StatusConsulta status, Integer idPaciente);
}
	
