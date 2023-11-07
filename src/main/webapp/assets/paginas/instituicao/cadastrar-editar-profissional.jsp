<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<title>Cadastro de Profissional de Saúde</title>
		<style><%@include file="../../estilos/pagina-inicial.css"%></style>
	</head>
	<body>
		<%@ include file="../../../menu.jsp"%>
		<div>
			<div>
				<h1>
					<c:if test="${profissional != null}">Editar Profissional de Saúde</c:if>
					<c:if test="${profissional == null}">Inserir Profissional de Saúde</c:if>
				</h1>
				<div>
					<c:if test="${profissional != null}">
						<form action="atualizar-profissional" method="post">
					</c:if>
					<c:if test="${profissional == null}">
						<form action="inserir-profissional" method="post">
					</c:if>
					<c:if test="${profissional != null}">
						<input type="hidden" name="id" value="<c:out value='${profissional.id}' />" />
					</c:if>
					<label>Nome:</label>
					<input type="text" value="<c:out value='${profissional.nome}' />" id="p.nome" name="nome" placeholder="Informe o nome..."> 
					<label>Sobrenome:</label>
					<input type="text" value="<c:out value='${profissional.sobrenome}' />" id="p.sobrenome" name="sobrenome" placeholder="Informe o sobrenome..."> 
					<label>Especialidade:</label>
					<input type="text" value="<c:out value='${profissional.especialidade}' />" id="p.especialidade" name="especialidade" oninput="mascaraEspecialidade()" placeholder="Informe a especialidade..."> 

					<button type="submit">Salvar</button>
					<button type="reset">Limpar Formulário</button>
				</form>
				</div>
			</div>
		</div>
	</body>
</html>

<!-- NÃO REFEITO / ESTILIZADO -->