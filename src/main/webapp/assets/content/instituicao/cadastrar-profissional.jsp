<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib url="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<title>Cadastro de Profissional de Saúde</title>
		<style><%@include file="./assets/styles/pagina-inicial.css"%></style>
		<script><%@include file="./assets/script/script.js"%></script>
	</head>
	<body>
		<%@ include file="menu.jsp"%>
		<div>
			<div>
				<h1>
					<c:if test="${profissional != null}">Editar Profissional de Saúde</c:if>
					<c:if test="${profissional == null}">Inserir Profissional de Saúde</c:if>
				</h1>
				<div>
					<c:if test="${profissional != null}">
						<form action="atualizar" method="post">
					</c:if>
					<c:if test="${profissional == null}">
						<form action="inserir" method="post">
					</c:if>
					<c:if test="${profissional != null}">
						<input type="hidden" name="id" value="<c:out value='${profissional.id}' />" />
					</c:if>
					<label>Nome:</label>
					<input type="text" value="<c:out value='${profissional.nome}' />" id="c.nome" name="nome" placeholder="Informe o nome..."> 
					<label>Sobrenome:</label>
					<input type="text" value="<c:out value='${profissional.sobrenome}' />" id="c.sobrenome" name="sobrenome" placeholder="Informe o sobrenome..."> 
					<label>especialidade:</label>
					<input type="text" value="<c:out value='${profissional.especialidade}' />" id="c.especialidade" name="especialidade" oninput="mascaraEspecialidade()" placeholder="Informe a especialidade..."> 

					<button type="submit">Salvar</button>
					<button type="reset">Limpar Formulário</button>
				</form>
				</div>
			</div>
		</div>
	</body>
</html>