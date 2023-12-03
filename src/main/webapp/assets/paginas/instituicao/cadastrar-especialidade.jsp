<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <title>Cadastrar Especialidade | MediConnect</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" type="image/x-icon" href="./assets/imagens/favicon.ico">
    <style><%@include file="../../estilos/padroes.css"%></style>
    <style><%@include file="../../estilos/instituicao-cadastrar-especialidade.css"%></style>
</head>
<body>
	<%@include file="../../componentes/cabecalhos/voltar.jsp"%>
	<main>
        <div class="template-grid">
            <h1 class="titulo texto-azul">Cadastrar Especialidade</h1>
        </div>
        <form action="inserir-especialidade" method="post" autocomplete="off">
	        <div class="template-grid">
	            <div class="formulario-esquerda">
	                <div class="formulario-input">
	                    <div class="input-icone">
	                        <p class="icone-grande"><%@include file="/assets/imagens/icone-especialidade.svg"%></p>
	                    </div>
	                    <div class="input-item">
	                        <label for="horario" class="texto">Especialidade</label>
	                        <input class="texto-enfase" type="text" value="<c:out value='${especialidade.nome}' />" id="e.nome" name="nome" placeholder="Especialidade" required>
	                    </div>
	                </div>
					<div class="checkbox">
	                    <input type="checkbox" required>
	                    <p class="texto-sem-enfase">Li e estou de acordo com o <a href="#" class="texto-enfase texto-azul">Termo de Uso e Política de Privacidade</a></p>
	                </div>
	                <div class="botoes">
	                    <button class="botao-circular-m texto-enfase texto-claro" type="submit">Salvar Alterações</button>
	                    <button class="botao-circular-m texto-enfase texto-azul" type="reset">Descartar Alterações</button>
	                </div>
				</div>
            </div>
        </form>
    </main>		
</body>
</html>