<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <title>MediConnect</title>
    <meta name="description" content="O MediConnect é um sistema que se propõe a auxiliar pessoas e instituições, trazendo praticidade e engajamento. Venha conhecer nosso modelo de negócios!">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" type="image/x-icon" href="../imagens/favicon.ico">
    <style><%@include file="../estilos/padroes.css"%></style>
    <style><%@include file="../estilos/sobre-nos.css"%></style>
</head>
<body>
    <header class="template-grid" id="cabecalho">
        <img src="../imagens/logo.svg" alt="logo-mediconnect" id="logo">
        <nav class="barra-navegacao">
            <a href="../../index.jsp" class="texto link-escuro">Página Inicial</a>
            <a href="./login-usuario.html" class="texto link-escuro">Entrar</a>
            <a href="./cadastro-usuario.html" class="botao-circular-m texto link-claro">Cadastrar</a>
        </nav>
    </header>
    <main>
        <section id="sessao-propositos" class="template-grid">
            <div id="propositos-titulo">
                <h1 class="titulo-especial"><span class="link-azul">Medi</span>Connect</h1>
            </div>
            <div id="container-propositos">
                <div class="container-missao">
                    <img src="../imagens/icone-missao.svg" alt="icone-missao">
                    <h2 class="subtitulo">Missão</h2>
                    <p class="texto-sem-enfase">Transformar a relação das pessoas com consultas, trazendo mais praticidade e engajamento</p>
                </div>
                <div class="container-visao">
                    <img src="../imagens/icone-visao.svg" alt="icone-visao">
                    <h2 class="subtitulo">Visão</h2>
                    <p class="texto-sem-enfase">Ser um sistema auxiliar para pessoas e instituições, reduzindo os índices de absenteísmo</p>
                </div>
                <div class="container-valores">
                    <img src="../imagens/icone-valores.svg" alt="icone-valores">
                    <h2 class="subtitulo">Valores</h2>
                    <p class="texto-sem-enfase">Incentivo a saúde, ética, inovação e foco nas necessidades do público são nossos valores</p>
                </div>
            </div>
        </section>
        <section id="sessao-membros" class="template-grid">
            <div class="conteudo-esquerda">
                <div id="card-membro">
                    <div class="card-conteudo">
                        <div class="card-imagem">
                            <img src="../imagens/perfil-exemplo.jpg" class="foto-integrante" alt="icone-camera">
                        </div>
                        <h2 class="subtitulo">Nome Completo do Integrante</h2>
                        <p class="texto-sem-enfase">integrante.email@gmail.com</p>
                    </div>
                    <div class="card-social">
                        <img src="../imagens/logo-github.svg" alt="logo-github">
                        <img src="../imagens/logo-linkedin.svg" alt="logo-linkedin">
                        <img src="../imagens/icone-whatsapp.svg" alt="logo-whatsapp">
                    </div>
                </div>
            </div>
            <div class="conteudo-direita caixa-textual">
                <h1 class="titulo-especial link-roxo">Quem somos?</h1>
                <p class="texto-sem-enfase">Aqui, trazer pelo que cada um ficou responsável ao longo do projeto - expondo apenas brevemente e com poucos detalhes sobre cada um, apenas para ressaltar o enfoque que cada um deu no projeto (front-end, back-end, full-stack).</p>
            </div>
        </section>
    </main>
    <footer>
        <div class="template-grid" id="rodape-links">
            <div class="rodape-mediconnect">
                <p class="texto">MediConnect</p>
                <a href="#sessao-propositos" class="texto-sem-enfase link-claro">Sobre nós</a>
                <a href="../../index.jsp" class="texto-sem-enfase link-claro">Página inicial</a>
            </div>
            <div class="rodape-contato">
                <p class="texto">Atendimento</p>
                <a href="#" class="texto-sem-enfase link-claro">Contato</a>
                <a href="#" class="texto-sem-enfase link-claro">Termos de Uso</a>
            </div>
            <div class="rodape-social">
                <p class="texto">Redes Sociais</p>
                <div class="social-whatsapp">
                    <img src="../imagens/logo-whatsapp.svg">
                    <a href="#" class="texto-sem-enfase link-claro">WhatsApp</a>
                </div>
                <div class="social-github">
                    <img src="../imagens/logo-github.svg">
                    <a href="#" class="texto-sem-enfase link-claro">GitHub</a>
                </div>
                <div class="social-instagram">
                    <img src="../imagens/logo-instagram.svg">
                    <a href="#" class="texto-sem-enfase link-claro">Instagram</a>
                </div>
            </div>
        </div>
        <div class="template-grid" id="rodape-comercial">
            <hr><br>
            <div class="comercial-conteudo">
                <img src="../imagens/logo-rodape.svg" alt="logo-mediconnect">
                <p class="texto-pequeno">2023 &copy Todos os direitos reservados</p>
            </div>
        </div>
    </footer>
</body>