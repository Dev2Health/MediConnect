<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<title>Card de Consulta</title>
		<style><%@include file="../estilos/pagina-inicial.css"%></style>
	</head>
	<body>
<div>
    </button>
        <p>Consulta - <c:out value="${consulta.id}" /></p>
        <div>
            <p><c:out value="${consulta.status}" /></p>
        </div>
        <div>
            <p><c:out value="${consulta.data}" /></p>
        </div>
        <div>
            <p><c:out value="${consulta.horario}" /></p>
        </div>
        <div>
			<p><c:out value="${consulta.descricao}" />...ver mais</p>
        </div>
    </div>
			</div>
		</div>
	</body>
</html>
    
<!-- NÃO REFEITO / ESTILIZADO -->