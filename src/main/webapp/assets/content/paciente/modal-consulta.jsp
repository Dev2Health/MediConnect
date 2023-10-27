<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<title>Cadastro de Consulta</title>
		<style><%@include file="../../styles/pagina-inicial.css"%></style>
	</head>
	<body>
		<%@ include file="../../../menu.jsp"%>
<div>
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
            <img src="././images/icone-especialidade.svg" alt="icone-instituicao">
			<p><c:out value="${consulta.especialidade}" /></p>
        </div>
            <img src="././images/icone-instituicao.svg" alt="icone-instituicao">
			<p><c:out value="${consulta.instituicao}" /></p>
        <div>
            <img src="././images/icone-profissional.svg" alt="icone-instituicao">
			<p><c:out value="${consulta.profissional}" /></p>
        </div>
    </div>
			</div>
		</div>
	</body>
</html>
    