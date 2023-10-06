<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib url="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<title>Cadastro de Atendente</title>
		<style><%@include file="./assets/styles/pagina-inicial.css"%></style>
		<script><%@include file="./assets/script/script.js"%></script>
	</head>
	<body>
		<%@ include file="menu.jsp"%>
		<div>
			<div>
				<h1>
					<c:if test="${atendente != null}">Editar Atendente</c:if>
					<c:if test="${atendente == null}">Inserir Atendente</c:if>
				</h1>
				<div>
					<c:if test="${atendente != null}">
						<form action="atualizar" method="post">
					</c:if>
					<c:if test="${atendente == null}">
						<form action="inserir" method="post">
					</c:if>
					<c:if test="${atendente != null}">
						<input type="hidden" name="id" value="<c:out value='${atendente.id}' />" />
					</c:if>
					<label>Nome:</label>
					<input type="text" value="<c:out value='${atendente.nome}' />" id="c.nome" name="nome" placeholder="Informe o nome..."> 
					<label>Sobrenome:</label>
					<input type="text" value="<c:out value='${atendente.sobrenome}' />" id="c.sobrenome" name="sobrenome" placeholder="Informe o sobrenome..."> 
					<label>CTPS:</label>
					<input type="text" value="<c:out value='${atendente.ctps}' />" id="c.ctps" name="ctps" oninput="mascaraCtps()" placeholder="Informe o ctps..."> 
					<label>Data de Cadastro:</label>
					<input type="date" value="<c:out value='${atendente.data}' />" id="c.data" name="data" oninput="mascaraData()" placeholder="Informe a data de cadastro..."> 

					<button type="submit">Salvar</button>
					<button type="reset">Limpar Formulário</button>
				</form>
				</div>
			</div>
		</div>
	</body>
</html>