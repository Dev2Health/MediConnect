<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <title>Consultas | MediConnect</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" type="image/x-icon" href="./assets/imagens/favicon.ico">
    <style><%@include file="../../estilos/padroes.css"%></style>
    <style><%@include file="../../estilos/atendente-consultas.css"%></style>

</head>
<body>
    <%@include file="../../componentes/cabecalhos/filtro.jsp"%>
    <main>
        <section id="consultas">
            <div class="template-grid">
                <div id="botoes-selecao">
                    <button class="botao-quadrado-p texto-enfase" autofocus>Recentes</button>
                    <button class="botao-quadrado-p texto-enfase">Todas</button>
                </div>
            </div>
            <c:if test = "${empty notificacoes}">
        		<%@include file="../../componentes/retorno-vazio.jsp"%>
       		</c:if>
            <div id="consulta" class="template-grid">
                <c:forEach var="consulta" items="${consultas}">

                    <div class="card-horizontal">
                        <p class="texto-enfase">Título da consulta</p>
                        <div class="info-direita">
                            <div class="info-variavel">
                                <div class="info-data">
                                    <img src="./assets/imagens/icone-calendario.svg" alt="icone-calendario">
                                    <p class="texto" type="datetime"><fmt:formatDate pattern = 'dd/MM/yyyy' value = '${data}'/></p>
                                </div>
                                <div class="info-horario">
                                    <img src="./assets/imagens/icone-horario.svg" alt="icone-calendario">
                                    <p class="texto"><c:out value='${consulta.horario}'/></p>
                                </div>
                            </div>
                            <button class="botao-quadrado-p texto-enfase">Ver detalhes</button>
                        </div>
                    </div>

                </c:forEach>
            </div>
        </section>
    </main>
	<%@include file="../../componentes/rodape/rodape.jsp"%>
</body>
</html>