<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<title>Cadastro de Instituição</title>
		<style><%@include file="../../styles/pagina-inicial.css"%></style>
	</head>
	<body>
		<div>
			<div>
				<h1>
					Cadastrar Instituição
				</h1>
				<div>
					<form action="inserir-instituicao" method="post">
					<input type="hidden" name="id" value="<c:out value='${instituicao.id}' />" />
					<label>Razão Social:</label>
					<input type="text" value="<c:out value='${instituicao.razao}' />" id="i.razao" name="razao" oninput="mascaraRazao()" placeholder="Informe a razão social..."> 
					<label>Nome Fantasia:</label>
					<input type="text" value="<c:out value='${instituicao.fantasia}' />" id="i.fantasia" name="fantasia" oninput="mascaraFantasia()" placeholder="Informe o nome fantasia..."> 
					<label>CNPJ</label>
					<input type="text" value="<c:out value='${instituicao.cnpj}' />" id="i.cnpj" name="cnpj" oninput="mascaraCnpj()" placeholder="Informe o cnpj..."> 
					<label>Email:</label>
					<input type="email" value="<c:out value='${instituicao.email}' />" id="i.email" name="email" placeholder="Informe o email..."> 
					<label>Senha:</label>
					<input type="password" value="<c:out value='${instituicao.senha}' />" id="i.senha" name="senha" oninput="mascaraSenha()" placeholder="Informe a senha..."> 
					<label>Confirmar Senha:</label>
					<input type="password" value="<c:out value='${instituicao.senha}' />" id="i.confirmar-senha" name="confirmar-senha" oninput="mascaraSenha()" placeholder="Confirme a senha..."> 

					<label>CEP</label>
					<input type="text" value="<c:out value='${instituicao.cep}' />" id="i.cep" name="cep" oninput="mascaraCep()" placeholder="Informe o cep..."> 
					<label>Estado:</label>
					<input type="text" value="<c:out value='${instituicao.estado}' />" id="i.estado" name="estado" placeholder="Informe o estado..."> 
					<label>Cidade:</label>
					<input type="text" value="<c:out value='${instituicao.cidade}' />" id="i.cidade" name="cidade" placeholder="Informe a cidade..."> 
					<label>Bairro:</label>
					<input type="text" value="<c:out value='${instituicao.bairro}' />" id="i.bairro" name="bairro" placeholder="Informe o bairro..."> 
					<label>Logradouro:</label>
					<input type="text" value="<c:out value='${instituicao.logradouro}' />" id="i.logradouro" name="logradouro" placeholder="Informe o logradouro..."> 
					<label>Número:</label>
					<input type="number" value="<c:out value='${instituicao.numero}' />" id="i.numero" name="numero" placeholder="Informe o número..."> 

					<button type="submit">Salvar</button>
					<button type="reset">Limpar Formulário</button>
				</form>
				</div>
			</div>
		</div>
	</body>
</html>