<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<title>Perfil de Paciente</title>
		<style><%@include file="../../estilos/perfil-instituicao.css"%></style>
	</head>
	<body>
		<header>
	<nav>
		<ul>
			<li class="dropdown">
			 <!-- <a href="#" class="dropbtn">Menu</a> -->
			<a class="dropbtn">Perfil de Paciente</a>
				<div class="dropdown-content">
					<a href="<%=request.getContextPath()%>/cadastrar-paciente">Novo</a>
					 <a href="<%=request.getContextPath()%>/perfil-paciente">Listar</a>
				</div>
			</li>
		</ul>
	</nav>
		</header>
<div>

        <div>
        <p><c:out value="${paciente.nome}"/> <c:out value="${paciente.sobrenome}"/></p>
        <p><c:out value="${paciente.email}" /></p>
        </div>
 
    </div>
		
	</body>
</html>
    