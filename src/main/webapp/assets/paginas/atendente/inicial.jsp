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
    <%@include file="../../componentes/cabecalhos/logado.jsp"%>
    <main>
        <section id="inicio" class="template-grid">
            <div class="conteudo-esquerda">
                <img src="./assets/imagens/ilustracao-atendente.svg" alt="ilustracao-atendente" class="ilustracao">
                <button class="botao-circular-g"><a href="./pacientes.jsp" class="texto texto-claro">Ver pacientes</a></button>
            </div>
            <div class="conteudo-direita">
                <h1 class="titulo-especial">Boas-vindas!</h1>
                <h2 class="subtitulo-especial texto-roxo"><c:out value="${atendente.nome}"/> <c:out value="${atendente.sobrenome}"/></h2>
                <h2 class="subtitulo-especial texto-azul"><c:out value="${instituicao.nomeFantasia}"/></h2>
            </div>
        </section>
        <section id="pacientes">
            <div class="template-grid titulo-sessao">
                <h1 class="titulo-especial texto-roxo">Pacientes de Hoje</h1>
            </div>

            <div id="paciente" class="template-grid">
                <div class="cards-agrupamento">
                    <c:forEach var="paciente" items="${pacientes}">
                    <div class="card-entidade">
                        <div class="card-superior">
                            <div class="entidade-imagem">
                                <img src="./assets/imagens/perfil-exemplo.jpg" alt="foto-de-perfil">
                            </div>
                            <div class="entidade-informacao">
                                <p class="texto"><c:out value="${paciente.nome}"/> <c:out value="${paciente.sobrenome}"/></p>
                                <p class="texto-sem-enfase"><c:out value="${paciente.telefone}"/></p>
                            </div>
                        </div>
                        <div class="card-inferior">
                            <div class="inferior-informacoes">
                                <p class="texto-sem-enfase"><span class="texto-enfase">Horário:</span> <c:out value="${consulta.horario}"/></p>
                                <p class="texto-sem-enfase"><span class="texto-enfase">CPF:</span> <c:out value="${paciente.cpf}"/></p>
                                <p class="texto-sem-enfase"><span class="texto-enfase">Profissional:</span> <c:out value="${profissional.nome}"/></p>
                                <p class="texto-sem-enfase"><span class="texto-enfase">Especialidade:</span> <c:out value="${especialidade.nome}"/></p>
                            </div>
                            <div class="inferior-status">
                                <div class="status">
                                    <p class="texto-enfase texto-claro"><c:out value="${consulta.status}"/></p>
                                </div>
                            </div>
                        </div>
                    </div>
                    </c:forEach>

                </div>
            </div>
        </section>
    </main>
    <%@include file="../../componentes/rodape/rodape.jsp"%>
    <script><%@include file="../../scripts/modal-lateral.js"%></script>
</body>
</html>