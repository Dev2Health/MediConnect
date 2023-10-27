<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<title>Modal de Especialidade</title>
		<style><%@include file="../../styles/pagina-inicial.css"%></style>
	</head>
	<body>
		<%@ include file="../../../menu.jsp"%>
<div>
        <p>Especialidade - <c:out value="${especialidade.id}" /></p>
        <div>
            <img src="././images/icone-calendario.svg" alt="icone-calendario">
            <p><c:out value="${especialidade.nome}" /></p> // Ou ao invés da tag p usar um input de date, mas acho melhor texto
        </div>
        <div>
            <img src="././images/icone-profissional.svg" alt="icone-profissional">
			<p><c:out value="${especialidade.profissionais}" /></p>
        </div>
    </div>
			</div>
		</div>
	</body>
</html>
    