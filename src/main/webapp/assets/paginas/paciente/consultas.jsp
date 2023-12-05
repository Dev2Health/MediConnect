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
    <style>
        .modal {
            display: none;
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background: rgba(0, 0, 0, 0.7);
            justify-content: center;
            align-items: center;
        }

        .modal-conteudo {
            background: #fff;
            padding: 20px;
            border-radius: 5px;
            text-align: center;
        }

        #close-btn {
            cursor: pointer;
        }
    </style>

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
                    <button id="agendar" class="botao-quadrado-p texto-enfase">
                    	<a href="./agendar-consulta" class="texto-claro">Agendar</a>
                    	<p class="icone-pequeno"><%@include file="/assets/imagens/icone-adicionar.svg"%></p>
                    </button>
                </div>
            </div>
            <c:forEach var="consulta" items="${consultas}">
            <div id="consulta-${consulta.id}">

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
                                    <img src="../../imagens/icone-horario.svg" alt="icone-horario">
                                    <p class="texto" type="time"><c:out value="${consulta.horario}" /></p>
                                </div>
                            </div>
			                <button onclick="abrirModal(${consulta.id})" class="btn-square-sm text-emphasis link-light">Ver detalhes <img src="../../images/icone-adicionar.svg"></button>
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