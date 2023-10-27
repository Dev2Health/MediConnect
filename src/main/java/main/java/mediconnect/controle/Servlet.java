package main.java.mediconnect.controle;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.mediconnect.modelo.dao.atendente.AtendenteDAO;
import main.java.mediconnect.modelo.dao.atendente.AtendenteDAOImpl;
import main.java.mediconnect.modelo.dao.conquista.ConquistaDAO;
import main.java.mediconnect.modelo.dao.conquista.ConquistaDAOImpl;
import main.java.mediconnect.modelo.dao.consulta.ConsultaDAO;
import main.java.mediconnect.modelo.dao.consulta.ConsultaDAOImpl;
import main.java.mediconnect.modelo.dao.endereco.EnderecoDAO;
import main.java.mediconnect.modelo.dao.endereco.EnderecoDAOImpl;
import main.java.mediconnect.modelo.dao.especialidadeProfissional.EspecialidadeProfissionalDAO;
import main.java.mediconnect.modelo.dao.especialidadeProfissional.EspecialidadeProfissionalDAOImpl;
import main.java.mediconnect.modelo.dao.instituicao.InstituicaoDAO;
import main.java.mediconnect.modelo.dao.instituicao.InstituicaoDAOImpl;
import main.java.mediconnect.modelo.dao.paciente.PacienteDAO;
import main.java.mediconnect.modelo.dao.paciente.PacienteDAOImpl;
import main.java.mediconnect.modelo.dao.profissionalDeSaude.ProfissionalDeSaudeDAO;
import main.java.mediconnect.modelo.dao.profissionalDeSaude.ProfissionalDeSaudeDAOImpl;
import main.java.mediconnect.modelo.entidade.atendente.Atendente;
import main.java.mediconnect.modelo.entidade.consulta.Consulta;
import main.java.mediconnect.modelo.entidade.endereco.Endereco;
import main.java.mediconnect.modelo.entidade.especialidadeProfissional.EspecialidadeProfissional;
import main.java.mediconnect.modelo.entidade.instituicao.Instituicao;
import main.java.mediconnect.modelo.entidade.paciente.Paciente;
import main.java.mediconnect.modelo.entidade.profissionalDeSaude.ProfissionalDeSaude;
import main.java.mediconnect.modelo.enumeracao.consulta.StatusConsulta;


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

	
	public void init() {
		
		especialidadeDAO = new EspecialidadeProfissionalDAOImpl();
		conquistaDAO = new ConquistaDAOImpl();
		pacienteDAO = new PacienteDAOImpl();
		instituicaoDAO = new InstituicaoDAOImpl();
		profissionalDAO = new ProfissionalDeSaudeDAOImpl();
		enderecoDAO = new EnderecoDAOImpl();
		atendenteDAO = new AtendenteDAOImpl();
		consultaDAO = new ConsultaDAOImpl();	
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
				mostrarTelaInicialLogadoPaciente(request, response);
				break;
				
			case "/home-instituicao":
				mostrarTelaInicialLogadoInstituicao(request, response);
				break;
				
			case "/home-atendente":
				mostrarTelaInicialLogadoAtendente(request, response);
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
				
			//TELA CADASTRO PACIENTE 
			
			case "/inserir-paciente":
				inserirPaciente(request, response);
				break;
						
			// TELA LOGIN
				
			case "/esqueci-senha":
				mostrarTelaEsqueciSenha(request, response);
				break;

				
			// TELA ESQUECI SENHA
				
			
				
			
			// TELA PERFIL PACIENTE	
				
			case "/perfil-paciente":
				mostrarTelaPerfilPaciente(request, response);
				break;	
				
						
			case "/editar-perfil":
				mostrarTelaEditarPerfilPaciente(request, response);
				break;	
				
			case "/conquistas-paciente":
				mostrarTelaConquistasPaciente(request, response);
				break;	
				
			case "/consultas":
				mostrarTelaConsultasPaciente(request, response);
				break;	
				
			// TELA EDITAR PERFIL PACIENTE
				
			case "/editar-paciente":
				editarPaciente(request, response);
				break;
				
				
			// TELA PERFIL ATENDENTE 
				
			case "/perfil-atendente":
				mostrarTelaPerfilAtendente(request, response);
				break;		
				
			case "/editar-perfil-atendente":
				mostrarTelaEditarPerfilAtendente(request, response);
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
				
			case "/editar-atendente":
				editarAtendente(request, response);
				break;
				
			// TELA PERFIL INSTITUICAO	
				
			case "/perfil-instituicao":
				mostrarTelaPerfilInstituicao(request, response);
				break;
				
			case "/editar-perfil-instituicao":
				mostrarTelaEditarPerfilInstituicao(request, response);
				break;	
				
			// TELA EDITAR PERFIL INSTITUICAO 
				
			case "/editar-instituicao":
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
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("sobre.jsp");
		dispatcher.forward(request, response);
	}
	
	private void mostrarTelaLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		dispatcher.forward(request, response);
	}
	
	private void mostrarTelaInicialLogadoPaciente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Integer id = Integer.parseInt(request.getParameter("id"));
		
		List<Consulta> consultas = consultaDAO.recuperarConsultasAgendadasViaPacientePorId(id);
		List<Instituicao> instituicoes = instituicaoDAO.recuperarInstituicoesRecentesPorIdPaciente(id);
		
		if(consultas != null) {
			
			request.setAttribute("consultas", consultas);
			
		} else if(instituicoes != null) {
			
			request.setAttribute("instituicoes", instituicoes);
			
		}
				
		RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
		dispatcher.forward(request, response);
	}
	
	private void mostrarTelaInicialLogadoInstituicao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Integer id = Integer.parseInt(request.getParameter("id"));
		
		
		//Cada info da tela inicial logada da institui��o � uma query diferente?
				
		RequestDispatcher dispatcher = request.getRequestDispatcher("home-instituicao.jsp");
		dispatcher.forward(request, response);
	}
	
	private void mostrarTelaInicialLogadoAtendente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Integer id = Integer.parseInt(request.getParameter("id"));

		
		//Cada info da tela inicial logada ddo atendente � uma query diferente?
				
		RequestDispatcher dispatcher = request.getRequestDispatcher("home-atendente.jsp");
		dispatcher.forward(request, response);
	}
	
	private void mostrarTelaCadastro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("cadastro.jsp");
		dispatcher.forward(request, response);
	}
	
	// TELA CADASTRO 
	
	private void mostrarTelaCadastrarInstituicao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/content/instituicao/cadastro-1.jsp");
		dispatcher.forward(request, response);
	}
	private void mostrarTelaCadastrarEndereco(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/content/instituicao/cadastro-2.jsp");
		dispatcher.forward(request, response);
	}
	
	private void mostrarTelaCadastrarPaciente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/content/paciente/cadastrar-paciente.jsp");
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
		
		Endereco endereco = null;
		
		String cep = request.getParameter("cep");
		String estado = request.getParameter("estado");
		String cidade = request.getParameter("cidade");
		String bairro = request.getParameter("bairro");
		String logradouro = request.getParameter("logradouro");
		int numero = Integer.parseInt(request.getParameter("numero"));
		
		endereco = new Endereco(cep, numero, logradouro, cidade, estado, bairro);

		enderecoDAO.inserirEndereco(endereco);
		Integer idInstituicao = Integer.parseInt(request.getParameter("instituicao"));
		Instituicao instituicao = instituicaoDAO.recuperarInstituicaoPorId(idInstituicao);
		instituicao.setEndereco(endereco);
		instituicaoDAO.atualizarInstituicao(instituicao);
		response.sendRedirect("perfil-instituicao");
	}
	
	
	//TELA CADASTRO PACIENTE
	
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
		
		paciente = new Paciente(email, senha, ehAtivo, nome, sobrenome, cpf, dataNascimento, telefone);
		
		pacienteDAO.inserirPaciente(paciente);
		response.sendRedirect("perfil-paciente");
		
	}
	
	// TELA LOGIN 
	
	private void mostrarTelaEsqueciSenha(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("esqueci-senha.jsp");
		dispatcher.forward(request, response);
		
	}

	// TELA PERFIL PACIENTE 
	
	private void mostrarTelaPerfilPaciente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean concluido = false;
		int id = 1;
		Paciente paciente = pacienteDAO.recuperarPacientePorId(1);
		while(!concluido) {
		paciente = pacienteDAO.recuperarPacientePorId(id);
		if (paciente == null) 
			id++;
		 else 
			concluido = true;
		
		}
		
		request.setAttribute("paciente", paciente);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/content/paciente/perfil.jsp");
		dispatcher.forward(request, response);
				
	}
		
	private void mostrarTelaEditarPerfilPaciente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Integer id = Integer.parseInt(request.getParameter("id"));	

		Paciente paciente = pacienteDAO.recuperarPacientePorId(id);
		
		request.setAttribute("paciente", paciente);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/content/paciente/editar-perfil.jsp");
		dispatcher.forward(request, response);
		
	}
	
	private void editarPaciente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Integer id = Integer.parseInt(request.getParameter("id"));
		
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
		//nomenclatura do jsp dos perfils vai dar problema?

	}
	
	private void mostrarTelaConquistasPaciente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Integer id = Integer.parseInt(request.getParameter("id"));
		
		// query que retorna as conquistas do paciente vai na classe intermediaria?

		//List<Conquista> conquistas = conquistaDAO.filtrarConquistaViaPacienteDoPacientePorStatus();
		//request.setAttribute("conquistas", conquistas);
		RequestDispatcher dispatcher = request.getRequestDispatcher("conquistas-paciente.jsp");

		dispatcher.forward(request, response);
		
	}
	
	private void mostrarTelaConsultasPaciente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Integer id = Integer.parseInt(request.getParameter("id"));
		List<Consulta> consultas = consultaDAO.recuperarConsultasViaPacientePorId(1);
			
		if(consultas != null) {
			
			request.setAttribute("consultas", consultas);
			
		} 
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("consultas.jsp");
		dispatcher.forward(request, response);
		
	}
	
	// TELA AGENDAR CONSULTA PACIENTE
	
	private void mostrarTelaAgendarConsultas(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/content/paciente/cadastrar-consulta.jsp");
		dispatcher.forward(request, response);
		
	}
	
	private void inserirConsulta(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ServletException {
		
		Consulta consulta = null;

		LocalTime horarioConsulta = LocalTime.parse(request.getParameter("horario")); 
		LocalDate dataConsulta = LocalDate.parse(request.getParameter("data"));
		Integer idEspecialidade = Integer.parseInt(request.getParameter("especialidade"));
		Integer idInstituicao = Integer.parseInt(request.getParameter("instituicao"));
		Integer idProfissional = Integer.parseInt(request.getParameter("profissional"));
		Integer idPaciente = Integer.parseInt(request.getParameter("paciente"));
//		String descricao = request.getParameter("descricao");
		
		StatusConsulta status = StatusConsulta.AGENDADA;
		
		EspecialidadeProfissional especialidade = especialidadeDAO.recuperarEspecialidadePorId(idEspecialidade);	
		
		Instituicao instituicao = instituicaoDAO.recuperarInstituicaoPorId(idInstituicao);
		
		ProfissionalDeSaude profissional = profissionalDAO.recuperarProfissionalPorId(idProfissional);
		
		Paciente paciente = pacienteDAO.recuperarPacientePorId(idPaciente);
		
		consulta = new Consulta(especialidade, instituicao, profissional, dataConsulta, horarioConsulta, paciente, status);
		
		consultaDAO.inserirConsulta(consulta);
		response.sendRedirect("consultas");
		
	}
	
	// TELA PERFIL ATENDENTE
	
	private void mostrarTelaPerfilAtendente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		boolean concluido = false;
		int id = 1;
		Atendente atendente = atendenteDAO.recuperarAtendentePorId(1);
		while(!concluido) {
		atendente = atendenteDAO.recuperarAtendentePorId(id);
		if (atendente == null) 
			id++;
		 else 
			concluido = true;
		
		}
//
//		if (request.getParameter("id") != null)
//			id = Integer.parseInt(request.getParameter("id"));
			
		atendente = atendenteDAO.recuperarAtendentePorId(id);
		Instituicao instituicao = atendente.getInstituicao();
		Endereco endereco = instituicao.getEndereco();
		
		request.setAttribute("atendente", atendente);
		request.setAttribute("instituicao", instituicao);
		request.setAttribute("endereco", endereco);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/content/atendente/perfil.jsp");
		dispatcher.forward(request, response);
		
	}
	
	private void mostrarTelaEditarPerfilAtendente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Integer id = Integer.parseInt(request.getParameter("id"));	

		Atendente atendente = atendenteDAO.recuperarAtendentePorId(id);
		
		request.setAttribute("paciente", atendente);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/content/atendente/editar-perfil.jsp");
		dispatcher.forward(request, response);
		
	}
	
	private void editarAtendente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Integer id = Integer.parseInt(request.getParameter("id"));
		
		Atendente atendente = atendenteDAO.recuperarAtendentePorId(id);
		
		String email = request.getParameter("email");
		
		atendente.setEmail(email);
		
		atendenteDAO.atualizarAtendente(atendente);
		response.sendRedirect("perfil");
	
	}
	
	private void mostrarTelaVerConsultas(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("consultas-atendente.jsp");
		dispatcher.forward(request, response);
		
	}
	
	private void mostrarTelaVerPacientesCadastrados(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Integer id = Integer.parseInt(request.getParameter("id"));
		
		List<Paciente> pacientes = pacienteDAO.recuperarPacientesCadastradosViaInstituicaoPorIdAtendente(id);	
		
		request.setAttribute("pacientes", pacientes);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("pacientes-cadastrados.jsp");
		dispatcher.forward(request, response);
		
	}
	
	// TELA PERFIL INSTITUICAO
	
	private void mostrarTelaPerfilInstituicao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
//		Integer id = Integer.parseInt(request.getParameter("id"));
		boolean concluido = false;
		int id = 1;
		Instituicao instituicao = instituicaoDAO.recuperarInstituicaoPorId(1);
		while(!concluido) {
		instituicao = instituicaoDAO.recuperarInstituicaoPorId(id);
		if (instituicao == null) 
			id++;
		 else 
			concluido = true;
		
		}
		
		request.setAttribute("instituicao", instituicao);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/content/instituicao/perfil.jsp");
		dispatcher.forward(request, response);
		
	}
	
	private void mostrarTelaEditarPerfilInstituicao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Integer id = Integer.parseInt(request.getParameter("id"));
		Instituicao instituicao = instituicaoDAO.recuperarInstituicaoPorId(id);
		
		request.setAttribute("instituicao", instituicao);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("editar-perfil-instituicao.jsp");
		dispatcher.forward(request, response);
		
	}
	
	private void editarInstituicao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Integer id = Integer.parseInt(request.getParameter("id"));
		
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
		//atualizar endereco antes de inserir na instituicao sendo editada??
			
		instituicaoDAO.atualizarInstituicao(new Instituicao(endereco, razaoSocial, nomeFantasia, email, senha));
		response.sendRedirect("perfil-instituicao");
		//nomenclatura do jsp dos perfils ta certo?

	}
	
	private void mostrarTelaAtendentesInstituicao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Integer id = Integer.parseInt(request.getParameter("id"));
		
		List<Atendente> atendentes = atendenteDAO.recuperarListaDeAtendentes(id);
		
		request.setAttribute("atendentes", atendentes);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("atendentes-instituicao.jsp");
		dispatcher.forward(request, response);
		
	}
	
	// TELA CADASTRAR ATENDENTE 
	
	private void mostrarTelaCadastrarAtendente(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ServletException {
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/content/instituicao/cadastrar-atendente.jsp");
		dispatcher.forward(request, response);
		
	}
	
	private void inserirAtendente(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ServletException {
		
		Integer id = 3;
		if (request.getParameter("id") != null)
			id = Integer.parseInt(request.getParameter("id"));
		
		Atendente atendente = null;

		String nome = request.getParameter("nome");
		String sobrenome = request.getParameter("sobrenome");
		String cpf = request.getParameter("cpf");
		String ctps = request.getParameter("ctps");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		LocalDate dataCadastro = LocalDate.parse(request.getParameter("data")); 
		Instituicao instituicao = instituicaoDAO.recuperarInstituicaoPorId(id);
		boolean ehAtivo = true;
		
		atendente = new Atendente(email, senha, ehAtivo, nome, sobrenome, cpf, dataCadastro, instituicao, ctps);
		
		atendenteDAO.inserirAtendente(atendente);
		
		response.sendRedirect("perfil-atendente");
		
	}
	
	private void mostrarTelaEspecialidadesInstituicao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Integer id = Integer.parseInt(request.getParameter("id"));
		
		List<EspecialidadeProfissional> especialidades = especialidadeDAO.recuperarEspecialidadesProfissionaisPorId(id);
		
		request.setAttribute("especialidade", especialidades);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("especialidades-instituicao.jsp");
		dispatcher.forward(request, response);
		
	}
	
	private void inserirEspecialidade(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ServletException {
		
//		Integer id = Integer.parseInt(request.getParameter("id"));
		
//		Instituicao instituicao = instituicaoDAO.recuperarInstituicaoPorId(id);
//		ProfissionalDeSaude profissional = profissionalDAO.recuperarProfissionalPorIdInstituicao(id);
//		
		EspecialidadeProfissional especialidade = null;
		
		String nome = request.getParameter("nome");
		
		especialidade = new EspecialidadeProfissional(nome);
		
		especialidadeDAO.inserirEspecialidadeProfissional(especialidade);
		
//		instituicao.adicionarEspecialidadeProfissional(especialidade);
//		
//		instituicaoDAO.atualizarInstituicao(instituicao);
//		
//		profissional.setEspecialidadeProfissional(especialidade);
//		
//		profissionalDAO.atualizarProfissionalDeSaude(profissional);
//		
		response.sendRedirect("especialidades-instituicao");
		
	}
	
	private void mostrarTelaCadastrarProfissional(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/content/instituicao/cadastrar-profissional.jsp");
		dispatcher.forward(request, response);
		
	}
	private void mostrarTelaCadastrarEspecialidade(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/content/instituicao/cadastrar-especialidade.jsp");
		dispatcher.forward(request, response);
		
	}
	
	private void inserirProfissional(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ServletException {
		
//		Integer id = Integer.parseInt(request.getParameter("id"));
		
		
		
		ProfissionalDeSaude profissional = null;
		
//		String nome = request.getParameter("nome");
//		String sobrenome = request.getParameter("sobrenome");
//		Integer idEspecialidade = Integer.parseInt(request.getParameter("especialidade"));
//		Integer idInstituicao = Integer.parseInt(request.getParameter("instituicao"));
//		Instituicao instituicao = instituicaoDAO.recuperarInstituicaoPorId(idInstituicao);
//		EspecialidadeProfissional especialidade = especialidadeDAO.recuperarEspecialidadePorId(idEspecialidade);
//		profissional = new ProfissionalDeSaude(nome, sobrenome, especialidade, instituicao);
		
		String nome = request.getParameter("nome");
		String sobrenome = request.getParameter("sobrenome");
		profissional = new ProfissionalDeSaude(nome, sobrenome);
		
		profissionalDAO.inserirProfissionalDeSaude(profissional);
		
		response.sendRedirect("perfil-instituicao");
		
	}
	
	

	
}