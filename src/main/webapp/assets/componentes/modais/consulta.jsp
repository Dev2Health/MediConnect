<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
	<head>
		<title>Cadastro de Consulta</title>
		<style><%@include file="../../estilos/pagina-inicial.css"%></style>
	</head>
	<body>
<div>
        <p>Consulta - <c:out value="${consulta.id}" /></p>
        <div>
            <p><%@include file="/assets/imagens/icone-calendario.svg"%></p>
            <fmt:parseDate value="${consulta.data}" type="date"
            pattern="yyyy-MM-dd" var="parsedDate" />
            <fmt:formatDate value="${parsedDate}" type="date"
            pattern="dd/MM/yyyy" var="data" />
            <p class="text" type="date">Data: <c:out value="${data}" /></p>
        </div>
        <div>
            <p><%@include file="/assets/imagens/icone-horario.svg"%></p>
            <p>Horário: <c:out value="${consulta.horario}" /></p>
        </div>
        <div>
            <p><%@include file="/assets/imagens/icone-especialidade.svg"%></p>
			<p>Especialidade: <c:out value="${especialidade.nome}" /></p>
        </div>
            <p><%@include file="/assets/imagens/icone-instituicao.svg"%></p>
			<p>Instituição: <c:out value="${instituicao.nomeFantasia}" /></p>
        <div>
            <p><%@include file="/assets/imagens/icone-profissional.svg"%></p>
			<p>Profissional: <c:out value="${profissional.nome}" /> <c:out value="${profissional.sobrenome}" /></p>
        </div>
        <button onclick="fecharModal(${consulta.id})" class="btn-square-sm text-emphasis link-light"><p><%@include file="../../imagens/icone-fechar.svg"%></p></button>
    </div>

    <script><%@include file="../../scripts/modal-consulta.js"%></script>
	</body>
</html>