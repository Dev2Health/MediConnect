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
							<img src="<c:out value='${urlFoto}'/>">
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
							<img src="<c:out value='${urlFoto}'/>">
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
							<img src="<c:out value='${urlFoto}'/>">
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
							<a href="./pacientes-atendente" class="texto texto-escuro">Pacientes</a>
							<p class="icone-pequeno"><%@include file="/assets/imagens/icone-paciente.svg"%></p>
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