<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <title>Atendentes | MediConnect</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" type="image/x-icon" href="./assets/imagens/favicon.ico">
    <style><%@include file="../../estilos/padroes.css"%></style>
    <style><%@include file="../../estilos/pagina-inicial.css"%></style>
</head>
<body>
<%@include file="../../componentes/cabecalhos/filtro.jsp"%>
    <main>
        <div id="pesquisa-retornar" class="template-grid">
            <div id="retornar-atendente">
                <p class="subtitulo texto-azul">Atendentes da instituição</p>
                <button class="botao-quadrado-p texto-enfase"> <a href="./cadastrar-atendente"> Adicionar <img src="./assets/imagens/icone-adicionar.svg"></a></button>
            </div>
        </div>

        <div id="atendente" class="template-grid">

            <div class="card-horizontal">
                <p class="texto-enfase"> AQUI <c:out value='${atendente.id}' /> <c:out value="${atendente.nome}"/> <c:out value="${atendente.sobrenome}"/></p>
                <div class="info-direita">
                    <div class="info-variavel">
                        <img src="./assets/imagens/icone-deletar.svg" alt="icone-deletar">
                        <img src="./assets/imagens/icone-editar-dados.svg" alt="icone-editar">
                    </div>
                    <button class="botao-quadrado-p texto-enfase texto-claro">Ver detalhes</button>
                </div>
            </div>
        </div>
    </main>
<%@include file="../../componentes/rodape/rodape.jsp"%>
</main>
</body>
</html>