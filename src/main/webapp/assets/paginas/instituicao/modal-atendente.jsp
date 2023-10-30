<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<title>Modal de Atendente</title>
		<style><%@include file="../../estilos/pagina-inicial.css"%></style>
	</head>
	<body>
		<%@ include file="../../../menu.jsp"%>
<div>
        <p>Atendente - <c:out value="${atendente.id}" /></p>
        <div>
            <img src="././images/icone-calendario.svg" alt="icone-calendario">
            <p>Contratação: <c:out value="${atendente.data}" /></p> // Ou ao invés da tag p usar um input de date, mas acho melhor texto
        </div>
        <div>
            <p><c:out value="${atendente.nome}" /> <c:out value="${atendente.sobrenome}" /></p>
        </div>
        <div>
            <img src="././images/icone-ctps.svg" alt="icone-especialidade">
			<p><c:out value="${atendente.ctps}" /></p>
        </div>
            <img src="././images/icone-instituicao.svg" alt="icone-instituicao">
			<p><c:out value="${atendente.instituicao}" /></p>
        <div>
            <img src="././images/icone-cpf.svg" alt="icone-profissional">
			<p><c:out value="${atendente.cpf}" /></p>
        </div>
    </div>
			</div>
		</div>
	</body>
</html>
    