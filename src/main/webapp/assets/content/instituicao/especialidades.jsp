<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <title>Especialidades | MediConnect</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" type="image/x-icon" href="../../images/favicon.ico">
    <link rel="stylesheet" type="text/css" href="../../styles/padroes.css">
    <link rel="stylesheet" type="text/css" href="../../styles/especialidades-instituicao.css">
</head>
<body>
    <header id="content-header" class="template-grid">
        <nav class="nav-bar">
            <img src="../../images/icone-menu.svg" alt="icone-menu">
            <img src="../../images/logo.svg" alt="logo-mediconnect">
        </nav>
    </header>
    <main>
        <div id="pesquisa-retornar" class="template-grid">
            <div id="retornar-especialidade">
                <p class="text">Especialidades atendidas pela instituição</p>
                <button class="btn-square-sm text">Adicionar <img src="../../images/icone-adicionar.svg"></button>
            </div>
        </div>
        <div id="especialidade" class="template-grid">

            <c:forEach var="especialidade" items="${especialidades}">
            <div class="card-especialidade">
                <p class="text-emphasis"><c:out value='${especialidade.id}' /> <c:out value="${especialidade.nome}"/> Geral</p>
                <div class="card-info">
                    <div class="info-profissional">
                        <img src="../../images/icone-profissional.svg" alt="icone-profissional">
                        <p class="text"><c:out value="${especialidade.profissionais}" /></p> <!-- descobrir como pegar esse número -->
                    </div>
                    <button class="btn-square-sm text-emphasis">Ver detalhes</button>
                </div>
            </div>
            </c:forEach>
        </div>
    </main>
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
</body>
</html>