<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <title>Especialidades | MediConnect</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" type="image/x-icon" href="assets/images/favicon.ico">
    <style><%@include file="../../estilos/padroes.css"%></style>
    <style><%@include file="../../estilos/instituicao-especialidades.css"%></style>
</head>
<body>
    <%@include file="../../componentes/cabecalhos/logado.jsp"%>
    <main>
    	<div id="pesquisa-retornar" class="template-grid">
            <div id="retornar-especialidade">
                <p class="titulo texto-azul">Especialidades da Instituição</p>
                <button class="botao-quadrado-p texto-enfase"> 
                	<a href="./cadastrar-especialidade" class="texto-claro">Cadastrar</a>
                	<p class="icone-pequeno"><%@include file="/assets/imagens/icone-adicionar.svg"%></p>
                </button>
            </div>
        </div>
        <c:if test = "${empty especialidades}">
        	<%@include file="../../componentes/retorno-vazio.jsp"%>
        </c:if>
        <div id="especialidades" class="template-grid">
        <div class="agrupamento-especialidades">
			<c:forEach var="especialidade" items="${especialidades}">
            
	            <div class="container-especialidade">
		            <div class="especialidade-superior">
		            	<h2 class="texto texto-claro"><c:out value="${especialidade.nome}"/></h2>
		            	<div class="icones-especialidade">
		            		<a href="./cadastrar-profissional"><p class="icone-grande"><%@include file="/assets/imagens/icone-adicionar.svg"%></p></a>
		            		<p class="icone-grande"><%@include file="/assets/imagens/icone-editar.svg"%></p>
		            	</div>
		            </div>
		            
		            <div class="especialidade-profissionais">
		            	<c:forEach var="profissional" items="${profissionais}">
	            			<p class="texto"><c:out value="${profissional.nome}"/> <c:out value="${profissional.sobrenome}"/></p>
	            		</c:forEach>
		            </div>
		            
	            </div>
                        
            </c:forEach>
        </div>
        </div>        
    </main>
    <%@include file="../../componentes/rodape/rodape.jsp"%>
</body>
</html>