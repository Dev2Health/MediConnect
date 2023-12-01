<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <title>Profissionais | MediConnect</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" type="image/x-icon" href="./assets/imagens/favicon.ico">
    <style><%@include file="../../estilos/padroes.css"%></style>
    <style><%@include file="../../estilos/instituicao-atendentes.css"%></style>
</head>
<body>
	<%@include file="../../componentes/cabecalhos/filtro.jsp"%>
    <main>
        <div id="pesquisa-retornar" class="template-grid">
            <div id="retornar-atendente">
                <p class="subtitulo texto-azul">Profissionais da instituição</p>
                <button class="botao-quadrado-p texto-enfase"> 
                	<a href="./cadastrar-profissional" class="texto-claro"> Adicionar </a>
                	<p class="icone-pequeno"><%@include file="/assets/imagens/icone-adicionar.svg"%></p>
                </button>
            </div>
        </div>
        <div id="profissional" class="template-grid">
        <c:forEach var="profissional" items="${profissionais}">

			<div class="card-horizontal">
                <p class="texto-enfase"><c:out value='${profissional.id}' /> <c:out value="${profissional.nome}"/> <c:out value="${profissional.sobrenome}"/></p>
                <div class="info-direita">
                    <div class="info-variavel">
                        <p class="icone-pequeno"><%@include file="/assets/imagens/icone-deletar.svg"%></p>
                        <p class="icone-pequeno"><%@include file="/assets/imagens/icone-editar-dados.svg"%></p>
                    </div>
                    <button class="botao-quadrado-p texto-enfase texto-claro">Ver detalhes</button>
                </div>
            </div>
            
        </c:forEach>
        </div>
    </main>
	<%@include file="../../componentes/rodape/rodape.jsp"%>
</body>
</html>