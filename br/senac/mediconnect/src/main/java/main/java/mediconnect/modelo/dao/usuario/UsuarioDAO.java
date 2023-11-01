package main.java.mediconnect.modelo.dao.usuario;

import java.util.List;

import main.java.mediconnect.modelo.entidade.usuario.Usuario;

public interface UsuarioDAO {
	void inserirSelo(Usuario usuario);
	void deletarSelo(Usuario usuario);
	void atualizarSelo(Usuario usuario);
	List<Usuario> recupearUsuarios();
	boolean verificarUsuario(String email, String senha);
	Usuario recuperarUsuarioPorEmail(String email);
}