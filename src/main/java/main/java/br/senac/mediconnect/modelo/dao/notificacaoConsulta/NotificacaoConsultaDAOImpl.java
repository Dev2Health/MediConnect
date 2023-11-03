package main.java.br.senac.mediconnect.modelo.dao.notificacaoConsulta;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import main.java.br.senac.mediconnect.modelo.entidade.notificacaoConsulta.NotificacaoConsulta;
import main.java.br.senac.mediconnect.modelo.factory.BuildFactory;

public class NotificacaoConsultaDAOImpl implements NotificacaoConsultaDAO{
public BuildFactory fac;
	
	public NotificacaoConsultaDAOImpl() {
		fac = new BuildFactory();
	}

	@Override
	public void inserirNotificacaoConsulta(NotificacaoConsulta notificacao_consulta) {
		
		Session sessao = null;
		
		try {
			
			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();

			sessao.save(notificacao_consulta);
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
	public void deletarNotificacaoConsulta(NotificacaoConsulta notificacao_consulta) {
		
		Session sessao = null;
		
		try {
			
			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();

			sessao.delete(notificacao_consulta);
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
	public void atualizarNotificacaoConsulta(NotificacaoConsulta notificacao_consulta) {
		
		Session sessao = null;
		
		try {
			
			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();
			
			sessao.update(notificacao_consulta);
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
	public List<NotificacaoConsulta> recuperarNotificacaoConsulta() {
		
		Session sessao = null;
		List<NotificacaoConsulta> conquistas = null;
		
		try {
			
			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<NotificacaoConsulta> criteria = construtor.createQuery(NotificacaoConsulta.class);
			Root<NotificacaoConsulta> raizConquista = criteria.from(NotificacaoConsulta.class);
			criteria.select(raizConquista);
			conquistas = sessao.createQuery(criteria).getResultList();

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
		
		return conquistas;
	}
}
