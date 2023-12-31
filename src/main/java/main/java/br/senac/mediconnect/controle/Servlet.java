package main.java.br.senac.mediconnect.controle;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.TimeZone;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import main.java.br.senac.mediconnect.controle.util.ConversorImagem;
import main.java.br.senac.mediconnect.modelo.dao.atendente.AtendenteDAO;
import main.java.br.senac.mediconnect.modelo.dao.atendente.AtendenteDAOImpl;
import main.java.br.senac.mediconnect.modelo.dao.conquista.ConquistaDAO;
import main.java.br.senac.mediconnect.modelo.dao.conquista.ConquistaDAOImpl;
import main.java.br.senac.mediconnect.modelo.dao.consulta.ConsultaDAO;
import main.java.br.senac.mediconnect.modelo.dao.consulta.ConsultaDAOImpl;
import main.java.br.senac.mediconnect.modelo.dao.endereco.EnderecoDAO;
import main.java.br.senac.mediconnect.modelo.dao.endereco.EnderecoDAOImpl;
import main.java.br.senac.mediconnect.modelo.dao.especialidadeInstituicao.EspecialidadeInstituicaoDAO;
import main.java.br.senac.mediconnect.modelo.dao.especialidadeInstituicao.EspecialidadeInstituicaoDAOImpl;
import main.java.br.senac.mediconnect.modelo.dao.especialidadeProfissional.EspecialidadeProfissionalDAO;
import main.java.br.senac.mediconnect.modelo.dao.especialidadeProfissional.EspecialidadeProfissionalDAOImpl;
import main.java.br.senac.mediconnect.modelo.dao.instituicao.InstituicaoDAO;
import main.java.br.senac.mediconnect.modelo.dao.instituicao.InstituicaoDAOImpl;
import main.java.br.senac.mediconnect.modelo.dao.notificacao.NotificacaoDAO;
import main.java.br.senac.mediconnect.modelo.dao.notificacao.NotificacaoDAOImpl;
import main.java.br.senac.mediconnect.modelo.dao.paciente.PacienteDAO;
import main.java.br.senac.mediconnect.modelo.dao.paciente.PacienteDAOImpl;
import main.java.br.senac.mediconnect.modelo.dao.pacienteConquista.PacienteConquistaDAO;
import main.java.br.senac.mediconnect.modelo.dao.pacienteConquista.PacienteConquistaDAOImpl;
import main.java.br.senac.mediconnect.modelo.dao.pacienteSelo.PacienteSeloDAO;
import main.java.br.senac.mediconnect.modelo.dao.pacienteSelo.PacienteSeloDAOImpl;
import main.java.br.senac.mediconnect.modelo.dao.profissionalDeSaude.ProfissionalDeSaudeDAO;
import main.java.br.senac.mediconnect.modelo.dao.profissionalDeSaude.ProfissionalDeSaudeDAOImpl;
import main.java.br.senac.mediconnect.modelo.dao.usuario.UsuarioDAO;
import main.java.br.senac.mediconnect.modelo.dao.usuario.UsuarioDAOImpl;
import main.java.br.senac.mediconnect.modelo.entidade.atendente.Atendente;
import main.java.br.senac.mediconnect.modelo.entidade.conquista.Conquista;
import main.java.br.senac.mediconnect.modelo.entidade.consulta.Consulta;
import main.java.br.senac.mediconnect.modelo.entidade.endereco.Endereco;
import main.java.br.senac.mediconnect.modelo.entidade.especialidadeInstituicao.EspecialidadeInstituicao;
import main.java.br.senac.mediconnect.modelo.entidade.especialidadeProfissional.EspecialidadeProfissional;
import main.java.br.senac.mediconnect.modelo.entidade.instituicao.Instituicao;
import main.java.br.senac.mediconnect.modelo.entidade.notificacao.Notificacao;
import main.java.br.senac.mediconnect.modelo.entidade.paciente.Paciente;
import main.java.br.senac.mediconnect.modelo.entidade.pacienteConquista.PacienteConquista;
import main.java.br.senac.mediconnect.modelo.entidade.pacienteSelo.PacienteSelo;
import main.java.br.senac.mediconnect.modelo.entidade.profissionalDeSaude.ProfissionalDeSaude;
import main.java.br.senac.mediconnect.modelo.entidade.usuario.Usuario;
import main.java.br.senac.mediconnect.modelo.enumeracao.consulta.StatusConsulta;

@MultipartConfig
@WebServlet("/")
public class Servlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private InstituicaoDAO instituicaoDAO;
	private EnderecoDAO enderecoDAO;
	private AtendenteDAO atendenteDAO;
	private ProfissionalDeSaudeDAO profissionalDAO;
	private ConsultaDAO consultaDAO;
	private EspecialidadeProfissionalDAO especialidadeDAO;
	private PacienteDAO pacienteDAO;
	private ConquistaDAO conquistaDAO;
	private PacienteConquistaDAO pacienteConquistaDAO;
	private UsuarioDAO usuarioDAO;
	private ConversorImagem conversorImagem;
	private byte[] fotoPerfil = null;
	private PacienteSeloDAO pacienteSeloDAO;
	private NotificacaoDAO notificacaoDAO;
	private EspecialidadeInstituicaoDAO especialidadeInstituicaoDAO;
	private String urlFoto = null;

	public void init() {

		especialidadeDAO = new EspecialidadeProfissionalDAOImpl();
		conquistaDAO = new ConquistaDAOImpl();
		pacienteDAO = new PacienteDAOImpl();
		instituicaoDAO = new InstituicaoDAOImpl();
		profissionalDAO = new ProfissionalDeSaudeDAOImpl();
		enderecoDAO = new EnderecoDAOImpl();
		atendenteDAO = new AtendenteDAOImpl();
		consultaDAO = new ConsultaDAOImpl();
		pacienteConquistaDAO = new PacienteConquistaDAOImpl();
		usuarioDAO = new UsuarioDAOImpl();
		conversorImagem = new ConversorImagem();
		notificacaoDAO = new NotificacaoDAOImpl();
		pacienteSeloDAO = new PacienteSeloDAOImpl();
		especialidadeInstituicaoDAO = new EspecialidadeInstituicaoDAOImpl();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		TimeZone.setDefault(TimeZone.getTimeZone("America/Sao_Paulo"));
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		TimeZone.setDefault(TimeZone.getTimeZone("America/Sao_Paulo"));
		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuario");
		if (sessao.getAttribute("usuario") instanceof Paciente) {
			String tipoUsuario = "1";
			request.setAttribute("tipoUsuario", tipoUsuario);
		}

		else if (sessao.getAttribute("usuario") instanceof Instituicao) {
			String tipoUsuario = "2";
			request.setAttribute("tipoUsuario", tipoUsuario);
		}

		else if (sessao.getAttribute("usuario") instanceof Atendente) {
			String tipoUsuario = "3";
			request.setAttribute("tipoUsuario", tipoUsuario);
		}

		if (usuario != null) {
			request.getSession().setAttribute("urlFoto", urlFoto);
		}
		String action = request.getServletPath();

		try {

			if (usuario != null) {
				request.getSession().setAttribute("urlFoto", urlFoto);
			}
			switch (action) {

			// TELA INICIAL DESLOGADO

			case "/index":
				mostrarTelaInicialDeslogado(request, response);
				break;

			case "/sobre":
				mostrarTelaSobreMediconnect(request, response);
				break;

			case "/login":
				mostrarTelaLogin(request, response);
				break;

			case "/cadastro":
				mostrarTelaCadastro(request, response);
				break;

			// TELA INICIAL LOGADO

			case "/home":
				mostrarTelaInicial(request, response);
				break;

			case "/inicial-instituicao":
				mostrarTelaInicialInstituicao(request, response);
				break;

			case "/inicial-paciente":
				mostrarTelaInicialPaciente(request, response);
				break;

			case "/confirmar-login":
				confirmarLogin(request, response);
				break;

			case "/deslogar":
				finalizarLogin(request, response);
				break;

			// TELA CADASTRO

			case "/cadastrar-instituicao":
				mostrarTelaCadastrarInstituicao(request, response);
				break;

			case "/cadastrar-instituicao-2":
				mostrarTelaCadastrarEndereco(request, response);
				break;

			case "/cadastrar-paciente":
				mostrarTelaCadastrarPaciente(request, response);
				break;

			// TELA CADASTRAR INSTITUICAO

			case "/inserir-instituicao":
				inserirInstituicao(request, response);
				break;
			case "/inserir-endereco":
				inserirEndereco(request, response);
				break;

			// TELA CADASTRO PACIENTE

			case "/inserir-paciente":
				inserirPaciente(request, response);
				break;

			// TELA LOGIN

			case "/esqueceu-senha":
				mostrarTelaEsqueciSenha(request, response);
				break;

			// TELA ESQUECI SENHA

			// TELA PERFIL PACIENTE

			case "/perfil":
				mostrarTelaPerfil(request, response);
				break;

			case "/editar-perfil":
				mostrarTelaEditarPerfil(request, response);
				break;

			case "/conquistas-paciente":
				mostrarTelaConquistasPaciente(request, response);
				break;

			case "/consultas":
				mostrarTelaConsultasPaciente(request, response);
				break;
			case "/consulta":
				mostrarTelaConsulta(request, response);
				break;

			// TELA EDITAR PERFIL PACIENTE

			case "/atualizar-paciente":
				atualizarPaciente(request, response);
				break;

			case "/consultas-atendente":
				mostrarTelaVerConsultas(request, response);
				break;

			case "/agendar-consulta":
				mostrarTelaAgendarConsultas(request, response);
				break;

			case "/editar-consulta":
				mostrarTelaEditarConsultas(request, response);
				break;

			case "/atualizar-consulta":
				atualizarConsulta(request, response);
				break;

			case "/inserir-consulta":
				inserirConsulta(request, response);
				break;

			case "/pacientes-atendente":
				mostrarTelaVerPacientesCadastrados(request, response);
				break;

			case "/editar-atendente":
				mostrarTelaEditarAtendente(request, response);
				break;

			// TELA EDITAR PERFIL ATENDENTE

			case "/atualizar-atendente":
				atualizarAtendente(request, response);
				break;
				
			// TELA EDITAR PERFIL ATENDENTE
				
			case "/instituicao-atualizar-atendente":
				editarAtendente(request, response);
				break;

			// TELA EDITAR PERFIL INSTITUICAO

			case "/atualizar-instituicao":
				atualizarInstituicao(request, response);
				break;

			// TELA CADASTRAR ATENDENTE

			case "/cadastrar-atendente":
				mostrarTelaCadastrarAtendente(request, response);
				break;

			case "/inserir-atendente":
				inserirAtendente(request, response);
				break;

			case "/atendentes-instituicao":
				mostrarTelaAtendentesInstituicao(request, response);
				break;

			case "/especialidades-instituicao":
				mostrarTelaEspecialidadesInstituicao(request, response);
				break;

			case "/cadastrar-especialidade":
				mostrarTelaCadastrarEspecialidade(request, response);
				break;

			case "/editar-especialidade":
				mostrarTelaEditarEspecialidade(request, response);
				break;

			case "/atualizar-especialidade":
				atualizarEspecialidade(request, response);
				break;

			case "/inserir-especialidade":
				inserirEspecialidade(request, response);
				break;

			// TELA PROFISSIONAIS

			case "/cadastrar-profissional":
				mostrarTelaCadastrarProfissional(request, response);
				break;

			// TELA CADASTRAR PROFISSIONAL

			case "/inserir-profissional":
				inserirProfissional(request, response);
				break;

			// ROTAS CRIADAS PARA TRF40

			case "/cadastrar-editar-profissional":
				mostrarTelaCadastrarEditarProfissional(request, response);
				break;

			case "/card-paciente":
				mostrarCardPaciente(request, response);
				break;

			case "/modal-atendente":
				mostrarModalAtendente(request, response);
				break;

			case "/modal-especialidade":
				mostrarModalEspecialidade(request, response);
				break;

			case "/notificacoes-instituicao":
				mostrarTelaNotificacoesDaInstituicao(request, response);
				break;

			case "/notificacoes-atendente":
				mostrarTelaNotificacoesDoAtendente(request, response);
				break;

			case "/cadastro-paciente":
				mostrarTelaCadastroDoPaciente(request, response);
				break;

			case "/card-consulta-paciente":
				mostrarCardConsulta(request, response);
				break;

			case "/editar-perfil-paciente":
				mostrarTelaEditarPerfil(request, response);
				break;

			case "/listar-consulta-paciente":
				mostrarTelaListarConsulta(request, response);
				break;

			case "/modal-consulta-paciente":
				mostrarModalConsulta(request, response);
				break;

			case "/notificacoes-paciente":
				mostrarTelaNotificacoesDoPaciente(request, response);
				break;

			case "/listar-notificacao":
				mostrarTelaListarNotificacao(request, response);
				break;

			case "/modal-notificacao":
				mostrarModalNotificacao(request, response);
				break;

			case "/deletar-usuario":
				deletarUsuario(request, response);
				break;

			case "/deletar-atendente":
				deletarAtendente(request, response);
				break;

			case "/deletar-paciente":
				deletarPaciente(request, response);
				break;

			case "/deletar-instituicao":
				deletarInstituicao(request, response);
				break;

			case "/deletar-especialidade":
				deletarEspecialidade(request, response);
				break;

			case "/deletar-consulta":
				deletarConsulta(request, response);
				break;

			case "/deletar-profissional":
				deletarProfissional(request, response);
				break;

			case "/deletar-endereco":
				deletarEndereco(request, response);
				break;

			case "/deletar-paciente-conquista":
				deletarPacienteConquista(request, response);
				break;

			case "/deletar-paciente-selo":
				deletarPacienteSelo(request, response);
				break;

			case "/deletar-notificacao":
				deletarNotificacao(request, response);
				break;

			default:
				mostrarTelaInicialDeslogado(request, response);
				break;
			}

		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	// TELA INICIAL DESLOGADO

	private void mostrarTelaInicialDeslogado(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}

	private void deletarUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sessao = request.getSession();

		if (sessao.getAttribute("usuario") instanceof Usuario) {

			Usuario usuario = (Usuario) sessao.getAttribute("usuario");
			Integer id = usuario.getId();

			usuario = usuarioDAO.recuperarUsuarioPorId(id);

			usuario.setEhAtivo(false);

			usuarioDAO.atualizarUsuario(usuario);

			try {

				finalizarLogin(request, response);

			} catch (SQLException e) {

				e.printStackTrace();
			}

			response.sendRedirect("index");

		}
	}

	private void deletarAtendente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sessao = request.getSession();

		if (sessao.getAttribute("usuario") instanceof Atendente) {

			Atendente atendente = (Atendente) sessao.getAttribute("atendente");

			Integer id = atendente.getId();
			atendente = atendenteDAO.filtrarAtendenteViaInstituicaoPorId(id);

			atendente.setEhAtivo(false);

			atendenteDAO.atualizarAtendente(atendente);

			RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/instituicao/atendentes.jsp");
			dispatcher.forward(request, response);
		}
	}

	private void deletarPaciente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sessao = request.getSession();

		if (sessao.getAttribute("usuario") instanceof Paciente) {

			Paciente paciente = (Paciente) sessao.getAttribute("paciente");

			Integer id = paciente.getId();

			paciente = pacienteDAO.recuperarPacientePorId(id);

			paciente.setEhAtivo(false);

			pacienteDAO.atualizarPaciente(paciente);

			try {

				finalizarLogin(request, response);

			} catch (SQLException e) {

				e.printStackTrace();
			}

			response.sendRedirect("index");

		}
	}

	private void deletarInstituicao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sessao = request.getSession();

		if (sessao.getAttribute("usuario") instanceof Instituicao) {

			Instituicao instituicao = (Instituicao) sessao.getAttribute("instituicao");

			Integer id = instituicao.getId();

			instituicao = instituicaoDAO.recuperarInstituicaoPorId(id);

			instituicao.setEhAtivo(false);

			instituicaoDAO.atualizarInstituicao(instituicao);

			try {

				finalizarLogin(request, response);

			} catch (SQLException e) {

				e.printStackTrace();
			}

			response.sendRedirect("index");

		}
	}

	private void deletarEspecialidade(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Integer id = Integer.parseInt(request.getParameter("id"));

		EspecialidadeProfissional especialidade = especialidadeDAO.recuperarEspecialidadeDaInstituicaoPorId(id);

		especialidade.setEhAtivo(false);

		especialidadeDAO.atualizarEspecialidadeProfissionalDaInstituicao(especialidade);

		response.sendRedirect("especialidades.jsp");

	}

	private void deletarConsulta(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Integer id = Integer.parseInt(request.getParameter("id"));

		Consulta consulta = consultaDAO.recuperarConsultaPorId(id);

		consulta.setEhAtivo(false);

		consultaDAO.atualizarConsulta(consulta);

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/paciente/consultas.jsp");
		dispatcher.forward(request, response);

	}

	private void deletarProfissional(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Integer id = Integer.parseInt(request.getParameter("id"));

		ProfissionalDeSaude profissional = profissionalDAO.recuperarProfissionalPorId(id);

		profissional.setEhAtivo(false);

		profissionalDAO.atualizarProfissionalDeSaude(profissional);

		RequestDispatcher dispatcher = request.getRequestDispatcher("profissionais.jsp");
		dispatcher.forward(request, response);

	}

	private void deletarEndereco(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Integer id = Integer.parseInt(request.getParameter("id"));

		Endereco endereco = enderecoDAO.recuperarEnderecoPorId(id);

		endereco.setEhAtivo(false);

		enderecoDAO.atualizarEndereco(endereco);

		RequestDispatcher dispatcher = request.getRequestDispatcher("enderecos.jsp");
		dispatcher.forward(request, response);

	}

	private void deletarPacienteConquista(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Integer id = Integer.parseInt(request.getParameter("id"));

		PacienteConquista pacienteConquista = pacienteConquistaDAO.recuperarPacienteConquistaPorId(id);

		pacienteConquista.setEhAtivo(false);

		pacienteConquistaDAO.atualizarPacienteConquista(pacienteConquista);

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/paciente/tela-conquistas.jsp");
		dispatcher.forward(request, response);

	}

	private void deletarPacienteSelo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Integer id = Integer.parseInt(request.getParameter("id"));

		PacienteSelo pacienteSelo = pacienteSeloDAO.recuperarPacienteSeloPorId(id);

		pacienteSelo.setEhAtivo(false);

		pacienteSeloDAO.atualizarPacienteSelo(pacienteSelo);

		RequestDispatcher dispatcher = request.getRequestDispatcher("selos.jsp");
		dispatcher.forward(request, response);

	}

	private void deletarNotificacao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Integer id = Integer.parseInt(request.getParameter("id"));

		Notificacao notificacao = notificacaoDAO.recuperarNotificacaoPorId(id);
		;

//		notificacao.setEhAtivo(false);

		notificacaoDAO.atualizarNotificacao(notificacao);

		RequestDispatcher dispatcher = request.getRequestDispatcher("notificacao.jsp");
		dispatcher.forward(request, response);

	}

	private void mostrarTelaSobreMediconnect(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/sobre-nos.jsp");
		dispatcher.forward(request, response);
	}

	private void mostrarTelaLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/usuario-login.jsp");
		dispatcher.forward(request, response);
	}

	private void mostrarTelaInicial(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuario");

		Integer id = usuario.getId();

		if (sessao.getAttribute("usuario") instanceof Paciente) {
			Paciente paciente = pacienteDAO.recuperarPacientePorId(id);

			request.setAttribute("paciente", paciente);

			List<Consulta> consultas = consultaDAO.recuperarConsultasViaPacientePorId(id);
			request.setAttribute("consultas", consultas);
			List<Conquista> conquistas = conquistaDAO.recuperarListaDeConquistas(); // fazer filtrado depois
			request.setAttribute("conquistas", conquistas);
			List<Instituicao> instituicoes = instituicaoDAO.recuperarInstituicao();
			request.setAttribute("instituicoes", instituicoes);

			RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/paciente/inicial.jsp");
			dispatcher.forward(request, response);

		}

		else if (sessao.getAttribute("usuario") instanceof Instituicao) {
			Instituicao instituicao = instituicaoDAO.recuperarInstituicaoPorId(id);
			Integer idInstituicao = instituicao.getId();

			request.setAttribute("instituicao", instituicao);
			
			List<Atendente> atendentes = atendenteDAO.recuperarListaDeAtendentesViaInstituicao(id);
			request.setAttribute("atendentes", atendentes);
			List<EspecialidadeProfissional> especialidades = especialidadeDAO.recuperarEspecialidadesProfissionais();
			
			request.setAttribute("especialidades", especialidades);

			RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/instituicao/inicial.jsp");
			dispatcher.forward(request, response);
		}

		else if (sessao.getAttribute("usuario") instanceof Atendente) {
			Atendente atendente = atendenteDAO.recuperarAtendentePorId(id);

			request.setAttribute("atendente", atendente);

			List<Paciente> pacientes = pacienteDAO.recuperarPacientes();
			List<Consulta> consultas = consultaDAO.recuperarListaDeConsultas();
			request.setAttribute("pacientes", pacientes);
			Consulta ultimaConsulta = null;
			for (Consulta consulta : consultas) {
				ultimaConsulta = consulta;
			}
			request.setAttribute("consulta", ultimaConsulta);
			request.setAttribute("consultas", consultas);

			RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/atendente/inicial.jsp");
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect("index");
		}
	}

	private void mostrarTelaInicialInstituicao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/instituicao/inicial.jsp");
		dispatcher.forward(request, response);
	}

	private void mostrarTelaInicialPaciente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/paciente/inicial.jsp");
		dispatcher.forward(request, response);
	}

	private void mostrarTelaCadastro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/usuario-cadastro.jsp");
		dispatcher.forward(request, response);
	}

	// TELA CADASTRO

	private void mostrarTelaCadastrarInstituicao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/instituicao/cadastro-1.jsp");
		dispatcher.forward(request, response);
	}

	private void mostrarTelaCadastrarEndereco(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/instituicao/cadastro-2.jsp");
		dispatcher.forward(request, response);
	}

	private void mostrarTelaCadastrarPaciente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/paciente/cadastro.jsp");
		dispatcher.forward(request, response);
	}

	// TELA CADASTRO INSTITUICAO

	private void inserirInstituicao(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		Instituicao instituicao = null;

		String razaoSocial = request.getParameter("razao");
		String nomeFantasia = request.getParameter("fantasia");
		String cnpj = request.getParameter("cnpj");
		boolean ehAtivo = true;
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");

		urlFoto = null;

		instituicao = new Instituicao(cnpj, razaoSocial, nomeFantasia, email, senha, ehAtivo, urlFoto);

		instituicaoDAO.inserirInstituicao(instituicao);
		request.setAttribute("instituicao", instituicao);
		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/instituicao/cadastro-2.jsp");
		dispatcher.forward(request, response);
	}

	private void inserirEndereco(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		Endereco endereco = null;

		String cep = request.getParameter("cep");
		String estado = request.getParameter("estado");
		String cidade = request.getParameter("cidade");
		String bairro = request.getParameter("bairro");
		String logradouro = request.getParameter("logradouro");
		int numero = Integer.parseInt(request.getParameter("numero"));

		endereco = new Endereco(cep, numero, logradouro, cidade, estado, bairro);

		enderecoDAO.inserirEndereco(endereco);

		Integer id = Integer.parseInt(request.getParameter("id"));

		Instituicao instituicao = instituicaoDAO.recuperarInstituicaoPorId(id);

		instituicao.setEndereco(endereco);
		instituicaoDAO.atualizarInstituicao(instituicao);

		response.sendRedirect("login");
	}

	// TELA CADASTRO PACIENTE

	private void inserirPaciente(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		Paciente paciente = null;

		String nome = request.getParameter("nome");
		String sobrenome = request.getParameter("sobrenome");
		String cpf = request.getParameter("cpf");
		boolean ehAtivo = true;
		LocalDate dataNascimento = LocalDate.parse(request.getParameter("data"));
		String email = request.getParameter("email");
		String telefone = request.getParameter("telefone");
		String senha = request.getParameter("senha");

		String urlFoto = null;

		paciente = new Paciente(email, senha, ehAtivo, nome, sobrenome, cpf, dataNascimento, telefone, urlFoto);

		pacienteDAO.inserirPaciente(paciente);
		response.sendRedirect("login");

	}

	// TELA LOGIN

	private void mostrarTelaEsqueciSenha(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/esqueceu-senha.jsp");
		dispatcher.forward(request, response);

	}

	// TELA PERFIL PACIENTE

	private void mostrarTelaPerfil(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuario");
		Integer id = usuario.getId();
		if (sessao.getAttribute("usuario") instanceof Paciente) {

			Paciente paciente = pacienteDAO.recuperarPacientePorId(id);
			request.setAttribute("paciente", paciente);
			
			List<Consulta> consultas = consultaDAO.recuperarConsultasViaPacientePorId(id);
			request.setAttribute("consultas", consultas);

			RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/paciente/perfil.jsp");
			dispatcher.forward(request, response);
		}

		if (sessao.getAttribute("usuario") instanceof Instituicao) {

			Instituicao instituicao = instituicaoDAO.recuperarInstituicaoPorId(id);

			request.setAttribute("instituicao", instituicao);
			List<Atendente> atendentes = atendenteDAO.recuperarListaDeAtendentesViaInstituicao(id);
			request.setAttribute("atendentes", atendentes);
			List<EspecialidadeProfissional> especialidades = especialidadeDAO.recuperarEspecialidadesProfissionais();
			request.setAttribute("especialidades", especialidades);
			
			for (EspecialidadeProfissional especialidade : especialidades) {
				List<ProfissionalDeSaude> profissionais = profissionalDAO.recuperarProfissionaisDeSaudePorEspecialidade(especialidade);
				request.setAttribute("profissionais", profissionais);
				String numeroProfissionais = String.valueOf(profissionais.size());
				request.setAttribute("numeroProfissionais", numeroProfissionais);
			}
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/instituicao/perfil.jsp");
			dispatcher.forward(request, response);
		}

		if (sessao.getAttribute("usuario") instanceof Atendente) {

			Atendente atendente = atendenteDAO.recuperarAtendentePorId(id);
			
			Integer idInstituicao = atendente.getInstituicao().getId();
			Instituicao instituicao = instituicaoDAO.recuperarInstituicaoPorId(idInstituicao); 
			Endereco endereco = enderecoDAO.recuperarEnderecoPorInstituicao(idInstituicao);
			request.setAttribute("atendente", atendente);
			request.setAttribute("instituicao", instituicao);
			request.setAttribute("endereco", endereco);
			
			List<Paciente> pacientes = pacienteDAO.recuperarPacientes();

			request.setAttribute("pacientes", pacientes);
			
			List<Consulta> consultas = consultaDAO.recuperarListaDeConsultas();
			request.setAttribute("consultas", consultas);
			

			RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/atendente/perfil.jsp");
			dispatcher.forward(request, response);
		}

	}

	private void mostrarTelaEditarPerfil(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sessao = request.getSession();

		if (sessao.getAttribute("usuario") instanceof Paciente) {

			Usuario usuario = (Usuario) sessao.getAttribute("usuario");
			Integer id = usuario.getId();
			Paciente paciente = pacienteDAO.recuperarPacientePorId(id);

			LocalDate dataNascimento = paciente.getDataNascimento();
			request.setAttribute("paciente", paciente);
			request.setAttribute("dataNascimento", dataNascimento);

			RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/paciente/editar-perfil.jsp");
			dispatcher.forward(request, response);
		}

		if (sessao.getAttribute("usuario") instanceof Instituicao) {

			Usuario usuario = (Usuario) sessao.getAttribute("usuario");
			Integer id = usuario.getId();

			Instituicao instituicao = instituicaoDAO.recuperarInstituicaoPorId(id);

			Endereco endereco = enderecoDAO.recuperarEnderecoPorInstituicao(instituicao);
			request.setAttribute("instituicao", instituicao);
			request.setAttribute("endereco", endereco);

			RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/instituicao/editar-perfil.jsp");
			dispatcher.forward(request, response);
		}

		if (sessao.getAttribute("usuario") instanceof Atendente) {

			Usuario usuario = (Usuario) sessao.getAttribute("usuario");
			Integer id = usuario.getId();

			Atendente atendente = atendenteDAO.recuperarAtendentePorId(id);

			request.setAttribute("atendente", atendente);

			RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/atendente/editar-perfil.jsp");
			dispatcher.forward(request, response);
		}
	}

	private void atualizarPaciente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sessao = request.getSession();

		Usuario usuario = (Usuario) sessao.getAttribute("usuario");
		Integer id = usuario.getId();
		Paciente paciente = pacienteDAO.recuperarPacientePorId(id);

		String nome = request.getParameter("nome");
		String sobrenome = request.getParameter("sobrenome");
		String telefone = request.getParameter("telefone");
		Part parteImagem = request.getPart("imagem");
		String nomeArquivo = null;
		for (String content : parteImagem.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename")) {
				nomeArquivo = content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
			}
		}

		if (nomeArquivo != "") {
			String extensao = null;
			int pontoIndex = nomeArquivo.lastIndexOf('.');
			if (pontoIndex > 0 && pontoIndex < nomeArquivo.length() - 1) {
				extensao = nomeArquivo.substring(pontoIndex + 1);
			}

			byte[] bytesImagem = ConversorImagem.obterBytesImagem(parteImagem);

			urlFoto = ConversorImagem.urlFoto(bytesImagem, extensao);
		}

		paciente.setNome(nome);
		paciente.setSobrenome(sobrenome);
		paciente.setTelefone(telefone);
		paciente.setFotoPerfil(urlFoto);

		pacienteDAO.atualizarPaciente(paciente);
		request.setAttribute("urlFoto", urlFoto);
		response.sendRedirect("perfil");
	}

	private void mostrarTelaConquistasPaciente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sessao = request.getSession();

		Usuario usuario = (Usuario) sessao.getAttribute("usuario");
		Integer id = usuario.getId();

		List<Conquista> conquistas = pacienteConquistaDAO.recuperarConquistasPacientePorId(id);

		request.setAttribute("conquistas", conquistas);

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/paciente/conquistas.jsp");

		dispatcher.forward(request, response);

	}

	private void mostrarTelaConsultasPaciente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sessao = request.getSession();

		Usuario usuario = (Paciente) sessao.getAttribute("usuario");
		Integer id = usuario.getId();

		List<Consulta> consultas = consultaDAO.recuperarConsultasViaPacientePorId(id);

		request.setAttribute("consultas", consultas);

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/paciente/consultas.jsp");
		dispatcher.forward(request, response);

	}

	private void mostrarTelaConsulta(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sessao = request.getSession();

		Usuario usuario = (Paciente) sessao.getAttribute("usuario");
		Integer id = usuario.getId();

		Paciente paciente = pacienteDAO.recuperarPacientePorId(id);

		// GAMBIARRA
		boolean concluido2 = false;
		int idConsulta = 1;
		Consulta consulta = consultaDAO.filtrarConsultaViaPacientePorIdDaConsulta(1, paciente.getId());
		while (!concluido2) {
			consulta = consultaDAO.filtrarConsultaViaPacientePorIdDaConsulta(idConsulta, paciente.getId());
			if (consulta == null)
				idConsulta++;
			else
				concluido2 = true;
		}

		request.setAttribute("consulta", consulta);
		request.setAttribute("paciente", paciente);

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/paciente/card-consulta.jsp");
		dispatcher.forward(request, response);

	}

	// TELA AGENDAR CONSULTA PACIENTE

	private void mostrarTelaAgendarConsultas(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<EspecialidadeProfissional> especialidades = especialidadeDAO.recuperarEspecialidadesProfissionais();
		request.setAttribute("especialidades", especialidades);
		List<ProfissionalDeSaude> profissionais = profissionalDAO.recuperarProfissionaisDeSaude();
		request.setAttribute("profissionais", profissionais);
		List<Instituicao> instituicoes = instituicaoDAO.recuperarInstituicao();
		request.setAttribute("instituicoes", instituicoes);
		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/paciente/agendar-consulta.jsp");
		dispatcher.forward(request, response);

	}

	private void mostrarTelaEditarConsultas(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/paciente/editar-consulta.jsp");
		dispatcher.forward(request, response);

	}

	private void atualizarConsulta(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Integer idConsulta = Integer.parseInt(request.getParameter("idConsulta"));

		Consulta consulta = consultaDAO.recuperarConsultaPorId(idConsulta);

		Integer idInstituicao = Integer.parseInt(request.getParameter("idEspecialidade"));
		Instituicao instituicao = instituicaoDAO.recuperarInstituicaoPorId(idInstituicao);

		Integer idEspecialidade = Integer.parseInt(request.getParameter("idEspecialidade"));
		EspecialidadeProfissional especialidadeProfissional = especialidadeDAO
				.recuperarEspecialidadeDaInstituicaoPorId(idEspecialidade);

		Integer idPaciente = Integer.parseInt(request.getParameter("idPaciente"));
		Paciente paciente = pacienteDAO.recuperarPacientePorId(idPaciente);

		Integer idProfissional = Integer.parseInt(request.getParameter("idProfissional"));
		ProfissionalDeSaude profissional = profissionalDAO.recuperarProfissionalPorId(idProfissional);

		StatusConsulta status = StatusConsulta.valueOf(request.getParameter("status"));

		LocalDate data = LocalDate.parse("data");
		LocalTime horario = LocalTime.parse("horario");
		String descricao = request.getParameter("descricao");

		consulta.setEspecialidadeProfissional(especialidadeProfissional);
		consulta.setInstituicao(instituicao);
		consulta.setPaciente(paciente);
		consulta.setProfissionalDeSaude(profissional);
		consulta.setStatus(status);
		consulta.setData(data);
		consulta.setHorario(horario);
		consulta.setDescricao(descricao);

		consultaDAO.atualizarConsulta(consulta);
		response.sendRedirect("consultas");

	}

	private void inserirConsulta(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		Consulta consulta = null;

		LocalTime horarioConsulta = LocalTime.parse(request.getParameter("horario"));
		LocalDate dataConsulta = LocalDate.parse(request.getParameter("data"));
		Integer idEspecialidade = Integer.parseInt(request.getParameter("especialidade"));
		Integer idInstituicao = Integer.parseInt(request.getParameter("instituicao"));
		Integer idProfissional = Integer.parseInt(request.getParameter("profissional"));
		String descricao = request.getParameter("descricao");

		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuario");
		Integer id = usuario.getId();
		Paciente paciente = pacienteDAO.recuperarPacientePorIdComConsultas(id);
//		String descricao = request.getParameter("descricao");

		StatusConsulta status = StatusConsulta.AGENDADA;

		Instituicao instituicao = instituicaoDAO.recuperarInstituicaoComConsultasPorId(idInstituicao);

		EspecialidadeProfissional especialidade = especialidadeDAO
				.recuperarEspecialidadeDaInstituicaoPorId(idEspecialidade);

		ProfissionalDeSaude profissional = profissionalDAO.recuperarProfissionalPorId(idProfissional);

		consulta = new Consulta(especialidade, instituicao, profissional, dataConsulta, horarioConsulta, paciente,
				status, descricao);

		consultaDAO.inserirConsulta(consulta);

		instituicao.adicionarConsulta(consulta);
		instituicaoDAO.atualizarInstituicao(instituicao);
		paciente.adicionarConsulta(consulta);
		pacienteDAO.atualizarPaciente(paciente);

		response.sendRedirect("consultas");

	}

	private void mostrarTelaEditarAtendente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/instituicao/editar-atendente.jsp");
		dispatcher.forward(request, response);

	}

	private void atualizarAtendente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuario");
		Integer id = usuario.getId();
		Atendente atendente = atendenteDAO.recuperarAtendentePorId(id);

		Part parteImagem = request.getPart("imagem");
		String nomeArquivo = null;
		for (String content : parteImagem.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename")) {
				nomeArquivo = content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
			}
		}

		if (nomeArquivo != "") {
			String extensao = null;
			int pontoIndex = nomeArquivo.lastIndexOf('.');
			if (pontoIndex > 0 && pontoIndex < nomeArquivo.length() - 1) {
				extensao = nomeArquivo.substring(pontoIndex + 1);
			}

			byte[] bytesImagem = ConversorImagem.obterBytesImagem(parteImagem);

			urlFoto = ConversorImagem.urlFoto(bytesImagem, extensao);
		}
		atendente.setFotoPerfil(urlFoto);
		atendenteDAO.atualizarAtendente(atendente);
		request.setAttribute("urlFoto", urlFoto);
		response.sendRedirect("perfil");

	}
	private void editarAtendente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Integer id = Integer.parseInt(request.getParameter("id"));
		Atendente atendente = atendenteDAO.recuperarAtendentePorId(id);
		
		String ctps = request.getParameter("ctps");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		String nome = request.getParameter("nome");
		String sobrenome = request.getParameter("sobrenome");
		String cpf = request.getParameter("cpf");
		Part parteImagem = request.getPart("imagem");
		String nomeArquivo = null;
		for (String content : parteImagem.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename")) {
				nomeArquivo = content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		
		if (nomeArquivo != "") {
			String extensao = null;
			int pontoIndex = nomeArquivo.lastIndexOf('.');
			if (pontoIndex > 0 && pontoIndex < nomeArquivo.length() - 1) {
				extensao = nomeArquivo.substring(pontoIndex + 1);
			}
			
			byte[] bytesImagem = ConversorImagem.obterBytesImagem(parteImagem);
			
			urlFoto = ConversorImagem.urlFoto(bytesImagem, extensao);
		}
		atendente.setEmail(email);
		atendente.setCtps(ctps);
		atendente.setSenha(senha);
		atendente.setNome(nome);
		atendente.setSobrenome(sobrenome);
		atendente.setCpf(cpf);
		atendente.setFotoPerfil(urlFoto);
		atendenteDAO.atualizarAtendente(atendente);
		request.setAttribute("urlFoto", urlFoto);
		response.sendRedirect("perfil");
		
	}

	private void mostrarTelaVerConsultas(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sessao = request.getSession();

		Usuario usuario = (Usuario) sessao.getAttribute("usuario");
		Integer id = usuario.getId();

		List<Consulta> consultas = consultaDAO.recuperarListaDeConsultas();

		request.setAttribute("consultas", consultas);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/atendente/consultas.jsp");
		dispatcher.forward(request, response);

	}

	private void mostrarTelaVerPacientesCadastrados(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuario");
		Integer id = usuario.getId();

		Atendente atendente = atendenteDAO.recuperarAtendentePorId(id);

		List<Paciente> pacientes = pacienteDAO.recuperarPacientes();

		request.setAttribute("pacientes", pacientes);

		// Verificar o nome da rota quando tiver o arquivo JSP pronto

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/atendente/pacientes.jsp");
		dispatcher.forward(request, response);

	}

	private void atualizarInstituicao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuario");
		Integer id = usuario.getId();
		Instituicao instituicao = instituicaoDAO.recuperarInstituicaoPorId(id);
		// recuperar a entidade e setar informa��es novas nela ou atualizar com new
		// Entidade?

		Endereco endereco = enderecoDAO.recuperarEnderecoPorInstituicao(instituicao);

		String razaoSocial = request.getParameter("razao");
		String nomeFantasia = request.getParameter("fantasia");
		String cep = request.getParameter("cep");
		String estado = request.getParameter("estado");
		String cidade = request.getParameter("cidade");
		String bairro = request.getParameter("bairro");
		String logradouro = request.getParameter("logradouro");
		int numero = Integer.parseInt(request.getParameter("numero"));
		Part parteImagem = request.getPart("imagem");
		String nomeArquivo = null;
		for (String content : parteImagem.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename")) {
				nomeArquivo = content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
			}
		}

		if (nomeArquivo != "") {
			String extensao = null;
			int pontoIndex = nomeArquivo.lastIndexOf('.');
			if (pontoIndex > 0 && pontoIndex < nomeArquivo.length() - 1) {
				extensao = nomeArquivo.substring(pontoIndex + 1);
			}

			byte[] bytesImagem = ConversorImagem.obterBytesImagem(parteImagem);

			urlFoto = ConversorImagem.urlFoto(bytesImagem, extensao);
		}
		endereco.setCep(cep);
		endereco.setEstado(estado);
		endereco.setCidade(cidade);
		endereco.setBairro(bairro);
		endereco.setLogradouro(logradouro);
		endereco.setNumero(numero);

		enderecoDAO.atualizarEndereco(endereco);
		// atualizar endereco antes de inserir na instituicao sendo editada??
		instituicao.setFotoPerfil(urlFoto);
		instituicao.setNomeFantasia(nomeFantasia);
		instituicao.setRazaoSocial(razaoSocial);
		instituicaoDAO.atualizarInstituicao(instituicao);
		response.sendRedirect("perfil");
	}

	private void mostrarTelaAtendentesInstituicao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuario");
		Integer id = usuario.getId();

		List<Atendente> atendentes = atendenteDAO.recuperarListaDeAtendentesViaInstituicao(id);

		request.setAttribute("atendentes", atendentes);

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/instituicao/atendentes.jsp");
		dispatcher.forward(request, response);

	}

	// TELA CADASTRAR ATENDENTE

	private void mostrarTelaCadastrarAtendente(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("assets/paginas/instituicao/cadastrar-atendente.jsp");
		dispatcher.forward(request, response);

	}

	private void inserirAtendente(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuario");
		Integer id = usuario.getId();

		Instituicao instituicao = instituicaoDAO.recuperarInstituicaoPorId(id);
		Atendente atendente = null;

		String nome = request.getParameter("nome");
		String sobrenome = request.getParameter("sobrenome");
		String cpf = request.getParameter("cpf");
		String ctps = request.getParameter("ctps");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		LocalDate dataCadastro = LocalDate.parse(request.getParameter("data"));
		boolean ehAtivo = true;
		Part parteImagem = request.getPart("imagem");

		String nomeArquivo = null;
		for (String content : parteImagem.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename")) {
				nomeArquivo = content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
			}
		}

		String extensao = null;
		int pontoIndex = nomeArquivo.lastIndexOf('.');
		if (pontoIndex > 0 && pontoIndex < nomeArquivo.length() - 1) {
			extensao = nomeArquivo.substring(pontoIndex + 1);
		}

		byte[] bytesImagem = ConversorImagem.obterBytesImagem(parteImagem);

		String urlFoto = ConversorImagem.urlFoto(bytesImagem, extensao);

		atendente = new Atendente(email, senha, ehAtivo, nome, sobrenome, cpf, dataCadastro, instituicao, ctps,
				urlFoto);

		atendenteDAO.inserirAtendente(atendente);

		response.sendRedirect("atendentes-instituicao");

	}

	private void mostrarTelaEspecialidadesInstituicao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sessao = request.getSession();

		Usuario usuario = (Usuario) sessao.getAttribute("usuario");
		Integer id = usuario.getId();
		Instituicao instituicao = instituicaoDAO.recuperarInstituicaoPorIdComEspecialidades(id);

		List<EspecialidadeProfissional> especialidades = especialidadeDAO.recuperarEspecialidadesProfissionais();
		request.setAttribute("especialidades", especialidades);
//		
//		for (EspecialidadeProfissional especialidade : especialidades) {
//			especialidade.getProfissionalDeSaude();
//			List<ProfissionalDeSaude> profissionais = profissionalDAO.recuperarProfissionaisDeSaudePorEspecialidade(especialidade);
//			request.setAttribute("profissionais", profissionais);
//		}
		

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/instituicao/especialidades.jsp");
		dispatcher.forward(request, response);

  }

	private void mostrarTelaEditarEspecialidade(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/paciente/editar-especialidade.jsp");

		dispatcher.forward(request, response);

	}

	private void atualizarEspecialidade(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Integer id = Integer.parseInt(request.getParameter("id"));

		EspecialidadeProfissional especialidade = especialidadeDAO.recuperarEspecialidadeDaInstituicaoPorId(id);

		String nome = request.getParameter("nome");
		boolean ehAtivo = Boolean.parseBoolean("ehAtivo");

		especialidade.setNome(nome);
		especialidade.setEhAtivo(ehAtivo);

		especialidadeDAO.atualizarEspecialidadeProfissionalDaInstituicao(especialidade);
		response.sendRedirect("especialidades");

	}

	private void inserirEspecialidade(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuario");

		Integer id = usuario.getId();
		Instituicao instituicao = instituicaoDAO.recuperarInstituicaoPorIdComEspecialidades(id);

		EspecialidadeProfissional especialidade = null;
		EspecialidadeInstituicao especialidadeInstituicao = null;

		String nome = request.getParameter("nome");

		especialidade = new EspecialidadeProfissional(nome);

		especialidadeDAO.inserirEspecialidadeProfissionalDaInstituicao(especialidade);

		especialidadeInstituicao = new EspecialidadeInstituicao(especialidade, instituicao);

		instituicao.adicionarEspecialidadeProfissional(especialidade);

		instituicaoDAO.atualizarInstituicao(instituicao);

		especialidadeInstituicaoDAO.inserirEspecialidadeInstituicao(especialidadeInstituicao);

		response.sendRedirect("especialidades-instituicao");

	}

	private void mostrarTelaCadastrarProfissional(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuario");
		Integer id = usuario.getId();
		List<EspecialidadeProfissional> especialidades = especialidadeDAO.recuperarEspecialidadesProfissionais();
		request.setAttribute("especialidades", especialidades);
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("assets/paginas/instituicao/cadastrar-profissional.jsp");
		dispatcher.forward(request, response);

	}

	private void mostrarTelaCadastrarEspecialidade(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("assets/paginas/instituicao/cadastrar-especialidade.jsp");
		dispatcher.forward(request, response);

	}
	private void mostrarTelaCadastrarConquista(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/instituicao/cadastrar-notificacao.jsp");
		dispatcher.forward(request, response);
		
	}

	private void inserirConquista(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuario");
		Integer id = usuario.getId();
		Instituicao instituicao = instituicaoDAO.recuperarInstituicaoPorIdComProfissionais(id);
		
		ProfissionalDeSaude profissional = null;
		
		String nome = request.getParameter("nome");
		String sobrenome = request.getParameter("sobrenome");
		Integer idEspecialidade = Integer.parseInt(request.getParameter("especialidade"));
		EspecialidadeProfissional especialidade = especialidadeDAO
				.recuperarEspecialidadeDaInstituicaoPorId(idEspecialidade);
		profissional = new ProfissionalDeSaude(nome, sobrenome, especialidade, instituicao);
		
		profissionalDAO.inserirProfissionalDeSaude(profissional);
		
		instituicao.adicionarProfissionalDeSaude(profissional);
		instituicaoDAO.atualizarInstituicao(instituicao);
		
		response.sendRedirect("especialidades-instituicao");
		
	}
	private void inserirProfissional(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuario");
		Integer id = usuario.getId();
		Instituicao instituicao = instituicaoDAO.recuperarInstituicaoPorIdComProfissionais(id);

		ProfissionalDeSaude profissional = null;

		String nome = request.getParameter("nome");
		String sobrenome = request.getParameter("sobrenome");
		Integer idEspecialidade = Integer.parseInt(request.getParameter("especialidade"));
		EspecialidadeProfissional especialidade = especialidadeDAO
				.recuperarEspecialidadeDaInstituicaoPorId(idEspecialidade);
		profissional = new ProfissionalDeSaude(nome, sobrenome, especialidade, instituicao);

		profissionalDAO.inserirProfissionalDeSaude(profissional);

		instituicao.adicionarProfissionalDeSaude(profissional);
		instituicaoDAO.atualizarInstituicao(instituicao);

		response.sendRedirect("especialidades-instituicao");

	}

	// INSTITUIÇÃO

	private void mostrarTelaCadastrarEditarProfissional(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("assets/paginas/instituicao/cadastrar-editar-profissional.jsp");
		dispatcher.forward(request, response);

	}

	private void mostrarCardPaciente(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/instituicao/card-paciente.jsp");
		dispatcher.forward(request, response);

	}

	private void mostrarModalAtendente(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/instituicao/modal-atendente.jsp");
		dispatcher.forward(request, response);

	}

	private void mostrarModalEspecialidade(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		EspecialidadeProfissional especialidade = especialidadeDAO.recuperarEspecialidadeDaInstituicaoPorId(1);
		request.setAttribute("especialidade", especialidade);
		List<ProfissionalDeSaude> profissionais = profissionalDAO.recuperarProfissionaisDeSaude();
		// Fazer filtro por especialidade depois
		request.setAttribute("profissionais", profissionais);
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("assets/paginas/instituicao/modal-especialidade.jsp");
		dispatcher.forward(request, response);

	}

	private void mostrarTelaNotificacoesDaInstituicao(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuario");
		Integer id = usuario.getId();
		List<Notificacao> notificacoes = notificacaoDAO.recuperarNotificacao();
		request.setAttribute("notificacoes", notificacoes);
		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/instituicao/notificacoes.jsp");
		dispatcher.forward(request, response);
	}

	private void mostrarTelaNotificacoesDoAtendente(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuario");
		Integer id = usuario.getId();
		List<Notificacao> notificacoes = notificacaoDAO.recuperarNotificacao();
		request.setAttribute("notificacoes", notificacoes);
		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/atendente/notificacoes.jsp");
		dispatcher.forward(request, response);

	}
	
	private void mostrarTelaNotificacoesDoPaciente(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuario");
		Integer id = usuario.getId();
		List<Notificacao> notificacoes = notificacaoDAO.recuperarNotificacao();
		request.setAttribute("notificacoes", notificacoes);
		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/paciente/notificacoes.jsp");
		dispatcher.forward(request, response);

	}

	// PACIENTE

	private void mostrarTelaCadastroDoPaciente(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		HttpSession sessao = request.getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuario");
		Integer id = usuario.getId();
		List<Notificacao> notificacoes = notificacaoDAO.recuperarNotificacao();
		request.setAttribute("notificacoes", notificacoes);
		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/paciente/cadastro.jsp");
		dispatcher.forward(request, response);

	}

	private void mostrarCardConsulta(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/paciente/card-consulta.jsp");
		dispatcher.forward(request, response);

	}

	private void mostrarTelaListarConsulta(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/paciente/listar-consulta.jsp");
		dispatcher.forward(request, response);

	}

	private void mostrarModalConsulta(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		Integer id = Integer.parseInt(request.getParameter("id"));
		Consulta consulta = consultaDAO.recuperarConsultaPorId(id);
		request.setAttribute("consulta", consulta);

		Integer idEspecialidade = consulta.getEspecialidadeProfissional().getId();
		EspecialidadeProfissional especialidade = especialidadeDAO
				.recuperarEspecialidadeDaInstituicaoPorId(idEspecialidade);
		request.setAttribute("especialidade", especialidade);

		Integer idProfissional = consulta.getProfissionalDeSaude().getId();
		ProfissionalDeSaude profissional = profissionalDAO.recuperarProfissionalPorId(idProfissional);
		request.setAttribute("profissional", profissional);

		Integer idInstituicao = consulta.getInstituicao().getId();
		Instituicao instituicao = instituicaoDAO.recuperarInstituicaoPorId(idInstituicao);
		request.setAttribute("instituicao", instituicao);

	}

	// SISTEMA

	private void mostrarTelaListarNotificacao(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/listar-notificacao.jsp");
		dispatcher.forward(request, response);

	}

	private void mostrarModalNotificacao(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/modal-notificacao.jsp");
		dispatcher.forward(request, response);

	}

	private void confirmarLogin(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		String usuarioInvalido = null;
		String emailUsuario = request.getParameter("email");
		String senhaUsuario = request.getParameter("senha");
		System.out.println(emailUsuario + ", " + senhaUsuario);
		boolean existe = usuarioDAO.verificarUsuario(emailUsuario, senhaUsuario);

		if (existe) {

			HttpSession sessao = request.getSession();
			Usuario usuario = usuarioDAO.recuperarUsuarioPorEmail(emailUsuario);
			sessao.setAttribute("usuario", usuario);
			urlFoto = usuario.getUrlFoto();
			request.getSession().setAttribute("urlFoto", urlFoto);
			response.sendRedirect("home");

		} else {

			usuarioInvalido = "invalido";

			request.setAttribute("usuarioInvalido", usuarioInvalido);
			response.sendRedirect("login");
		}

	}

	private void finalizarLogin(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		request.getSession().invalidate();

		response.sendRedirect("index");

	}

}
