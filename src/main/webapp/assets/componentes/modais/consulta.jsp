<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<div class="modal-superior">
		<p class="texto texto-claro">Consulta - <c:out value="${consulta.id}" /></p>
		<div class="superior-icones">
			<a href="./editar-consulta"><p class="icone-pequeno"><%@include file="/assets/imagens/icone-editar.svg"%></p></a>
			<button onclick="fecharModal(${consulta.id})">
				<p class="icone-pequeno"><%@include file="/assets/imagens/icone-fechar.svg"%></p>
			</button>
		</div>
	</div>
	<div class="modal-informacoes">
		<div class="consulta-descricao">
			<p class="texto-sem-enfase">Descrição <br> <c:out value="${consulta.descricao}"/></p>
		</div>
		<div class="consulta-dados">
			<div class="consulta-especialidade">
				<p class="icone-pequeno"><%@include file="/assets/imagens/icone-especialidade.svg"%></p>
				<p class="texto-enfase texto-roxo"><c:out value="${consulta.especialidadeProfissional.nome}" /></p>
			</div>
			<div class="consulta-endereco">
				<p class="icone-pequeno"><%@include file="/assets/imagens/icone-instituicao.svg"%></p>
				<p class="texto-enfase texto-roxo"><c:out value="${consulta.instituicao.nomeFantasia}"/></p>
			</div>
			<div class="consulta-profissional">
				<p class="icone-pequeno"><%@include file="/assets/imagens/icone-profissional.svg"%></p>
				<p class="texto-enfase texto-roxo"><c:out value="${consulta.profissionalDeSaude.nome}"/> <c:out value="${consulta.profissionalDeSaude.sobrenome}"/></p>
			</div>
		</div>
	</div>

<script><%@include file="../../scripts/modal-consulta.js"%></script>