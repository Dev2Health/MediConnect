<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <title>Início | MediConnect</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" type="image/x-icon" href="./assets/imagens/favicon.ico">
    <style><%@include file="../../estilos/padroes.css"%></style>
    <style><%@include file="../../estilos/instituicao-inicial.css"%></style>
</head>
<body>
     <%@include file="../../componentes/cabecalhos/logado.jsp"%>
    <main>
        <section id="inicio" class="template-grid">
            <div class="conteudo-esquerda">
                <p class="ilustracao"><%@include file="/assets/imagens/ilustracao-instituicao.svg"%></p>
            </div>
            <div class="conteudo-direita">
                <div class="inicial-textos">
                    <h1 class="titulo-especial">Boas-vindas!</h1>
                    <h2 class="subtitulo-especial texto-azul"><c:out value="${instituicao.nomeFantasia}"/></h2>
                </div>
                <button class="botao-circular-g texto"><a href="./atendentes-instituicao" class="texto-claro">Ver Atendentes</a></button>
            </div>
        </section>
        <section id="atendentes">
            <div class="template-grid titulo-sessao">
                <h2 class="titulo-especial">Atendentes Recentes</h2>
            </div>
            <div id="atendente" class="template-grid">
                <div class="cards-agrupamento">
                	<c:if test = "${empty atendentes}">
                		<%@include file="../../componentes/retorno-vazio.jsp"%>
                	</c:if>
                    <c:forEach var="atendente" items="${atendentes}">
                    <div class="card-entidade">
                        <div class="card-superior">
                            <div class="entidade-imagem">
                                <%-- <img src="<c:out value='${urlFoto}'/>"> --%>
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
        </section>
        <section id="especialidades">
            <div class="template-grid titulo-sessao">
                <h2 class="titulo-especial">Especialidades</h2>
            </div>
            <div id="especialidade" class="template-grid">
                <div class="label-agrupamento">
                	<c:if test = "${empty especialidades}">
                		<%@include file="../../componentes/retorno-vazio.jsp"%>
            		</c:if>
	                <c:forEach var="especialidade" items="${especialidades}">
	    
	                    <div class="label-especialidade">
	                        <div class="label-titulo">
	                            <p class="texto"><c:out value="${especialidade.nome}"/></p>
	                        </div>
	                        <div class="label-profissionais">
	                            <img src="./assets/imagens/icone-profissional.svg" alt="icone-profissional">
	                            <div class="quantidade">
	                                <p class="texto-enfase">1</p>
	                                <%-- Tem que retornar a quantidade de profissionais da especialidade --%>
	                            </div>
	                        </div>
	                    </div>
	                    
	                </c:forEach>
                </div>
            </div>
        </section>
    </main>
    <%@include file="../../componentes/rodape/rodape.jsp"%>
</body>
</html>