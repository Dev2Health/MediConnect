<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<title>Perfil de Atendente</title>
	</head>
	<body>
<div>
        <input type="hidden" name="id" value="<c:out value='${atendente.id}' />" />
        <div>
        <img src="../images/icone-atendente.svg" alt="imagem-atendente">
        </div>
        <div>
        <img src="././images/icone-atendente.svg" alt="icone-atendente">
        <p><c:out value="${atendente.nome}"/> <c:out value="${atendente.sobrenome}"/></p>
        <p><c:out value="${atendente.email}" /></p> 
        </div>
        <div>
        <c:if test="${atendente.instituicao != null}">
        <p><c:out value="${instituicao.nomeFantasia}"/></p>
        <p><c:out value="${endereco.logradouro}" /></p>
        <p><c:out value="${endereco.cep}" /></p>
        </c:if>
        </div>

        <p>Pacientes Cadastrados</p>
        <c:forEach var="paciente" items="${pacientes}">
        <input type="hidden" value="<c:out value='${paciente.id}'/>" />
        <div>
            <p><c:out value="${paciente.nome}" /> <c:out value="${paciente.sobrenome}" /></p>
            <p>Contato: <c:out value="${paciente.telefone}" /></p>
            <img src="././images/icone-informacoes.svg" alt="icone-informacoes">
            <p>Informações Gerais</p>
            <p>Data de Nascimento</p>
            <p><c:out value="${paciente.data}" /></p> 
            <p>CPF</p>
            <p><c:out value="${paciente.cpf}" /></p> 
        </div>
        <div>
            <img src="././images/icone-relogio.svg" alt="icone-horario">
            <p><c:out value="${paciente.horario}" /></p>
        </div>
        <div>
            <button>Ver detalhes</button>
            // Vai abrir um modal a partir do onClick
        </div>
        </c:forEach>
</div>
	</body>
</html>
    