<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<title>Perfil de Instituição</title>
		<style><%@include file="../../styles/perfil-instituicao.css"%></style>
	</head>
	<body>
		<%@ include file="../../../menu.jsp"%>
<div>
        <input type="hidden" name="id" value="<c:out value='${instituicao.id}' />" />
        <div>
        <img src="<c:out value='${instituicao.imagem}'/>" alt="imagem-paciente">
        </div>
        <div>
        <img src="././images/icone-instituicao.svg" alt="icone-instituicao">
        <p><c:out value="${instituicao.fantasia}"/></p>
        <p><c:out value="${instituicao.email}" /></p> // Ou ao invés da tag p usar um input de date, mas acho melhor texto
        </div>
        <div>
        <p>Endereço</p>
        <p><c:out value="${instituicao.rua}"/></p>
        <p><c:out value="${instituicao.cep}" /></p> // Ou ao invés da tag p usar um input de date, mas acho melhor texto
        </div>
</div>
	</body>
</html>
    