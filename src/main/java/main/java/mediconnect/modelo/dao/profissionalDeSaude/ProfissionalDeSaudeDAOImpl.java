package main.java.mediconnect.modelo.dao.profissionalDeSaude;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import main.java.mediconnect.modelo.entidade.atendente.Atendente_;
import main.java.mediconnect.modelo.entidade.consulta.Consulta;
import main.java.mediconnect.modelo.entidade.consulta.Consulta_;
import main.java.mediconnect.modelo.entidade.especialidadeProfissional.EspecialidadeProfissional;
import main.java.mediconnect.modelo.entidade.especialidadeProfissional.EspecialidadeProfissional_;
import main.java.mediconnect.modelo.entidade.instituicao.Instituicao;
import main.java.mediconnect.modelo.entidade.instituicao.Instituicao_;
import main.java.mediconnect.modelo.entidade.profissionalDeSaude.ProfissionalDeSaude;
import main.java.mediconnect.modelo.entidade.profissionalDeSaude.ProfissionalDeSaude_;
import main.java.mediconnect.modelo.factory.BuildFactory;

public class ProfissionalDeSaudeDAOImpl implements ProfissionalDeSaudeDAO {

	public BuildFactory fac;
	public ProfissionalDeSaudeDAOImpl() {
		fac = new BuildFactory();
	}
	
	public void inserirProfissionalDeSaude(ProfissionalDeSaude profissionalDeSaude) {
		
		Session sessao = null;
		
		try {
			
			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();
			
			sessao.saveOrUpdate(profissionalDeSaude);
			
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

	public void deletarProfissionalDeSaude(ProfissionalDeSaude profissionalDeSaude) {
	
		Session sessao = null;
		
		try {
			
			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();
			
			sessao.delete(profissionalDeSaude);
			
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

	public void atualizarProfissionalDeSaude(ProfissionalDeSaude profissionalDeSaude) {

		Session sessao = null;
		
		try {
			
			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();
			
			sessao.update(profissionalDeSaude);
			
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

	public List<ProfissionalDeSaude> recuperarProfissionaisDeSaude() {
	
		Session sessao = null;
		List<ProfissionalDeSaude> profissionaisDeSaude = null;
		
		try {
			
			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();
			
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			
			CriteriaQuery<ProfissionalDeSaude> criteria = construtor.createQuery(ProfissionalDeSaude.class);
			Root<ProfissionalDeSaude> raizProfissionalDeSaude = criteria.from(ProfissionalDeSaude.class);
			
			criteria.select(raizProfissionalDeSaude);
			
			profissionaisDeSaude = sessao.createQuery(criteria).getResultList();
			
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
		
		return profissionaisDeSaude;
	}
	
	@Override
	public ProfissionalDeSaude recuperarProfissionalPorIdInstituicao(Integer id) {
		
		Session sessao = null;
		ProfissionalDeSaude profissionalDeSaude = null;
		
		try {
			
			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();
			
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			
			CriteriaQuery<ProfissionalDeSaude> criteria = construtor.createQuery(ProfissionalDeSaude.class);
			Root<ProfissionalDeSaude> raizProfissionalDeSaude = criteria.from(ProfissionalDeSaude.class);
			
			criteria.select(raizProfissionalDeSaude);
			
			criteria.where(construtor.equal(raizProfissionalDeSaude.get(ProfissionalDeSaude_.instituicao).get(Instituicao_.ID), id));
					 
			profissionalDeSaude = sessao.createQuery(criteria).getSingleResult();
			
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
		
		return profissionalDeSaude;
	}	
	
	@Override
	public ProfissionalDeSaude recuperarProfissionalPorId(Integer id) {
		
		Session sessao = null;
		ProfissionalDeSaude profissionalDeSaude = null;
		
		try {
			
			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();
			
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			
			CriteriaQuery<ProfissionalDeSaude> criteria = construtor.createQuery(ProfissionalDeSaude.class);
			Root<ProfissionalDeSaude> raizProfissionalDeSaude = criteria.from(ProfissionalDeSaude.class);
			
			criteria.select(raizProfissionalDeSaude);
			
			criteria.where(construtor.equal(raizProfissionalDeSaude.get(ProfissionalDeSaude_.ID), id));
					 
			profissionalDeSaude = sessao.createQuery(criteria).getSingleResult();
			
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
		
		return profissionalDeSaude;
	}	

}
