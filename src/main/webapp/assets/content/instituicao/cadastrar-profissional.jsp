<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<title>Cadastro de Atendente</title>
		<style><%@include file="../../styles/pagina-inicial.css"%></style>
	</head>
	<body>
		<%@ include file="../../../menu.jsp"%>
		<div>
			<div>
					<input type="hidden" name="instituicao" value=1 />
					<form action="inserir-profissional" method="post">
					<label>Nome:</label>
					<input type="text" id="pr.nome" name="nome" placeholder="Informe o nome...">
					<label>Sobrenome:</label>
					<input type="text" id="pr.sobrenome" name="sobrenome" placeholder="Informe o sobrenome...">
					<label>Especialidade:</label>
					<input type="text" id="pr.especialidade" name="especialidade" placeholder="Informe a especialidade...">
					<button type="submit">Salvar</button>
					<button type="reset">Limpar Formulário</button>
				</form>
				</div>
			</div>
		</div>
	</body>
</html>