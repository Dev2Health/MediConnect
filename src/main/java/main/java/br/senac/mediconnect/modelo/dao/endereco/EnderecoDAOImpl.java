package main.java.br.senac.mediconnect.modelo.dao.endereco;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import main.java.br.senac.mediconnect.modelo.entidade.endereco.Endereco;
import main.java.br.senac.mediconnect.modelo.entidade.endereco.Endereco_;
import main.java.br.senac.mediconnect.modelo.entidade.instituicao.Instituicao;
import main.java.br.senac.mediconnect.modelo.factory.BuildFactory;

public class EnderecoDAOImpl implements EnderecoDAO {

	private BuildFactory fac;

	public EnderecoDAOImpl() {
		fac = new BuildFactory();
	}

	public void inserirEndereco(Endereco endereco) {

		Session sessao = null;

		try {

			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();

			sessao.save(endereco);

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
	public void deletarEndereco(Endereco endereco) {

		Session sessao = null;

		try {

			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();

			sessao.delete(endereco);
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
	public void atualizarEndereco(Endereco endereco) {

		Session sessao = null;

		try {

			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();

			sessao.update(endereco);
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
	public Endereco recuperarEnderecoPorInstituicao(Instituicao instituicao) {

		Session sessao = null;
		Endereco endereco = null;

		try {

			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Endereco> criteria = construtor.createQuery(Endereco.class);
			Root<Endereco> raizEndereco = criteria.from(Endereco.class);

			criteria.select(raizEndereco);

			criteria.where(construtor.equal(raizEndereco.get(Endereco_.INSTITUICAO), instituicao));

			endereco = sessao.createQuery(criteria).getSingleResult();

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

		return endereco;

	}
	
public Endereco recuperarEnderecoPorInstituicao(Integer idInstituicao) {
		
		Session sessao = null;
		Endereco endereco = null;

		try {

			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Endereco> criteria = construtor.createQuery(Endereco.class);
			Root<Endereco> raizEndereco = criteria.from(Endereco.class);

			criteria.select(raizEndereco);
			
			criteria.where(construtor.equal(raizEndereco.get(Endereco_.INSTITUICAO), idInstituicao));

			endereco = sessao.createQuery(criteria).getSingleResult();

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

		return endereco;

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
		return enderecos;
	}

}
