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
	        <div id="pesquisa-retornar" class="template-grid">
	            <div id="retornar-consultas">
	                <p class="titulo texto-roxo">Consultas Agendadas</p>
					<button id="agendar" class="botao-quadrado-p texto-enfase">
						<a href="./agendar-consulta" class="texto-claro">Agendar</a>
						<p class="icone-pequeno"><%@include file="/assets/imagens/icone-adicionar.svg"%></p>
					</button>
	            </div>
	        </div>
	        <c:if test = "${empty consultas}">
        		<%@include file="../../componentes/retorno-vazio.jsp"%>
       		</c:if>
            <c:forEach var="consulta" items="${consultas}">
            	<div id="consulta-${consulta.id}" class="template-grid">

                    <div class="card-horizontal">
                        <p class="texto-enfase">Consulta - <c:out value="${consulta.id}" /></p>
                        <div class="info-direita">
                            <div class="info-variavel">
                                <div class="info-data">
                                    <p class="icone-grande"><%@include file="/assets/imagens/icone-calendario.svg"%></p>
                                    <fmt:parseDate value="${consulta.data}" type="date" pattern="yyyy-MM-dd" var="parsedDate" />
					               	<fmt:formatDate value="${parsedDate}" type="date" pattern="dd/MM/yyyy" var="data" />
									<p class="texto" type="date"><c:out value="${data}" /></p>
                                </div>
                                <div class="info-horario">
                                    <p class="icone-grande"><%@include file="/assets/imagens/icone-horario.svg"%></p>
                                    <p class="texto"><c:out value='${consulta.horario}'/></p>
                                </div>
                            </div>
			                <button onclick="abrirModal(${consulta.id})" class="botao-quadrado-p texto-enfase texto-claro">Ver detalhes</button>
                        </div>

                    </div>
           		</div>
           		
            </c:forEach>
            <c:forEach var="consulta" items="${consultas}">
	            <div id="modal-${consulta.id}" class="modal">
		            <div id="modal-conteudo-${consulta.id}" class="modal-conteudo">
		                <%@include file="../../componentes/modais/consulta.jsp"%>
		            </div>
	            </div>
            </c:forEach>
                    
    	</section>
    </main>
	<%@include file="../../componentes/rodape/rodape.jsp"%>
</body>
</html>