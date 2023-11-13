package main.java.br.senac.mediconnect.controle;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import main.java.br.senac.mediconnect.controle.util.ConverterImagem;
import main.java.br.senac.mediconnect.controle.util.ConverterImagemImpl;
import main.java.br.senac.mediconnect.modelo.dao.atendente.AtendenteDAO;
import main.java.br.senac.mediconnect.modelo.dao.atendente.AtendenteDAOImpl;
import main.java.br.senac.mediconnect.modelo.dao.conquista.ConquistaDAO;
import main.java.br.senac.mediconnect.modelo.dao.conquista.ConquistaDAOImpl;
import main.java.br.senac.mediconnect.modelo.dao.consulta.ConsultaDAO;
import main.java.br.senac.mediconnect.modelo.dao.consulta.ConsultaDAOImpl;
import main.java.br.senac.mediconnect.modelo.dao.endereco.EnderecoDAO;
import main.java.br.senac.mediconnect.modelo.dao.endereco.EnderecoDAOImpl;
import main.java.br.senac.mediconnect.modelo.dao.especialidadeProfissional.EspecialidadeProfissionalDAO;
import main.java.br.senac.mediconnect.modelo.dao.especialidadeProfissional.EspecialidadeProfissionalDAOImpl;
import main.java.br.senac.mediconnect.modelo.dao.instituicao.InstituicaoDAO;
import main.java.br.senac.mediconnect.modelo.dao.instituicao.InstituicaoDAOImpl;
import main.java.br.senac.mediconnect.modelo.dao.paciente.PacienteDAO;
import main.java.br.senac.mediconnect.modelo.dao.paciente.PacienteDAOImpl;
import main.java.br.senac.mediconnect.modelo.dao.pacienteSelo.PacienteSeloDAO;
import main.java.br.senac.mediconnect.modelo.dao.pacienteSelo.PacienteSeloDAOImpl;
import main.java.br.senac.mediconnect.modelo.dao.pacienteConquista.PacienteConquistaDAO;
import main.java.br.senac.mediconnect.modelo.dao.pacienteConquista.PacienteConquistaDAOImpl;
import main.java.br.senac.mediconnect.modelo.dao.profissionalDeSaude.ProfissionalDeSaudeDAO;
import main.java.br.senac.mediconnect.modelo.dao.profissionalDeSaude.ProfissionalDeSaudeDAOImpl;
import main.java.br.senac.mediconnect.modelo.dao.notificacao.NotificacaoDAO;
import main.java.br.senac.mediconnect.modelo.dao.notificacao.NotificacaoDAOImpl;
import main.java.br.senac.mediconnect.modelo.dao.usuario.UsuarioDAO;
import main.java.br.senac.mediconnect.modelo.dao.usuario.UsuarioDAOImpl;
import main.java.br.senac.mediconnect.modelo.entidade.atendente.Atendente;
import main.java.br.senac.mediconnect.modelo.entidade.conquista.Conquista;
import main.java.br.senac.mediconnect.modelo.entidade.consulta.Consulta;
import main.java.br.senac.mediconnect.modelo.entidade.endereco.Endereco;
import main.java.br.senac.mediconnect.modelo.entidade.especialidadeProfissional.EspecialidadeProfissional;
import main.java.br.senac.mediconnect.modelo.entidade.instituicao.Instituicao;
import main.java.br.senac.mediconnect.modelo.entidade.paciente.Paciente;
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
	private PacienteSeloDAO pacienteSeloDAO;
	private UsuarioDAO usuarioDAO;
	private NotificacaoDAO notificadaoDAO;

	private ConverterImagem converterImagem;
	private byte [] fotoPerfil = null;

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
		converterImagem = new ConverterImagemImpl();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();

		try {

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

			case "/esqueci-senha":
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
				editarPaciente(request, response);
				break;

			case "/consultas-atendente":
				mostrarTelaVerConsultas(request, response);
				break;

			case "/agendar-consulta":
				mostrarTelaAgendarConsultas(request, response);
				break;

			case "/inserir-consulta":
				inserirConsulta(request, response);
				break;

			case "/pacientes-atendente":
				mostrarTelaVerPacientesCadastrados(request, response);
				break;

			// TELA EDITAR PERFIL ATENDENTE

			case "/atualizar-atendente":
				editarAtendente(request, response);
				break;


			// TELA EDITAR PERFIL INSTITUICAO

			case "/atualizar-instituicao":
				editarInstituicao(request, response);
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
	
	private void deletarUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession sessao = request.getSession();
		
		Usuario usuario = (Usuario) sessao.getAttribute("usuario");
		Integer id = usuario.getId();
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/usuario-login.jsp");
		dispatcher.forward(request, response);	 //para onde dispatch quando "deletar" usuario
	}

	private void mostrarTelaInicial(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession sessao = request.getSession();
		
		if (sessao.getAttribute("usuario") instanceof Paciente) {
			Usuario usuario = (Usuario) sessao.getAttribute("usuario");
			Integer id = usuario.getId();
			
			Paciente paciente = pacienteDAO.recuperarPacientePorId(id);
			
			request.setAttribute("paciente", paciente);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/paciente/home.jsp");
			dispatcher.forward(request, response);
			
			List<Consulta> consultas = consultaDAO.recuperarConsultasAgendadasViaPacientePorId(id);
			List<Instituicao> instituicoes = instituicaoDAO.recuperarInstituicoesRecentesPorIdPaciente(id);

			if (consultas != null) {
				request.setAttribute("consultas", consultas);
			}  
			
			if (instituicoes != null) {
				request.setAttribute("instituicoes", instituicoes);
			}
		}
		
		if (sessao.getAttribute("usuario") instanceof Instituicao) {
			Usuario usuario = (Usuario) sessao.getAttribute("usuario");
			Integer id = usuario.getId();

			Instituicao instituicao = instituicaoDAO.recuperarInstituicaoPorId(id);	
			
			request.setAttribute("instituicao", instituicao);
			
			//Cada info da tela inicial logada da institui��o � uma query diferente?	
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/instituicao/home.jsp");
			dispatcher.forward(request, response);
		}
		
		if (sessao.getAttribute("usuario") instanceof Atendente) {
			Usuario usuario = (Usuario) sessao.getAttribute("usuario");
			Integer id = usuario.getId();
			
			Atendente atendente = atendenteDAO.recuperarAtendentePorId(id);
			
			request.setAttribute("atendente", atendente);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/atendente/home.jsp");
			dispatcher.forward(request, response);
		}
		
					
		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/paciente/perfil.jsp");
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

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/paciente/cadastrar-paciente.jsp");
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

		instituicao = new Instituicao(cnpj, razaoSocial, nomeFantasia, email, senha, ehAtivo);

		instituicaoDAO.inserirInstituicao(instituicao);
		response.sendRedirect("cadastrar-instituicao-2");
	}

	private void inserirEndereco(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
		HttpSession sessao = request.getSession();

		Endereco endereco = null;

		String cep = request.getParameter("cep");
		String estado = request.getParameter("estado");
		String cidade = request.getParameter("cidade");
		String bairro = request.getParameter("bairro");
		String logradouro = request.getParameter("logradouro");
		int numero = Integer.parseInt(request.getParameter("numero"));

		endereco = new Endereco(cep, numero, logradouro, cidade, estado, bairro);

		enderecoDAO.inserirEndereco(endereco);
		
		Usuario usuario = (Usuario) sessao.getAttribute("usuario");
		Integer id = usuario.getId();

		Instituicao instituicao = instituicaoDAO.recuperarInstituicaoPorId(id);
		
		instituicao.setEndereco(endereco);
		instituicaoDAO.atualizarInstituicao(instituicao);
		response.sendRedirect("perfil-instituicao");
	}

	// TELA CADASTRO PACIENTE

	private void inserirPaciente(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		Paciente paciente = null;
		Part parteFoto = null;

		String nome = request.getParameter("nome");
		String sobrenome = request.getParameter("sobrenome");
		String cpf = request.getParameter("cpf");
		boolean ehAtivo = true;
		LocalDate dataNascimento = LocalDate.parse(request.getParameter("data"));
		String email = request.getParameter("email");
		String telefone = request.getParameter("telefone");
		String senha = request.getParameter("senha");
		
		parteFoto = request.getPart("foto-perfil");
		String extensao = parteFoto.getContentType();
		byte[] binarioFoto = ConversorImagem.obterBytesImagem(parteFoto);
		Foto fotoPerfil = new Foto(binarioFoto, extensao);
		fotoDAO.inserirFoto(fotoPerfil);		

		paciente = new Paciente(email, senha, ehAtivo, nome, sobrenome, cpf, dataNascimento, telefone, fotoPerfil);

		pacienteDAO.inserirPaciente(paciente);
		response.sendRedirect("perfil-paciente");
		
	}
	
	// TELA LOGIN 
	
	private void mostrarTelaEsqueciSenha(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/esqueceu-sua-senha.jsp");
		dispatcher.forward(request, response);
		
	}

	// TELA PERFIL PACIENTE

	private void mostrarTelaPerfil(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession sessao = request.getSession();
		
		if (sessao.getAttribute("usuario") instanceof Paciente) {
			Usuario usuario = (Usuario) sessao.getAttribute("usuario");
			Integer id = usuario.getId();
			
			Paciente paciente = pacienteDAO.recuperarPacientePorId(id);
			
			request.setAttribute("paciente", paciente);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/paciente/perfil.jsp");
			dispatcher.forward(request, response);	
		}
		
		if (sessao.getAttribute("usuario") instanceof Instituicao) {
			Usuario usuario = (Usuario) sessao.getAttribute("usuario");
			Integer id = usuario.getId();
			
			Instituicao instituicao = instituicaoDAO.recuperarInstituicaoPorId(id);
			
			request.setAttribute("instituicao", instituicao);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/instituicao/perfil.jsp");
			dispatcher.forward(request, response);
		}
		
		if (sessao.getAttribute("usuario") instanceof Atendente ) {
			Usuario usuario = (Usuario) sessao.getAttribute("usuario");
			Integer id = usuario.getId();
			
			Atendente atendente = atendenteDAO.recuperarAtendentePorId(id);
			
			request.setAttribute("atendente", atendente);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/atendente/perfil.jsp");
			dispatcher.forward(request, response);
		}

	}

	private void mostrarTelaEditarPerfil(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		boolean concluido = false;
//		int id = 1;
//		Paciente paciente = pacienteDAO.recuperarPacientePorId(1);
//		while (!concluido) {
//			paciente = pacienteDAO.recuperarPacientePorId(id);
//			if (paciente == null)
//				id++;
//			else
//				concluido = true;
//		}
//		
//		Date dataNascimento = java.sql.Date.valueOf(paciente.getDataNasciento());
//		request.setAttribute("paciente", paciente);
//		request.setAttribute("dataNascimento", dataNascimento);
//		request.setAttribute("dataNascimento", paciente.getDataNasciento());
//		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/paciente/editar-perfil.jsp");
//		dispatcher.forward(request, response);
//
//	}
		
		HttpSession sessao = request.getSession();
		
		if (sessao.getAttribute("usuario") instanceof Paciente) {
			Usuario usuario = (Usuario) sessao.getAttribute("usuario");
			Integer id = usuario.getId();
			
			Paciente paciente = pacienteDAO.recuperarPacientePorId(id);
			
			request.setAttribute("paciente", paciente);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/paciente/editar-perfil.jsp");
			dispatcher.forward(request, response);	
		}
		
		if (sessao.getAttribute("usuario") instanceof Instituicao) {
			Usuario usuario = (Usuario) sessao.getAttribute("usuario");
			Integer id = usuario.getId();
			
			Instituicao instituicao = instituicaoDAO.recuperarInstituicaoPorId(id);
			
			request.setAttribute("instituicao", instituicao);
			
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

	private void editarPaciente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession sessao = request.getSession();

		Usuario usuario = (Usuario) sessao.getAttribute("usuario");
		Integer id = usuario.getId();
		
		Paciente paciente = pacienteDAO.recuperarPacientePorId(id);

		String nome = request.getParameter("nome");
		String sobrenome = request.getParameter("sobrenome");
		String email = request.getParameter("email");
		String telefone = request.getParameter("telefone");
		String senha = request.getParameter("senha");

		paciente.setNome(nome);
		paciente.setSobrenome(sobrenome);
		paciente.setEmail(email);
		paciente.setTelefone(telefone);
		paciente.setSenha(senha);

		pacienteDAO.atualizarPaciente(paciente);
		response.sendRedirect("perfil");
		// nomenclatura do jsp dos perfils vai dar problema?

	}

	private void mostrarTelaConquistasPaciente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession sessao = request.getSession();

		Usuario usuario = (Usuario) sessao.getAttribute("usuario");
		Integer id = usuario.getId();
		
		List<Conquista> conquistas = pacienteConquistaDAO.recuperarConquistasPacientePorId(id);

		request.setAttribute("conquistas", conquistas);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/paciente/tela-conquistas.jsp");

		dispatcher.forward(request, response);

	}

	private void mostrarTelaConsultasPaciente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession sessao = request.getSession();

		Usuario usuario = (Usuario) sessao.getAttribute("usuario");
		Integer id = usuario.getId();
		
		List<Consulta> consultas = consultaDAO.recuperarConsultasViaPacientePorId(id);

		if (consultas != null) {

			request.setAttribute("consultas", consultas);

		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("consultas.jsp");
		dispatcher.forward(request, response);

	}
	private void mostrarTelaConsulta(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession sessao = request.getSession();
		
		Usuario usuario = (Usuario) sessao.getAttribute("usuario");
		Integer id = usuario.getId();
		
		Paciente paciente = pacienteDAO.recuperarPacientePorId(id);
		
		boolean concluido2 = false;
		int idConsulta = 1;
		Consulta consulta = consultaDAO.filtrarConsultaViaPacientePorIdDaConsulta(1, paciente.getId());
		while(!concluido2) {
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

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/paciente/cadastrar-consulta.jsp");
		dispatcher.forward(request, response);

	}

	private void inserirConsulta(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
		HttpSession sessao = request.getSession();

		Consulta consulta = null;

		LocalTime horarioConsulta = LocalTime.parse(request.getParameter("horario"));
		LocalDate dataConsulta = LocalDate.parse(request.getParameter("data"));
		Integer idEspecialidade = Integer.parseInt(request.getParameter("especialidade"));
		Integer idInstituicao = Integer.parseInt(request.getParameter("instituicao"));
		Integer idProfissional = Integer.parseInt(request.getParameter("profissional"));
		String descricao = request.getParameter("descricao");
		
		Usuario usuario = (Usuario) sessao.getAttribute("usuario");
		Integer id = usuario.getId();
		
		Paciente paciente = pacienteDAO.recuperarPacientePorId(id);
		
//		String descricao = request.getParameter("descricao");

		StatusConsulta status = StatusConsulta.AGENDADA;

		EspecialidadeProfissional especialidade = especialidadeDAO.recuperarEspecialidadeDaInstituicaoPorId(idEspecialidade);

		Instituicao instituicao = instituicaoDAO.recuperarInstituicaoPorId(idInstituicao);

		ProfissionalDeSaude profissional = profissionalDAO.recuperarProfissionalPorId(idProfissional);

		consulta = new Consulta(especialidade, instituicao, profissional, dataConsulta, horarioConsulta, paciente,
				status, descricao);

		consultaDAO.inserirConsulta(consulta);
		response.sendRedirect("consultas");

	}

	private void editarAtendente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession sessao = request.getSession();

		Usuario usuario = (Usuario) sessao.getAttribute("usuario");
		Integer id = usuario.getId();

		Atendente atendente = atendenteDAO.recuperarAtendentePorId(id);

		String email = request.getParameter("email");

		atendente.setEmail(email);

		atendenteDAO.atualizarAtendente(atendente);
		response.sendRedirect("perfil");

	}

	private void mostrarTelaVerConsultas(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// Verificar o nome da rota quando tiver o arquivo JSP pronto
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/atendente/consultas.jsp");
		dispatcher.forward(request, response);

	}

	private void mostrarTelaVerPacientesCadastrados(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sessao = request.getSession();

		Usuario usuario = (Usuario) sessao.getAttribute("usuario");
		Integer id = usuario.getId();

		List<Paciente> pacientes = pacienteDAO.recuperarPacientesCadastradosViaInstituicaoPorIdAtendente(id);

		request.setAttribute("pacientes", pacientes);
		
		// Verificar o nome da rota quando tiver o arquivo JSP pronto
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/atendente/pacientes.jsp");
		dispatcher.forward(request, response);

	}
  
	private void editarInstituicao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sessao = request.getSession();

		Usuario usuario = (Usuario) sessao.getAttribute("usuario");
		Integer id = usuario.getId();

		Instituicao instituicao = instituicaoDAO.recuperarInstituicaoPorId(id);
		//recuperar a entidade e setar informa��es novas nela ou atualizar com new Entidade?
		

		Endereco endereco = enderecoDAO.recuperarEnderecoPorInstituicao(instituicao);

		String razaoSocial = request.getParameter("razaoSocial");
		String nomeFantasia = request.getParameter("nomeFantasia");
		String cep = request.getParameter("cep");
		String estado = request.getParameter("estado");
		String cidade = request.getParameter("cidade");
		String bairro = request.getParameter("bairro");
		String logradouro = request.getParameter("logradouro");
		int numero = Integer.parseInt(request.getParameter("numero"));
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");

		endereco.setCep(cep);
		endereco.setEstado(estado);
		endereco.setCidade(cidade);
		endereco.setBairro(bairro);
		endereco.setLogradouro(logradouro);
		endereco.setNumero(numero);

		enderecoDAO.atualizarEndereco(endereco);
		// atualizar endereco antes de inserir na instituicao sendo editada??

		instituicaoDAO.atualizarInstituicao(new Instituicao(endereco, razaoSocial, nomeFantasia, email, senha));
		response.sendRedirect("perfil-instituicao");
		// nomenclatura do jsp dos perfils ta certo?

	}

	private void mostrarTelaAtendentesInstituicao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sessao = request.getSession();

		Usuario usuario = (Usuario) sessao.getAttribute("usuario");
		Integer id = usuario.getId();

		List<Atendente> atendentes = atendenteDAO.recuperarListaDeAtendentes(id);

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
	
		Instituicao instituicao = instituicaoDAO.recuperarInstituicaoPorId(1);

		Atendente atendente = null;

		String nome = request.getParameter("nome");
		String sobrenome = request.getParameter("sobrenome");
		String cpf = request.getParameter("cpf");
		String ctps = request.getParameter("ctps");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		LocalDate dataCadastro = LocalDate.parse(request.getParameter("data"));
		boolean ehAtivo = true;

		atendente = new Atendente(email, senha, ehAtivo, nome, sobrenome, cpf, dataCadastro, instituicao, ctps, fotoPerfil);

		atendenteDAO.inserirAtendente(atendente);

		response.sendRedirect("perfil-atendente");

	}

	private void mostrarTelaEspecialidadesInstituicao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sessao = request.getSession();

		Usuario usuario = (Usuario) sessao.getAttribute("usuario");
		Integer id = usuario.getId();
		
		EspecialidadeProfissional especialidade = especialidadeDAO.recuperarEspecialidadeDaInstituicaoPorId(1);

		List<EspecialidadeProfissional> especialidades = especialidadeDAO.recuperarEspecialidadeProfissionalDaInstituicao();

		request.setAttribute("especialidades", especialidades);

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/instituicao/especialidades.jsp");
		dispatcher.forward(request, response);

	}

	private void inserirEspecialidade(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		HttpSession sessao = request.getSession();

		Usuario usuario = (Usuario) sessao.getAttribute("usuario");
		Integer id = usuario.getId();

		Instituicao instituicao = instituicaoDAO.recuperarInstituicaoPorId(id);
		ProfissionalDeSaude profissional = profissionalDAO.recuperarProfissionalPorIdInstituicao(id);
		
		EspecialidadeProfissional especialidade = null;

		String nome = request.getParameter("nome");

		especialidade = new EspecialidadeProfissional(nome);

		especialidadeDAO.inserirEspecialidadeProfissionalDaInstituicao(especialidade);

		instituicao.adicionarEspecialidadeProfissional(especialidade);
	
		instituicaoDAO.atualizarInstituicao(instituicao);
		
		profissional.setEspecialidadeProfissional(especialidade);
		
		profissionalDAO.atualizarProfissionalDeSaude(profissional);
		
		response.sendRedirect("especialidades-instituicao");

	}

	private void mostrarTelaCadastrarProfissional(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

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

	private void inserirProfissional(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		HttpSession sessao = request.getSession();

		Usuario usuario = (Usuario) sessao.getAttribute("usuario");
		Integer id = usuario.getId();

		ProfissionalDeSaude profissional = null;

		String nome = request.getParameter("nome");
		String sobrenome = request.getParameter("sobrenome");
		Integer idEspecialidade = Integer.parseInt(request.getParameter("especialidade"));
		Integer idInstituicao = Integer.parseInt(request.getParameter("instituicao"));
		Instituicao instituicao = instituicaoDAO.recuperarInstituicaoPorId(idInstituicao);
		EspecialidadeProfissional especialidade = especialidadeDAO.recuperarEspecialidadeDaInstituicaoPorId(idEspecialidade);
		profissional = new ProfissionalDeSaude(nome, sobrenome, especialidade, instituicao);
		
		profissionalDAO.inserirProfissionalDeSaude(profissional);
		
		response.sendRedirect("perfil-instituicao");
		
	}
	
	// INSTITUIÇÃO
	
	private void mostrarTelaCadastrarEditarProfissional(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ServletException {
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/instituicao/cadastrar-editar-profissional.jsp");
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
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/instituicao/modal-especialidade.jsp");
		dispatcher.forward(request, response);
		
	}

	private void mostrarTelaNotificacoesDaInstituicao(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ServletException {
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/instituicao/notificacoes.jsp");
		dispatcher.forward(request, response);
		
	}
	
	// PACIENTE
	
	private void mostrarTelaCadastroDoPaciente(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ServletException {
		
		
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
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/paciente/modal-consulta.jsp");
		dispatcher.forward(request, response);
		
	}
	
	private void mostrarTelaNotificacoesDoPaciente(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ServletException {
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/paciente/notificacoes.jsp");
		dispatcher.forward(request, response);
		
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
		boolean existe = usuarioDAO.verificarUsuario(emailUsuario, senhaUsuario);
		
		if(existe) {
			
			HttpSession sessao = request.getSession();
			Usuario usuario = usuarioDAO.recuperarUsuarioPorEmail(emailUsuario);
			sessao.setAttribute("usuario", usuario);
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

