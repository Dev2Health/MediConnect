<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib url="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<title>Cadastro de Especialidade</title>
		<style><%@include file="./assets/styles/pagina-inicial.css"%></style>
		<script><%@include file="./assets/script/script.js"%></script>
	</head>
	<body>
		<%@ include file="menu.jsp"%>
		<div>
			<div>
				<h1>
					<c:if test="${especialidade != null}">Editar Especialidade</c:if>
					<c:if test="${especialidade == null}">Inserir Especialidade</c:if>
				</h1>
				<div>
					<c:if test="${especialidade != null}">
						<form action="atualizar" method="post">
					</c:if>
					<c:if test="${especialidade == null}">
						<form action="inserir" method="post">
					</c:if>
					<c:if test="${especialidade != null}">
						<input type="hidden" name="id" value="<c:out value='${especialidade.id}' />" />
					</c:if>
					<label>Nome:</label>
					<input type="text" value="<c:out value='${especialidade.nome}' />" id="c.nome" name="nome" placeholder="Informe o nome da especialidade..."> 

					<button type="submit">Salvar</button>
					<button type="reset">Limpar Formulário</button>
				</form>
				</div>
			</div>
		</div>
	</body>
</html>