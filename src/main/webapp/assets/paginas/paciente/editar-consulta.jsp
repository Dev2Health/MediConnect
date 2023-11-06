<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <title>Editar Consulta | MediConnect</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" type="image/x-icon" href="../../images/favicon.ico">
    <link rel="stylesheet" type="text/css" href="../../styles/padroes.css">
    <link rel="stylesheet" type="text/css" href="../../styles/editar-consulta-paciente.css">
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
            <h1 class="title">Alterar dados da consulta</h1>
        </div>
        <form action="atualizar-consulta" method="post" autocomplete="on" id="content-form" class="template-grid">
            <div class="form-left">
                <div class="form-input">
                    <div class="input-icon">
                        <img src="../../images/icone-horario.svg" alt="icone-horario" id="icon-time">
                    </div>
                    <div class="input-itens">
                        <label for="time" class="text">Horário</label>
                        <input class="text-emphasis" type="time" id="c.horario" name="horario"
                        value="<c:out value='${consulta.horario}'/>" required>
                    </div>
                </div>
                <div class="form-input">
                    <div class="input-icon">
                        <img src="../../images/icone-profissional.svg" alt="icone-profissional" id="icon-professional">
                    </div>
                    <div class="input-itens">
                        <label for="professional" class="text">Profissional</label>
                        <input list="professionals" class="text-emphasis" type="text" id="professional"
                            name="professional" value="<c:out value='${consulta.profissional}'/>" required>
                        <datalist id="professionals">
                            <c:forEach var="profissional" items="${profissionais}">
                            <option value="<c:out value='${profissional.nome}'/>"></option>
                            </c:forEach>
                        </datalist>
                    </div>
                </div>
                <div class="checkbox">
                    <input type="checkbox">
                    <p class="text-no-emphasis">Li e estou de acordo com o <a href="#" class="text-emphasis link-purple">Termo de Uso e Política de Privacidade</a></p>
                </div>
                <div class="form-footer">
                    <button class="btn-round-sm text-emphasis link-light" type="submit">Salvar Alterações</button>
                    <button class="btn-round-sm text-emphasis link-purple" type="reset">Descartar Alterações</button>
                </div>
            </div>
            <div class="form-right">
                <div class="form-input">
                    <div class="input-icon">
                        <img src="../../images/icone-calendario.svg" alt="icone-calendario">
                    </div>
                    <div class="input-itens">
                        <label for="date" class="text">Data</label>
                        <input class="text-emphasis" type="datetime" value="<fmt:formatDate pattern = 'dd/MM/yyyy' value = '${dataNascimento}'/>" id="p.data" name="data"
                            required>
                    </div>
                </div>
                <div class="form-input">
                    <div class="input-icon">
                        <img src="../../images/icone-consulta.svg" alt="icone-consulta">
                    </div>
                    <div class="input-itens">
                        <label for="status" class="text">Status da Consulta</label>
                        <input list="status-list" class="text-emphasis" type="text" id="status" name="status"
                            placeholder="(Selecione o Status)" required>
                        <datalist id="status-list"> <!--A listagem deve ser feita para o JSP-->
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