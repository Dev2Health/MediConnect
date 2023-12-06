<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <title>Perfil | MediConnect</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" type="image/x-icon" href="./assets/imagens/favicon.ico">
    <style><%@include file="../../estilos/padroes.css"%></style>
    <style><%@include file="../../estilos/instituicao-perfil.css"%></style>
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
	        		<h2 class="subtitulo texto-azul"><c:out value="${instituicao.nomeFantasia}"/></h2>
					<p class="texto texto-azul"><c:out value="${instituicao.email}"/></p>
	        	</div>
	        </div>
        </section>
        
        <%-- PRECISA COLOCAR NO SERVLET PARA MOSTRAR AS ESPECIALIDADES E OS PACIENTES NESSA PÁGINA--%>
        
        <section id="especialidades">
            <div class="sessao-subtitulo">
                <h2 class="subtitulo">Especialidades Atendidas</h2>
            </div>
            <c:if test = "${empty especialidades}">
    	    	<%@include file="../../componentes/retorno-vazio.jsp"%>
	        </c:if>
            <div id="especialidade" class="template-grid">
	            <c:forEach var="especialidade" items="${especialidades}">
	                <div class="card-horizontal">
	                    <p class="texto-enfase"><c:out value="${especialidade.nome}"/></p>
	                    <div class="info-direita">
	                        <div class="info-variavel">
	                            <p class="icone-grande"><%@include file="/assets/imagens/icone-profissional.svg"%></p>
	                            <p class="texto"><c:out value="${fn:length(especialidade.profissionalDeSaude)}"/></p>
	                            <%-- Mostrar a quantidade de profissionais --%>
	                        </div>
	                        <button class="botao-quadrado-p texto-enfase texto-claro">Ver detalhes</button>
	                    </div>
	                </div>
	            </c:forEach>
            </div>
            <div class="ver-tudo">
                <button class="botao-quadrado-p texto-enfase">
                	<a href="./especialidades-instituicao" class="texto-claro">Ver todas</a>
                	<p class="icone-pequeno"><%@include file="/assets/imagens/icone-seta.svg"%></p>
                </button>
            </div>
        </section>
        <section id="atendentes">
            <div class="sessao-subtitulo">
                <h2 class="subtitulo">Atendentes Cadastrados</h2>
            </div>
			<c:if test = "${empty atendentes}">
   	    		<%@include file="../../componentes/retorno-vazio.jsp"%>
        	</c:if>
            <div id="atendente" class="template-grid"> 
                <div class="cards-agrupamento">
                	<c:forEach var="atendente" items="${atendentes}">
	                	<div class="card-entidade">
	                        <div class="card-superior">
	                            <div class="entidade-imagem">
	                                <img src="<c:out value='${atendente.urlFoto}'/>">
	                            </div>
	                            <div class="entidade-informacao">
	                                <p class="texto"><c:out value="${atendente.nome}"/> <c:out value="${atendente.sobrenome}"/></p>
	                                <p class="texto-sem-enfase">Nº Cadastro <c:out value="${atendente.id}"/></p>
	                            </div>
	                        </div>
	                        <div class="card-meio">
	                            <p class="icone-pequeno"><%@include file="/assets/imagens/icone-informacoes.svg"%></p>
	                            <p class="texto">Informações Gerais</p>
	                        </div>
	                        <div class="card-inferior">
	                            <div class="inferior-informacao">
	                                <p class="texto-sem-enfase">Data de cadastro</p>
	                                <p class="texto-sem-enfase"><c:out value="${atendente.dataCadastro}"/></p>
	                            </div>
	                            <div class="inferior-informacao">
	                                <p class="texto-sem-enfase">CTPS</p>
	                                <p class="texto-sem-enfase"><c:out value="${atendente.ctps}"/></p>
	                            </div>
	                        </div>
	                    </div>
                    </c:forEach>
                </div>
            </div>
            <div class="ver-tudo">
                <button class="botao-quadrado-p texto-enfase">
                	<a href="./atendentes-instituicao" class="texto-claro">Ver todas</a>
                	<p class="icone-pequeno"><%@include file="/assets/imagens/icone-seta.svg"%></p>
                </button>
            </div>
        </section>
    </main>
    <%@include file="../../componentes/rodape/rodape.jsp"%>
</body>
</html>