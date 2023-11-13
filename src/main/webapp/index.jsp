<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <title>MediConnect</title>
    <meta name="description" content="Utilizar o sistema MediConnect traz vários benefícios, como praticidade, pontualidade e maior engajamento dos usuários com suas consultas. Venha conferir!">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" type="image/x-icon" href="./assets/imagens/favicon.ico">
    <style><%@include file="/assets/estilos/padroes.css"%></style>
    <style><%@include file="/assets/estilos/pagina-inicial.css"%></style>
</head>
<body>
    <%@include file="/assets/componentes/cabecalhos/deslogado.jsp"%>
    <main>
        <section id="sessao-principal" class="template-grid">
            <div class="conteudo-esquerda caixa-textual">
                <h1 class="titulo-especial"><span class="texto-azul">Medi</span>Connect</h1>
                <p class="texto">Utilizar nosso sistema traz vários <span class="texto-roxo">benefícios</span>. Além da <span class="texto-roxo">praticidade</span>, auxiliamos você com a <span class="texto-roxo">pontualidade</span> nas suas consultas. <span class="texto-roxo">Venha conferir!</span></p>
            </div>
            <div class="conteudo-direita">
                <img src="./assets/imagens/ilustracao-medica.svg" alt="ilustracao-medica" class="ilustracao">
            </div>
        </section>
        <section id="sessao-gamificacao" class="template-grid">
            <div class="conteudo-esquerda">
                <img src="./assets/imagens/ilustracao-gamificacao.svg" alt="ilustracao-gamificacao" class="ilustracao">
            </div>
            <div class="conteudo-direita caixa-textual">
                <h1 class="titulo-especial">Gamificação</h1>
                <p class="texto">Nosso sistema apresenta uma solução divertida para aumentar seu engajamento com as suas consultas, criando conquistas e selos para aumentar sua objetividade!</p>
            </div>
        </section>
        <section id="sessao-notificacao" class="template-grid">
            <div class="conteudo-esquerda caixa-textual">
                <h1 class="titulo-especial">Notificações <span class="texto-azul">Personalizadas</span></h1>
                <p class="texto">Trabalhamos para que sua consulta não seja esquecida. Com base no seu histórico de comparecimento, montamos um plano de notificações exclusivos para você!</p>
            </div>
            <div class="conteudo-direita">
                <img src="./assets/imagens/ilustracao-notificacao.svg" alt="ilustracao-notificacao" class="ilustracao">
            </div>
        </section>
    </main>
<%@include file="./assets/componentes/rodape/rodape.jsp"%>
</body>
</html>