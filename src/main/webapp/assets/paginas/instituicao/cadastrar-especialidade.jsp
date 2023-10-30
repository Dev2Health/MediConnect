<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<title>Cadastro de Especialidade</title>
		<style><%@include file="../../styles/pagina-inicial.css"%></style>
	</head>
	<body>
		<%@ include file="../../../menu.jsp"%>
		<div>
			<div>
				<h1>
					<c:if test="${especialidade != null}">Editar Especialidade</c:if>
					<c:if test="${especialidade == null}">Inserir Especialidade</c:if>
				</h1>
				<div>
					<c:if test="${especialidade != null}">
						<form action="atualizar-especialidade" method="post">
					</c:if>
					<c:if test="${especialidade == null}">
						<form action="inserir-especialidade" method="post">
					</c:if>
					<c:if test="${especialidade != null}">
						<input type="hidden" name="id" value="<c:out value='${especialidade.id}' />" />
					</c:if>
					<label>Nome:</label>
					<input type="text" value="<c:out value='${especialidade.nome}' />" id="e.nome" name="nome" placeholder="Informe o nome da especialidade..."> 

					<button type="submit">Salvar</button>
					<button type="reset">Limpar Formulário</button>
				</form>
				</div>
			</div>
		</div>
	</body>
</html>

<!-- NÃO ESTILIZADO -->