<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<header class="template-grid" id="cabecalho">
	<div class="barra-navegacao">
		<div class="icones-logado">
			<p onclick="alternarModal()" class="logo"><%@include file="/assets/imagens/icone-menu.svg"%></p>
			<a href="./home"><p class="logo"><%@include file="/assets/imagens/logo.svg"%></p></a>
		</div>
		<c:choose>
	  		<c:when test="${tipoUsuario == 1}">
	  		
				<nav class="barra-lateral">
					<div class="barra-superior">
						<div class="perfil-imagem">
							<img> <%-- Imagem em base 64--%>
						</div>
					</div>
					<div class="barra-centro">
						<div class="centro-icones"> 
							<a href="./perfil" class="texto texto-escuro">Perfil</a>
							<p class="icone-pequeno"><%@include file="/assets/imagens/icone-perfil.svg"%></p>
						</div>
						<div class="centro-icones">
							<a href="./consultas" class="texto texto-escuro">Consultas</a>
							<p class="icone-pequeno"><%@include file="/assets/imagens/icone-consulta.svg"%></p>
						</div>
						<div class="centro-icones">
							<a href="./conquistas-paciente" class="texto texto-escuro">Conquistas</a>
							<p class="icone-pequeno"><%@include file="/assets/imagens/icone-conquista.svg"%></p>
						</div>
						<div class="centro-icones">
							<a href="./notificacoes-paciente" class="texto texto-escuro">Notificações</a>
							<p class="icone-pequeno"><%@include file="/assets/imagens/icone-notificacao.svg"%></p> 
						</div>
					</div>
					<div class="barra-inferior">
						<button class="botao-circular-p"><a href="./deslogar" class="texto texto-claro">Terminar sessão</a></button>
						<a href="./editar-perfil"><p class="icone-pequeno"><%@include file="/assets/imagens/icone-configuracoes.svg"%></p></a>
					</div>
					<div class="barra-rodape">
						<p class="icone-mediconnect"><%@include file="/assets/imagens/logo-rodape.svg"%></p>
						<div class="rodape-linha">
							<hr>
						</div>
					</div>
				</nav>
			
			</c:when>
	  		<c:when test="${tipoUsuario == 2}">
	  				
				<nav class="barra-lateral">
					<div class="barra-superior">
						<div class="perfil-imagem">
							<img> <%-- Imagem em base 64--%>
						</div>
					</div>
					<div class="barra-centro">
						<div class="centro-icones"> 
							<a href="./perfil" class="texto texto-escuro">Perfil</a>
							<p class="icone-pequeno"><%@include file="/assets/imagens/icone-perfil.svg"%></p>
						</div>
						<div class="centro-icones">
							<a href="./especialidades-instituicao" class="texto texto-escuro">Especialidades</a>
							<p class="icone-pequeno"><%@include file="/assets/imagens/icone-especialidade.svg"%></p>
						</div>
						<div class="centro-icones">
							<a href="./atendentes-instituicao" class="texto texto-escuro">Atendentes</a>
							<p class="icone-pequeno"><%@include file="/assets/imagens/icone-atendente.svg"%></p>
						</div>
						<div class="centro-icones">
							<a href="./notificacoes-instituicao" class="texto texto-escuro">Notificações</a>
							<p class="icone-pequeno"><%@include file="/assets/imagens/icone-notificacao.svg"%></p> 
						</div>
					</div>
					<div class="barra-inferior">
						<button class="botao-circular-p"><a href="./deslogar" class="texto texto-claro">Terminar sessão</a></button>
						<a href="./editar-perfil"><p class="icone-pequeno"><%@include file="/assets/imagens/icone-configuracoes.svg"%></p></a>
					</div>
					<div class="barra-rodape">
						<p class="icone-mediconnect"><%@include file="/assets/imagens/logo-rodape.svg"%></p>
						<div class="rodape-linha">
							<hr>
						</div>
					</div>
				</nav>
				
			</c:when>
			<c:when test="${tipoUsuario == 3}">
			
				<nav class="barra-lateral">
					<div class="barra-superior">
						<div class="perfil-imagem">
							<img> <%-- Imagem em base 64--%>
						</div>
					</div>
					<div class="barra-centro">
						<div class="centro-icones"> 
							<a href="./perfil" class="texto texto-escuro">Perfil</a>
							<p class="icone-pequeno"><%@include file="/assets/imagens/icone-perfil.svg"%></p>
						</div>
						<div class="centro-icones">
							<a href="./consultas-atendente" class="texto texto-escuro">Consultas</a>
							<p class="icone-pequeno"><%@include file="/assets/imagens/icone-consulta.svg"%></p>
						</div>
						<div class="centro-icones">
							<a href="./notificacoes-paciente" class="texto texto-escuro">Notificações</a>
							<p class="icone-pequeno"><%@include file="/assets/imagens/icone-notificacao.svg"%></p> 
						</div>
					</div>
					<div class="barra-inferior">
						<button class="botao-circular-p"><a href="./deslogar" class="texto texto-claro">Terminar sessão</a></button>
						<a href="./editar-perfil"><p class="icone-pequeno"><%@include file="/assets/imagens/icone-configuracoes.svg"%></p></a>
					</div>
					<div class="barra-rodape">
						<p class="icone-mediconnect"><%@include file="/assets/imagens/logo-rodape.svg"%></p>
						<div class="rodape-linha">
							<hr>
						</div>
					</div>
				</nav>
				
			</c:when>
		</c:choose>
            </div>
                <a href="./home"> <img src="../../imagens/logo.svg" alt="logo-mediconnect"> </a>
    
  </c:when>
    </c:choose>
  
        <nav class="navegacao-filtro">
            <div class="filtro">
                <div class="input-item">
                    <input class="texto-enfase" type="texto" id="pesquisar" name="pesquisar" placeholder="Pesquisar">
                </div>
                <div class="filtro-icone">
                    <img src="./assets/imagens/icone-lupa.svg" alt="icone-pesquisar">
                </div>
            </div>
            <button class="botao-quadrado-g texto">Filtrar <img src="./assets/imagens/icone-filtro.svg"></button>
        </nav>
</header>