package main.java.mediconnect.modelo.dao.consulta;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import main.java.mediconnect.modelo.entidade.consulta.Consulta;
import main.java.mediconnect.modelo.entidade.consulta.Consulta_;
import main.java.mediconnect.modelo.entidade.especialidadeProfissional.EspecialidadeProfissional;
import main.java.mediconnect.modelo.entidade.especialidadeProfissional.EspecialidadeProfissional_;
import main.java.mediconnect.modelo.entidade.instituicao.Instituicao;
import main.java.mediconnect.modelo.entidade.instituicao.Instituicao_;
import main.java.mediconnect.modelo.entidade.paciente.Paciente;
import main.java.mediconnect.modelo.entidade.paciente.Paciente_;
import main.java.mediconnect.modelo.entidade.profissionalDeSaude.ProfissionalDeSaude;
import main.java.mediconnect.modelo.entidade.profissionalDeSaude.ProfissionalDeSaude_;
import main.java.mediconnect.modelo.enumeracao.consulta.StatusConsulta;
import main.java.mediconnect.modelo.factory.BuildFactory;

public class ConsultaDAOImpl implements ConsultaDAO {
	public BuildFactory fac;

	public ConsultaDAOImpl() {
		fac = new BuildFactory();
	}

	@Override
	public void inserirConsulta(Consulta consulta) {
		Session sessao = null;

		try {

			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();

			sessao.save(consulta);
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
	public void deletarConsulta(Consulta consulta) {
		Session sessao = null;

		try {

			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();

			sessao.delete(consulta);
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
	public void atualizarConsulta(Consulta consulta) {
		Session sessao = null;

		try {

			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();

			sessao.update(consulta);
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
	public List<Consulta> recuperarListaDeConsultas() {
		Session sessao = null;
		List<Consulta> consultas = null;

		try {

			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Consulta> criteria = construtor.createQuery(Consulta.class);
			Root<Consulta> raizAtendente = criteria.from(Consulta.class);
			criteria.select(raizAtendente);
			consultas = sessao.createQuery(criteria).getResultList();

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
		return consultas;
	}

	public List<Consulta> filtrarConsultaViaInstituicaoPorPaciente(Paciente paciente, Instituicao instituicao) {
		Session sessao = null;
		List<Consulta> consultas = null;

		try {

			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Consulta> criteria = construtor.createQuery(Consulta.class);
			Root<Consulta> raizConsulta = criteria.from(Consulta.class);

			Join<Consulta, Paciente> pacienteJoin = raizConsulta.join(Consulta_.paciente);

			criteria.select(raizConsulta);

			Expression<String> nomeExpression = construtor.concat(pacienteJoin.get(Paciente_.NOME), " ");
			nomeExpression = construtor.concat(nomeExpression, (pacienteJoin.get(Paciente_.SOBRENOME)));

			criteria.where(
					construtor.like(nomeExpression, "%" + paciente.getNome() + " " + paciente.getSobrenome() + "%"),
					construtor.equal(raizConsulta.get(Consulta_.instituicao).get(Instituicao_.ID),
							instituicao.getId()));

			consultas = sessao.createQuery(criteria).getResultList();

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

		return consultas;

	}

	public List<Consulta> filtrarConsultaViaInstituicaoPorProfissionalDeSaude(ProfissionalDeSaude profissionalDeSaude,
			Instituicao instituicao) {
		Session sessao = null;
		List<Consulta> consultas = null;

		try {

			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Consulta> criteria = construtor.createQuery(Consulta.class);
			Root<Consulta> raizConsulta = criteria.from(Consulta.class);

			Join<Consulta, ProfissionalDeSaude> profissionalJoin = raizConsulta.join(Consulta_.profissional_de_saude);

			criteria.select(raizConsulta);

			ParameterExpression<Integer> idProfissional = construtor.parameter(Integer.class);
			criteria.where(construtor.equal(profissionalJoin.get(ProfissionalDeSaude_.ID), idProfissional), construtor
					.equal(raizConsulta.get(Consulta_.instituicao).get(Instituicao_.ID), instituicao.getId()));

			consultas = sessao.createQuery(criteria).setParameter(idProfissional, profissionalDeSaude.getId())
					.getResultList();

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

		return consultas;

	}

	public List<Consulta> filtrarConsultaViaInstituicaoPorEspecialidadeProfissional(
			EspecialidadeProfissional especialidade, Instituicao instituicao) {
		Session sessao = null;
		List<Consulta> consultas = null;

		try {

			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Consulta> criteria = construtor.createQuery(Consulta.class);
			Root<Consulta> raizConsulta = criteria.from(Consulta.class);

			Join<Consulta, EspecialidadeProfissional> especialidadeJoin = raizConsulta
					.join(Consulta_.especialidade_profissional);

			criteria.select(raizConsulta);

			ParameterExpression<Integer> idEspecialidade = construtor.parameter(Integer.class);
			criteria.where(construtor.equal(especialidadeJoin.get(ProfissionalDeSaude_.ID), idEspecialidade), construtor
					.equal(raizConsulta.get(Consulta_.instituicao).get(Instituicao_.ID), instituicao.getId()));

			consultas = sessao.createQuery(criteria).setParameter(idEspecialidade, especialidade.getId())
					.getResultList();

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

		return consultas;

	}

	public List<Consulta> filtrarConsultaViaInstituicaoPorStatus(StatusConsulta status, Instituicao instituicao) {
		Session sessao = null;
		List<Consulta> consultas = null;

		try {

			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Consulta> criteria = construtor.createQuery(Consulta.class);
			Root<Consulta> raizConsulta = criteria.from(Consulta.class);

			criteria.select(raizConsulta);

			criteria.where(construtor.equal(raizConsulta.get(Consulta_.STATUS), status), construtor
					.equal(raizConsulta.get(Consulta_.instituicao).get(Instituicao_.ID), instituicao.getId()));

			consultas = sessao.createQuery(criteria).getResultList();

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

		return consultas;

	}

	@Override
	public List<Consulta> filtrarConsultaViaInstituicaoPorData(LocalDate dataInicial, LocalDate dataFinal,
			Instituicao instituicao) {
		Session sessao = null;
		List<Consulta> consultas = null;

		try {

			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Consulta> criteria = construtor.createQuery(Consulta.class);
			Root<Consulta> raizConsulta = criteria.from(Consulta.class);

			criteria.select(raizConsulta);

			criteria.where(construtor.between(raizConsulta.get(Consulta_.DATA), dataInicial, dataFinal), construtor
					.equal(raizConsulta.get(Consulta_.instituicao).get(Instituicao_.ID), instituicao.getId()));

			consultas = sessao.createQuery(criteria).getResultList();

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

		return consultas;
	}

	public Consulta filtrarConsultasViaAtendentePorTitulo(Integer id, Instituicao instituicao) {

		Session sessao = null;
		Consulta consultas = null;

		try {

			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Consulta> criteria = construtor.createQuery(Consulta.class);
			Root<Consulta> raizConsulta = criteria.from(Consulta.class);

			criteria.select(raizConsulta);

			criteria.where(construtor.equal(raizConsulta.get(Consulta_.ID), id),
					construtor.equal(raizConsulta.get(Consulta_.instituicao), instituicao));

			consultas = sessao.createQuery(criteria).getSingleResult();

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

		return consultas;

	}

	public List<Consulta> filtrarConsultaViaPacientePorProfissionalDeSaude(ProfissionalDeSaude profissionalDeSaude,
			Paciente paciente) {

		Session sessao = null;
		List<Consulta> consultas = null;

		try {
			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Consulta> criteria = construtor.createQuery(Consulta.class);
			Root<Consulta> raizConsulta = criteria.from(Consulta.class);

			Join<Consulta, ProfissionalDeSaude> profissionalJoin = raizConsulta.join(Consulta_.profissional_de_saude);

			criteria.select(raizConsulta);

			ParameterExpression<Integer> idProfissional = construtor.parameter(Integer.class);
			ParameterExpression<Integer> idPaciente = construtor.parameter(Integer.class);

			criteria.where(construtor.equal(profissionalJoin.get(ProfissionalDeSaude_.ID), idProfissional),
					construtor.equal(raizConsulta.get(Consulta_.paciente).get(Paciente_.ID), idPaciente));

			consultas = sessao.createQuery(criteria).setParameter(idProfissional, profissionalDeSaude.getId())
					.setParameter(idPaciente, paciente.getId()).getResultList();

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

		return consultas;
	}

	public List<Consulta> filtrarConsultaViaPacientePorEspecialidade(
			EspecialidadeProfissional especialidadeProfissional, Paciente paciente) {

		Session sessao = null;
		List<Consulta> consultas = null;

		try {
			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Consulta> criteria = construtor.createQuery(Consulta.class);
			Root<Consulta> raizConsulta = criteria.from(Consulta.class);

			Join<Consulta, EspecialidadeProfissional> especialidadeJoin = raizConsulta
					.join(Consulta_.especialidade_profissional);

			criteria.select(raizConsulta);

			criteria.where(
					construtor.equal(especialidadeJoin.get(EspecialidadeProfissional_.ID),
							especialidadeProfissional.getId()),
					construtor.equal(raizConsulta.get(Consulta_.paciente).get(Paciente_.ID), paciente.getId()));

			consultas = sessao.createQuery(criteria).getResultList();

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

		return consultas;
	}

	public List<Consulta> filtrarConsultaViaPacientePorInstituicao(Instituicao instituicao, Paciente paciente) {

		Session sessao = null;
		List<Consulta> consultas = null;

		try {
			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Consulta> criteria = construtor.createQuery(Consulta.class);
			Root<Consulta> raizConsulta = criteria.from(Consulta.class);

			criteria.select(raizConsulta);

			criteria.where(
					construtor.equal(raizConsulta.get(Consulta_.instituicao).get(Instituicao_.ID), instituicao.getId()),
					construtor.equal(raizConsulta.get(Consulta_.paciente).get(Paciente_.ID), paciente.getId()));

			consultas = sessao.createQuery(criteria).getResultList();

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

		return consultas;
	}

	public List<Consulta> filtrarConsultaViaPacientePorData(LocalDate dataInicial, LocalDate dataFinal,
			Paciente paciente) {

		Session sessao = null;
		List<Consulta> consultas = null;

		try {
			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Consulta> criteria = construtor.createQuery(Consulta.class);
			Root<Consulta> raizConsulta = criteria.from(Consulta.class);

			criteria.select(raizConsulta);

			criteria.where(construtor.between(raizConsulta.get(Consulta_.DATA), dataInicial, dataFinal),
					construtor.equal(raizConsulta.get(Consulta_.paciente).get(Paciente_.ID), paciente.getId()));

			consultas = sessao.createQuery(criteria).getResultList();

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

		return consultas;
	}

	public List<Consulta> filtrarConsultaViaPacientePorStatus(StatusConsulta status, Paciente paciente) {

		Session sessao = null;
		List<Consulta> consultas = null;

		try {
			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Consulta> criteria = construtor.createQuery(Consulta.class);
			Root<Consulta> raizConsulta = criteria.from(Consulta.class);

			criteria.select(raizConsulta);

			criteria.where(construtor.equal(raizConsulta.get(Consulta_.STATUS), status),
					construtor.equal(raizConsulta.get(Consulta_.paciente).get(Paciente_.ID), paciente.getId()));

			consultas = sessao.createQuery(criteria).getResultList();

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

		return consultas;
	}

	public List<Consulta> filtrarConsultasViaPacientePorId(Integer id) {

		Session sessao = null;
		List<Consulta> consultas = null;

		try {
			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Consulta> criteria = construtor.createQuery(Consulta.class);
			Root<Consulta> raizConsulta = criteria.from(Consulta.class);

			criteria.select(raizConsulta);

			criteria.where(construtor.equal(raizConsulta.get(Consulta_.paciente).get(Paciente_.ID), id));

			consultas = sessao.createQuery(criteria).getResultList();

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

		return consultas;
	}
}
