<%@ page isELIgnored="false" language="java"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<title>Cadastrar Profissional | MediConnect</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="image/x-icon" href="./assets/imagens/favicon.ico">
<style><%@include file ="../../estilos/padroes.css"%></style><style>
<%@include file="../../estilos/instituicao-cadastrar-atendente.css"%>
</style>
</head>
<body>
	<%@include file="../../componentes/cabecalhos/voltar.jsp"%>
	<main>
		<form class="template-grid" action="inserir-profissional" method="post"
			enctype="multipart/form-data">
			<div class="formulario-esquerda">
				<div class="formulario-input">
					<div class="input-icone">
						<p class="icone-grande"><%@include
								file="/assets/imagens/icone-paciente.svg"%></p>
					</div>
					<div class="input-item">
						<label for="nome" class="texto">Nome</label> <input
							class="texto-enfase" type="text" name="nome" id="i.nome"
							placeholder="Nome" maxlength="60" required>
					</div>
				</div>
				<div class="formulario-input">
					<div class="input-icone">
						<p class="icone-grande"><%@include
								file="/assets/imagens/icone-especialidade.svg"%></p>
					</div>
					<div class="input-item">
						<label for="especialidade" class="texto">Especialidade</label> 
						<select	class="texto-enfase" id="i.especialidade" name="especialidade" required>
						<option value="" disabled selected hidden="true">(Selecione a especialidade)</option>
							<c:forEach var="especialidade" items="${especialidades}">
							<option value="<c:out value='${especialidade.id}'/>"><c:out
							value='${especialidade.nome}' /></option>
							</c:forEach>
						</select>
					</div>
				</div>

			</div>
			<div class="formulario-direita">
				<div class="formulario-input">
					<div class="input-icone">
						<p class="icone-grande"><%@include
								file="/assets/imagens/icone-paciente.svg"%></p>
					</div>
					<div class="input-item">
						<label for="sobrenome" class="texto">Sobrenome</label> <input
							class="texto-enfase" type="text" name="sobrenome"
							id="i.sobrenome" placeholder="Sobrenome" maxlength="60" required>
					</div>
				</div>
				<div class="formulario-rodape">
					<button type="submit"
						class="botao-circular-p texto-enfase texto-claro">Confirmar</button>
					<button type="reset"
						class="botao-circular-p texto-enfase texto-azul">Descartar</button>
				</div>
			</div>
		</form>
	</main>
</body>
</html>
