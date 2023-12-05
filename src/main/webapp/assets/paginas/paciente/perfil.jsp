<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <title>Perfil | MediConnect</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" type="image/x-icon" href="./assets/imagens/favicon.ico">
    <style><%@include file="../../estilos/padroes.css"%></style>
    <style><%@include file="../../estilos/paciente-perfil.css"%></style>
</head>
<body>
    <%@include file="../../componentes/cabecalhos/logado.jsp"%>
    <main>
    
    	<section id="inicial" class="template-grid">
	        <div id="perfil">
	        	<div class="perfil-imagem">
	        		<div class="perfil-apresentacao">
		                <div class="perfil-foto">
		                    <img src="<c:out value='${urlFoto}'/>">
		                </div>
	            	</div>
	                <div class="perfil-editar">
	                    <button class="botao-perfil texto-enfase">
		                    <a href="./editar-perfil"><p class="icone-pequeno"><%@include file="/assets/imagens/icone-editar.svg"%></p></a>
	                    </button>
	                </div>
	        	</div>
	        	<div class="perfil-informacoes">
	        		<div>
		        		<h2 class="subtitulo"> <c:out value="${paciente.nome}"/> <c:out value="${paciente.sobrenome}"/></h2>
						<p class="texto"> <c:out value="${paciente.email}"/> </p>
					</div>
					<div class="perfil-selos">
                        <div id="selo-assiduo">
                            <div class="selo-superior">
                                <p class="icone-grande"><%@include file="/assets/imagens/icone-selo-assiduo.svg"%></p>
                                <span></span>
                            </div>
                            <p class="texto-pequeno texto-roxo">Assíduo</p>
                        </div>
                        <div id="selo-pontual">
                            <div class="selo-superior">
                                <p class="icone-grande"><%@include file="/assets/imagens/icone-selo-pontual.svg"%></p>
                                <span></span>
                            </div>
                            <p class="texto-pequeno texto-roxo">Pontual</p>
                        </div>
                    </div>
	        	</div>
	        </div>
        </section>
        <section id="conquistas" class="template-grid">
            <div id="container-conquistas">
                <div class="conquistas-superior">
                    <div class="titulo-conquistas">
                        <h2 class="subtitulo texto-roxo">Conquistas</h2>
                    </div>
                    <div id="barra-conquistas">
                        <input type="range" min="0" max="10" disabled>
                    </div>
                </div>
                <div class="conquistas-inferior">
                    <div class="conquista">
                        <p class="icone-grande"><%@include file="/assets/imagens/icone-profissional-favorito.svg"%></p>
                    </div>
                    <div class="conquista">
                        <p class="icone-grande"><%@include file="/assets/imagens/icone-nosso-presente.svg"%></p>
                    </div>
                    <div class="conquista">
                        <p class="icone-grande"><%@include file="/assets/imagens/icone-explorador.svg"%></p>
                    </div>
                    <div id="conquista-botao">
                        <a href="./conquistas-paciente" class="texto texto-roxo">Ver Todas</a>
                    </div>
                </div>                
            </div>
        </section>
        <section id="consultas">
            <div class="sessao-subtitulo">
                <h2 class="subtitulo">Consultas Próximas</h2>
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

            <div class="ver-tudo">
                <button class="botao-quadrado-p texto-enfase">
                	<a href="./consultas" class="texto-claro">Ver todas</a>
                	<p class="icone-pequeno"><%@include file="/assets/imagens/icone-seta.svg"%></p>
                </button>
            </div>
        </section>
    </main>
    <%@include file="../../componentes/rodape/rodape.jsp"%>
</body>
</html>