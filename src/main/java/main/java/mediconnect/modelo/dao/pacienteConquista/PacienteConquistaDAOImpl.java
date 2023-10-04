package main.java.mediconnect.modelo.dao.pacienteConquista;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import main.java.mediconnect.modelo.entidade.conquista.Conquista;
import main.java.mediconnect.modelo.entidade.pacienteConquista.PacienteConquista;
import main.java.mediconnect.modelo.factory.BuildFactory;

public class PacienteConquistaDAOImpl implements PacienteConquistaDAO{
public BuildFactory fac;
	
	public PacienteConquistaDAOImpl() {
		fac = new BuildFactory();
	}

	@Override
	public void inserirPacienteConquista(PacienteConquista paciente_conquista) {
		Session sessao = null;
		
		try {
			
			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();

			sessao.save(paciente_conquista);
			sessao.getTransaction().commit();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			if (sessao.getTransaction() != null) {
				sessao.getTransaction().rollback();
			}

		} finally {
			if (sessao != null) {
				sessao.close();
			}
		}
	}

	@Override
	public void deletarPacienteConquista(PacienteConquista paciente_conquista) {
		Session sessao = null;
		
		try {
			
			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();

			sessao.delete(paciente_conquista);
			sessao.getTransaction().commit();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			if (sessao.getTransaction() != null) {
				sessao.getTransaction().rollback();
			}
			
		} finally {
			if (sessao != null) {
				sessao.close();
			}
		}
		
	}

	@Override
	public void atualizarPacienteConquista(PacienteConquista paciente_conquista) {
		Session sessao = null;
		
		try {
			
			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();
			
			sessao.update(paciente_conquista);
			sessao.getTransaction().commit();

		} catch (Exception e) {
			
			e.printStackTrace();
			if (sessao.getTransaction() != null) {
				sessao.getTransaction().rollback();
			}
			
		} finally {
			if (sessao != null) {
				sessao.close();
			}
		}
		
	}

	@Override
	public List<PacienteConquista> recuperarPacienteConquista() {
		Session sessao = null;
		List<PacienteConquista> conquistas = null;
		
		try {
			
			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<PacienteConquista> criteria = construtor.createQuery(PacienteConquista.class);
			Root<PacienteConquista> raizConquista = criteria.from(PacienteConquista.class);
			criteria.select(raizConquista);
			conquistas = sessao.createQuery(criteria).getResultList();

			sessao.getTransaction().commit();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			if (sessao.getTransaction() != null) {
				sessao.getTransaction().rollback();
			}

		} finally {
			if (sessao != null) {
				sessao.close();
			}
		}
		return conquistas;
	}
}
