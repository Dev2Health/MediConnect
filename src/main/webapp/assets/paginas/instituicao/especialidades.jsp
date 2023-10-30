<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <title>Especialidades | MediConnect</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" type="image/x-icon" href="../../images/favicon.ico">
    <style><%@include file="../../estilos/padroes.css"%></style>
    <style><%@include file="../../estilos/especialidades-instituicao.css"%></style>
</head>
<body>
            <c:forEach var="especialidade" items="${especialidades}">
            <div>
                <p><c:out value='${especialidade.id}' /> <c:out value="${especialidade.nome}"/></p>
                <div>
                    <div>
                        <img src="../../images/icone-profissional.svg" alt="icone-profissional">
                        <p>Mostrar profissionais</p>
                    <button>Ver detalhes</button>
                </div>
            </div>
            </c:forEach>
</body>
</html>