
package main.java.br.senac.mediconnect.modelo.dao.pessoa;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import main.java.br.senac.mediconnect.modelo.entidade.pessoa.Pessoa;
import main.java.br.senac.mediconnect.modelo.factory.BuildFactory;

public class PessoaDAOImpl implements PessoaDAO {
	public BuildFactory fac;
	public PessoaDAOImpl() {
		fac = new BuildFactory();
	}

	public void inserirPessoa(Pessoa Pessoa) {
		
		Session sessao = null;

		try {
			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();

			sessao.saveOrUpdate(Pessoa);

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

	public void deletarPessoa(Pessoa Pessoa) {
		
		Session sessao = null;

		try {

			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();

			sessao.delete(Pessoa);

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

	public void atualizarPessoa(Pessoa Pessoa) {
		
		Session sessao = null;

		try {

			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();

			sessao.update(Pessoa);

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

	public List<Pessoa> recuperarPessoa() {
		
		Session sessao = null;
		List<Pessoa> pessoas = null;

		try {

			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Pessoa> criteria = construtor.createQuery(Pessoa.class);
			Root<Pessoa> raizPessoa = criteria.from(Pessoa.class);

			criteria.select(raizPessoa);

			pessoas = sessao.createQuery(criteria).getResultList();

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

		return pessoas;
	}
}
