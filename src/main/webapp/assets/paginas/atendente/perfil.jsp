<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <title>Perfil | MediConnect</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" type="image/x-icon" href="./assets/imagens/favicon.ico">
    <style><%@include file="../../estilos/padroes.css"%></style>
    <style><%@include file="../../estilos/atendente-perfil.css"%></style>
</head>
<body>
    <%@include file="../../componentes/cabecalhos/logado.jsp"%>
    <main>
        <section id="perfil">
            <div class="perfil-apresentacao">
                <div class="perfil-foto">
                    <img src="<c:out value='${urlFoto}'/>">
                </div>
                <div class="perfil-editar">
                    <button class="botao-quadrado-m texto-enfase"><a href="./editar-perfil">Editar Perfil</a><img src="./assets/imagens/icone-editar.svg" alt="icone-editar"></button>
                </div>
            </div>
            <div id="informacoes-atendente" class="template-grid">
                <div class="perfil-informacao">
                    <div class="perfil-imagem">
                        <img class="icone-claro" src="./assets/imagens/icone-paciente.svg" alt="icone-atendente">
                    </div>
                    <div class="perfil-detalhes">
                        <h2 class="subtitulo"><c:out value="${atendente.nome}"/> <c:out value="${atendente.sobrenome}"/></h2>
                        <p class="texto"><c:out value="${atendente.email}"/></p>
                    </div>
                </div>
                <div class="perfil-informacao">
                    <div class="perfil-imagem">
                        <img class="icone-claro" src="./assets/imagens/icone-instituicao.svg" alt="icone-instituicao">
                    </div>
                    <div class="perfil-detalhes">
                        <c:if test="${atendente.instituicao != null}"/>
                            <h2 class="subtitulo"><c:out value="${instituicao.nomeFantasia}"/></h2>
                            <div class="instituicao-dados">
                                <p class="texto"><c:out value="${endereco.logradouro}"/></p>
                                <p class="texto">CEP <c:out value="${endereco.cep}"/></p>
                            </div>
                    </div>
                </div>
            </div>
        </section>
        <section id="consultas">
            <div class="sessao-subtitulo">
                <h2 class="subtitulo">Consultas Agendadas</h2>
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
                <button class="botao-quadrado-p texto-enfase"><a href="./consultas-atendente"> Ver todas </a><img src="./assets/imagens/icone-seta.svg" alt="icone-seta"></button>
            </div>
        </section>
        <section id="pacientes">
            <div class="sessao-subtitulo">
                <h2 class="subtitulo">Pacientes Cadastrados</h2>
            </div>
            <div id="pacientes" class="template-grid"> 
                <div class="cards-agrupamento">
                    <div class="card-entidade">
                        <div class="card-superior">
                            <div class="entidade-imagem">
                                <img src="./assets/imagens/perfil-exemplo.jpg" alt="foto-de-perfil">
                            </div>
                            <div class="entidade-informacao">
                                <p class="texto">Mario de Oliveira</p>
                                <p class="texto-sem-enfase">Contato: (47) 9 9721 2859</p>
                            </div>
                        </div>
                        <div class="card-meio">
                            <img src="./assets/imagens/icone-informacoes.svg" alt="icone-informações">
                            <p class="texto">Informações Gerais</p>
                        </div>
                        <div class="card-inferior">
                            <div class="inferior-informacao">
                                <p class="texto-sem-enfase">Data de nascimento</p>
                                <p class="texto-sem-enfase">09/09/1984</p>
                            </div>
                            <div class="inferior-informacao">
                                <p class="texto-sem-enfase">CPF</p>
                                <p class="texto-sem-enfase">123.456.789-10</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="ver-tudo">
                <button  class="botao-quadrado-p texto-enfase"><a href="./pacientes-atendente"> Ver todas </a><img src="./assets/imagens/icone-seta.svg" alt="icone-seta"></button>
            </div>
        </section>
    </main>
    <%@include file="../../componentes/rodape/rodape.jsp"%>
</body>
</html>