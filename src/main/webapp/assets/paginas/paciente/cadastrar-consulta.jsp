<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<title>Cadastro de Consulta</title>
		<style><%@include file="../../estilos/pagina-inicial.css"%></style>
	</head>
	<body>
		<%@ include file="../../../menu.jsp"%>
		<div>
			<div>
				<h1>
					<c:if test="${consulta != null}">Editar Consulta</c:if>
					<c:if test="${consulta == null}">Inserir Consulta</c:if>
				</h1>
				<div>
					<c:if test="${consulta != null}">
						<form action="atualizar-consulta" method="post">
					</c:if>
					<c:if test="${consulta == null}">
						<form action="inserir-consulta" method="post">
					</c:if>
					<c:if test="${consulta != null}">
						<input type="hidden" name="id" value="<c:out value='${consulta.id}' />" />
					</c:if>
						<input type="hidden" name="paciente" value=1 />
					<label>Horário:</label>
					<input type="time" id="c.horario" name="horario" oninput="mascaraHorario()" placeholder="Informe o horário..."> 
					<label>Data:</label>
					<input type="date" id="c.data" name="data" oninput="mascaraData()" placeholder="Informe a data..."> 
					<label>Especialidade Profissional:</label>
					<input type="text" id="c.especialidade" name="especialidade" placeholder="Informe a especialidade..."> 
					<label>Instituição:</label>
					<input type="text" id="c.instituicao" name="instituicao" placeholder="Informe a instituição..."> 
					<label>Profissional de Saúde:</label>
					<input type="text" id="c.profissional" name="profissional" placeholder="Informe profissional de saúde..."> 
					<label>Descrição:</label>
					<input type="text" id="c.descricao" name="descricao" placeholder="Informe a descrição..."> 

					<button type="submit">Salvar</button>
					<button type="reset">Limpar Formulário</button>
				</form>
				</div>
			</div>
		</div>
	</body>
</html>