package main.java.br.senac.mediconnect.modelo.dao.profissionalDeSaude;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import main.java.br.senac.mediconnect.modelo.entidade.especialidadeProfissional.EspecialidadeProfissional;
import main.java.br.senac.mediconnect.modelo.entidade.instituicao.Instituicao_;
import main.java.br.senac.mediconnect.modelo.entidade.profissionalDeSaude.ProfissionalDeSaude;
import main.java.br.senac.mediconnect.modelo.entidade.profissionalDeSaude.ProfissionalDeSaude_;
import main.java.br.senac.mediconnect.modelo.factory.BuildFactory;

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
	public ProfissionalDeSaude recuperarProfissionalPorIdInstituicao(Integer idInstituicao) {
		
		Session sessao = null;
		ProfissionalDeSaude profissionalDeSaude = null;
		
		try {
			
			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();
			
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			
			CriteriaQuery<ProfissionalDeSaude> criteria = construtor.createQuery(ProfissionalDeSaude.class);
			Root<ProfissionalDeSaude> raizProfissionalDeSaude = criteria.from(ProfissionalDeSaude.class);
			
			criteria.select(raizProfissionalDeSaude);
			
			criteria.where(construtor.equal(raizProfissionalDeSaude.get(ProfissionalDeSaude_.instituicao).get(Instituicao_.ID), idInstituicao));
					 
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
	public ProfissionalDeSaude recuperarProfissionalPorId(Integer idProfissional) {
		
		Session sessao = null;
		ProfissionalDeSaude profissionalDeSaude = null;
		
		try {
			
			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();
			
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			
			CriteriaQuery<ProfissionalDeSaude> criteria = construtor.createQuery(ProfissionalDeSaude.class);
			Root<ProfissionalDeSaude> raizProfissionalDeSaude = criteria.from(ProfissionalDeSaude.class);
			
			criteria.select(raizProfissionalDeSaude);
			
			criteria.where(construtor.equal(raizProfissionalDeSaude.get(ProfissionalDeSaude_.ID), idProfissional));
					 
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
	
	public 	List<ProfissionalDeSaude> recuperarProfissionaisDeSaudePorEspecialidade(EspecialidadeProfissional especialidade) {
		
		Session sessao = null;
		List<ProfissionalDeSaude> profissionaisDeSaude = null;
		
		try {
			
			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();
			
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			
			CriteriaQuery<ProfissionalDeSaude> criteria = construtor.createQuery(ProfissionalDeSaude.class);
			Root<ProfissionalDeSaude> raizProfissionalDeSaude = criteria.from(ProfissionalDeSaude.class);
			
			criteria.select(raizProfissionalDeSaude);
			
			criteria.where(construtor.equal(raizProfissionalDeSaude.get(ProfissionalDeSaude_.ESPECIALIDADE_PROFISSIONAL), especialidade));
			 
			
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

}
