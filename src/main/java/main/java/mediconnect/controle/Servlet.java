package main.java.mediconnect.controle;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.mediconnect.modelo.dao.atendente.AtendenteDAO;
import main.java.mediconnect.modelo.dao.atendente.AtendenteDAOImpl;
import main.java.mediconnect.modelo.dao.consulta.ConsultaDAO;
import main.java.mediconnect.modelo.dao.consulta.ConsultaDAOImpl;
import main.java.mediconnect.modelo.dao.endereco.EnderecoDAO;
import main.java.mediconnect.modelo.dao.endereco.EnderecoDAOImpl;
import main.java.mediconnect.modelo.dao.instituicao.InstituicaoDAO;
import main.java.mediconnect.modelo.dao.instituicao.InstituicaoDAOImpl;
import main.java.mediconnect.modelo.entidade.consulta.Consulta;
import main.java.mediconnect.modelo.entidade.endereco.Endereco;
import main.java.mediconnect.modelo.entidade.instituicao.Instituicao;


@WebServlet("/")
public class Servlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private InstituicaoDAO instituicaoDAO;
	private EnderecoDAO enderecoDAO;
	private AtendenteDAO atendenteDAO;
	private ConsultaDAO consultaDAO;
	
	

	public void init() {
		
		instituicaoDAO = new InstituicaoDAOImpl();
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
				
			// TELA CADASTRO 	
				
			case "/cadastro-instituicao":
				mostrarTelaCadastroInstituicao(request, response);
				break;

			case "/cadastro-paciente":
				mostrarTelaCadastroPaciente(request, response);
				break;	
			
			// TELA LOGIN
				
			case "/esqueci-senha":
				mostrarTelaEsqueciSenha(request, response);
				break;

				
			// TELA ESQUECI SENHA
				
			
				
			
			// TELA PERFIL PACIENTE	
				
						
			case "/editar-perfil":
				mostrarTelaEditarPerfilPaciente(request, response);
				break;	
				
			case "/conquistas":
				mostrarTelaConquistasPaciente(request, response);
				break;	
				
			case "/consultas":
				mostrarTelaConsultasPaciente(request, response);
				break;	
				
				
				
			// TELA PERFIL ATENDENTE 
				
			case "/editar-perfil-atendente":
				mostrarTelaEditarPerfilAtendente(request, response);
				break;	
				
			case "/consultas-atendente":
				mostrarTelaVerConsultas(request, response);
				break;	
				
			case "/pacientes-atendente":
				mostrarTelaVerPacientesCadastrados(request, response);
				break;	
				
			// TELA PERFIL INSTITUICAO	
				
			case "/perfil-instituicao":
				mostrarTelaPerfilInstituicao(request, response);
				break;
				
			case "/editar-perfil-instituicao":
				mostrarTelaEditarPerfilInstituicao(request, response);
				break;	
				
			case "/atendentes-instituicao":
				mostrarTelaAtendentesInstituicao(request, response);
				break;
				
			case "/especialidades-instituicao":
				mostrarTelaEspecialidadesInstituicao(request, response);
				break;

				
			default:
				listarContatos(request, response);
				break;
			}

		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listarContatos(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
		
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
	
	private void mostrarTelaCadastro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("cadastro.jsp");
		dispatcher.forward(request, response);
	}
	
	// TELA CADASTRO 
	
	private void mostrarTelaCadastroInstituicao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("cadastro-instituicao.jsp");
		dispatcher.forward(request, response);
	}
	
	private void mostrarTelaCadastroPaciente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("cadastro-paciente.jsp");
		dispatcher.forward(request, response);
	}
	
	// TELA CADASTRO INSTITUICAO 
	
	private void cadastrarInstituicao(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		
		Instituicao instituicao = new Instituicao();
		
		String razaoSocial = request.getParameter("razao");
		String nomeFantasia = request.getParameter("fantasia");
		String cnpj = request.getParameter("cnpj");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		String cep = request.getParameter("cep");
		String estado = request.getParameter("estado");
		String cidade = request.getParameter("cidade");
		String bairro = request.getParameter("bairro");
		String logradouro = request.getParameter("logradouro");
		int numero = Integer.parseInt(request.getParameter("numero"));
		
		Endereco endereco = new Endereco();
		
		endereco.setCep(cep);
		endereco.setEstado(estado);
		endereco.setCidade(cidade);
		endereco.setBairro(bairro);
		endereco.setLogradouro(logradouro);
		endereco.setNumero(numero);
		
		enderecoDAO.inserirEndereco(endereco);
		
		instituicao.setRazaoSocial(razaoSocial);
		instituicao.setNomeFantasia(nomeFantasia);
		instituicao.setCnpj(cnpj);
		instituicao.setEmail(email);
		instituicao.setSenha(senha);
		instituicao.setEndereco(endereco);
		
		instituicaoDAO.inserirInstituicao(instituicao);
		response.sendRedirect("perfil-instituicao");
	}
	
	// TELA LOGIN 
	
	private void mostrarTelaEsqueciSenha(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("esqueci-senha.jsp");
		dispatcher.forward(request, response);
		
	}

	// TELA PERFIL PACIENTE 
	
	private void mostrarTelaEditarPerfilPaciente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("editar-perfil.jsp");
		dispatcher.forward(request, response);
		
	}
	
	private void mostrarTelaConquistasPaciente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("conquistas.jsp");
		dispatcher.forward(request, response);
		
	}
	
	private void mostrarTelaConsultasPaciente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Integer id = Integer.parseInt(request.getParameter("id"));
		List<Consulta> consultas = consultaDAO.recuperarListaDeConsultas();
		RequestDispatcher dispatcher = request.getRequestDispatcher("consultas.jsp");
		dispatcher.forward(request, response);
		
	}
	
	// TELA PERFIL ATENDENTE 
	
	private void mostrarTelaEditarPerfilAtendente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("editar-perfil-atendente.jsp");
		dispatcher.forward(request, response);
		
	}
	
	private void mostrarTelaVerConsultas(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("consultas-atendente.jsp");
		dispatcher.forward(request, response);
		
	}
	
	private void mostrarTelaVerPacientesCadastrados(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("pacientes-atendente.jsp");
		dispatcher.forward(request, response);
		
	}
	
	// TELA PERFIL INSTITUICAO mostrarTelaPerfilInstituicao
	
	private void mostrarTelaPerfilInstituicao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("perfil-instituicao.jsp");
		dispatcher.forward(request, response);
		
	}
	
	private void mostrarTelaEditarPerfilInstituicao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("editar-perfil-instituicao.jsp");
		dispatcher.forward(request, response);
		
	}
	
	private void mostrarTelaAtendentesInstituicao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("atendentes-instituicao.jsp");
		dispatcher.forward(request, response);
		
	}
	
	private void mostrarTelaEspecialidadesInstituicao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("especialidades-instituicao.jsp");
		dispatcher.forward(request, response);
		
	}

	
}