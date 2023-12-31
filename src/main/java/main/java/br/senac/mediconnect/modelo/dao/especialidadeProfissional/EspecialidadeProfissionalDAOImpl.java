package main.java.br.senac.mediconnect.modelo.dao.especialidadeProfissional;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import main.java.br.senac.mediconnect.modelo.entidade.especialidadeInstituicao.EspecialidadeInstituicao;
import main.java.br.senac.mediconnect.modelo.entidade.especialidadeInstituicao.EspecialidadeInstituicao_;
import main.java.br.senac.mediconnect.modelo.entidade.especialidadeProfissional.EspecialidadeProfissional;
import main.java.br.senac.mediconnect.modelo.entidade.especialidadeProfissional.EspecialidadeProfissional_;
import main.java.br.senac.mediconnect.modelo.entidade.usuario.Usuario;
import main.java.br.senac.mediconnect.modelo.factory.BuildFactory;

public class EspecialidadeProfissionalDAOImpl implements EspecialidadeProfissionalDAO {

	public BuildFactory fac;

	public EspecialidadeProfissionalDAOImpl() {
		fac = new BuildFactory();
	}

	@Override
	public void inserirEspecialidadeProfissionalDaInstituicao(EspecialidadeProfissional especialidadeProfissional) {

		Session sessao = null;

		try {

			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();

			sessao.save(especialidadeProfissional);
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
	public void deletarEspecialidadeProfissionalDaInstituicao(EspecialidadeProfissional especialidadeProfissional) {

		Session sessao = null;

		try {

			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();

			sessao.delete(especialidadeProfissional);
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
	public void atualizarEspecialidadeProfissionalDaInstituicao(EspecialidadeProfissional especialidadeProfissional) {

		Session sessao = null;

		try {

			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();
			sessao.update(especialidadeProfissional);
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
	public List<EspecialidadeProfissional> recuperarEspecialidadesProfissionalDaInstituicao(Integer idInstituicao) {
		Session sessao = null;
		List<EspecialidadeProfissional> especialidadesProfissionais = null;

		try {
			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<EspecialidadeProfissional> criteria = construtor.createQuery(EspecialidadeProfissional.class);
			Root<EspecialidadeProfissional> raizEspecialidadeProfissional = criteria
					.from(EspecialidadeProfissional.class);

			// Joining with EspecialidadeInstituicao
			Join<EspecialidadeProfissional, EspecialidadeInstituicao> joinEspecialidadeInstituicao = raizEspecialidadeProfissional
					.join(EspecialidadeProfissional_.ID);

			// Adding the condition to filter by Instituicao ID
			criteria.where(construtor.equal(joinEspecialidadeInstituicao.get(EspecialidadeInstituicao_.USUARIO), idInstituicao));

			criteria.select(raizEspecialidadeProfissional);

			especialidadesProfissionais = sessao.createQuery(criteria).getResultList();

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
		return especialidadesProfissionais;
	}

	public EspecialidadeProfissional recuperarEspecialidadeDaInstituicaoPorId(Integer idEspecialidade) {

		Session sessao = null;
		EspecialidadeProfissional especialidadeProfissionai = null;

		try {

			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<EspecialidadeProfissional> criteria = construtor.createQuery(EspecialidadeProfissional.class);
			Root<EspecialidadeProfissional> raizEspecialidadeProfissional = criteria
					.from(EspecialidadeProfissional.class);

			criteria.select(raizEspecialidadeProfissional);

			criteria.where(construtor.equal(raizEspecialidadeProfissional.get(EspecialidadeProfissional_.ID),
					idEspecialidade));

			especialidadeProfissionai = sessao.createQuery(criteria).getSingleResult();

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
		return especialidadeProfissionai;
	}

	public List<EspecialidadeProfissional> recuperarEspecialidadesProfissionais() {

		Session sessao = null;
		List<EspecialidadeProfissional> especialidadesProfissionais = null;

		try {

			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<EspecialidadeProfissional> criteria = construtor.createQuery(EspecialidadeProfissional.class);
			Root<EspecialidadeProfissional> raizEspecialidadeProfissional = criteria
					.from(EspecialidadeProfissional.class);

			raizEspecialidadeProfissional.fetch(EspecialidadeProfissional_.profissionalDeSaude, JoinType.LEFT);

			criteria.distinct(true);

			especialidadesProfissionais = sessao.createQuery(criteria).getResultList();

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

		return especialidadesProfissionais;
	}

}
