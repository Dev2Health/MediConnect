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
    <%@include file="../../componentes/cabecalhos/filtro.jsp"%>
    <main>
        <section id="consultas">
            <div class="template-grid">
                <div id="botoes-opcoes">
                    <div class="botoes-selecao">
                        <button class="botao-quadrado-p texto-enfase" autofocus>Pendentes</button>
                        <button class="botao-quadrado-p texto-enfase">Todas</button>
                    </div>
             
                    <button id="agendar" class="botao-quadrado-p texto-enfase"><a href="./agendar-consulta"> Agendar <img src="../../imagens/icone-adicionar.svg"></a></button>
            
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