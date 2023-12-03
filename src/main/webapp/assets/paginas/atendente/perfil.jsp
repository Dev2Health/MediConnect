<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <title>Perfil | MediConnect</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" type="image/x-icon" href="./assets/imagens/favicon.ico">
    <style><%@include file="../../estilos/padroes.css"%></style>
    <style><%@include file="../../estilos/atendente-perfil.css"%></style>
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
	        		<h2 class="subtitulo texto-roxo"><c:out value="${atendente.nome}"/> <c:out value="${atendente.sobrenome}"/></h2>
					<p class="texto texto-roxo"><c:out value="${atendente.email}"/></p>
	        	</div>
	        </div>
	        <div id="container-informacoes">
	        	<div class="icone-instituicao">
	        		<p class="icone-grande icone-claro"><%@include file="/assets/imagens/icone-instituicao.svg"%></p>
	        	</div>
	        	<div class="dados-instituicao">
	        		<h2 class="subtitulo"><c:out value="${instituicao.nomeFantasia}"/></h2>
	        		<div class="instituicao-endereco">
	        			<p class="texto-enfase"><c:out value="${endereco.logradouro}"/>, <c:out value="${endereco.numero}"/></p>
	        			<p class="texto-enfase">CEP <c:out value="${endereco.cep}"/></p>
	        		</div>
	        	</div>
        	</div>
        </section>
        <section id="consultas">
            <div class="sessao-subtitulo">
                <h2 class="subtitulo">Consultas Agendadas</h2>
            </div>
            <c:if test = "${empty consultas}">
            	<%@include file="../../componentes/retorno-vazio.jsp"%>
            </c:if>
            <div id="consulta" class="template-grid">
	            <c:forEach var="consulta" items="${consultas}">
	            
	                <div class="card-horizontal">
	                    <p class="texto-enfase">Título da consulta</p>
	                    <div class="info-direita">
	                        <div class="info-variavel">
	                            <div class="info-data">
	                                <p class="icone-grande"><%@include file="/assets/imagens/icone-calendario.svg"%></p>
	                                <p class="texto">12/02/2024</p>
	                            </div>
	                            <div class="info-horario">
	                                <p class="icone-grande"><%@include file="/assets/imagens/icone-horario.svg"%></p>
	                                <p class="texto">13h59</p>
	                            </div>
	                        </div>
	                        <button class="botao-quadrado-p texto-enfase texto-claro">Ver detalhes</button>
	                    </div>
	                </div>
                
                </c:forEach>
            </div>
            <div class="ver-tudo">
                <button class="botao-quadrado-p texto-enfase">
                	<a href="./consultas-atendente" class="texto-claro">Ver todas</a>
                	<p class="icone-pequeno"><%@include file="/assets/imagens/icone-seta.svg"%></p>
                </button>
            </div>
        </section>
        <section id="pacientes">
            <div class="sessao-subtitulo">
                <h2 class="subtitulo">Pacientes Cadastrados</h2>
            </div>
            <c:if test = "${empty pacientes}">
            	<%@include file="../../componentes/retorno-vazio.jsp"%>
            </c:if>
            <div id="pacientes" class="template-grid"> 
                <div class="cards-agrupamento">
	                <c:forEach var="paciente" items="${pacientes}">
	                
	                    <div class="card-entidade">
	                        <div class="card-superior">
	                            <div class="entidade-imagem">
	                                <img>
	                                <%-- Adicionar a foto de perfil do paciente --%>
	                            </div>
	                            <div class="entidade-informacao">
	                                <p class="texto">Mario de Oliveira</p>
	                                <p class="texto-sem-enfase">Contato: (47) 9 9721 2859</p>
	                            </div>
	                        </div>
	                        <div class="card-meio">
	                            <p class="icone-pequeno"><%@include file="/assets/imagens/icone-informacoes.svg"%></p>
	                            <p class="texto">Informações Gerais</p>
	                        </div>
	                        <div class="card-inferior">
	                            <div class="inferior-informacao">
	                                <p class="texto-sem-enfase">Data de nascimento</p>
	                                <p class="texto-sem-enfase">09/09/1984</p>
	                            </div>
	                            <div class="inferior-informacao">
	                                <p class="texto-sem-enfase">CPF</p>
	                                <p class="texto-sem-enfase">123.456.789-10</p>
	                            </div>
	                        </div>
	                    </div>
	                    
	              	</c:forEach>
                </div>
            </div>
            <div class="ver-tudo">
                <button class="botao-quadrado-p texto-enfase">
                	<a href="./pacientes-atendente" class="texto-claro">Ver todas</a>
                	<p class="icone-pequeno"><%@include file="/assets/imagens/icone-seta.svg"%></p>
                </button>
            </div>
        </section>
    </main>
    <%@include file="../../componentes/rodape/rodape.jsp"%>
</body>
</html>