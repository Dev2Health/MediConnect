<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
	<head>
		<title>Cadastro de Consulta</title>
		<style><%@include file="../estilos/pagina-inicial.css"%></style>
	</head>
	<body>
<div>
        <p>Consulta - <c:out value="${consulta.id}" /></p>
        <div>
            <img src="././images/icone-calendario.svg" alt="icone-calendario">
            <fmt:parseDate value="${consulta.data}" type="date"
            pattern="yyyy-MM-dd" var="parsedDate" />
            <fmt:formatDate value="${parsedDate}" type="date"
            pattern="dd/MM/yyyy" var="data" />
            <p class="text" type="date"><c:out value="${data}" /></p>
        </div>
        <div>
            <img src="././images/icone-relogio.svg" alt="icone-horario">
            <p><c:out value="${consulta.horario}" /></p>
        </div>
        <div>
            <img src="././images/icone-especialidade.svg" alt="icone-especialidade">
			<p><c:out value="${especialidade.nome}" /></p>
        </div>
            <img src="././images/icone-instituicao.svg" alt="icone-instituicao">
			<p><c:out value="${instituicao.nomeFantasia}" /></p>
        <div>
            <img src="././images/icone-profissional.svg" alt="icone-profissional">
			<p><c:out value="${profissional.nome}" /> <c:out value="${profissional.sobrenome}" /></p>
        </div>
    </div>
			</div>
		</div>
	</body>
</html>
    
<!-- NÃO REFEITO / ESTILIZADO -->