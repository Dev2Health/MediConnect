package main.java.br.senac.mediconnect;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

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
import main.java.br.senac.mediconnect.modelo.dao.notificacaoConsulta.NotificacaoConsultaDAO;
import main.java.br.senac.mediconnect.modelo.dao.notificacaoConsulta.NotificacaoConsultaDAOImpl;
import main.java.br.senac.mediconnect.modelo.dao.paciente.PacienteDAO;
import main.java.br.senac.mediconnect.modelo.dao.paciente.PacienteDAOImpl;
import main.java.br.senac.mediconnect.modelo.dao.pacienteConquista.PacienteConquistaDAO;
import main.java.br.senac.mediconnect.modelo.dao.pacienteConquista.PacienteConquistaDAOImpl;
import main.java.br.senac.mediconnect.modelo.dao.pacienteSelo.PacienteSeloDAO;
import main.java.br.senac.mediconnect.modelo.dao.pacienteSelo.PacienteSeloDAOImpl;
import main.java.br.senac.mediconnect.modelo.dao.profissionalDeSaude.ProfissionalDeSaudeDAO;
import main.java.br.senac.mediconnect.modelo.dao.profissionalDeSaude.ProfissionalDeSaudeDAOImpl;
import main.java.br.senac.mediconnect.modelo.dao.selo.SeloDAO;
import main.java.br.senac.mediconnect.modelo.dao.selo.SeloDAOImpl;
import main.java.br.senac.mediconnect.modelo.entidade.atendente.Atendente;
import main.java.br.senac.mediconnect.modelo.entidade.conquista.Conquista;
import main.java.br.senac.mediconnect.modelo.entidade.consulta.Consulta;
import main.java.br.senac.mediconnect.modelo.entidade.endereco.Endereco;
import main.java.br.senac.mediconnect.modelo.entidade.especialidadeInstituicao.EspecialidadeInstituicao;
import main.java.br.senac.mediconnect.modelo.entidade.especialidadeProfissional.EspecialidadeProfissional;
import main.java.br.senac.mediconnect.modelo.entidade.instituicao.Instituicao;
import main.java.br.senac.mediconnect.modelo.entidade.notificacao.Notificacao;
import main.java.br.senac.mediconnect.modelo.entidade.notificacaoConsulta.NotificacaoConsulta;
import main.java.br.senac.mediconnect.modelo.entidade.paciente.Paciente;
import main.java.br.senac.mediconnect.modelo.entidade.pacienteConquista.PacienteConquista;
import main.java.br.senac.mediconnect.modelo.entidade.pacienteSelo.PacienteSelo;
import main.java.br.senac.mediconnect.modelo.entidade.profissionalDeSaude.ProfissionalDeSaude;
import main.java.br.senac.mediconnect.modelo.entidade.selo.Selo;
import main.java.br.senac.mediconnect.modelo.enumeracao.conquista.StatusConquista;
import main.java.br.senac.mediconnect.modelo.enumeracao.consulta.StatusConsulta;
import main.java.br.senac.mediconnect.modelo.enumeracao.notificacao.StatusNotificacao;
import main.java.br.senac.mediconnect.modelo.enumeracao.selo.StatusSelo;

public class Principal {

	public static void main(String[] args) {

		// ATENDENTE
		AtendenteDAO atendenteDAO = new AtendenteDAOImpl();

		String email = "email_atendente@gmail.com";
		String cpf_atendente = "123.456.789-10";
		String senha = "12345";
		String nome = "Rivaldo";
		String sobrenome = "Santos";
		int cadastro = 123123;
		LocalDate dataCadastro = LocalDate.of(2010, 3, 12);
		String ctps = "123.123.123";

		Atendente atendente = new Atendente();

		atendente.setEmail(email);
		atendente.setCpf(cpf_atendente);
		atendente.setSenha(senha);
		atendente.setEhAtivo(true);
		atendente.setNome(nome);
		atendente.setSobrenome(sobrenome);
		atendente.setDataCadastro(dataCadastro);
		atendente.setCtps(ctps);

		atendenteDAO.inserirAtendente(atendente);
    
		// ATENDENTE 2
		AtendenteDAO atendente2DAO = new AtendenteDAOImpl();
		
		String email2 = "astolfo@atendente.com";
		String cpf_atendente2 = "123.454.789-22";
		String senha2 = "12346";
		String nome2 = "Astolfo";
		String sobrenome2 = "Horas";
		int cadastro2 = 123124;
		LocalDate dataCadastro2 = LocalDate.of(2012, 11, 1);
		String ctps2 = "123.123.124";
		Atendente atendente2 = new Atendente();
		atendente2.setEmail(email2);
		atendente2.setCpf(cpf_atendente2);
		atendente2.setSenha(senha2);
		atendente2.setEhAtivo(true);
		atendente2.setNome(nome2);
		atendente2.setSobrenome(sobrenome2);
		atendente2.setDataCadastro(dataCadastro2);
		atendente2.setCtps(ctps2);
		
		atendente2DAO.inserirAtendente(atendente2);
		
		// ENDEREÇO
		EnderecoDAO enderecoDAO = new EnderecoDAOImpl();

		String cep = "80-7682";
		int numero = 23;
		String logradouro = "Avenida Adineva";
		String cidade = "Blumenau";
		String estado = "Santa Catarina";
		String bairro = "Garcia";

		Endereco endereco = new Endereco();

		endereco.setCep(cep);
		endereco.setNumero(numero);
		endereco.setLogradouro(logradouro);
		endereco.setCidade(cidade);
		endereco.setEstado(estado);
		endereco.setBairro(bairro);

		enderecoDAO.inserirEndereco(endereco);

		// INSTITUIÇÃO
		InstituicaoDAO instituicaoDAO = new InstituicaoDAOImpl();

		String cnpj = "72.090.789/0001.32";
		Endereco endereco_instituicao = endereco;
		String senha_instituicao = "5581558185";
		String razaoSocial = "Medi Ltda";
		String emailInstituicao = "insti@gmail.com";
		String nomeFantasia = "MediConnect";
		LocalTime horarioInicioAtendimento = LocalTime.of(8, 30);
		LocalTime horarioFimAtendimento = LocalTime.of(18, 30);

		Instituicao instituicao = new Instituicao();

		instituicao.setCnpj(cnpj);
		instituicao.setEndereco(endereco_instituicao);
		instituicao.setSenha(senha_instituicao);
		instituicao.setRazaoSocial(razaoSocial);
		instituicao.setEmail(emailInstituicao);
		instituicao.setNomeFantasia(nomeFantasia);
		instituicao.setHorarioInicioAtendimento(horarioInicioAtendimento);
		instituicao.setHorarioFimAtendimento(horarioFimAtendimento);

		instituicaoDAO.inserirInstituicao(instituicao);

		// PACIENTE
		PacienteDAO pacienteDAO = new PacienteDAOImpl();

		String nome_paciente = "Roberto";
		String sobrenome_paciente = "Carlos";
		LocalDate dataNascimento = LocalDate.of(1990, 2, 27);
		String cpf_paciente = "123.456.789-11";
		String telefone = "(47) 99000-0000";
		String email_paciente = "email_paciente@gmail.com";
		String senha_paciente = "adiwnudiowanbu";

		Paciente paciente = new Paciente();

		paciente.setNome(nome_paciente);
		paciente.setSobrenome(sobrenome_paciente);
		paciente.setDataNascimento(dataNascimento);
		paciente.setCpf(cpf_paciente);
		paciente.setTelefone(telefone);
		paciente.setEmail(email_paciente);
		paciente.setSenha(senha_paciente);

		pacienteDAO.inserirPaciente(paciente);

		// ESPECIALIDADE PROFISSIONAL
		EspecialidadeProfissionalDAO especialidadeDAO = new EspecialidadeProfissionalDAOImpl();

		String nomeEspecialidadeProfissional = "Cardiologia";

		EspecialidadeProfissional especialidade = new EspecialidadeProfissional();

		especialidade.setNome(nomeEspecialidadeProfissional);

		especialidadeDAO.inserirEspecialidadeProfissionalDaInstituicao(especialidade);

		// PROFISSIONAL DE SAÚDE
		String nomeProfissionalDeSaude = "Cleber do Nascimento";

		ProfissionalDeSaudeDAO profissionalDAO = new ProfissionalDeSaudeDAOImpl();

		ProfissionalDeSaude profissional = new ProfissionalDeSaude();

		profissional.setNome(nomeProfissionalDeSaude);
		profissional.setSobrenome(nomeProfissionalDeSaude);

		profissionalDAO.inserirProfissionalDeSaude(profissional);

		// CONSULTA
		ConsultaDAO consultaDAO = new ConsultaDAOImpl();
		Consulta consulta = new Consulta();

		String descricao = "Descrição";

		LocalDate dataConsulta = LocalDate.of(2023, 7, 31);
		LocalTime horarioConsulta = LocalTime.of(11, 20);
		StatusConsulta status = StatusConsulta.AGENDADA;

		consulta.setInstituicao(instituicao);
		consulta.setEspecialidadeProfissional(especialidade);
		consulta.setProfissionalDeSaude(profissional);
		consulta.setDescricao(descricao);
		consulta.setData(dataConsulta);
		consulta.setHorario(horarioConsulta);
		consulta.setPaciente(paciente);
		consulta.setStatus(status);

		consultaDAO.inserirConsulta(consulta);

		// CONQUISTA
		ConquistaDAO conquistaDAO = new ConquistaDAOImpl();
		Conquista conquista = new Conquista();

		conquista.setNome("Pontual");
		conquista.setDescricao("Compareceu sem se atrasar em 41 consultas");
		conquistaDAO.inserirConquista(conquista);
		
		PacienteConquista pacienteConquista = new PacienteConquista();
		
		PacienteConquistaDAO pacienteConquistaDAO = new PacienteConquistaDAOImpl();
		
		pacienteConquista.setConquista(conquista);
		pacienteConquista.setNivel((byte)0);
		pacienteConquista.setPaciente(paciente);
		pacienteConquista.setStatus(StatusConquista.EM_PROGRESSO);
		
		pacienteConquistaDAO.inserirPacienteConquista(pacienteConquista);

		// SELO
		SeloDAO seloDAO = new SeloDAOImpl();
		Selo selo = new Selo();

		selo.setNome("Assiduidade");
		selo.setDescricao("O quanto você compareceu as consultas marcadas. (Níveis: Alto, Médio e Baixo)");

		seloDAO.inserirSelo(selo);

		SeloDAO seloDAO2 = new SeloDAOImpl();
		Selo selo2 = new Selo();

		selo2.setNome("Pontualidade");
		selo2.setDescricao("O quanto você não se atrasou as consultas marcadas. (Níveis: Alto, Médio e Baixo)");

		seloDAO2.inserirSelo(selo2);
    
		PacienteSelo pacienteSelo = new PacienteSelo();
		PacienteSeloDAO pacienteSeloDAO = new PacienteSeloDAOImpl();
		
		pacienteSelo.setSelo(selo);
		pacienteSelo.setPaciente(paciente);
		pacienteSelo.setStatus(StatusSelo.BAIXO);
		
		pacienteSeloDAO.inserirPacienteSelo(pacienteSelo);
		
		//NOTIFICAÇÃO
		NotificacaoDAO notificacaoDAO = new NotificacaoDAOImpl();
		Notificacao notificacao = new Notificacao();

		LocalDate dataNotificacao = LocalDate.now();
		LocalTime horarioNotificacao = LocalTime.now();
		StatusNotificacao statusNotificacao = StatusNotificacao.ENVIADA;

		notificacao.setTitulo("Criação de conta");
		notificacao.setDescricao("Sua conta foi criada com sucesso! Use seus dados de login para entrar.");
		notificacao.setData(dataNotificacao);
		notificacao.setHorario(horarioNotificacao);
		notificacao.setPeriodicidade(1);
		notificacao.setStatus(statusNotificacao);
		notificacao.setUsuario(paciente);

		notificacaoDAO.inserirNotificacao(notificacao);

		// ENDEREÇO 2
		EnderecoDAO enderecoDAO2 = new EnderecoDAOImpl();

		String cep2 = "89020020";
		int numero2 = 32;
		String logradouro2 = "Adineva Avenida";
		String cidade2 = "Gaspar";
		String estado2 = "Catarina Santa";
		String bairro2 = "Ciagar";

		Endereco endereco2 = new Endereco();

		endereco2.setCep(cep2);
		endereco2.setNumero(numero2);
		endereco2.setLogradouro(logradouro2);
		endereco2.setCidade(cidade2);
		endereco2.setEstado(estado2);
		endereco2.setBairro(bairro2);

		enderecoDAO2.inserirEndereco(endereco2);

		// INSTITUIÇÃO 2
		InstituicaoDAO instituicao2DAO = new InstituicaoDAOImpl();

		String cnpj2 = "27.909.123/0001.23";
		Endereco endereco_instituicao2 = endereco2;
		String senha_instituicao2 = "1010101010";
		String razaoSocial2 = "Medicina Colaborativa Ltda";
		String emailInstituicao2 = "med@colab.com";
		String nomeFantasia2 = "Hospital Colaborativo";
		LocalTime horarioInicioAtendimento2 = LocalTime.of(8, 0);
		LocalTime horarioFimAtendimento2 = LocalTime.of(23, 59);

		Instituicao instituicao2 = new Instituicao();

		instituicao2.setCnpj(cnpj2);
		instituicao2.setEndereco(endereco_instituicao2);
		instituicao2.setSenha(senha_instituicao2);
		instituicao2.setRazaoSocial(razaoSocial2);
		instituicao2.setEmail(emailInstituicao2);
		instituicao2.setNomeFantasia(nomeFantasia2);
		instituicao2.setHorarioInicioAtendimento(horarioInicioAtendimento2);
		instituicao2.setHorarioFimAtendimento(horarioFimAtendimento2);

		instituicao2DAO.inserirInstituicao(instituicao2);

		// ESPECIALIDADE PROFISSIONAL 2
		EspecialidadeProfissionalDAO especialidade2DAO = new EspecialidadeProfissionalDAOImpl();

		String nomeEspecialidadeProfissional2 = "Psiquiatria";

		EspecialidadeProfissional especialidade2 = new EspecialidadeProfissional();

		especialidade2.setNome(nomeEspecialidadeProfissional2);

		especialidade2DAO.inserirEspecialidadeProfissionalDaInstituicao(especialidade2);

		// ESPECIALIDADE PROFISSIONAL 3
		EspecialidadeProfissionalDAO especialidade3DAO = new EspecialidadeProfissionalDAOImpl();

		String nomeEspecialidadeProfissional3 = "Oncologia";

		EspecialidadeProfissional especialidade3 = new EspecialidadeProfissional();

		especialidade3.setNome(nomeEspecialidadeProfissional3);

		especialidade3DAO.inserirEspecialidadeProfissionalDaInstituicao(especialidade3);
		
		EspecialidadeInstituicao especialidadeInstituicao = new EspecialidadeInstituicao();
		EspecialidadeInstituicaoDAO especialidadeInstituicaoDAO = new EspecialidadeInstituicaoDAOImpl();
		
		especialidadeInstituicao.setEspecialidadeProfissional(especialidade);
		especialidadeInstituicao.setInstituicao(instituicao2);
		
		especialidadeInstituicaoDAO.inserirEspecialidadeInstituicao(especialidadeInstituicao);
    
		// PROFISSIONAL DE SAÚDE 2
		ProfissionalDeSaudeDAO profissional2DAO = new ProfissionalDeSaudeDAOImpl();

		String nomeProfissionalDeSaude2 = "Arnoldo Bukowski";

		ProfissionalDeSaude profissional2 = new ProfissionalDeSaude();

		profissional2.setNome(nomeProfissionalDeSaude2);
		profissional2.setSobrenome(nomeProfissionalDeSaude2);

		profissional2DAO.inserirProfissionalDeSaude(profissional2);

		// PROFISSIONAL DE SAÚDE 3
		ProfissionalDeSaudeDAO profissional3DAO = new ProfissionalDeSaudeDAOImpl();

		String nomeProfissionalDeSaude3 = "Ricardo Murphy";

		ProfissionalDeSaude profissional3 = new ProfissionalDeSaude();

		profissional3.setNome(nomeProfissionalDeSaude3);
		profissional3.setNome(nomeProfissionalDeSaude3);

		profissional3DAO.inserirProfissionalDeSaude(profissional3);

		// PROFISSIONAL DE SAÚDE 4
		ProfissionalDeSaudeDAO profissional4DAO = new ProfissionalDeSaudeDAOImpl();

		String nomeProfissionalDeSaude4 = "Cillian Müller";

		ProfissionalDeSaude profissional4 = new ProfissionalDeSaude();

		profissional4.setNome(nomeProfissionalDeSaude4);
		profissional4.setSobrenome(nomeProfissionalDeSaude4);

		profissional4DAO.inserirProfissionalDeSaude(profissional4);

		// PROFISSIONAL DE SAÚDE 5
		ProfissionalDeSaudeDAO profissional5DAO = new ProfissionalDeSaudeDAOImpl();

		String nomeProfissionalDeSaude5 = "Marcelo Pinheiro";

		ProfissionalDeSaude profissional5 = new ProfissionalDeSaude();

		profissional5.setNome(nomeProfissionalDeSaude5);
		profissional5.setSobrenome(nomeProfissionalDeSaude5);

		profissional5DAO.inserirProfissionalDeSaude(profissional5);

		// PACIENTE 2
		PacienteDAO paciente2DAO = new PacienteDAOImpl();

		String nome_paciente2 = "Carlos";
		String sobrenome_paciente2 = "Roberto";
		LocalDate dataNascimento2 = LocalDate.of(1997, 12, 5);
		String cpf_paciente2 = "021.369.024-70";
		String telefone2 = "(48) 99699-1234";
		String email_paciente2 = "carlos1997@yahoo.com.br";
		String senha_paciente2 = "senha1997";

		Paciente paciente2 = new Paciente();

		paciente2.setNome(nome_paciente2);
		paciente2.setSobrenome(sobrenome_paciente2);
		paciente2.setDataNascimento(dataNascimento2);
		paciente2.setCpf(cpf_paciente2);
		paciente2.setTelefone(telefone2);
		paciente2.setEmail(email_paciente2);
		paciente2.setSenha(senha_paciente2);

		paciente2DAO.inserirPaciente(paciente2);

		// PACIENTE 3
		PacienteDAO paciente3DAO = new PacienteDAOImpl();

		String nome_paciente3 = "Amauri";
		String sobrenome_paciente3 = "da Costa";
		LocalDate dataNascimento3 = LocalDate.of(2000, 7, 13);
		String cpf_paciente3 = "119.199.911-99";
		String telefone3 = "(47) 98867-4017";
		String email_paciente3 = "paciente_email@terra.com";
		String senha_paciente3 = "soseiquenadasei123";

		Paciente paciente3 = new Paciente();

		paciente3.setNome(nome_paciente3);
		paciente3.setSobrenome(sobrenome_paciente3);
		paciente3.setDataNascimento(dataNascimento3);
		paciente3.setCpf(cpf_paciente3);
		paciente3.setTelefone(telefone3);
		paciente3.setEmail(email_paciente3);
		paciente3.setSenha(senha_paciente3);

		paciente3DAO.inserirPaciente(paciente3);
		
		// CONSULTA
		ConsultaDAO consultaDAO2 = new ConsultaDAOImpl();
		Consulta consulta2 = new Consulta();

		String descricao2 = "Descrição";

		LocalDate dataConsulta2 = LocalDate.of(2023, 7, 30);
		LocalTime horarioConsulta2 = LocalTime.of(11, 21);
		StatusConsulta status2 = StatusConsulta.AGENDADA;

		consulta2.setInstituicao(instituicao);
		consulta2.setEspecialidadeProfissional(especialidade);
		consulta2.setProfissionalDeSaude(profissional);
		consulta2.setDescricao(descricao2);
		consulta2.setData(dataConsulta2);
		consulta2.setHorario(horarioConsulta2);
		consulta2.setPaciente(paciente2);
		consulta2.setStatus(status2);

		consultaDAO2.inserirConsulta(consulta2);
		
		ConsultaDAO consultaDAO3 = new ConsultaDAOImpl();
		Consulta consulta3 = new Consulta();

		String descricao3 = "Descrição";

		LocalDate dataConsulta3 = LocalDate.of(2023, 7, 30);
		LocalTime horarioConsulta3 = LocalTime.of(11, 21);
		StatusConsulta status3 = StatusConsulta.AGENDADA;

		consulta3.setInstituicao(instituicao);
		consulta3.setEspecialidadeProfissional(especialidade);
		consulta3.setProfissionalDeSaude(profissional);
		consulta3.setDescricao(descricao3);
		consulta3.setData(dataConsulta3);
		consulta3.setHorario(horarioConsulta3);
		consulta3.setPaciente(paciente2);
		consulta3.setStatus(status3);

		consultaDAO3.inserirConsulta(consulta3);
		
		ConsultaDAO consultaDAO4 = new ConsultaDAOImpl();
		Consulta consulta4 = new Consulta();

		String descricao4 = "Descrição";

		LocalDate dataConsulta4 = LocalDate.of(2023, 7, 30);
		LocalTime horarioConsulta4 = LocalTime.of(11, 21);
		StatusConsulta status4 = StatusConsulta.AGENDADA;

		consulta4.setInstituicao(instituicao);
		consulta4.setEspecialidadeProfissional(especialidade);
		consulta4.setProfissionalDeSaude(profissional);
		consulta4.setDescricao(descricao4);
		consulta4.setData(dataConsulta4);
		consulta4.setHorario(horarioConsulta4);
		consulta4.setPaciente(paciente2);
		consulta4.setStatus(status4);

		consultaDAO4.inserirConsulta(consulta4);
    
		NotificacaoConsultaDAO notificacaoConsultaDAO = new NotificacaoConsultaDAOImpl();
		NotificacaoConsulta notificacaoConsulta = new NotificacaoConsulta();
		
		notificacaoConsulta.setConsulta(consulta);
		notificacaoConsulta.setNotificacao(notificacao);
		
		notificacaoConsultaDAO.inserirNotificacaoConsulta(notificacaoConsulta);
		
		List<Consulta> consaunuadw = consultaDAO.recuperarConsultasAgendadasViaPacientePorId(6);
		
		System.out.println(consaunuadw);
		
		
		}
	
	
}