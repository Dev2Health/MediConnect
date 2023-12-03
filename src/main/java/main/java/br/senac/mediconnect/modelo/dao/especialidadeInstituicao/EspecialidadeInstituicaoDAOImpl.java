package main.java.br.senac.mediconnect.modelo.dao.especialidadeInstituicao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import main.java.br.senac.mediconnect.modelo.entidade.especialidadeInstituicao.EspecialidadeInstituicao;
import main.java.br.senac.mediconnect.modelo.factory.BuildFactory;

public class EspecialidadeInstituicaoDAOImpl implements EspecialidadeInstituicaoDAO{
public BuildFactory fac;
	
	public EspecialidadeInstituicaoDAOImpl() {
		fac = new BuildFactory();
	}

	@Override
	public void inserirEspecialidadeInstituicao(EspecialidadeInstituicao especialidadeInstituicao) {
		
		Session sessao = null;
		
		try {
			
			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();

			sessao.save(especialidadeInstituicao);
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

	@Override
	public void deletarEspecialidadeInstituicao(EspecialidadeInstituicao especialidadeInstituicao) {
		
		Session sessao = null;
		
		try {
			
			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();

			sessao.delete(especialidadeInstituicao);
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

	@Override
	public void atualizarEspecialidadeInstituicao(EspecialidadeInstituicao especialidadeInstituicao) {
		
		Session sessao = null;
		
		try {
			
			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();
			
			sessao.update(especialidadeInstituicao);
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

	@Override
	public List<EspecialidadeInstituicao> recuperarEspecialidadesInstituicao() {
		
		Session sessao = null;
		List<EspecialidadeInstituicao> especialidadesInstituicao = null;
		
		try {
			
			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<EspecialidadeInstituicao> criteria = construtor.createQuery(EspecialidadeInstituicao.class);
			Root<EspecialidadeInstituicao> raizEspecialidadeInstituicao = criteria.from(EspecialidadeInstituicao.class);
			
			criteria.select(raizEspecialidadeInstituicao);
			
			especialidadesInstituicao = sessao.createQuery(criteria).getResultList();

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
		return especialidadesInstituicao;
	}
}
