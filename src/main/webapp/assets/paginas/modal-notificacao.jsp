<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<title>Modal de Notificacao</title>
		<style><%@include file="../estilos/pagina-inicial.css"%></style>
	</head>
	<body>
<div>
        <input type="hidden" name="id" value="<c:out value='${notificacao.id}' />" />
        <div>
            <img src="../images/icone-calendario.svg" alt="icone-calendario">
            <p>Contratação: <c:out value="${notificacao.data}" /></p>
        </div>
        <div>
            <img src="../images/icone-relogio.svg" alt="icone-relogio">
            <p>Contratação: <c:out value="${notificacao.horario}" /></p>
        </div>
        <div>
            <p>Contratação: <c:out value="${notificacao.descricao}" /></p>
        </div>
    </div>
			</div>
		</div>
	</body>
</html>


<!-- NÃO ESTILIZADO -->