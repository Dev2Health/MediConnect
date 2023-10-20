<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <title>Atendentes | MediConnect</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" type="image/x-icon" href="../../images/favicon.ico">
    <link rel="stylesheet" type="text/css" href="../../styles/padroes.css">
    <link rel="stylesheet" type="text/css" href="../../styles/atendentes-instituicao.css">
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
        <div id="pesquisa-retornar" class="template-grid">
            <div id="retornar-atendente">
                <p class="text">Atendentes da instituição</p>
                <button class="btn-square-sm text">Adicionar <img src="../../images/icone-adicionar.svg"></button>
            </div>
        </div>
        <div id="atendente" class="template-grid">
            <c:forEach var="atendente" items="${atendentes}">
            <div class="card-atendente">
                <p class="text-emphasis atendente-name"><c:out value='${especialidade.id}' /> <c:out value="${atendente.nome}"/> <c:out value="${atendente.sobrenome}"/></p>
                <div class="card-info">
                    <div class="info-atendente">
                        <img src="../../images/icone-calendario.svg" alt="icone-calendario">
                        <p class="text-emphasis">Contratação: <c:out value="${atendente.data}" /></p>
                    </div>
                    <button class="btn-square-sm text-emphasis">Ver detalhes</button>
                </div>
            </div><!--fim do card-->
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
</main>
</body>
</html>