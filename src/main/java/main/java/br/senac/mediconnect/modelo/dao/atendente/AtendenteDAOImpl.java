package main.java.br.senac.mediconnect.modelo.dao.atendente;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import main.java.br.senac.mediconnect.modelo.entidade.atendente.Atendente;
import main.java.br.senac.mediconnect.modelo.entidade.atendente.Atendente_;
import main.java.br.senac.mediconnect.modelo.entidade.instituicao.Instituicao;
import main.java.br.senac.mediconnect.modelo.entidade.instituicao.Instituicao_;
import main.java.br.senac.mediconnect.modelo.factory.BuildFactory;

public class AtendenteDAOImpl implements AtendenteDAO {

	public BuildFactory fac;

	public AtendenteDAOImpl() {
		fac = new BuildFactory();
	}

	@Override
	public void inserirAtendente(Atendente atendente) {

		Session sessao = null;

		try {

			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();

			sessao.save(atendente);
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
	public void deletarAtendente(Atendente atendente) {

		Session sessao = null;

		try {

			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();

			sessao.delete(atendente);
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
	public void atualizarAtendente(Atendente atendente) {

		Session sessao = null;

		try {

			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();
			sessao.update(atendente);
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
	public Atendente recuperarAtendentePorId(Integer id) {

		Session sessao = null;
		Atendente atendente = null;

		try {

			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Atendente> criteria = construtor.createQuery(Atendente.class);
			Root<Atendente> raizAtendente = criteria.from(Atendente.class);

			criteria.select(raizAtendente);

			criteria.where(construtor.equal(raizAtendente.get(Atendente_.ID), id));

			atendente = sessao.createQuery(criteria).getSingleResult();

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

		return atendente;

	}

	@Override
	public List<Atendente> recuperarListaDeAtendentes() {

		Session sessao = null;
		List<Atendente> atendentes = null;

		try {

			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Atendente> criteria = construtor.createQuery(Atendente.class);
			Root<Atendente> raizAtendente = criteria.from(Atendente.class);

			criteria.select(raizAtendente);

			atendentes = sessao.createQuery(criteria).getResultList();

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
		return atendentes;
	}
	
	public List<Atendente> recuperarListaDeAtendentesViaInstituicao(Integer idInstituicao) {

		Session sessao = null;
		List<Atendente> atendentes = null;

		try {

			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
            CriteriaQuery<Atendente> criteria = construtor.createQuery(Atendente.class);
            Root<Atendente> raizAtendente = criteria.from(Atendente.class);

            criteria.select(raizAtendente);
            criteria.where(construtor.equal(raizAtendente.get("instituicao").get("id"), idInstituicao));

			atendentes = sessao.createQuery(criteria).getResultList();

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
		return atendentes;
	}

	@Override
	public Atendente filtrarAtendenteViaInstituicaoPorId(Integer id) {

		Session sessao = null;
		Atendente Atendentes = null;

		try {

			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Atendente> criteria = construtor.createQuery(Atendente.class);
			Root<Atendente> raizAtendente = criteria.from(Atendente.class);

			criteria.select(raizAtendente);

			criteria.where(construtor.equal(raizAtendente.get(Atendente_.ID), id));

			Atendentes = sessao.createQuery(criteria).getSingleResult();

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

		return Atendentes;

	}

	public List<Atendente> filtrarAtendentesViaInstituicaoPorNomeCompleto(String nomeCompleto, Instituicao instituicao) {

		Session sessao = null;
		List<Atendente> Atendentes = null;

		try {

			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Atendente> criteria = construtor.createQuery(Atendente.class);
			Root<Atendente> raizAtendente = criteria.from(Atendente.class);

			criteria.select(raizAtendente);
			
			Expression<String> nomeCompletoExpression = construtor.concat(raizAtendente.get(Atendente_.NOME),
					" " + raizAtendente.get(Atendente_.SOBRENOME));
			criteria.where(construtor.like(nomeCompletoExpression, "%" + nomeCompleto + "%"),
					construtor.equal(raizAtendente.get(Atendente_.instituicao).get(Instituicao_.ID), instituicao.getId()));
			Atendentes = sessao.createQuery(criteria).getResultList();

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

		return Atendentes;

	}

	public List<Atendente> filtrarAtendentesViaInstituicaoPorNomeCompleto(String nomeCompleto, Integer idInstituicao) {

		Session sessao = null;
		List<Atendente> Atendentes = null;

		try {

			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Atendente> criteria = construtor.createQuery(Atendente.class);
			Root<Atendente> raizAtendente = criteria.from(Atendente.class);

			criteria.select(raizAtendente);
			
			Expression<String> nomeCompletoExpression = construtor.concat(raizAtendente.get(Atendente_.NOME),
					" " + raizAtendente.get(Atendente_.SOBRENOME));
			criteria.where(construtor.like(nomeCompletoExpression, "%" + nomeCompleto + "%"),
					construtor.equal(raizAtendente.get(Atendente_.instituicao).get(Instituicao_.ID), idInstituicao));
			Atendentes = sessao.createQuery(criteria).getResultList();

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

		return Atendentes;

	}

	@Override
	public List<Atendente> filtrarAtendentesViaInstituicaoPorCpf(String cpf, Instituicao instituicao) {

		Session sessao = null;
		List<Atendente> Atendentes = null;

		try {

			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Atendente> criteria = construtor.createQuery(Atendente.class);
			Root<Atendente> raizAtendente = criteria.from(Atendente.class);

			criteria.select(raizAtendente);
			
			Expression<String> cpfExpression = raizAtendente.get(Atendente_.CPF);
			criteria.where(construtor.equal(cpfExpression, cpf),
					construtor.equal(raizAtendente.get(Atendente_.instituicao).get(Instituicao_.ID), instituicao.getId()));
			Atendentes = sessao.createQuery(criteria).getResultList();

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

		return Atendentes;

	}

	public List<Atendente> filtrarAtendentesViaInstituicaoPorCpf(String cpf, Integer idInstituicao) {

		Session sessao = null;
		List<Atendente> Atendentes = null;

		try {

			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Atendente> criteria = construtor.createQuery(Atendente.class);
			Root<Atendente> raizAtendente = criteria.from(Atendente.class);

			criteria.select(raizAtendente);
			
			Expression<String> cpfExpression = raizAtendente.get(Atendente_.CPF);
			criteria.where(construtor.equal(cpfExpression, cpf),
					construtor.equal(raizAtendente.get(Atendente_.instituicao).get(Instituicao_.ID), idInstituicao));
			Atendentes = sessao.createQuery(criteria).getResultList();

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

		return Atendentes;

	}

	@Override
	public List<Atendente> filtrarAtendentesViaInstituicaoPorCtps(String ctps, Instituicao instituicao) {

		Session sessao = null;
		List<Atendente> Atendentes = null;

		try {

			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Atendente> criteria = construtor.createQuery(Atendente.class);
			Root<Atendente> raizAtendente = criteria.from(Atendente.class);

			criteria.select(raizAtendente);
			
			Expression<String> ctpsExpression = raizAtendente.get(Atendente_.CTPS);
			criteria.where(construtor.equal(ctpsExpression, ctps),
					construtor.equal(raizAtendente.get(Atendente_.instituicao).get(Instituicao_.ID), instituicao.getId()));
			Atendentes = sessao.createQuery(criteria).getResultList();

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

		return Atendentes;
	}

	public List<Atendente> filtrarAtendentesViaInstituicaoPorCtps(String ctps, Integer idInstituicao) {

		Session sessao = null;
		List<Atendente> Atendentes = null;

		try {

			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Atendente> criteria = construtor.createQuery(Atendente.class);
			Root<Atendente> raizAtendente = criteria.from(Atendente.class);

			criteria.select(raizAtendente);
			
			Expression<String> ctpsExpression = raizAtendente.get(Atendente_.CTPS);
			criteria.where(construtor.equal(ctpsExpression, ctps),
					construtor.equal(raizAtendente.get(Atendente_.instituicao).get(Instituicao_.ID), idInstituicao));
			Atendentes = sessao.createQuery(criteria).getResultList();

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

		return Atendentes;
	}

	@Override
	public List<Atendente> filtrarAtendentesViaInstituicaoPorDataCadastro(LocalDate dataCadastro,
			Instituicao instituicao) {

		Session sessao = null;
		List<Atendente> Atendentes = null;

		try {

			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Atendente> criteria = construtor.createQuery(Atendente.class);
			Root<Atendente> raizAtendente = criteria.from(Atendente.class);

			criteria.select(raizAtendente);
			
			Expression<String> dataCadastroExpression = raizAtendente.get(Atendente_.DATA_CADASTRO);
			criteria.where(construtor.equal(dataCadastroExpression, dataCadastro),
					construtor.equal(raizAtendente.get(Atendente_.instituicao).get(Instituicao_.ID), instituicao.getId()));
			Atendentes = sessao.createQuery(criteria).getResultList();

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

		return Atendentes;
	}

	public List<Atendente> filtrarAtendentesViaInstituicaoPorDataCadastro(LocalDate dataCadastro,
			Integer idInstituicao) {

		Session sessao = null;
		List<Atendente> Atendentes = null;

		try {

			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Atendente> criteria = construtor.createQuery(Atendente.class);
			Root<Atendente> raizAtendente = criteria.from(Atendente.class);

			criteria.select(raizAtendente);
			
			Expression<String> dataCadastroExpression = raizAtendente.get(Atendente_.DATA_CADASTRO);
			criteria.where(construtor.equal(dataCadastroExpression, dataCadastro),
					construtor.equal(raizAtendente.get(Atendente_.instituicao).get(Instituicao_.ID), idInstituicao));
			Atendentes = sessao.createQuery(criteria).getResultList();

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

		return Atendentes;
	}

	@Override
	public List<Atendente> filtrarAtendentesViaInstituicaoPorCadastro(Integer cadastro, Instituicao instituicao) {

		Session sessao = null;
		List<Atendente> Atendentes = null;

		try {

			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Atendente> criteria = construtor.createQuery(Atendente.class);
			Root<Atendente> raizAtendente = criteria.from(Atendente.class);
			Root<Instituicao> raizInstituicao = criteria.from(Instituicao.class);

			criteria.select(raizAtendente);
			Expression<String> cadastroExpression = raizAtendente.get(Atendente_.ID);
			criteria.where(construtor.equal(cadastroExpression, cadastro),
					construtor.equal(raizInstituicao.get(Instituicao_.ID), instituicao.getId()));
			Atendentes = sessao.createQuery(criteria).getResultList();

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

		return Atendentes;
	}

	public List<Atendente> filtrarAtendentesViaInstituicaoPorCadastro(Integer cadastro, Integer idInstituicao) {

		Session sessao = null;
		List<Atendente> Atendentes = null;

		try {

			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Atendente> criteria = construtor.createQuery(Atendente.class);
			Root<Atendente> raizAtendente = criteria.from(Atendente.class);
			Root<Instituicao> raizInstituicao = criteria.from(Instituicao.class);

			criteria.select(raizAtendente);
			Expression<String> cadastroExpression = raizAtendente.get(Atendente_.ID);
			criteria.where(construtor.equal(cadastroExpression, cadastro),
					construtor.equal(raizInstituicao.get(Instituicao_.ID), idInstituicao));
			Atendentes = sessao.createQuery(criteria).getResultList();

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

		return Atendentes;
	}

}