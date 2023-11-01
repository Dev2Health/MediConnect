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
    <header class="template-grid" id="cabecalho">
        <nav class="barra-navegacao">
            <img src="./assets/imagens/icone-voltar.svg" alt="icone-voltar">
            <a href="../../index.jsp" class="texto texto-escuro">Voltar</a>
        </nav>
        <img src="./assets/imagens/logo-legendado.svg" alt="logo-mediconnect" class="logo">
    </header>
    <main class="template-grid">
        <div class="conteudo-esquerda">
            <img src="./assets/imagens/cadastro-ilustracao.svg" alt="ilustracao-cadastro" class="ilustracao">
        </div>
        <div class="conteudo-direita">
            <h1 class="titulo-especial">Deseja criar o seu cadastro?</h1>
            <div class="botoes">
                <button class="botao-circular-g">
                    <img class="icone-claro" src="./assets/imagens/icone-instituicao.svg" alt="icone-cadastro">
                    <a href="./instituicao/cadastro-1.html" class="texto texto-claro">Cadastrar Instituição</a>
                </button>
                <button class="botao-circular-g">
                    <img class="icone-claro" src="./assets/imagens/icone-paciente.svg" alt="icone-paciente">
                    <a href="./paciente/cadastro.html" class="texto texto-claro">Cadastrar Paciente</a>
                </button>
            </div>
            <p class="texto-sem-enfase">Caso possua uma conta, <a href="./usuario-login.jsp" class="texto-enfase texto-roxo">clique aqui</a> para fazer o login</p>
        </div>
    </main>
</body>
</html>