<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<title>Editar Perfil de Instituição</title>
		<style><%@include file="../../styles/pagina-inicial.css"%></style>
	</head>
	<body>
		<%@ include file="../../../menu.jsp"%>
<div>
        <form action="atualizar" method="post">
        <input type="hidden" name="id" value="<c:out value='${instituicao.id}' />" />
        <div>
            <img src="././images/imagem-instituicao.svg" alt="imagem-instituicao">
        <p>Alterar dados da instituição</p>
        <p>Razão Social</p>
        <input type="text" value="<c:out value='${instituicao.razao}/>'" id="p.razao" name="razao"/>
        <p>Nome Fantasia</p>
        <input type="text" value="<c:out value='${instituicao.fantasia}/>'" id="p.razao" name="razao"/>
        <p>CEP</p>
        <input type="text" value="<c:out value='${instituicao.cep}/>'" id="p.cep" name="cep"/>
        <p>Estado</p>
        <input type="text" value="<c:out value='${instituicao.estado}/>'" id="p.estado" name="estado"/>
        <p>Cidade</p>
        <input type="text" value="<c:out value='${instituicao.cidade}/>'" id="p.cidade" name="cidade"/>
        <p>Bairro</p>
        <input type="text" value="<c:out value='${instituicao.bairro}/>'" id="p.bairro" name="bairro"/>
        <p>Logradouro</p>
        <input type="text" value="<c:out value='${instituicao.logradouro}/>'" id="p.logradouro" name="logradouro"/>
        <p>Número</p>
        <input type="text" value="<c:out value='${instituicao.numero}/>'" id="p.numero" name="numero"/>
        <button type="submit">Salvar</button>
        <button type="reset">Limpar Formulário</button>
        </form>
</div>
	</body>
</html>
    