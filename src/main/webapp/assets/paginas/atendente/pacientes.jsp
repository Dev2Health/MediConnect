<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <title>Pacientes | MediConnect</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" type="image/x-icon" href="./assets/imagens/favicon.ico">
    <style><%@include file="../../estilos/padroes.css"%></style>
    <style><%@include file="../../estilos/atendente-pacientes.css"%></style>
</head>
<body>
    <%@include file="../../componentes/cabecalhos/pesquisa-pacientes.jsp"%>
    <main>
        <section>
            <div class="template-grid">
                <h2 class="subtitulo">Pacientes com consulta hoje</h2>
            </div>
            <div class="pacientes template-grid">
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
        </section>
        <section>
            <div class="template-grid">
                <h2 class="subtitulo">Pacientes com consultas agendadas</h2>
            </div>
            <div class="pacientes template-grid">
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
        </section>
    </main>
    <%@include file="../../componentes/rodape/rodape.jsp"%>
</body>
</html>