<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<head>
		<title>Card de Paciente</title>
		<style><%@include file="../../styles/pagina-inicial.css"%></style>
	</head>
	<body>
		<%@ include file="../../../menu.jsp"%>
<div>
    </button>
        <input type="hidden" name="id" value="<c:out value='${paciente.id}' />" />
        <p><c:out value="${paciente.nome}"/> <c:out value="${paciente.sobrenome}"/></p>
        <div>
            <img src="././images/imagem-paciente.svg" alt="imagem-paciente">
            <p>Contato: <c:out value="${paciente.foto}" /></p> // Implementar imagens e descobrir como pegá-las
        </div>
        <div>
            <img src="././images/icone-telefone.svg" alt="icone-telefone">
            <p>Contato: <c:out value="${paciente.telefone}" /></p> // Ou ao invés da tag p usar um input de date, mas acho melhor texto
        </div>
        <div>
            <img src="././images/icone-calendario.svg" alt="icone-calendario">
            <p>Data de Nascimento: <c:out value="${paciente.data}" /></p> // Ou ao invés da tag p usar um input de date, mas acho melhor texto
        </div>
        <div>
            <img src="././images/icone-cpf.svg" alt="icone-cpf">
            <p>CPF: <c:out value="${paciente.cpf}" /></p> // Ou ao invés da tag p usar um input de date, mas acho melhor texto
        </div>
    </button>
    </div>
			</div>
		</div>
	</body>
</html>
    