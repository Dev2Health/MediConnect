<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <title>Agendar Consulta | MediConnect</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" type="image/x-icon" href="../../images/favicon.ico">
    <link rel="stylesheet" type="text/css" href="../../styles/padroes.css">
    <link rel="stylesheet" type="text/css" href="../../styles/agendar-consulta-paciente.css">
</head>
<body>
    <header id="content-header" class="template-grid">
        <nav class="nav-bar">
            <img src="../../images/icone-menu.svg" alt="icone-menu">
            <img src="../../images/logo.svg" alt="logo-mediconnect">
        </nav>
    </header>
    <main>
        <div class="template-grid">
            <h1 class="title">Informe seus dados</h1>
        </div>
        <form action="inserir-consulta" method="post" autocomplete="on" id="content-form" class="template-grid">
            <div class="form-left">

                <div class="form-input">
                    <input type="hidden" name="id" value="<c:out value='${consulta.id}' />" />
                    <div class="input-icon">
                        <img src="../../images/icone-horario.svg" alt="icone-horario" id="icon-time">
                    </div>
                    <div class="input-itens">
                        <label for="time" class="text">Horário</label>
                        <input class="text-emphasis" type="time" id="c.horario" name="horario"
                            placeholder="(Selecione o Horário)" required>
                    </div>
                </div>
                <div class="form-input">
                    <div class="input-icon">
                        <img src="../../images/icone-especialidade.svg" alt="icone-especialidade">
                    </div>
                    <div class="input-itens">
                        <label for="specialty" class="text">Especialidade</label>
                        <input list="specialties" class="text-emphasis" type="text" id="c.especialidade" name="especialidade"
                            placeholder="(Selecione a Especialidade)" required>
                        <datalist id="specialties">
                            <c:forEach var="especialidade" items="${especialidades}">
                            <option value="<c:out value='${especialidade.nome}'/>"></option>
                            </c:forEach>
                        </datalist>
                    </div>
                </div>
                <div class="form-input">
                    <div class="input-icon">
                        <img src="../../images/icone-profissional.svg" alt="icone-profissional" id="icon-professional">
                    </div>
                    <div class="input-itens">
                        <label for="professional" class="text">Profissional</label>
                        <input list="professionals" class="text-emphasis" type="text" id="c.profissional" name="profissional" placeholder="(Selecione o Profissional)" required>
                        <datalist id="professionals">
                            <c:forEach var="profissional" items="${profissionais}">
                                <option value="<c:out value='${profissional.nome}'/>"></option>
                                </c:forEach>
                        </datalist>
                    </div>
                </div>
                <div class="form-footer">
                    <button class="btn-round-sm text-emphasis link-light" type="submit">Agendar consulta</button>
                    <button class="btn-round-sm text-emphasis link-purple" type="reset">Cancelar consulta</button>
                </div>
            </div>
            <div class="form-right">
                <div class="form-input">
                    <div class="input-icon">
                        <img src="../../images/icone-calendario.svg" alt="icone-calendario">
                    </div>
                    <div class="input-itens">
                        <label for="date" class="text">Data</label>
                        <input class="text-emphasis" type="date" id="c.data" name="data"
                            placeholder="(Selecione a Data)" required>
                    </div>
                </div>
                <div class="form-input">
                    <div class="input-icon">
                        <img src="../../images/icone-instituicao.svg" alt="icone-instituicao">
                    </div>
                    <div class="input-itens">
                        <label for="instituition" class="text">Instituição</label>
                        <input list="institutions" class="text-emphasis" type="text" id="institution"
                            name="institution" placeholder="(Selecione a Instituição)" required>
                        <datalist id="institutions">
                            <c:forEach var="instituicao" items="${instituicoes}">
                            <option value="<c:out value='${instituicao.nome}'/>"></option>
                            </c:forEach>
                        </datalist>
                    </div>
                </div>
            </div>
        </form>
    </main>
</body>
</html>