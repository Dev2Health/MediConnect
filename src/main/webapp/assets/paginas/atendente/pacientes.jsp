<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <title>Pacientes | MediConnect</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" type="image/x-icon" href="./assets/imagens/favicon.ico">
    <style><%@include file="../../estilos/padroes.css"%></style>
    <style><%@include file="../../estilos/atendente-pacientes.css"%></style>
</head>
<body>
    <%@include file="../../componentes/cabecalhos/filtro.jsp"%>
    <main>
        <section>
            <div class="template-grid">
                <h2 class="subtitulo">Pacientes com consulta hoje</h2>
            </div>
            <c:if test = "${empty pacientes}">
            	<%@include file="../../componentes/retorno-vazio.jsp"%>
            </c:if>
            <div class="pacientes template-grid">
                <div class="cards-agrupamento">
	                <c:forEach var="paciente" items="${pacientes}">
	                
	                    <div class="card-entidade">
	                        <div class="card-superior">
	                            <div class="entidade-imagem">
	                            	<img>
	                                <%-- foto do paciente --%>
	                            </div>
	                            <div class="entidade-informacao">
	                                <p class="texto"><c:out value="${paciente.nome}"/></p>
	                                <p class="texto-sem-enfase">Contato: (47) 9 9167-8729</p>
	                            </div>
	                        </div>
	                        <div class="card-meio">
	                            <p class="icone-pequeno"><%@include file="/assets/imagens/icone-informacoes.svg"%></p>
	                            <p class="texto">Informações Gerais</p>
	                        </div>
	                        <div class="card-inferior">
	                            <div class="inferior-informacao">
	                                <p class="texto-sem-enfase">Data de nascimento</p>
	                                <p class="texto-sem-enfase"><c:out value="${paciente.dataNascimento}"/></p>
	                            </div>
	                            <div class="inferior-informacao">
	                                <p class="texto-sem-enfase">CPF</p>
	                                <p class="texto-sem-enfase"><c:out value="${paciente.cpf}"/></p>
	                            </div>
	                        </div>
	                    </div>
	               	</c:forEach>
                </div>
            </div>
        </section>
        <section>
            <div class="template-grid">
                <h2 class="subtitulo">Pacientes com consultas agendadas</h2>
            </div>
            <c:if test = "${empty pacientes}">
            	<%@include file="../../componentes/retorno-vazio.jsp"%>
            </c:if>
            <div class="pacientes template-grid">
                <div class="cards-agrupamento">
                    
                    <c:forEach var="paciente" items="${pacientes}">
	                
	                    <div class="card-entidade">
	                        <div class="card-superior">
	                            <div class="entidade-imagem">
	                            	<img>
	                                <%-- foto do paciente --%>
	                            </div>
	                            <div class="entidade-informacao">
	                                <p class="texto"><c:out value="${paciente.nome}"/></p>
	                                <p class="texto-sem-enfase">Contato: (47) 9 9167-8729</p>
	                            </div>
	                        </div>
	                        <div class="card-meio">
	                            <p class="icone-pequeno"><%@include file="/assets/imagens/icone-informacoes.svg"%></p>
	                            <p class="texto">Informações Gerais</p>
	                        </div>
	                        <div class="card-inferior">
	                            <div class="inferior-informacao">
	                                <p class="texto-sem-enfase">Data de nascimento</p>
	                                <p class="texto-sem-enfase"><c:out value="${paciente.dataNascimento}"/></p>
	                            </div>
	                            <div class="inferior-informacao">
	                                <p class="texto-sem-enfase">CPF</p>
	                                <p class="texto-sem-enfase"><c:out value="${paciente.cpf}"/></p>
	                            </div>
	                        </div>
	                    </div>
	               	</c:forEach>
                    
                </div>
            </div>
        </section>
    </main>
    <%@include file="../../componentes/rodape/rodape.jsp"%>
</body>
</html>