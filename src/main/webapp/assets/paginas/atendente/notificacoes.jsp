<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <title>Notificações | MediConnect</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" type="image/x-icon" href="./assets/imagens/favicon.ico">
    <style><%@include file="../../estilos/padroes.css"%></style>
    <style><%@include file="../../estilos/notificacoes.css"%></style>
</head>
<body>
    <%@include file="../../componentes/cabecalhos/filtro.jsp"%>
    <main>
        <div id="notificacoes" class="template-grid">
            <c:forEach var="notificacao" items="${notificacoes}" >
                <div class="card-notificacao">
                    <div class="notificacao-superior">
                        <h2 class="subtitulo">Notificação</h2>
                        <!-- Adicionar o título da notificação com o JSP -->
                        <div class="informacoes-consulta">
                            <div class="informacao-data">
                                <img src="./assets/imagens/icone-calendario.svg" alt="icone-calendario">
                                <p class="texto">
                                    <c:out value="${notificacao.data}" />
                                </p>
                            </div>
                            <div class="informacao-horario">
                                <img src="./assets/imagens/icone-horario.svg" alt="icone-horario">
                                <p class="texto"> 
                                    <c:out value="${notificacao.horario}"/>
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="notificacao-inferior">
                        <p class="texto-sem-enfase">
                            <c:out value="${notificacao.descricao}"/>
                        </p>
                    </div>
                </div>
                <div class="card-notificacao">
                    <div class="notificacao-superior">
                        <h2 class="subtitulo">Notificação</h2>
                        <div class="informacoes-consulta">
                            <div class="informacao-data">
                                <img src="./assets/imagens/icone-calendario.svg" alt="icone-calendario">
                                <p class="texto">
                                    <c:out value="${notificacao.data}" />
                                </p>
                            </div>
                            <div class="informacao-horario">
                                <img src="./assets/imagens/icone-horario.svg" alt="icone-horario">
                                <p class="texto"> 
                                    <c:out value="${notificacao.horario}"/>
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="notificacao-inferior">
                        <p class="texto-sem-enfase">
                            <c:out value="${notificacao.descricao}"/>
                        </p>
                    </div>
                </div>
            </c:forEach>
        </div>
    </main>
<%@include file="../../componentes/rodape/rodape.jsp"%>
</body>
</html>