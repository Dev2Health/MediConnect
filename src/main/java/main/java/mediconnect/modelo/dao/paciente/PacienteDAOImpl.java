package main.java.mediconnect.modelo.dao.paciente;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import main.java.mediconnect.modelo.entidade.conquista.Conquista;
import main.java.mediconnect.modelo.entidade.consulta.Consulta;
import main.java.mediconnect.modelo.entidade.consulta.Consulta_;
import main.java.mediconnect.modelo.entidade.especialidadeProfissional.EspecialidadeProfissional;
import main.java.mediconnect.modelo.entidade.especialidadeProfissional.EspecialidadeProfissional_;
import main.java.mediconnect.modelo.entidade.instituicao.Instituicao;
import main.java.mediconnect.modelo.entidade.instituicao.Instituicao_;
import main.java.mediconnect.modelo.entidade.notificacao.Notificacao;
import main.java.mediconnect.modelo.entidade.notificacao.Notificacao_;
import main.java.mediconnect.modelo.entidade.paciente.Paciente;
import main.java.mediconnect.modelo.entidade.paciente.Paciente_;
import main.java.mediconnect.modelo.entidade.profissionalDeSaude.ProfissionalDeSaude;
import main.java.mediconnect.modelo.entidade.profissionalDeSaude.ProfissionalDeSaude_;
import main.java.mediconnect.modelo.enumeracao.consulta.StatusConsulta;
import main.java.mediconnect.modelo.factory.BuildFactory;

public class PacienteDAOImpl implements PacienteDAO {
	public BuildFactory fac;

	public PacienteDAOImpl() {
		fac = new BuildFactory();
	}

	public void inserirPaciente(Paciente Paciente) {
		Session sessao = null;

		try {

			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();

			sessao.saveOrUpdate(Paciente);

			sessao.getTransaction().commit();

		} catch (Exception sqlException) {

			sqlException.printStackTrace();

			if (sessao.getTransaction() != null) {
				sessao.getTransaction().rollback();
			}

		} finally {

			if (sessao != null) {
				sessao.close();
			}
		}

	}

	public void deletarPaciente(Paciente Paciente) {
		Session sessao = null;

		try {

			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();

			sessao.delete(Paciente);

			sessao.getTransaction().commit();

		} catch (Exception sqlException) {

			sqlException.printStackTrace();

			if (sessao.getTransaction() != null) {
				sessao.getTransaction().rollback();
			}

		} finally {

			if (sessao != null) {
				sessao.close();
			}
		}
	}

	public void atualizarPaciente(Paciente Paciente) {
		Session sessao = null;

		try {

			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();

			sessao.update(Paciente);

			sessao.getTransaction().commit();

		} catch (Exception sqlException) {

			sqlException.printStackTrace();

			if (sessao.getTransaction() != null) {
				sessao.getTransaction().rollback();
			}

		} finally {

			if (sessao != null) {
				sessao.close();
			}
		}
	}

	public List<Paciente> recuperarPaciente() {
		Session sessao = null;
		List<Paciente> pacientes = null;

		try {

			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Paciente> criteria = construtor.createQuery(Paciente.class);
			Root<Paciente> raizPaciente = criteria.from(Paciente.class);

			criteria.select(raizPaciente);

			pacientes = sessao.createQuery(criteria).getResultList();

			sessao.getTransaction().commit();

		} catch (Exception sqlException) {

			sqlException.printStackTrace();

			if (sessao.getTransaction() != null) {
				sessao.getTransaction().rollback();
			}

		} finally {

			if (sessao != null) {
				sessao.close();
			}
		}

		return pacientes;
	}
}