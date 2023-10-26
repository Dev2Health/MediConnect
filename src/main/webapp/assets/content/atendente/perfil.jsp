<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<title>Perfil de Atendente</title>
		<style><%@include file="../../styles/perfil-instituicao.css"%></style>
	</head>
	<body>
		<%@ include file="../../../menu.jsp"%>
<div>
        <input type="hidden" name="id" value="<c:out value='${atendente.id}' />" />
        <div>
        <img src="<c:out value='${atendente.imagem}'/>" alt="imagem-paciente">
        </div>
        <div>
        <img src="././images/icone-atendente.svg" alt="icone-atendente">
        <p><c:out value="${atendente.nome}"/> <c:out value="${atendente.sobrenome}"/></p>
        <p><c:out value="${atendente.email}" /></p> // Ou ao invés da tag p usar um input de date, mas acho melhor texto
        </div>
        <div>
        <p><c:out value="${atendente.instituicao}"/></p>
        <p><c:out value="${atendente.rua}" /></p> // Ou ao invés da tag p usar um input de date, mas acho melhor texto
        <p><c:out value="${atendente.cep}" /></p> // Ou ao invés da tag p usar um input de date, mas acho melhor texto
        </div>

        <p>Pacientes Cadastrados</p>
        <c:forEach var="paciente" items="${pacientes}">
        <input type="hidden" value="<c:out value='${paciente.id}'" />
        <div>
            <p><c:out value="${paciente.nome}" /> <c:out value="${paciente.sobrenome}" /></p>
            <p>Contato: <c:out value="${paciente.telefone}" /></p>
            <img src="././images/icone-informacoes.svg" alt="icone-informacoes">
            <p>Informações Gerais</p>
            <p>Data de Nascimento</p>
            <p><c:out value="${paciente.data}" /></p> // Ou ao invés da tag p usar um input de date, mas acho melhor texto
            <p>CPF</p>
            <p><c:out value="${paciente.cpf}" /></p> // Ou ao invés da tag p usar um input de date, mas acho melhor texto
        </div>
        <div>
            <img src="././images/icone-relogio.svg" alt="icone-horario">
            <p><c:out value="${paciente.horario}" /></p>
        </div>
        <div>
            <button>Ver detalhes</button>
            // Vai abrir um modal a partir do onClick
        </div>
        </c:forEach>
</div>
	</body>
</html>
    