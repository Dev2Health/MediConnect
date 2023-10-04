package main.java.mediconnect.modelo.dao.conquista;

import java.util.List;

import main.java.mediconnect.modelo.entidade.conquista.Conquista;
import main.java.mediconnect.modelo.entidade.paciente.Paciente;
import main.java.mediconnect.modelo.enumeracao.consulta.StatusConsulta;

public interface ConquistaDAO {
	void inserirConquista(Conquista conquista);
	void deletarConquista(Conquista conquista);
	void atualizarConquista(Conquista conquista);
	List<Conquista> recuperarListaDeConquistas();
	List<Conquista> filtrarConquistaViaPacienteDoPacientePorStatus(StatusConsulta status, Paciente paciente);
}
