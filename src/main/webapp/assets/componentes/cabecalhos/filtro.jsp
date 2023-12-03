<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<header class="template-grid" id="cabecalho">
		<div class="barra-navegacao">
		<%@include file="barra-lateral.jsp"%>
		<nav class="navegacao-filtro">
           <div class="filtro">
               <div class="input-item">
                   <input class="texto-enfase" type="text" id="i.pesquisar" name="pesquisar" placeholder="Pesquisar">
               </div>
               <div class="filtro-icone">
                    <p class="icone-pequeno"><%@include file="/assets/imagens/icone-lupa.svg"%></p>
               </div>
           </div>
           <button class="botao-quadrado-m texto texto-claro"> Filtrar <p class="icone-pequeno"><%@include file="/assets/imagens/icone-filtro.svg"%></p></button>
       	</nav>
       	</div>
</header>
<script><%@include file="../../scripts/modal-lateral.js"%></script>