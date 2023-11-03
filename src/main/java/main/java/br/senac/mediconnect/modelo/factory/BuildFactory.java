package main.java.br.senac.mediconnect.modelo.factory;


import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import main.java.br.senac.mediconnect.modelo.entidade.atendente.Atendente;
import main.java.br.senac.mediconnect.modelo.entidade.conquista.Conquista;
import main.java.br.senac.mediconnect.modelo.entidade.consulta.Consulta;
import main.java.br.senac.mediconnect.modelo.entidade.endereco.Endereco;
import main.java.br.senac.mediconnect.modelo.entidade.especialidadeInstituicao.EspecialidadeInstituicao;
import main.java.br.senac.mediconnect.modelo.entidade.especialidadeInstituicao.EspecialidadeInstituicaoId;
import main.java.br.senac.mediconnect.modelo.entidade.especialidadeProfissional.EspecialidadeProfissional;
import main.java.br.senac.mediconnect.modelo.entidade.instituicao.Instituicao;
import main.java.br.senac.mediconnect.modelo.entidade.notificacao.Notificacao;
import main.java.br.senac.mediconnect.modelo.entidade.notificacaoConsulta.NotificacaoConsulta;
import main.java.br.senac.mediconnect.modelo.entidade.notificacaoConsulta.NotificacaoConsultaId;
import main.java.br.senac.mediconnect.modelo.entidade.paciente.Paciente;
import main.java.br.senac.mediconnect.modelo.entidade.pacienteConquista.PacienteConquista;
import main.java.br.senac.mediconnect.modelo.entidade.pacienteConquista.PacienteConquistaId;
import main.java.br.senac.mediconnect.modelo.entidade.pacienteSelo.PacienteSelo;
import main.java.br.senac.mediconnect.modelo.entidade.pacienteSelo.PacienteSeloId;
import main.java.br.senac.mediconnect.modelo.entidade.pessoa.Pessoa;
import main.java.br.senac.mediconnect.modelo.entidade.profissionalDeSaude.ProfissionalDeSaude;
import main.java.br.senac.mediconnect.modelo.entidade.selo.Selo;
import main.java.br.senac.mediconnect.modelo.entidade.usuario.Usuario;

public class BuildFactory {
	
	public SessionFactory ConectFac() {
		
		Configuration config = new Configuration();
		
		config.addAnnotatedClass(Atendente.class);
		config.addAnnotatedClass(Conquista.class);
		config.addAnnotatedClass(Consulta.class);
		config.addAnnotatedClass(Endereco.class);
		config.addAnnotatedClass(EspecialidadeProfissional.class);
		config.addAnnotatedClass(Instituicao.class);
		config.addAnnotatedClass(Notificacao.class);
		config.addAnnotatedClass(Paciente.class);
		config.addAnnotatedClass(Pessoa.class);
		config.addAnnotatedClass(ProfissionalDeSaude.class);
		config.addAnnotatedClass(Selo.class);
		config.addAnnotatedClass(Usuario.class);
		config.addAnnotatedClass(PacienteConquista.class);
		config.addAnnotatedClass(PacienteConquistaId.class);
		config.addAnnotatedClass(PacienteSelo.class);
		config.addAnnotatedClass(PacienteSeloId.class);
		config.addAnnotatedClass(EspecialidadeInstituicao.class);
		config.addAnnotatedClass(EspecialidadeInstituicaoId.class);
		config.addAnnotatedClass(NotificacaoConsulta.class);
		config.addAnnotatedClass(NotificacaoConsultaId.class);
		
		config.configure("hibernate.cfg.xml");
		
		ServiceRegistry service = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		
		SessionFactory fabricaSessao = config.buildSessionFactory(service);
		
		return fabricaSessao;
	}
}
