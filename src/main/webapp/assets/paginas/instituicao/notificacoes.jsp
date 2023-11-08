<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <title>Notificações | MediConnect</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" type="image/x-icon" href="./assets/imagens/favicon.ico">
    <style><%@include file="../../estilos/padroes.css"%></style>
    <style><%@include file="../../estilos/instituicao-notificacoes.css"%></style>
</head>
<body>
    <header id="cabecalho" class="template-grid">
        <nav class="navegacao-barra">
            <img src="./assets/imagens/icone-menu.svg" alt="icone-menu">
            <img src="./assets/imagens/logo.svg" alt="icone-mediconnect">
        </nav>
        <nav class="navegacao-filtro">
            <div class="filtro">
                <div class="input-item">
                    <input class="texto-enfase" type="texto" id="pesquisar" name="pesquisar" placeholder="Pesquisar">
                </div>
                <div class="filtro-icone">
                    <img src="./assets/imagens/icone-lupa.svg" alt="icone-pesquisar">
                </div>
            </div>
            <button class="botao-quadrado-g texto">Filtrar <img src="./assets/imagens/icone-filtro.svg"></button>
        </nav>
    </header>
    <main>
        <div id="notificacoes">
            <c:forEach var="notificacao" items="${notificacoes}" class="template-grid">
                <div class="card-notificacao">
                    <div class="notificacao-superior">
                        <h2 class="subtitulo">Notificação</h2>
                        <!-- Adicionar o título da notificação com o JSP -->
                        <div class="informacoes-consulta">
                            <div class="informacao-data">
                                <img src="./assets/imagens/icone-calendario.svg" alt="icone-calendario">
                                <p class="texto">
                                    <c:out value="${notificacao.data}" />
                                </p>
                            </div>
                            <div class="informacao-horario">
                                <img src="./assets/imagens/icone-horario.svg" alt="icone-horario">
                                <p class="texto"> 
                                    <c:out value="${notificacao.horario}"/>
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="notificacao-inferior">
                        <p class="texto-sem-enfase">
                            <c:out value="${notificacao.descricao}"/>
                        </p>
                    </div>
                </div>
            </c:forEach>
        </div>
    </main>
    <footer>
        <div class="template-grid" id="rodape-links">
            <div class="rodape-mediconnect">
                <p class="texto">MediConnect</p>
                <a href="../../paginas/sobre-nos.jsp" class="texto-sem-enfase texto-claro">Sobre nós</a>
                <a href="../../../index.jsp" class="texto-sem-enfase texto-claro">Página inicial</a>
            </div>
            <div class="rodape-contato">
                <p class="texto">Atendimento</p>
                <a href="#" class="texto-sem-enfase texto-claro">Contato</a>
                <a href="#" class="texto-sem-enfase texto-claro">Termos de Uso</a>
            </div>
            <div class="rodape-social">
                <p class="texto">Redes Sociais</p>
                <div class="social-whatsapp">
                    <img src="./assets/imagens/logo-whatsapp.svg">
                    <a href="#" class="texto-sem-enfase texto-claro">WhatsApp</a>
                </div>
                <div class="social-github">
                    <img src="./assets/imagens/logo-github.svg">
                    <a href="#" class="texto-sem-enfase texto-claro">GitHub</a>
                </div>
                <div class="social-instagram">
                    <img src="./assets/imagens/logo-instagram.svg">
                    <a href="#" class="texto-sem-enfase texto-claro">Instagram</a>
                </div>
            </div>
        </div>
        <div class="template-grid" id="rodape-comercial">
            <hr><br>
            <div class="comercial-conteudo">
                <img src="./assets/imagens/logo-rodape.svg" alt="logo-mediconnect">
                <p class="texto-pequeno">2023 &copy Todos os direitos reservados</p>
            </div>
        </div>
    </footer>
</body>
</html>