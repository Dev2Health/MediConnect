<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<title>Modal de Especialidade</title>
		<style><%@include file="../../estilos/pagina-inicial.css"%></style>
	</head>
	<body>
<div>
        <p>Especialidade - <c:out value="${especialidade.id}" /></p>
        <div>
            <img src="././images/icone-calendario.svg" alt="icone-calendario">
            <p><c:out value="${especialidade.nome}" /></p>
        </div>
        <div>
            <p>profissionais Cadastrados</p>
            <img src="././images/icone-profissional.svg" alt="icone-profissional">
            <c:forEach var="profissional" items="${profissionais}">
			<p><c:out value="${profissional.nome} ${profissional.sobrenome}" /></p>
            </c:forEach>
        </div>
    </div>
			</div>
		</div>
	</body>
</html>

<!-- NÃO REFEITO / ESTILIZADO -->