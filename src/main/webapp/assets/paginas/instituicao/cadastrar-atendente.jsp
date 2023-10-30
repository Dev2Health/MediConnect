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
					<form action="inserir-atendente" method="post">
					<label>Nome:</label>
					<input type="text" id="a.nome" name="nome" placeholder="Informe o nome...">
					<label>Sobrenome:</label>
					<input type="text" id="a.sobrenome" name="sobrenome" placeholder="Informe o sobrenome...">
					<label>CTPS:</label>
					<input type="text" id="a.ctps" name="ctps" oninput="mascaraCtps()" placeholder="Informe o ctps...">
					<label>CPF:</label>
					<input type="text" id="a.cpf" name="cpf" oninput="mascaraCtps()" placeholder="Informe o cpf...">
					<label>Email:</label>
					<input type="email" id="i.email" name="email" placeholder="Informe o email..."/>
					<label>Senha:</label>
					<input type="password" id="i.senha" name="senha" oninput="mascaraSenha()" placeholder="Informe a senha..."/>
					<label>Confirmar Senha:</label>
					<input type="password" id="i.confirmar-senha" name="confirmar-senha" oninput="mascaraSenha()" placeholder="Confirme a senha..."/>
					<label>Data de Cadastro:</label>
					<input type="date" id="a.data" name="data" oninput="mascaraData()" placeholder="Informe a data de cadastro...">

					<button type="submit">Salvar</button>
					<button type="reset">Limpar Formulário</button>
				</form>
				</div>
			</div>
		</div>
	</body>
</html>

<!-- NÃO ESTILIZADO -->