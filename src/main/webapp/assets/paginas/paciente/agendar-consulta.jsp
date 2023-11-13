<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <title>Agendar Consulta | MediConnect</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" type="image/x-icon" href="./assets/imagens/favicon.ico">
    <style><%@include file="../../estilos/padroes.css"%></style>
    <style><%@include file="../../estilos/paciente-agendar-consulta.css"%></style>
</head>
<body>
    <header id="cabecalho" class="template-grid">
        <nav class="barra-navegacao">
            <img src="./assets/imagens/icone-menu.svg" alt="icone-menu">
            <img src="./assets/imagens/logo.svg" alt="logo-mediconnect">
        </nav>
    </header>
    <main>
        <div class="template-grid">
            <h1 class="titulo texto-roxo">Agendar Consulta</h1>
        </div>
        <form action="inserir-consulta" method="post" class="template-grid">
            <!-- <input type="hidden" name="id" value="<c:out value='${consulta.id}' />" /> -->

            <div class="formulario-esquerda">
                <div class="formulario-input">
                    <div class="input-icone">
                        <img src="./assets/imagens/icone-horario.svg" alt="icone-horario">
                    </div>
                    <div class="input-item">
                        <label for="horario" class="texto">Horário</label>
                        <input class="texto-enfase" type="time" id="i.horario" name="horario" required>
                    </div>
                </div>
                <div class="formulario-input">
                    <div class="input-icone">
                        <img src="./assets/imagens/icone-especialidade.svg" alt="icone-especialidade">
                    </div>
                    <div class="input-item">
                        <label for="especialidade" class="texto">Especialidade</label>
                        <input class="texto-enfase" list="lista-especialidade" type="text" id="i.especialidade" name="especialidade" placeholder="(Selecione a Especialidade)" required>
                        <datalist id="lista-especialidade">
                            <c:forEach var="especialidade" items="${especialidades}">
                                <option value="<c:out value='${especialidade.nome}'/>"></option>
                            </c:forEach>
                        </datalist>
                    </div>
                </div>
                <div class="formulario-input">
                    <div class="input-icone">
                        <img src="./assets/imagens/icone-profissional.svg" alt="icone-profissional">
                    </div>
                    <div class="input-item">
                        <label for="profissional" class="texto">Profissional</label>
                        <input class="texto-enfase" list="lista-profissional" type="text" id="i.profissional" name="profissional" placeholder="(Selecione o Profissional)" required>
                        <datalist id="lista-profissional">
                            <c:forEach var="profissional" items="${profissionais}">
                                <option value="<c:out value='${profissional.nome}'/> <c:out value='${profissional.sobrenome}'/>"></option>
                                </c:forEach>
                        </datalist>
                    </div>
                </div>
                <div class="checkbox">
                    <input type="checkbox">
                    <p class="texto-sem-enfase">Li e estou de acordo com o <a href="#" class="texto-enfase texto-roxo">Termo de Uso e Política de Privacidade</a></p>
                </div>
                <div class="botoes">
                    <button class="botao-circular-m texto-enfase texto-claro" type="submit">Agendar Consulta</button>
                    <button class="botao-circular-m texto-enfase texto-roxo" type="reset">Cancelar Consulta</button>
                </div>
            </div>
            <div class="formulario-direita">
                <div class="formulario-input">
                    <div class="input-icone">
                        <img src="./assets/imagens/icone-calendario.svg" alt="icone-calendario">
                    </div>
                    <div class="input-item">
                        <label for="data" class="texto">Data</label>
                        <input class="texto-enfase" type="date" id="i.data" name="data" required>
                    </div>
                </div>
                <div class="formulario-input">
                    <div class="input-icone">
                        <img src="./assets/imagens/icone-instituicao.svg" alt="icone-instituicao">
                    </div>
                    <div class="input-item">
                        <label for="instituicao" class="texto">Instituição</label>
                        <input class="texto-enfase" list="lista-instituicao" type="text" id="i.instituicao" name="instituicao" placeholder="(Selecione a Instituicao)" required>
                        <datalist id="lista-instituicao">
                            <c:forEach var="instituicao" items="${instituicoes}">
                            <option value="<c:out value='${instituicao.nomeFantasia}'/>"></option>
                            </c:forEach>
                        </datalist>
                    </div>
                </div>
            </div>
        </form>
    </main>
</body>
</html>