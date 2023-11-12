<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<title>Cadastro de Consulta</title>
		<style><%@include file="../../estilos/pagina-inicial.css"%></style>
	</head>
	<body>
<div>
        <c:forEach var="consulta" items="${consultas}">
        <p>Consulta - <c:out value="${consulta.id}" /></p>
        <div>
            <img src="././images/icone-calendario.svg" alt="icone-calendario">
            <p><c:out value="${consulta.data}" /></p> // Ou ao invés da tag p usar um input de date, mas acho melhor texto
        </div>
        <div>
            <img src="././images/icone-relogio.svg" alt="icone-horario">
            <p><c:out value="${consulta.horario}" /></p>
        </div>
        <div>
            <button>Ver detalhes</button>
            // Vai abrir um modal a partir do onClick
        </div>
        </c:forEach>
</div>
	</body>
</html>
    