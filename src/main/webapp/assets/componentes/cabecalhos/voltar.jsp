<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<header class="template-grid" id="cabecalho">
	<div class="barra-navegacao">
        <nav class="navegacao-voltar">
        	<p class="icone-grande"><%@include file="/assets/imagens/icone-voltar.svg"%></p>
            <a href="javascript:history.back()" class="texto texto-escuro">Voltar</a>
        </nav>
        <a href="./home"><p class="logo"><%@include file="/assets/imagens/logo-legendado.svg"%></p></a>
	</div>
</header>