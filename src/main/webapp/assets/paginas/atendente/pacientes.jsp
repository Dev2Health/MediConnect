<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <title>Pacientes | MediConnect</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" type="image/x-icon" href="../../images/favicon.ico">
    <link rel="stylesheet" type="text/css" href="../../styles/padroes.css">
</head>

<body>
    <header id="content-header" class="template-grid">
        <nav class="nav-bar">
            <img src="../../images/icone-menu.svg" alt="icone-menu">
            <img src="../../images/logo.svg" alt="icone-mediconnect">
        </nav>
        <nav class="nav-filter">
            <div class="filter-box">
                <div class="input-itens">
                    <input class="text-emphasis" type="text" id="pesquisar" name="pesquisar" placeholder="Pesquisar">
                </div>
                <div class="filter-icon">
                    <img src="../../images/icone-lupa.svg" alt="icone-pesquisar">
                </div>
            </div>
            <button class="btn-square-la text">Filtrar <img src="../../images/icone-filtro.svg"> </button>
        </nav>
    </header>
    <main>

        <section>
            <p class="text">Pacientes com consulta hoje</p>
            <div><!--agrupamento de tudo-->
                <div>
                    <div><!--todos os cards-->
                        <c:forEach var="pacienteHoje" items="${pacientesHoje}">
                        <div><!--card completo-->
                            <div><!--foto-->
                                <img src="../../images/perfil-exemplo.jpg" alt="foto-de-perfil">
                            </div>
                            <div><!--card-->
                                <div><!--Header-->
                                    <div><!--Textos-->
                                        <p class="text"><c:out value='${pacienteHoje.nome}'/></p>
                                        <p class="text-no-emphasis"><c:out value='${pacienteHoje.telefone}'/></p>
                                    </div>
                                </div>
                                <div><!--divisão-->
                                    <img src="../../images/icone-informacoes.svg" alt="icone-informações">
                                    <p class="text">Informações Gerais</p>
                                </div>
                                <div><!--Conteúdo do card-->
                                    <div><!--Textos-->
                                        <div>
                                            <p class="text-no-emphasis">Data de Nascimento</p>
                                            <p class="text-no-emphasis" type="datetime"><fmt:formatDate pattern = 'dd/MM/yyyy' value = '${dataNascimento}'/></p>
                                        </div>
                                        <div>
                                            <p class="text-no-emphasis">CPF</p>
                                            <p class="text-no-emphasis"><c:out value='${pacienteHoje.cpf}'/></p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </section>


        <section>
            <p class="text">Pacientes com consultas agendadas</p>
            <div><!--agrupamento de tudo-->
                <div>
                    <div><!--todos os cards-->
                        <c:forEach var="paciente" items="${pacientes}">
                        <div><!--card completo-->
                            <div><!--foto-->
                                <img src="../../images/perfil-exemplo.jpg" alt="foto-de-perfil">
                            </div>
                            <div><!--card-->
                                <div><!--Header-->
                                    <div><!--Textos-->
                                        <p class="text"><c:out value='${paciente.nome}'/></p>
                                        <p class="text-no-emphasis"><c:out value='${paciente.telefone}'/></p>
                                    </div>
                                </div>
                                <div><!--divisão-->
                                    <img src="../../images/icone-informacoes.svg" alt="icone-informações">
                                    <p class="text">Informações Gerais</p>
                                </div>
                                <div><!--Conteúdo do card-->
                                    <div><!--Textos-->
                                        <div>
                                            <p class="text-no-emphasis">Data de Nascimento</p>
                                            <p class="text-no-emphasis" type="datetime"><fmt:formatDate pattern = 'dd/MM/yyyy' value = '${dataNascimento}'/></p>
                                        </div>
                                        <div>
                                            <p class="text-no-emphasis">CPF</p>
                                            <p class="text-no-emphasis"><c:out value='${paciente.cpf}'/></p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </section>
        <footer>
            <div class="template-grid" id="footer-links">
                <div class="footer-mediconnect">
                    <p class="text">MediConnect</p>
                    <a href="../sobre-nos.html" class="text-no-emphasis link-light">Sobre nós</a>
                    <a href="../../../index.html" class="text-no-emphasis link-light">Página inicial</a>
                </div>
                <div class="footer-contact">
                    <p class="text">Atendimento</p>
                    <a href="#" class="text-no-emphasis link-light">Contato</a>
                    <a href="#" class="text-no-emphasis link-light">Termos de Uso</a>
                </div>
                <div class="footer-social">
                    <p class="text">Redes Sociais</p>
                    <div class="social-whatsapp">
                        <img src="../../images/logo-whatsapp.svg">
                        <a href="#" class="text-no-emphasis link-light">WhatsApp</a>
                    </div>
                    <div class="social-github">
                        <img src="../../images/logo-github.svg">
                        <a href="#" class="text-no-emphasis link-light">GitHub</a>
                    </div>
                    <div class="social-instagram">
                        <img src="../../images/logo-instagram.svg">
                        <a href="#" class="text-no-emphasis link-light">Instagram</a>
                    </div>
                </div>
            </div>
            <div class="template-grid" id="footer-commercial">
                <hr><br>
                <div class="commercial-content">
                    <img src="../../images/logo-rodape.svg" alt="logo-mediconnect">
                    <p class="text-small">2023 &copy Todos os direitos reservados</p>
                </div>
            </div>
        </footer>
    </main>
</body>

</html>