package main.java.mediconnect.modelo.dao.notificacao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import main.java.mediconnect.modelo.entidade.consulta.Consulta;
import main.java.mediconnect.modelo.entidade.consulta.Consulta_;
import main.java.mediconnect.modelo.entidade.instituicao.Instituicao;
import main.java.mediconnect.modelo.entidade.instituicao.Instituicao_;
import main.java.mediconnect.modelo.entidade.notificacao.Notificacao;
import main.java.mediconnect.modelo.entidade.notificacao.Notificacao_;
import main.java.mediconnect.modelo.entidade.paciente.Paciente;
import main.java.mediconnect.modelo.entidade.paciente.Paciente_;
import main.java.mediconnect.modelo.factory.BuildFactory;

public class NotificacaoDAOImpl implements NotificacaoDAO {
	public BuildFactory fac;

	public NotificacaoDAOImpl() {
		fac = new BuildFactory();
	}

	public void inserirNotificacao(Notificacao notificacao) {

		Session sessao = null;

		try {
			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();

			sessao.saveOrUpdate(notificacao);

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

	public void deletarNotificacao(Notificacao notificacao) {

		Session sessao = null;

		try {

			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();

			sessao.delete(notificacao);

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

	public void atualizarNotificacao(Notificacao notificacao) {

		Session sessao = null;

		try {

			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();

			sessao.update(notificacao);

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

	public List<Notificacao> recuperarNotificacao() {

		Session sessao = null;
		List<Notificacao> notificacoes = null;

		try {

			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Notificacao> criteria = construtor.createQuery(Notificacao.class);
			Root<Notificacao> raizNotificacao = criteria.from(Notificacao.class);

			criteria.select(raizNotificacao);

			notificacoes = sessao.createQuery(criteria).getResultList();

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

		return notificacoes;
	}

	@Override
	public List<Notificacao> filtrarNotificacaoViaAtendentePorIdConsulta(Integer id, Instituicao instituicao) {

		Session sessao = null;
		List<Notificacao> notificacoes = null;

		try {

			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Notificacao> criteria = construtor.createQuery(Notificacao.class);
			Root<Notificacao> raizNotificacao = criteria.from(Notificacao.class);
			Root<Paciente> raizPaciente = criteria.from(Paciente.class);

			Join<Paciente, Consulta> consuJoin = raizPaciente.join(Paciente_.consultas);

			criteria.select(raizNotificacao);

			criteria.where(construtor.equal(consuJoin.get(Consulta_.ID), id),
					construtor.equal(consuJoin.get(Consulta_.instituicao).get(Instituicao_.ID), instituicao.getId()));

			notificacoes = sessao.createQuery(criteria).getResultList();

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

		return notificacoes;
	}

	public List<Notificacao> filtrarNotificacaoViaAtendentePorIdConsulta(Integer id, Integer idInstituicao) {

		Session sessao = null;
		List<Notificacao> notificacoes = null;

		try {

			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Notificacao> criteria = construtor.createQuery(Notificacao.class);
			Root<Notificacao> raizNotificacao = criteria.from(Notificacao.class);
			Root<Paciente> raizPaciente = criteria.from(Paciente.class);

			Join<Paciente, Consulta> consuJoin = raizPaciente.join(Paciente_.consultas);

			criteria.select(raizNotificacao);

			criteria.where(construtor.equal(consuJoin.get(Consulta_.ID), id),
					construtor.equal(consuJoin.get(Consulta_.instituicao).get(Instituicao_.ID), idInstituicao));

			notificacoes = sessao.createQuery(criteria).getResultList();

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

		return notificacoes;
	}

	@Override
	public List<Notificacao> filtrarNotificacaoViaAtendentePorCPFPaciente(String cpf, Instituicao instituicao) {

		Session sessao = null;
		List<Notificacao> notificacoes = null;

		try {

			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Notificacao> criteria = construtor.createQuery(Notificacao.class);
			Root<Notificacao> raizNotificacao = criteria.from(Notificacao.class);
			Root<Paciente> raizPaciente = criteria.from(Paciente.class);
			Root<Instituicao> raizInstituicao = criteria.from(Instituicao.class);

			criteria.select(raizNotificacao);

			criteria.where(construtor.equal(raizPaciente.get(Paciente_.CPF), cpf),
					construtor.equal(raizInstituicao.get(Instituicao_.ID), instituicao.getId()));

			notificacoes = sessao.createQuery(criteria).getResultList();

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

		return notificacoes;

	}

	public List<Notificacao> filtrarNotificacaoViaAtendentePorCPFPaciente(String cpf, Integer idInstituicao) {

		Session sessao = null;
		List<Notificacao> notificacoes = null;

		try {

			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Notificacao> criteria = construtor.createQuery(Notificacao.class);
			Root<Notificacao> raizNotificacao = criteria.from(Notificacao.class);
			Root<Paciente> raizPaciente = criteria.from(Paciente.class);
			Root<Instituicao> raizInstituicao = criteria.from(Instituicao.class);

			criteria.select(raizNotificacao);

			criteria.where(construtor.equal(raizPaciente.get(Paciente_.CPF), cpf),
					construtor.equal(raizInstituicao.get(Instituicao_.ID), idInstituicao));

			notificacoes = sessao.createQuery(criteria).getResultList();

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

		return notificacoes;

	}

	@Override
	public List<Notificacao> filtrarNotificacaoViaAtendentePorData(LocalDate dataInicial, LocalDate dataFinal,
			Instituicao instituicao) {

		Session sessao = null;
		List<Notificacao> notificacoes = null;

		try {

			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Notificacao> criteria = construtor.createQuery(Notificacao.class);
			Root<Notificacao> raizNotificacao = criteria.from(Notificacao.class);
			Root<Consulta> raizConsulta = criteria.from(Consulta.class);

			criteria.select(raizNotificacao);

			criteria.where(construtor.between(raizNotificacao.get(Notificacao_.DATA), dataInicial, dataFinal),
					construtor.equal(raizConsulta.get(Consulta_.instituicao).get(Instituicao_.ID),
							instituicao.getId()));

			notificacoes = sessao.createQuery(criteria).getResultList();

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

		return notificacoes;
	}

	public List<Notificacao> filtrarNotificacaoViaAtendentePorData(LocalDate dataInicial, LocalDate dataFinal,
			Integer idInstituicao) {

		Session sessao = null;
		List<Notificacao> notificacoes = null;

		try {

			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Notificacao> criteria = construtor.createQuery(Notificacao.class);
			Root<Notificacao> raizNotificacao = criteria.from(Notificacao.class);
			Root<Consulta> raizConsulta = criteria.from(Consulta.class);

			criteria.select(raizNotificacao);

			criteria.where(construtor.between(raizNotificacao.get(Notificacao_.DATA), dataInicial, dataFinal),
					construtor.equal(raizConsulta.get(Consulta_.instituicao).get(Instituicao_.ID), idInstituicao));

			notificacoes = sessao.createQuery(criteria).getResultList();

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

		return notificacoes;
	}

	@Override
	public List<Notificacao> filtrarNotificacaoViaInstituicaoPorData(LocalDate dataInicial, LocalDate dataFinal, Paciente paciente) {

		Session sessao = null;
		List<Notificacao> Atendentes = null;

		try {

			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Notificacao> criteria = construtor.createQuery(Notificacao.class);
			Root<Notificacao> raizNotificacao = criteria.from(Notificacao.class);

			criteria.select(raizNotificacao);
			criteria.where(construtor.between(raizNotificacao.get(Notificacao_.DATA), dataInicial, dataFinal),
					construtor.equal(raizNotificacao.get(Notificacao_.USUARIO).get(Paciente_.ID), paciente.getId()));
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

	public List<Notificacao> filtrarNotificacaoViaInstituicaoPorData(LocalDate dataInicial, LocalDate dataFinal, Integer idPaciente) {

		Session sessao = null;
		List<Notificacao> Atendentes = null;

		try {

			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Notificacao> criteria = construtor.createQuery(Notificacao.class);
			Root<Notificacao> raizNotificacao = criteria.from(Notificacao.class);

			criteria.select(raizNotificacao);
			criteria.where(construtor.between(raizNotificacao.get(Notificacao_.DATA), dataInicial, dataFinal),
					construtor.equal(raizNotificacao.get(Notificacao_.USUARIO).get(Paciente_.ID), idPaciente));
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

	public List<Notificacao> filtrarNotificacaoViaPacientePorInstituicao(Instituicao instituicao, Paciente paciente) {

		Session sessao = null;
		List<Notificacao> notificacoes = null;

		try {
			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Notificacao> criteria = construtor.createQuery(Notificacao.class);
			Root<Notificacao> raizNotificacao = criteria.from(Notificacao.class);
			Root<Instituicao> raizInstituicao = criteria.from(Instituicao.class);
			Root<Paciente> raizPaciente = criteria.from(Paciente.class);

			criteria.select(raizNotificacao);

			Expression<String> nomeExpression = raizInstituicao.get(Instituicao_.NOME_FANTASIA);

			criteria.where(construtor.like(nomeExpression, "%" + instituicao.getNomeFantasia() + "%"),
					construtor.equal(raizPaciente.get(Paciente_.ID), paciente.getId()));

			notificacoes = sessao.createQuery(criteria).getResultList();

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

		return notificacoes;
	}
	
	public List<Notificacao> filtrarNotificacaoViaPacientePorInstituicao(Instituicao instituicao, Integer idPaciente) {

		Session sessao = null;
		List<Notificacao> notificacoes = null;

		try {
			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Notificacao> criteria = construtor.createQuery(Notificacao.class);
			Root<Notificacao> raizNotificacao = criteria.from(Notificacao.class);
			Root<Instituicao> raizInstituicao = criteria.from(Instituicao.class);
			Root<Paciente> raizPaciente = criteria.from(Paciente.class);

			criteria.select(raizNotificacao);

			Expression<String> nomeExpression = raizInstituicao.get(Instituicao_.NOME_FANTASIA);

			criteria.where(construtor.like(nomeExpression, "%" + instituicao.getNomeFantasia() + "%"),
					construtor.equal(raizPaciente.get(Paciente_.ID), idPaciente));

			notificacoes = sessao.createQuery(criteria).getResultList();

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

		return notificacoes;
	}

	public List<Notificacao> filtrarNotificacaoViaPacientePorIdConsulta(Consulta consulta, Paciente paciente) {

		Session sessao = null;
		List<Notificacao> notificacoes = null;

		try {
			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Notificacao> criteria = construtor.createQuery(Notificacao.class);
			Root<Notificacao> raizNotificacao = criteria.from(Notificacao.class);
			Root<Paciente> raizPaciente = criteria.from(Paciente.class);
			Join<Paciente, Consulta> consultaJoin = raizPaciente.join(Paciente_.consultas);

			criteria.select(raizNotificacao);

			criteria.where(construtor.equal(consultaJoin.get(Consulta_.ID), consulta.getId()),
					construtor.equal(consultaJoin.get(Consulta_.paciente).get(Paciente_.ID), paciente.getId()));

			notificacoes = sessao.createQuery(criteria).getResultList();

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

		return notificacoes;
	}
	
	public List<Notificacao> filtrarNotificacaoViaPacientePorIdConsulta(Integer idConsulta, Integer idPaciente) {

		Session sessao = null;
		List<Notificacao> notificacoes = null;

		try {
			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Notificacao> criteria = construtor.createQuery(Notificacao.class);
			Root<Notificacao> raizNotificacao = criteria.from(Notificacao.class);
			Root<Paciente> raizPaciente = criteria.from(Paciente.class);
			Join<Paciente, Consulta> consultaJoin = raizPaciente.join(Paciente_.consultas);

			criteria.select(raizNotificacao);

			criteria.where(construtor.equal(consultaJoin.get(Consulta_.ID), idConsulta),
					construtor.equal(consultaJoin.get(Consulta_.paciente).get(Paciente_.ID), idPaciente));

			notificacoes = sessao.createQuery(criteria).getResultList();

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

		return notificacoes;
	}

	public List<Notificacao> filtrarNotificacaoViaPacientePorData(LocalDate dataInicial, LocalDate dataFinal,
			Paciente paciente) {

		Session sessao = null;
		List<Notificacao> notificacoes = null;

		try {
			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Notificacao> criteria = construtor.createQuery(Notificacao.class);
			Root<Notificacao> raizNotificacao = criteria.from(Notificacao.class);

			criteria.select(raizNotificacao);

			criteria.where(construtor.between(raizNotificacao.get(Notificacao_.DATA), dataInicial, dataFinal),
					construtor.equal(raizNotificacao.get(Notificacao_.USUARIO).get(Paciente_.ID), paciente.getId()));

			notificacoes = sessao.createQuery(criteria).getResultList();

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

		return notificacoes;
	}
	
	public List<Notificacao> filtrarNotificacaoViaPacientePorData(LocalDate dataInicial, LocalDate dataFinal,
			Integer idPaciente) {

		Session sessao = null;
		List<Notificacao> notificacoes = null;

		try {
			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Notificacao> criteria = construtor.createQuery(Notificacao.class);
			Root<Notificacao> raizNotificacao = criteria.from(Notificacao.class);

			criteria.select(raizNotificacao);

			criteria.where(construtor.between(raizNotificacao.get(Notificacao_.DATA), dataInicial, dataFinal),
					construtor.equal(raizNotificacao.get(Notificacao_.USUARIO).get(Paciente_.ID), idPaciente));

			notificacoes = sessao.createQuery(criteria).getResultList();

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

		return notificacoes;
	}

}
