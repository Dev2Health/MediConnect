package main.java.br.senac.mediconnect.modelo.dao.paciente;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import main.java.br.senac.mediconnect.modelo.entidade.atendente.Atendente;
import main.java.br.senac.mediconnect.modelo.entidade.atendente.Atendente_;
import main.java.br.senac.mediconnect.modelo.entidade.consulta.Consulta;
import main.java.br.senac.mediconnect.modelo.entidade.consulta.Consulta_;
import main.java.br.senac.mediconnect.modelo.entidade.instituicao.Instituicao_;
import main.java.br.senac.mediconnect.modelo.entidade.paciente.Paciente;
import main.java.br.senac.mediconnect.modelo.entidade.paciente.Paciente_;
import main.java.br.senac.mediconnect.modelo.factory.BuildFactory;

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

	public List<Paciente> recuperarPacientes() {
		
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
	
	public List<Paciente> recuperarPacientesCadastradosViaInstituicaoPorIdAtendente(Integer id) {
		
		Session sessao = null;
		List<Paciente> pacientes = null;

		try {

			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Paciente> criteria = construtor.createQuery(Paciente.class);
			Root<Atendente> raizAtendente = criteria.from(Atendente.class);
			Root<Consulta> raizConsulta = criteria.from(Consulta.class);
			Root<Paciente> raizPaciente = criteria.from(Paciente.class);

			criteria.select(raizPaciente);
			
			criteria.where(construtor.equal(raizAtendente.get(Atendente_.instituicao).get(Instituicao_.ID), id),
						   construtor.equal(raizConsulta.get(Consulta_.instituicao).get(Instituicao_.ID), id));

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

	@Override
	public Paciente recuperarPacientePorId(Integer idPaciente) {
		
		Session sessao = null;
		Paciente paciente = null;

		try {

			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Paciente> criteria = construtor.createQuery(Paciente.class);
			Root<Paciente> raizPaciente = criteria.from(Paciente.class);

			criteria.select(raizPaciente);
			
			criteria.where(construtor.equal(raizPaciente.get(Paciente_.ID), idPaciente));

			paciente = sessao.createQuery(criteria).getSingleResult();

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

		return paciente;

	}
}