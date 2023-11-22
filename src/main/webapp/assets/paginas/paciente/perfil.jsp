<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <title>Perfil | MediConnect</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" type="image/x-icon" href="./assets/imagens/favicon.ico">
    <style><%@include file="../../estilos/padroes.css"%></style>
    <style><%@include file="../../estilos/paciente-perfil.css"%></style>
</head>
<body>
    <%@include file="../../componentes/cabecalhos/logado.html"%>
    <main>
        <section id="perfil">
            <div class="perfil-apresentacao">
                <div class="perfil-foto">
                    <img src="">
                    <!-- Foto inserida pelo paciente -->
                </div>
                <div class="perfil-editar">
                    <button class="botao-quadrado-m texto-enfase"> <a href="./editar-perfil">Editar Perfil </a> <img src="./assets/imagens/icone-editar.svg" alt="icone-editar"></button>
                </div>
            </div>
            <div class="template-grid">
                <div class="perfil-informacao">
                    <div class="perfil-dados">
                        <div class="perfil-imagem">
                            <img class="icone-claro" src="./assets/imagens/icone-paciente.svg" alt="icone-paciente">
                        </div>
                        <div class="perfil-detalhes">
                            <h2 class="subtitulo"> <c:out value="${paciente.nome}"/> <c:out value="${paciente.sobrenome}"/> </h2>
                            <p class="texto"> <c:out value="${paciente.email}"/> </p>
                        </div>
                    </div>
                    <div class="perfil-selos">
                        <div id="selo-assiduo">
                            <div class="selo-superior">
                                <img src="./assets/imagens/icone-selo-assiduo.svg">
                                <span></span>
                            </div>
                            <p class="texto-pequeno texto-roxo">Assíduo</p>
                        </div>
                        <div id="selo-pontual">
                            <div class="selo-superior">
                                <img src="./assets/imagens/icone-selo-pontual.svg">
                                <span></span>
                            </div>
                            <p class="texto-pequeno texto-roxo">Pontual</p>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <section id="conquistas" class="template-grid">
            <div id="container-conquistas">
                <div class="conquistas-superior"> <!-- Fundo roxo, flex-column, align-center -->
                    <div class="titulo-conquistas">
                        <img src="./assets/imagens/icone-conquista.svg">
                        <h2 class="subtitulo texto-claro">Conquistas</h2>
                    </div>
                    <div id="barra-conquistas">
                        <input type="range" min="0" max="10" disabled>
                        <!-- Informações necessárias:
                            max = quantidade de conquistas totais
                            value = conquistas completadas 
                            
                            Para mostrar o progresso, talvez seja necessário Javascript para alterar o width do -moz-range.
                        -->
                    </div>
                </div>
                <div class="conquistas-inferior">
                    <div class="conquista">
                        <img src="./assets/imagens/icone-profissional-favorito.svg">
                    </div>
                    <div class="conquista">
                        <img src="./assets/imagens/icone-nosso-presente.svg">
                    </div>
                    <div class="conquista">
                        <img src="./assets/imagens/icone-explorador.svg">
                    </div>
                    <div id="conquista-botao">
                        <a href="./conquistas-paciente" class="texto texto-roxo">Ver Todas</a>
                    </div>
                </div>                
            </div>
        </section>
        <section id="consultas">
            <div class="sessao-subtitulo">
                <h2 class="subtitulo">Consultas Próximas</h2>
            </div>
            <div id="consulta" class="template-grid">
                <div class="card-horizontal">
                    <p class="texto-enfase">Título da consulta</p>
                    <div class="info-direita">
                        <div class="info-variavel">
                            <div class="info-data">
                                <img src="./assets/imagens/icone-calendario.svg" alt="icone-calendario">
                                <p class="texto">12/02/2024</p>
                            </div>
                            <div class="info-horario">
                                <img src="./assets/imagens/icone-horario.svg" alt="icone-calendario">
                                <p class="texto">13h59</p>
                            </div>
                        </div>
                        <button class="botao-quadrado-p texto-enfase">Ver detalhes</button>
                    </div>
                </div>

                <div class="card-horizontal">
                    <p class="texto-enfase">Título da consulta</p>
                    <div class="info-direita">
                        <div class="info-variavel">
                            <div class="info-data">
                                <img src="./assets/imagens/icone-calendario.svg" alt="icone-calendario">
                                <p class="texto">12/02/2024</p>
                            </div>
                            <div class="info-horario">
                                <img src="./assets/imagens/icone-horario.svg" alt="icone-calendario">
                                <p class="texto">13h59</p>
                            </div>
                        </div>
                        <button class="botao-quadrado-p texto-enfase">Ver detalhes</button>
                    </div>
                </div>
            </div>
            <div class="ver-tudo">
                <button class="botao-quadrado-p texto-enfase"> <a href="./consultas">Ver todas </a><img src="./assets/imagens/icone-seta.svg" alt="icone-seta"></button>
            </div>
        </section>
    </main>
    <%@include file="../../componentes/rodape/rodape.jsp"%>
</body>
</html>