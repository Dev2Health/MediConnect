package main.java.mediconnect.modelo.dao.pacienteSelo;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import main.java.mediconnect.modelo.entidade.pacienteSelo.PacienteSelo;
import main.java.mediconnect.modelo.factory.BuildFactory;

public class PacienteSeloDAOImpl implements PacienteSeloDAO{
public BuildFactory fac;
	
	public PacienteSeloDAOImpl() {
		fac = new BuildFactory();
	}

	@Override
	public void inserirPacienteSelo(PacienteSelo paciente_selo) {
		Session sessao = null;
		
		try {
			
			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();

			sessao.save(paciente_selo);
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
	public void deletarPacienteSelo(PacienteSelo paciente_selo) {
		Session sessao = null;
		
		try {
			
			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();

			sessao.delete(paciente_selo);
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
	public void atualizarPacienteSelo(PacienteSelo paciente_selo) {
		Session sessao = null;
		
		try {
			
			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();
			
			sessao.update(paciente_selo);
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
	public List<PacienteSelo> recuperarPacienteSelo() {
		Session sessao = null;
		List<PacienteSelo> selos = null;
		
		try {
			
			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<PacienteSelo> criteria = construtor.createQuery(PacienteSelo.class);
			Root<PacienteSelo> raizselo = criteria.from(PacienteSelo.class);
			criteria.select(raizselo);
			selos = sessao.createQuery(criteria).getResultList();

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
		return selos;
	}
}
