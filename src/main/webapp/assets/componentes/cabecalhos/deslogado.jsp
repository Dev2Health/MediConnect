<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<header class="template-grid" id="cabecalho">
	<div class="barra-navegacao">
		<p class="logo"><%@include file="/assets/imagens/logo-legendado.svg"%></p>
		<nav class="navegacao-links">
			<a href="./login" class="texto texto-escuro">Entrar</a> 
			<button class="botao-circular-m texto"><a href="./cadastro" class="texto-claro">Cadastrar</a></button>
		</nav>
	</div>
</header>
