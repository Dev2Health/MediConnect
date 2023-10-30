<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<title>Cadastro de Paciente</title>
		<style><%@include file="../../styles/cadastro-paciente.css"%></style>
		<script><%@include file="../../scripts/cadastro-paciente.js"%></script>
	</head>
	<body>
		<div>
			<div>
		    	<h1>
					Cadastrar Paciente
				</h1>
				<div>
					<form action="inserir-paciente" method="post">
					<input type="hidden" name="id" value="<c:out value='${paciente.id}' />" />
					<label>Nome:</label>
					<input type="text" id="p.nome" name="nome" placeholder="Informe o nome..."> 
					<label>Sobrenome:</label>
					<input type="text" id="p.sobrenome" name="sobrenome" placeholder="Informe o sobrenome..."> 
					<label>CPF</label>
					<input type="text" id="p.cpf" name="cpf" oninput="mascaraCpf()" placeholder="Informe o cpf..."> 
					<label>Data de Nascimento:</label>
					<input type="date" id="p.data" name="data" oninput="mascaraData()" placeholder="Informe a data de nascimento..."> 
					<label>Email:</label>
					<input type="email" id="p.email" name="email" placeholder="Informe o email..."> 
					<label>Telefone:</label>
					<input type="tel" id="p.telefone" name="telefone" oninput="mascaraTelefone()" placeholder="Informe o telefone..."> 
					<label>Senha:</label>
					<input type="password" id="p.senha" name="senha" oninput="mascaraSenha()" placeholder="Informe a senha..."> 
					<label>Confirmar Senha:</label>
					<input type="password" id="p.confirmar-senha" name="confirmar-senha" oninput="mascaraSenha()" placeholder="Confirme a senha..."> 

					<button type="submit">Salvar</button>
					<button type="reset">Limpar Formulário</button>
				</form>
				</div>
			</div>
		</div>
	</body>
</html>