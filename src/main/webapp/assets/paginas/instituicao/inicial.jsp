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
    <style><%@include file="../../estilos/instituicao-inicial.css"%></style>
</head>
<body>
     <%--<%@include file="../../componentes/cabecalhos/logado.jsp"%>--%>
    <main>
        <section id="inicio" class="template-grid">
            <div class="conteudo-esquerda">
                <img src="./assets/imagens/ilustracao-instituicao.svg" alt="ilustracao-instituicao" class="ilustracao">
            </div>
            <div class="conteudo-direita">
                <div class="inicial-textos">
                    <h1 class="titulo-especial">Boas-vindas!</h1>
                    <h2 class="subtitulo-especial texto-azul">Hospital Santo Antônio </h2>
                </div>
                <div class="botao-inferior">
                    <button class="botao-circular-g texto"><a href="./atendentes-instituicao" class="texto-claro">Ver Atendentes</a></button>
                </div>
            </div>
        </section>
        <section id="atendentes">
            <div class="template-grid titulo-sessao">
                <h2 class="titulo-especial">Atendentes <span>recentes</span></h2>
            </div>
            <div id="atendente" class="template-grid">
                <div class="cards-agrupamento">
                    <div class="card-entidade">
                        <div class="card-superior">
                            <div class="entidade-imagem">
                                <img src="./assets/imagens/perfil-exemplo.jpg" alt="foto-de-perfil">
                            </div>
                            <div class="entidade-informacao">
                                <p class="texto">Gleice Silva Pinheiro</p>
                                <p class="texto-sem-enfase">Nº Cadastro 456456</p>
                            </div>
                        </div>
                        <div class="card-meio">
                            <img src="./assets/imagens/icone-informacoes.svg" alt="icone-informações">
                            <p class="texto">Informações Gerais</p>
                        </div>
                        <div class="card-inferior">
                            <div class="inferior-informacao">
                                <p class="texto-sem-enfase">Data de cadastro</p>
                                <p class="texto-sem-enfase">18/04/2000</p>
                            </div>
                            <div class="inferior-informacao">
                                <p class="texto-sem-enfase">CTPS</p>
                                <p class="texto-sem-enfase">123.456.789-10</p>
                            </div>
                        </div>
                    </div>
                    <div class="card-entidade">
                        <div class="card-superior">
                            <div class="entidade-imagem">
                                <img src="./assets/imagens/perfil-exemplo.jpg" alt="foto-de-perfil">
                            </div>
                            <div class="entidade-informacao">
                                <p class="texto">Gleice Silva Pinheiro</p>
                                <p class="texto-sem-enfase">Nº Cadastro 456456</p>
                            </div>
                        </div>
                        <div class="card-meio">
                            <img src="./assets/imagens/icone-informacoes.svg" alt="icone-informações">
                            <p class="texto">Informações Gerais</p>
                        </div>
                        <div class="card-inferior">
                            <div class="inferior-informacao">
                                <p class="texto-sem-enfase">Data de cadastro</p>
                                <p class="texto-sem-enfase">18/04/2000</p>
                            </div>
                            <div class="inferior-informacao">
                                <p class="texto-sem-enfase">CTPS</p>
                                <p class="texto-sem-enfase">123.456.789-10</p>
                            </div>
                        </div>
                    </div>
                    <div class="card-entidade">
                        <div class="card-superior">
                            <div class="entidade-imagem">
                                <img src="./assets/imagens/perfil-exemplo.jpg" alt="foto-de-perfil">
                            </div>
                            <div class="entidade-informacao">
                                <p class="texto">Gleice Silva Pinheiro</p>
                                <p class="texto-sem-enfase">Nº Cadastro 456456</p>
                            </div>
                        </div>
                        <div class="card-meio">
                            <img src="./assets/imagens/icone-informacoes.svg" alt="icone-informações">
                            <p class="texto">Informações Gerais</p>
                        </div>
                        <div class="card-inferior">
                            <div class="inferior-informacao">
                                <p class="texto-sem-enfase">Data de cadastro</p>
                                <p class="texto-sem-enfase">18/04/2000</p>
                            </div>
                            <div class="inferior-informacao">
                                <p class="texto-sem-enfase">CTPS</p>
                                <p class="texto-sem-enfase">123.456.789-10</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <section id="especialidades">
            <div class="template-grid titulo-sessao">
                <h2 class="titulo-especial">Especialidades</h2>
                <h3 class="subtitulo-especial">Quantidade de profissionais</h3>
            </div>
            <div id="especialidade" class="template-grid">
                <div class="label-agrupamento">
    
                    <div class="label-especialidade">
                        <div class="label-titulo">
                            <p class="texto">Cardiologia</p>
                        </div>
                        <div class="label-profissionais">
                            <img src="./assets/imagens/icone-profissional.svg" alt="icone-profissional">
                            <div class="quantidade">
                                <p class="texto-enfase">8</p>
                            </div>
                        </div>
                    </div>
                    
                    <div class="label-especialidade">
                        <div class="label-titulo">
                            <p class="texto">Dermatologia</p>
                        </div>
                        <div class="label-profissionais">
                            <img src="./assets/imagens/icone-profissional.svg" alt="icone-profissional">
                            <div class="quantidade">
                                <p class="texto-enfase">4</p>
                            </div>
                        </div>
                    </div>

                    <div class="label-especialidade">
                        <div class="label-titulo">
                            <p class="texto">Ortopedia</p>
                        </div>
                        <div class="label-profissionais">
                            <img src="./assets/imagens/icone-profissional.svg" alt="icone-profissional">
                            <div class="quantidade">
                                <p class="texto-enfase">2</p>
                            </div>
                        </div>
                    </div>

                    <div class="label-especialidade">
                        <div class="label-titulo">
                            <p class="texto">Oftalmologia</p>
                        </div>
                        <div class="label-profissionais">
                            <img src="./assets/imagens/icone-profissional.svg" alt="icone-profissional">
                            <div class="quantidade">
                                <p class="texto-enfase">6</p>
                            </div>
                        </div>
                    </div>

                    <div class="label-especialidade">
                        <div class="label-titulo">
                            <p class="texto">Radiologia</p>
                        </div>
                        <div class="label-profissionais">
                            <img src="./assets/imagens/icone-profissional.svg" alt="icone-profissional">
                            <div class="quantidade">
                                <p class="texto-enfase">5</p>
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