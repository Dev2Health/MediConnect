<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <title>Consultas | MediConnect</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" type="image/x-icon" href="../../imagens/favicon.ico">
    <style><%@include file="../../estilos/padroes.css"%></style>
    <style><%@include file="../../estilos/paciente-consultas.css"%></style>

</head>
<body>
    <header id="cabecalho" class="template-grid">
        <nav class="navegacao-barra">
            <img src="../../imagens/icone-menu.svg" alt="icone-menu">
            <img src="../../imagens/logo.svg" alt="icone-mediconnect">
        </nav>
        <nav class="navegacao-filtro">
            <div class="filtro">
                <div class="input-item">
                    <input class="texto-enfase" type="text" id="pesquisar" name="pesquisar" placeholder="Pesquisar">
                </div>
                <div class="filtro-icone">
                    <img src="../../imagens/icone-lupa.svg" alt="icone-pesquisar">
                </div>
            </div>
            <button class="botao-quadrado-g texto">Filtrar <img src="../../imagens/icone-filtro.svg"></button>
        </nav>
    </header>
    <main>
        <section id="consultas">
            <div class="template-grid">
                <div id="botoes-opcoes">
                    <div class="botoes-selecao">
                        <button class="botao-quadrado-p texto-enfase" autofocus>Pendentes</button>
                        <button class="botao-quadrado-p texto-enfase">Todas</button>
                    </div>
                    <form action="agendar-consulta" method="post">
                    <button type="submit" id="agendar" class="botao-quadrado-p texto-enfase">Agendar <img src="../../imagens/icone-adicionar.svg"></button>
                   	</form>
                </div>
            </div>
            <div id="consulta">
                <c:forEach var="consulta" items="${consultas}">

                    <div class="card-horizontal">
                        <p class="texto-enfase">Consulta - <c:out value="${consulta.id}" /></p>
                        <div class="info-direita">
                            <div class="info-variavel">
                                <div class="info-data">
                                    <img src="../../imagens/icone-calendario.svg" alt="icone-calendario">
                                    <fmt:parseDate value="${consulta.data}" type="date"
					                    pattern="yyyy-MM-dd" var="parsedDate" />
					                    <fmt:formatDate value="${parsedDate}" type="date"
                    					pattern="dd/MM/yyyy" var="data" />
                                        <p class="texto" type="date"><c:out value="${data}" /></p>
                                </div>
                                <div class="info-horario">
                                    <img src="../../imagens/icone-horario.svg" alt="icone-calendario">
                                    <p class="texto"><c:out value='${consulta.horario}'/></p>
                                </div>
                            </div>
                            <form action="modal-consulta-paciente" method="post">
			                <input type="hidden" name="id" value="${consulta.id}"/>
			                <button type="submit" class="btn-square-sm text-emphasis link-light">Ver detalhes <img src="../../images/icone-adicionar.svg"></button>
                            </form>
                        </div>
                    </div>
                 </c:forEach>
        	</div>
        	</section>
    </main>
<%@include file="../../componentes/rodape/rodape.jsp"%>
</body>
</html>