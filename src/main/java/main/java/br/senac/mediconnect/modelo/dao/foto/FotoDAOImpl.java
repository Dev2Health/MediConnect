package main.java.br.senac.mediconnect.modelo.dao.foto;

import org.hibernate.Session;

import main.java.br.senac.mediconnect.modelo.entidade.foto.Foto;
import main.java.br.senac.mediconnect.modelo.entidade.foto.Foto_;
import main.java.br.senac.mediconnect.modelo.factory.BuildFactory;

public class FotoDAOImpl implements FotoDAO {

	public BuildFactory fac;

	public FotoDAOImpl() {
		fac = new BuildFactory();
	}

	public void inserirFoto(Foto foto) {

		Session sessao = null;

		try {
			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();

			sessao.saveOrUpdate(foto);

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

	public void deletarFoto(Integer idFoto) {

		Session sessao = null;

		try {

			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();

			sessao.delete(Foto_.idFoto.equals(idFoto));

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

	public void atualizarFoto(Foto foto) {

		Session sessao = null;

		try {

			sessao = fac.ConectFac().openSession();
			sessao.beginTransaction();

			sessao.update(foto);

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

}