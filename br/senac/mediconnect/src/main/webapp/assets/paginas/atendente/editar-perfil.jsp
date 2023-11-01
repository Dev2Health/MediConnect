<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
	<head>
		<title>Editar Perfil de Atendente</title>
		<style><%@include file="../../estilos/pagina-inicial.css"%></style>
	</head>
	<body>
		<%@ include file="../../../menu.jsp"%>
<div>
        <form action="atualizar" method="post">
        <input type="hidden" name="id" value="<c:out value='${atendente.id}' />" />
        <div>
            <img src="././images/imagem-atendente.svg" alt="imagem-atendente">
        <p>Dados pessoais</p>
        <p>Nome</p>
        <input type="text" value="<c:out value='${atendente.nome}'/>" id="p.nome" name="nome"/>
        <p>Sobrenome</p>
        <input type="text" value="<c:out value='${atendente.sobrenome}'/>" id="p.sobrenome" name="sobrenome"/>
        <p>CTPS</p>
        <input type="text" value="<c:out value='${atendente.ctps}'/>" id="p.ctps" name="ctps"/>
        <p>Data de Cadastro</p>
        <input class="text-emphasis" type="datetime" value="<fmt:formatDate pattern = 'dd/MM/yyyy' value = '${data}'/>" id="p.data" name="data" disabled/>
        <button type="submit">Salvar</button>
        <button type="reset">Limpar Formulário</button>
        </form>
</div>
	</body>
</html>
    