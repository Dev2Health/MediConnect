<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<title>Editar Perfil de Atendente</title>
		<style><%@include file="../../styles/pagina-inicial.css"%></style>
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
        <input type="text" value="<c:out value='${atendente.nome}/>'" id="p.nome" name="nome"/>
        <p>Sobrenome</p>
        <input type="text" value="<c:out value='${atendente.sobrenome}/>'" id="p.sobrenome" name="sobrenome"/>
        <p>CTPS</p>
        <input type="text" value="<c:out value='${atendente.ctps}/>'" id="p.ctps" name="ctps"/>
        <p>Data de Cadastro</p>
        <input type="date" value="<c:out value='${atendente.data}/>'" id="p.data" name="data"/>
        <p>Número de Cadastro</p>
        <input type="text" value="<c:out value='${atendente.cadastro}/>'" id="p.cadastro" name="numero"/>
        <button type="submit">Salvar</button>
        <button type="reset">Limpar Formulário</button>
        </form>
</div>
	</body>
</html>
    