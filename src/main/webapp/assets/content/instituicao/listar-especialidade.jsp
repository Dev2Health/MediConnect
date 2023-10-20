<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<title>Lista de Especialidade</title>
		<style><%@include file="../../styles/pagina-inicial.css"%></style>
	</head>
	<body>
		<%@ include file="../../../menu.jsp"%>
<div>
        <c:forEach var="especialidade" items="${especialidades}">
        <input type="hidden" name="id" value="<c:out value='${especialidade.id}' />" />
        <p><c:out value="${especialidade.nome}"/></p>
        <div>
            <img src="././images/icone-profissional.svg" alt="icone-profissional">
			<p><c:out value="${especialidade.profissionais}" /></p> // descobrir como pegar esse número
        </div>
        <div>
            <button>Ver detalhes</button>
            // Vai abrir um modal a partir do onClick
        </div>
        </c:forEach>
</div>
	</body>
</html>
    