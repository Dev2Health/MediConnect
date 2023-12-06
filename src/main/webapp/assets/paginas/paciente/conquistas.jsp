<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <title>Conquistas | MediConnect</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" type="image/x-icon" href="../../images/favicon.ico">
    <link rel="stylesheet" type="text/css" href="../../styles/padroes.css">
</head>

<body>
    <%@include file="../../componentes/cabecalhos/voltar.jsp"%>

    <main>
        <section>
            <h2 class="title">Conquistas completas</h2>
            <c:forEach var="conquistaCompleta" items="${conquistas}">
                <div><!--agrupamento-->
                    <input type="hidden" value="<c:out value='${conquistaCompleta.id}'/>" />
                    <div><!--caixa-->
                        <div><!--icone-->
                            <img src="../../imagens/icone-<c:out value='${conquistaCompleta.nome}' />.svg" alt="icone-<c:out value='${conquistaCompleta.nome}' />">
                    </div>
                    <div><!--texto-->
                        <h2 class="subtitle"><c:out value='${conquistaCompleta.nome}' /></h2>
                        <p class="text-no-emphasis"><c:out value='${conquistaCompleta.descricao}' /></p>
                    </div>
                    <div><!--nível-->
                        <div>
                            <p class="text-emphasis">Nível 1</p>
                        </div>
                        <div>
                            <p class="text-emphasis">--/--</p>
                        </div>
                    </div>
                </div>
                <input type="range" min="0" max="">
            </c:forEach>

        </section>

        <section>
            <h2 class="title">Conquistas em andamento</h2>

            <c:forEach var="conquistaAndamento" items="${conquistas}">
                <div><!--agrupamento-->
                    <input type="hidden" value="<c:out value='${conquistaAndamento.id}'/>" />
                    <div><!--caixa-->
                        <div><!--icone-->
                            <img src="../../imagens/icone-<c:out value='${conquistaAndamento.nome}' />.svg" alt="icone-<c:out value='${conquistaAndamento.nome}' />">
                    </div>
                    <div><!--texto-->
                        <h2 class="subtitle"><c:out value='${conquistaAndamento.nome}' /></h2>
                        <p class="text-no-emphasis"><c:out value='${conquistaAndamento.descricao}' /></p>
                    </div>
                    <div><!--nível-->
                        <div>
                            <p class="text-emphasis">Nível 1</p>
                        </div>
                        <div>
                            <p class="text-emphasis">--/--</p>
                        </div>
                    </div>
                </div>
                <input type="range" min="0" max=""> <!-- JSP deve pegar a informação dos valores máximos do nível da conquista -->
            </c:forEach>

        </section>
    </main>
<%@include file="../../componentes/rodape/rodape.jsp"%>
</body>

</html>