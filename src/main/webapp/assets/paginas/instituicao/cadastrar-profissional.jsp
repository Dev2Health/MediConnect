<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<title>Cadastro de Profissional</title>
		<style><%@include file="../../estilos/pagina-inicial.css"%></style>
	</head>
	<body>
		<div>
			<div>
					<input type="hidden" name="instituicao" value=1 />
					<form action="inserir-profissional" method="post">
					<label>Nome:</label>
					<input type="text" id="pr.nome" name="nome" placeholder="Informe o nome...">
					<label>Sobrenome:</label>
					<input type="text" id="pr.sobrenome" name="sobrenome" placeholder="Informe o sobrenome...">
					<label for="especialidade" class="texto">Especialidade</label>
                        <select class="texto-enfase" id="i.especialidade" name="especialidade" required>
                        		<option value="" disabled selected hidden="true">(Selecione a especialidade)</option>
                            <c:forEach var="especialidade" items="${especialidades}">
                                <option value="<c:out value='${especialidade.id}'/>"><c:out value='${especialidade.nome}'/></option>
                            </c:forEach>
                        </select>
					<button type="submit">Salvar</button>
					<button type="reset">Limpar Formulário</button>
				</form>
				</div>
			</div>
		</div>
	</body>
</html>

<!-- NÃO REFEITO / ESTILIZADO -->