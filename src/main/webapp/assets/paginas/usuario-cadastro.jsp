<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <title>Cadastre-se | MediConnect</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" type="image/x-icon" href="./assets/imagens/favicon.ico">
    <style><%@include file="../estilos/padroes.css"%></style>
    <style><%@include file="../estilos/usuario-cadastro.css"%></style>
</head>
<body>
    <%@include file="../componentes/cabecalhos/voltar.jsp"%>
    <main class="template-grid">
        <div class="conteudo-esquerda">
        	<p class="ilustracao"><%@include file="/assets/imagens/ilustracao-cadastro.svg"%></p>
        </div>
        <div class="conteudo-direita">
            <h1 class="titulo-especial">Deseja criar o seu cadastro?</h1>
            <div class="botoes">
                <button class="botao-circular-g texto">
                	<p class="icone-pequeno icone-claro"><%@include file="/assets/imagens/icone-instituicao.svg"%></p>
                    <a href="./cadastrar-instituicao" class="texto-claro">Cadastrar Instituição</a>
                </button>
                <button class="botao-circular-g texto">
                	<p class="icone-pequeno icone-claro"><%@include file="/assets/imagens/icone-paciente.svg"%></p>
                    <a href="./cadastrar-paciente" class="texto-claro">Cadastrar Paciente</a>
                </button>
            </div>
            <p class="texto-sem-enfase">Caso possua uma conta, <a href="./login" class="texto-enfase texto-roxo">clique aqui</a> para fazer o login</p>
        </div>
    </main>
</body>
</html>