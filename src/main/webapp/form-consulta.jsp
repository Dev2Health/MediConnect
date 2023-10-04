<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<title>Cadastro de Consulta</title>
		<style><%@include file="assets/styles/pagina-inicial.css"%></style>
		<script><%@include file="assets/script/script.js"%></script>
	</head>
	<body>
		<%@ include file="menu.jsp"%>
		<div>
			<div>
				<h1>
					<c:if test="${consulta != null}">Editar Consulta</c:if>
					<c:if test="${consulta == null}">Inserir Consulta</c:if>
				</h1>
				<div>
					<c:if test="${consulta != null}">
						<form action="atualizar" method="post">
					</c:if>
					<c:if test="${consulta == null}">
						<form action="inserir" method="post">
					</c:if>
					<c:if test="${consulta != null}">
						<input type="hidden" name="id" value="<c:out value='${consulta.id}' />" />
					</c:if>
					<label>Horário:</label>
					<input type="time" value="<c:out value='${consulta.horario}' />" id="c.horario" name="horario" oninput="mascaraHorario()" placeholder="Informe o horário..."> 
					<label>Data:</label>
					<input type="date" value="<c:out value='${consulta.data}' />" id="c.data" name="data" oninput="mascaraData()" placeholder="Informe a data..."> 
					<label>Especialidade Profissional:</label>
					<input type="text" value="<c:out value='${consulta.especialidade}' />" id="c.especialidade" name="especialidade" placeholder="Informe a especialidade..."> 
					<label>Instituição:</label>
					<input type="text" value="<c:out value='${consulta.instituicao}' />" id="c.instituicao" name="instituicao" placeholder="Informe a instituição..."> 
					<label>Profissional de Saúde:</label>
					<input type="text" value="<c:out value='${consulta.profissional}' />" id="c.profissional" name="profissional" placeholder="Informe profissional de saúde..."> 

					<button type="submit">Salvar</button>
					<button type="reset">Limpar Formulário</button>
				</form>
				</div>
			</div>
		</div>
	</body>
</html>