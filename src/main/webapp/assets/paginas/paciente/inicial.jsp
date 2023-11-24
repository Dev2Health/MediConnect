<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <title>Início | MediConnect</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" type="image/x-icon" href="../../images/favicon.ico">
    <style><%@include file="../../estilos/padroes.css"%></style>
    <style><%@include file="../../estilos/paciente-inicial.css"%></style>
</head>
<body>
    <%@include file="../../componentes/cabecalhos/logado.jsp"%>
    <main>
        <section id="inicio" class="template-grid">
            <div class="conteudo-esquerda">
                <div class="inicial-textos">
                    <h1 class="titulo-especial">Boas-vindas!</h1>
                    <h2 class="subtitulo-especial texto-roxo">Joana Castela</h2>
                </div>
                <div class="botao-inferior">
                    <button class="botao-circular-g texto"> <a href="./consultas" class="texto-claro">Ver Consultas</a> </button>
                </div>
            </div>
            <div class="conteudo-direita">
                <img src="../../imagens/ilustracao-paciente.svg" alt="ilustracao-paciente" class="ilustracao">
            </div>
        </section>
        <section id="consultas">
            <div class="template-grid titulo-sessao">
                <h2 class="titulo-especial">Consultas <span>pendentes</span></h2>
            </div>
            <div id="consulta" class="template-grid">
                <div class="cards-agrupamento">

                    <c:forEach var="consulta" items="${consultas}">
                    <div class="card-consulta">
                        <div class="dados-superior">
                            <div>
                                <p class="texto texto-roxo"> <c:out value="${consulta.especialidade}"/> </p>
                                <p class="texto-pequeno texto-roxo"> <c:out value="${consulta.endereco}"/> </p>
                            </div>
                            <p class="texto-pequeno texto-roxo"> <c:out value="${consulta.profissional}"/> </p>
                        </div>
                        <div class="dados-inferior">
                            <p class="texto-pequeno texto-roxo"> <c:out value="${consulta.data}"/> </p> <!-- Fazer o parse da data aqui -->
                            <div class="status-consulta">
                                <p class="texto-pequeno texto-claro">Confirmada</p>
                                <!-- 
                                    Verificar como será feito esses elementos, já que a cor muda conforme a informação (JSP traz o texto e Javascript modifica o estilo)
                                    .dados-inferior .status-consulta {
                                        background-color: var(--);
                                    }
                                -->
                            </div>
                        </div>
                    </div>
					</c:forEach>
                </div>
            </div>
        </section>
        <section id="Instituicoes">
            <div class="template-grid titulo-sessao">
                <h2 class="titulo-especial">Instituições <span>visitadas</span></h2>
            </div>
            <div id="instituicao" class="template-grid">
                <div class="cards-agrupamento">

                    <div class="card-instituicao">
                        <div class="card-foto">
                            <img src="">
                            <!-- Pegar a imagem de perfil da instituição -->
                        </div>
                        <h2 class="subtitulo-especial texto-claro">Instituição Fritz Müller</h2>
                    </div>

                </div>
            </div>
        </section>
    </main>

    <%@include file="../../componentes/rodape/rodape.jsp"%>

</body>
</html>