package main.java.mediconnect.modelo.dao.endereco;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import main.java.mediconnect.modelo.entidade.endereco.Endereco;
import main.java.mediconnect.modelo.factory.BuildFactory;


public class EnderecoDAOImpl implements EnderecoDAO{
	public BuildFactory fac;
	public EnderecoDAOImpl() {
		fac = new BuildFactory();
	}
	@Override
	public void inserirEndereco(Endereco endereco) {
		Session sessao = null;
		
		try {
			
			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();

			sessao.save(endereco);
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
	public void deletarEndereco(Endereco endereco) {
		Session sessao = null;
		
		try {
			
			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();

			sessao.delete(endereco);
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
	public void atualizarEndereco(Endereco endereco) {
		Session sessao = null;
		
		try {
			
			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();
			
			sessao.update(endereco);
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
	public List<Endereco> recuperarListaDeEnderecos() {
		Session sessao = null;
		List<Endereco> enderecos = null;
		
		try {
			
			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Endereco> criteria = construtor.createQuery(Endereco.class);
			Root<Endereco> raizEndereco = criteria.from(Endereco.class);
			criteria.select(raizEndereco);
			enderecos = sessao.createQuery(criteria).getResultList();

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
		return enderecos;
	}
}
