<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<title>Editar Perfil de Paciente</title>
		<style><%@include file="../../styles/pagina-inicial.css"%></style>
	</head>
	<body>
		<%@ include file="../../../menu.jsp"%>
<div>
        <form action="atualizar" method="post">
        <input type="hidden" name="id" value="<c:out value='${paciente.id}' />" />
        <div>
            <img src="././images/imagem-paciente.svg" alt="imagem-paciente">
        <p>Dados pessoais</p>
        <p>Nome</p>
        <input type="text" value="<c:out value='${paciente.nome}/>'" id="p.nome" name="nome"/>
        <p>Sobrenome</p>
        <input type="text" value="<c:out value='${paciente.sobrenome}/>'" id="p.sobrenome" name="sobrenome"/>
        <p>CPF</p>
        <input type="text" value="<c:out value='${paciente.cpf}/>'" id="p.cpf" name="cpf"/>
        <p>Data de Nascimento</p>
        <input type="text" value="<c:out value='${paciente.data}/>'" id="p.data" name="data"/>
        <p>Alterar dado de contato</p>
        <p>Telefone</p>
        <input type="text" value="<c:out value='${paciente.telefone}/>'" id="p.telefone" name="telefone" oninput="mascaraTelefone()"/>
        <button type="submit">Salvar</button>
        <button type="reset">Limpar Formulário</button>
        </form>
    </div>
			</div>
		</div>
	</body>
</html>
    