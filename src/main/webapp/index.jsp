<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <title>MediConnect</title>
    <meta name="description" content="Utilizar o sistema MediConnect traz vários benefícios, como praticidade, pontualidade e maior engajamento dos usuários com suas consultas. Venha conferir!">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" type="image/x-icon" href="/assets/images/favicon.ico">
    <style><%@include file="/assets/styles/padroes.css"%></style>
    <style><%@include file="/assets/styles/pagina-inicial.css"%></style>
</head>
<body>
    <header class="template-grid" id="content-header">
        <img src="../images/logo.svg" alt="logo-mediconnect" id="logo">
        <nav class="nav-bar">
            <a href="./assets/content/sobre-nos.html" class="text link-dark">Sobre o MediConnect</a>
            <a href="./assets/content/login-usuario.html" class="text link-dark">Entrar</a>
            <a href="./assets/content/cadastrar-usuario.jsp" class="btn-round-me text link-light">Cadastrar</a>
        </nav>
    </header>
    <main>
        <section id="section-home" class="template-grid">
            <div class="content-left text-box">
                <h1 class="title-special"><span class="span-blue">Medi</span>Connect</h1> <!-- Lembrando que formatação será apenas no CSS (para deixar uppercase) -->
                <p class="text">Utilizar nosso sistema traz vários <span class="span-purple">benefícios</span>. Além da <span class="span-purple">praticidade</span>, auxiliamos você com a <span class="span-purple">pontualidade</span> nas suas consultas. <span class="span-purple">Venha conferir!</span></p>
            </div>
            <div class="content-right">
                <img src="./assets/images/inicial-medica.svg" alt="ilustracao-medica" class="illustration">
            </div>
        </section>
        <section id="section-gamification" class="template-grid">
            <div class="content-left">
                <img src="./assets/images/inicial-gamificacao.svg" alt="ilustracao-gamificacao" class="illustration">
            </div>
            <div class="content-right text-box">
                <h1 class="title-special">Gamificação</h1>
                <p class="text">Nosso sistema apresenta uma solução divertida para aumentar seu engajamento com as suas consultas, criando conquistas e selos para aumentar sua objetividade!</p>
            </div>
        </section>
        <section id="section-notification" class="template-grid">
            <div class="content-left text-box">
                <h1 class="title-special">Notificações <span class="span-blue">Personalizadas</span></h1>
                <p class="text">Trabalhamos para que sua consulta não seja esquecida. Com base no seu histórico de comparecimento, montamos um plano de notificações exclusivos para você!</p>
            </div>
            <div class="content-right">
                <img src="./assets/images/inicial-notificacao.svg" alt="ilustracao-notificacao" class="illustration">
            </div>
        </section>
    </main>
    <footer>
        <div class="template-grid" id="footer-links">
            <div class="footer-mediconnect">
                <p class="text">MediConnect</p>
                <a href="./assets/content/sobre-nos.html" class="text-no-emphasis link-light">Sobre nós</a>
                <a href="#section-home" class="text-no-emphasis link-light">Página inicial</a>
            </div>
            <div class="footer-contact">
                <p class="text">Atendimento</p>
                <a href="#" class="text-no-emphasis link-light">Contato</a>
                <a href="#" class="text-no-emphasis link-light">Termos de Uso</a>
            </div>
            <div class="footer-social">
                <p class="text">Redes Sociais</p>
                <div class="social-whatsapp">
                    <img src="./assets/images/logo-whatsapp.svg">
                    <a href="#" class="text-no-emphasis link-light">WhatsApp</a>
                </div>
                <div class="social-github">
                    <img src="./assets/images/logo-github.svg">
                    <a href="#" class="text-no-emphasis link-light">GitHub</a>
                </div>
                <div class="social-instagram">
                    <img src="./assets/images/logo-instagram.svg">
                    <a href="#" class="text-no-emphasis link-light">Instagram</a>
                </div>
            </div>
        </div>
        <div class="template-grid" id="footer-commercial">
            <hr><br>
            <div class="commercial-content">
                <img src="./assets/images/logo-rodape.svg" alt="logo-mediconnect">
                <p class="text-small">2023 &copy Todos os direitos reservados</p>
            </div>
        </div>
    </footer>
</body>
</html>