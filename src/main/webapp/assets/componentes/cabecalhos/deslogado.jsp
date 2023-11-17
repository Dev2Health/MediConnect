<%@ page isELIgnored="false" language="java"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:choose>
  <c:when test="${tipoUsuario == 1}">
    <header class="template-grid" id="cabecalho">
	<img src="assets/imagens/logo-legendado.svg" alt="logo-mediconnect"
		id="logo">
	<nav class="barra-navegacao">
		<a href="./home" class="texto texto-escuro">Perfil Paciente</a>
	</nav>
	</header>
  </c:when>
  <c:when test="${tipoUsuario == 2}">
	<header class="template-grid" id="cabecalho">
	<img src="assets/imagens/logo-legendado.svg" alt="logo-mediconnect"
		id="logo">
	<nav class="barra-navegacao">
		<a href="./home" class="texto texto-escuro">Perfil Instituição</a>
	</nav>
	</header>
  </c:when>
  <c:when test="${tipoUsuario == 3}">
    <header class="template-grid" id="cabecalho">
	<img src="assets/imagens/logo-legendado.svg" alt="logo-mediconnect"
		id="logo">
	<nav class="barra-navegacao">
		<a href="./home" class="texto texto-escuro">Perfil Atendente</a>
	</nav>
	</header>
  </c:when>
  <c:otherwise>
    <header class="template-grid" id="cabecalho">
	<p id="logo"><%@include file="/assets/imagens/logo-legendado.svg"%></p>
	<nav class="barra-navegacao">
		<a href="./sobre" class="texto texto-escuro">Sobre o MediConnect</a> <a
			href="./login" class="texto texto-escuro">Entrar</a> <a
			href="./cadastro" class="botao-circular-m texto texto-claro">Cadastrar</a>
	</nav>
	</header>
  </c:otherwise>
</c:choose>