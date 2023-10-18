<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<title>Perfil de Atendente</title>
		<style><%@include file="../../styles/perfil-instituicao.css"%></style>
	</head>
	<body>
		<%@ include file="../../../menu.jsp"%>
<div>
        <input type="hidden" name="id" value="<c:out value='${atendente.id}' />" />
        <div>
        <img src="<c:out value='${atendente.imagem}'/>" alt="imagem-paciente">
        </div>
        <div>
        <img src="././images/icone-atendente.svg" alt="icone-atendente">
        <p><c:out value="${atendente.nome}"/> <c:out value="${atendente.sobrenome}"/></p>
        <p><c:out value="${atendente.email}" /></p> // Ou ao invés da tag p usar um input de date, mas acho melhor texto
        </div>
        <div>
        <p><c:out value="${atendente.instituicao}"/></p>
        <p><c:out value="${atendente.rua}" /></p> // Ou ao invés da tag p usar um input de date, mas acho melhor texto
        <p><c:out value="${atendente.cep}" /></p> // Ou ao invés da tag p usar um input de date, mas acho melhor texto
        </div>
</div>
	</body>
</html>
    