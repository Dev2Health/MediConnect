<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<title>Lista de Atendente</title>
		<style><%@include file="../../styles/pagina-inicial.css"%></style>
	</head>
	<body>
		<%@ include file="../../../menu.jsp"%>
<div>
        <c:forEach var="atendente" items="${atendentes}">
        <input type="hidden" name="id" value="<c:out value='${atendente.id}' />" />
        <p><c:out value="${atendente.nome}"/> <c:out value="${atendente.sobrenome}"/></p>
        <div>
            <img src="././images/icone-calendario.svg" alt="icone-calendario">
            <p>Contratação: <c:out value="${atendente.data}" /></p> // Ou ao invés da tag p usar um input de date, mas acho melhor texto
        </div>
        <div>
            <button>Ver detalhes</button>
            // Vai abrir um modal a partir do onClick
        </div>
        </c:forEach>
</div>
	</body>
</html>
    