<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <title>Início | MediConnect</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" type="image/x-icon" href="./assets/imagens/favicon.ico">
    <style><%@include file="../../estilos/padroes.css"%></style>
    <style><%@include file="../../estilos/atendente-inicial.css"%></style>
</head>
<body>
    <header id="cabecalho" class="template-grid">
        <nav class="barra-navegacao">
            <img src="./assets/imagens/icone-menu.svg" alt="icone-menu">
            <img src="./assets/imagens/logo.svg" alt="logo-mediconnect">
        </nav>
    </header>
    <main>
        <section id="inicio" class="template-grid">
            <div class="conteudo-esquerda">
                <img src="./assets/imagens/ilustracao-atendente.svg" alt="ilustracao-atendente" class="ilustracao">
                <button class="botao-circular-g"><a href="./pacientes.jsp" class="texto texto-claro">Ver pacientes</a></button>
            </div>
            <div class="conteudo-direita">
                <h1 class="titulo-especial">Boas-vindas!</h1>
                <h2 class="subtitulo-especial texto-roxo">Joana Castela</h2>
                <h2 class="subtitulo-especial texto-azul">Hospital Fritz Müller</h2>
            </div>
        </section>
        <section id="pacientes">
            <div class="template-grid titulo-sessao">
                <h1 class="titulo-especial texto-roxo">Pacientes de Hoje</h1>
            </div>

            <div id="paciente" class="template-grid">
                <div class="cards-agrupamento">

                    <div class="card-entidade">
                        <div class="card-superior">
                            <div class="entidade-imagem">
                                <img src="./assets/imagens/perfil-exemplo.jpg" alt="foto-de-perfil">
                            </div>
                            <div class="entidade-informacao">
                                <p class="texto">Mario de Oliveira</p>
                                <p class="texto-sem-enfase">(47) 9 9143 1234</p>
                            </div>
                        </div>
                        <div class="card-inferior">
                            <div class="inferior-informacoes">
                                <p class="texto-sem-enfase"><span class="texto-enfase">Horário:</span> 12h39</p>
                                <p class="texto-sem-enfase"><span class="texto-enfase">CPF:</span> 123.456.745-25</p>
                                <p class="texto-sem-enfase"><span class="texto-enfase">Profissional:</span> Dr. Cláudia</p>
                                <p class="texto-sem-enfase"><span class="texto-enfase">Especialidade:</span> Clínico Geral</p>
                            </div>
                            <div class="inferior-status">
                                <div class="status">
                                    <p class="texto-enfase texto-claro">Agendada</p>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </section>
    </main>
    <%@include file="../../componentes/rodape/rodape.jsp"%>
</body>
</html>