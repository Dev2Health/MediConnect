package main.java.mediconnect.modelo.dao.selo;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import main.java.mediconnect.modelo.entidade.conquista.Conquista;
import main.java.mediconnect.modelo.entidade.paciente.Paciente;
import main.java.mediconnect.modelo.entidade.selo.Selo;
import main.java.mediconnect.modelo.factory.BuildFactory;

public class SeloDAOImpl implements SeloDAO {

	public BuildFactory fac;
	public SeloDAOImpl() {
		fac = new BuildFactory();
	}
	public void inserirSelo(Selo selo) {
		
		Session sessao = null;
		
		try {
			
			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();
			
			sessao.saveOrUpdate(selo);
			
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

	public void deletarSelo(Selo selo) {
		
		Session sessao = null;
		
		try {
			
			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();
			
			sessao.delete(selo);
			
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

	public void atualizarSelo(Selo selo) {

		Session sessao = null;
		
		try {
			
			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();
			
			sessao.update(selo);
			
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

	public List<Selo> recuperarSelos() {
		
		Session sessao = null;
		List<Selo> selos = null;
		
		try {
			
			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();
			
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			
			CriteriaQuery<Selo> criteria = construtor.createQuery(Selo.class);
			Root<Selo> raizSelo = criteria.from(Selo.class);
			
			criteria.select(raizSelo);
			
			selos = sessao.createQuery(criteria).getResultList();
			
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
		
		return selos;
	}
}
