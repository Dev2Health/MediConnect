<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <title>MediConnect</title>
    <meta name="description" content="Utilizar o sistema MediConnect traz vários benefícios, como praticidade, pontualidade e maior engajamento dos usuários com suas consultas. Venha conferir!">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" type="image/x-icon" href="webapp/assets/imagens/favicon.ico">
    <style><%@include file="/assets/estilos/padroes.css"%></style>
    <style><%@include file="/assets/estilos/pagina-inicial.css"%></style>
</head>
<body>
    <header class="template-grid" id="cabecalho">
        <img src="assets/imagens/logo-legendado.svg" alt="logo-mediconnect" id="logo">
        <nav class="barra-navegacao">
            <a href="./assets/paginas/sobre-nos.html" class="texto link-escuro">Sobre o MediConnect</a>
            <a href="./assets/paginas/login-usuario.html" class="texto link-escuro">Entrar</a>
            <a href="./assets/paginas/cadastrar-usuario.jsp" class="botao-circular-m texto link-claro">Cadastrar</a>
        </nav>
    </header>
    <main>
        <section id="sessao-principal" class="template-grid">
            <div class="conteudo-esquerda caixa-textual">
                <h1 class="titulo-especial"><span class="link-azul">Medi</span>Connect</h1>
                <p class="texto">Utilizar nosso sistema traz vários <span class="link-roxo">benefícios</span>. Além da <span class="link-roxo">praticidade</span>, auxiliamos você com a <span class="link-roxo">pontualidade</span> nas suas consultas. <span class="link-roxo">Venha conferir!</span></p>
            </div>
            <div class="conteudo-direita">
                <img src="webapp/assets/imagens/inicial-medica.svg" alt="ilustracao-medica" class="ilustracao">
            </div>
        </section>
        <section id="sessao-gamificacao" class="template-grid">
            <div class="conteudo-esquerda">
                <img src="webapp/assets/imagens/inicial-gamificacao.svg" alt="ilustracao-gamificacao" class="ilustracao">
            </div>
            <div class="conteudo-direita caixa-textual">
                <h1 class="titulo-especial">Gamificação</h1>
                <p class="texto">Nosso sistema apresenta uma solução divertida para aumentar seu engajamento com as suas consultas, criando conquistas e selos para aumentar sua objetividade!</p>
            </div>
        </section>
        <section id="sessao-notificacao" class="template-grid">
            <div class="conteudo-esquerda caixa-textual">
                <h1 class="titulo-especial">Notificações <span class="link-azul">Personalizadas</span></h1>
                <p class="texto">Trabalhamos para que sua consulta não seja esquecida. Com base no seu histórico de comparecimento, montamos um plano de notificações exclusivos para você!</p>
            </div>
            <div class="conteudo-direita">
                <img src="webapp/assets/imagens/inicial-notificacao.svg" alt="ilustracao-notificacao" class="ilustracao">
            </div>
        </section>
    </main>
    <footer>
        <div class="template-grid" id="rodape-links">
            <div class="rodape-mediconnect">
                <p class="texto">MediConnect</p>
                <a href="./assets/paginas/sobre-nos.html" class="texto-sem-enfase link-claro">Sobre nós</a>
                <a href="#sessao-principal" class="texto-sem-enfase link-claro">Página inicial</a>
            </div>
            <div class="rodape-contato">
                <p class="texto">Atendimento</p>
                <a href="#" class="texto-sem-enfase link-claro">Contato</a>
                <a href="#" class="texto-sem-enfase link-claro">Termos de Uso</a>
            </div>
            <div class="rodape-social">
                <p class="texto">Redes Sociais</p>
                <div class="social-whatsapp">
                    <img src="webapp/assets/imagens/logo-whatsapp.svg">
                    <a href="#" class="texto-sem-enfase link-claro">WhatsApp</a>
                </div>
                <div class="social-github">
                    <img src="webapp/assets/imagens/logo-github.svg">
                    <a href="#" class="texto-sem-enfase link-claro">GitHub</a>
                </div>
                <div class="social-instagram">
                    <img src="webapp/assets/imagens/logo-instagram.svg">
                    <a href="#" class="texto-sem-enfase link-claro">Instagram</a>
                </div>
            </div>
        </div>
        <div class="template-grid" id="rodape-comercial">
            <hr><br>
            <div class="comercial-conteudo">
                <img src="webapp/assets/imagens/logo-rodape.svg" alt="logo-mediconnect">
                <p class="texto-pequeno">2023 &copy Todos os direitos reservados</p>
            </div>
        </div>
    </footer>
</body>
</html>