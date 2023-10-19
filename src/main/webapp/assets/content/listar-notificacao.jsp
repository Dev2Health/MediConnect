<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<title>Lista de Notificacao</title>
		<style><%@include file="../styles/pagina-inicial.css"%></style>
	</head>
	<body>
		<%@ include file="../../../menu.jsp"%>
<div>
        <c:forEach var="atendente" items="${atendentes}">
        <button>
        <input type="hidden" name="id" value="<c:out value='${notificacao.id}' />" />
        <div>
            <img src="../images/icone-calendario.svg" alt="icone-calendario">
            <p>Contratação: <c:out value="${notificacao.data}" /></p> // Ou ao invés da tag p usar um input de date, mas acho melhor texto
        </div>
        <div>
            <img src="../images/icone-relogio.svg" alt="icone-relogio">
            <p>Contratação: <c:out value="${notificacao.horario}" /></p> // Ou ao invés da tag p usar um input de date, mas acho melhor texto
        </div>
        <div>
            <p>Contratação: <c:out value="${notificacao.descricao}" /></p> // Ou ao invés da tag p usar um input de date, mas acho melhor texto
        </div>
        </button>// Vai abrir um modal a partir do onClick
        </c:forEach>
</div>
	</body>
</html>
    