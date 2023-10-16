<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<title>Card de Consulta</title>
		<style><%@include file="../../styles/pagina-inicial.css"%></style>
	</head>
	<body>
		<%@ include file="../../../menu.jsp"%>
<div>
    </button>
        <p>Consulta - <c:out value="${consulta.id}" /></p>
        <div>
            <p><c:out value="${consulta.status}" /></p> // Ou ao invés da tag p usar um input de date, mas acho melhor texto
        </div>
        <div>
            <p><c:out value="${consulta.data}" /></p> // Ou ao invés da tag p usar um input de date, mas acho melhor texto
        </div>
        <div>
            <p><c:out value="${consulta.horario}" /></p>
        </div>
        <div>
			<p><c:out value="${consulta.descricao}" />...ver mais</p>
        </div>
    </div>
			</div>
		</div>
	</body>
</html>
    