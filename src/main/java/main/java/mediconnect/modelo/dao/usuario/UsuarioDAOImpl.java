package main.java.mediconnect.modelo.dao.usuario;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import main.java.mediconnect.modelo.entidade.instituicao.Instituicao;
import main.java.mediconnect.modelo.entidade.notificacao.Notificacao;
import main.java.mediconnect.modelo.entidade.usuario.Usuario;
import main.java.mediconnect.modelo.factory.BuildFactory;

public class UsuarioDAOImpl implements UsuarioDAO {
	public BuildFactory fac;
	
	public UsuarioDAOImpl() {
		fac = new BuildFactory();
	}

	public void inserirSelo(Usuario usuario) {
	
		Session sessao = null;
		
		try {
			
			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();
			
			sessao.saveOrUpdate(usuario);
			
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

	public void deletarSelo(Usuario usuario) {

		Session sessao = null;
		
		try {
			
			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();
			
			sessao.delete(usuario);
			
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

	public void atualizarSelo(Usuario usuario) {

		Session sessao = null;
		
		try {
			
			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();
			
			sessao.update(usuario);
			
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

	public List<Usuario> recupearUsuarios() {
		Session sessao = null;
		List<Usuario> usuarios = null;
		
		try {
			
			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();
			
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			
			CriteriaQuery<Usuario> criteria = construtor.createQuery(Usuario.class);
			Root<Usuario> raizUsuario = criteria.from(Usuario.class);
			
			criteria.select(raizUsuario);
			
			usuarios = sessao.createQuery(criteria).getResultList();
			
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
		
		return usuarios;
	}
}
