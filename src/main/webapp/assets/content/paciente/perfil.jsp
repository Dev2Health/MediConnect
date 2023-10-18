<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<title>Perfil de Paciente</title>
		<style><%@include file="../../styles/perfil-instituicao.css"%></style>
	</head>
	<body>
		<%@ include file="../../../menu.jsp"%>
<div>

        <div>
        <p><c:out value="${paciente.nome}"/> <c:out value="${paciente.sobrenome}"/></p>
        <p><c:out value="${paciente.email}" /></p>
        </div>
 
    </div>
		
	</body>
</html>
    