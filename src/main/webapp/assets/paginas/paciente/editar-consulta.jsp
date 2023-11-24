<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <title>Editar Consulta | MediConnect</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" type="image/x-icon" href="./assets/imagens/favicon.ico">    
    <style><%@include file="../../estilos/padroes.css"%></style>
    <style><%@include file="../../estilos/paciente-editar-consulta.css"%></style>
</head>
<body>
    <%@include file="../../componentes/cabecalhos/voltar.jsp"%>
    <main>
        <div class="template-grid">
            <h1 class="titulo texto-roxo">Alterar dados da consulta</h1>
        </div>
        <form action="atualizar-consulta" method="post" class="template-grid" autocomplete="off">
            <div class="formulario-esquerda">

                <div class="formulario-input">
                    <div class="input-icone">
                        <img src="./assets/imagens/icone-horario.svg" alt="icone-horario">
                    </div>
                    <div class="input-item">
                        <label for="horario" class="texto">Horário</label>
                        <input class="texto-enfase" type="time" id="i.horario" name="horario" value="<c:out value='${consulta.horario}'/>">
                    </div>
                </div>
                <div class="formulario-input">
                    <div class="input-icone">
                        <img src="./assets/imagens/icone-profissional.svg" alt="icone-profissional">
                    </div>
                    <div class="input-item">
                        <label for="profissional" class="texto">Profissional</label>
                        <input class="texto-enfase" list="lista-profissional" type="text" id="i.profissional" name="profissional" value="<c:out value='${consulta.profissional}'/>">
                        <datalist id="lista-profissional">
                            <c:forEach var="profissional" items="${profissionais}">
                                <option value="<c:out value='${profissional.nome}'/>"></option>
                            </c:forEach>
                        </datalist>
                    </div>
                </div>
                <div class="checkbox">
                    <input type="checkbox">
                    <p class="texto-sem-enfase">Li e estou de acordo com o <a href="#" class="texto-enfase texto-roxo">Termo de Uso e Política de Privacidade</a></p>
                </div>
                <div class="botoes">
                    <button class="botao-circular-m texto-enfase texto-claro" type="submit">Salvar alterações</button>
                    <button class="botao-circular-m texto-enfase texto-roxo" type="reset">Descartar alterações</button>
                </div>
            </div>
            <div class="formulario-direita">
                <div class="formulario-input">
                    <div class="input-icone">
                        <img src="./assets/imagens/icone-calendario.svg" alt="icone-calendario">
                    </div>
                    <div class="input-item">
                        <label for="data" class="texto">Data de Cadastro</label>
                        <input class="texto-enfase" type="datetime" id="i.data" name="data" value="<fmt:formatDate pattern = 'dd/MM/yyyy' value = '${dataNascimento}'/>">
                    </div>
                </div>
                <div class="formulario-input">
                    <div class="input-icone">
                        <img src="./assets/imagens/icone-consulta.svg" alt="icone-status">
                    </div>
                    <div class="input-item">
                        <label for="status" class="texto">Status da Consulta</label>
                        <input class="texto-enfase" list="lista-status" type="text" id="i.status" name="status" placeholder="(Alterar Status)">
                        <datalist id="lista-status">
                            <c:forEach var="status" items="${statuses}">
                                <option value="<c:out value='${status}'/>"></option>
                            </c:forEach>
                        </datalist>
                    </div>
                </div>
            </div>
        </form>
    </main>
</body>
</html>