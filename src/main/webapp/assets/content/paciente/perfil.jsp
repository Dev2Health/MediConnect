<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<title>Perfil de Paciente</title>
		<style><%@include file="../../styles/perfil-instituicao.css"%></style>
	</head>
	<body>
		<%@ include file="../../../menu.jsp"%>
<div>
        <input type="hidden" name="id" value="<c:out value='${paciente.id}' />" />
        <div>
        <img src="<c:out value='${paciente.imagem}'/>" alt="imagem-paciente">
            <p></p>
        </div>
        <div>
        <p><c:out value="${paciente.nome}"/> <c:out value="${paciente.sobrenome}"/></p>
        <p><c:out value="${paciente.email}" /></p> // Ou ao invés da tag p usar um input de date, mas acho melhor texto
        </div>
        <div>
        <img src="././images/icone-selo-pontual.svg" alt="selo-pontual">
        <p>Assíduo <c:out value="${paciente.seloPontual}"/></p>
        <img src="././images/icone-selo-assiduo.svg" alt="selo-assiduo">
        <p>Pontual <c:out value="${paciente.seloAssidu}" /></p> // Ou ao invés da tag p usar um input de date, mas acho melhor texto
        </div>
    </div>
			</div>
		</div>
	</body>
</html>
    