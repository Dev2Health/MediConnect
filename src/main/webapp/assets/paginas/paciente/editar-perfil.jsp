<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <title>Editar Perfil | MediConnect</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" type="image/x-icon" href="./assets/imagens/favicon.ico">
    <style><%@include file="../../estilos/padroes.css"%></style>
    <style><%@include file="../../estilos/paciente-editar-perfil.css"%></style>
</head>
<body>
   <form action="atualizar-paciente" method="post" enctype="multipart/form-data">
		<header class="template-grid" id="cabecalho">
			<div class="barra-navegacao">
		        <nav class="navegacao-voltar">
		        	<p class="icone-grande"><%@include file="/assets/imagens/icone-voltar.svg"%></p>
		            <a href="javascript:history.back()" class="texto texto-escuro">Voltar</a>
		        </nav>
		        <div class="perfil-foto">
						<label for="input-imagem">
							<c:if test = "${!empty urlFoto}">
			      			<img src="<c:out value='${urlFoto}'/>">
							</c:if>
					      	<c:if test = "${empty urlFoto}">
							<p class="icone-pequeno"><%@include file="/assets/imagens/icone-camera.svg"%></p>
							</c:if>
						</label>
					<input type="file" id="input-imagem" name="imagem" accept="image/*" style="display: none">
		        </div>
			</div>
		</header>
    	<main>
            <section id="visualizaveis">
                <div class="template-grid">
                    <div id="retorno-pesquisa">
                        <p class="texto">Dados pessoais</p>
                    </div>
                </div>
                <div id="dados-visualizaveis" class="template-grid">
                    <div class="formulario-esquerda">
                        <div class="formulario-input">
                            <div class="input-icone">
                                <p class="icone-grande"><%@include file="/assets/imagens/icone-cpf.svg"%></p>
                            </div>
                            <div class="input-item">
                                <label for="cpf" class="texto">CPF</label>
                                <input class="texto-enfase" type="text" id="i.cpf" name="cpf" value="<c:out value='${paciente.cpf}'/>" maxlength="14" disabled>
                            </div>
                        </div>
                    </div>
                    <div class="formulario-direita">
                        <div class="formulario-input">
                            <div class="input-icone">
                                <p class="icone-grande"><%@include file="/assets/imagens/icone-calendario.svg"%></p>
                            </div>
                            <div class="input-item">
                                <label for="nascimento" class="texto">Data de Nascimento</label>
                                <fmt:parseDate value="${dataNascimento}" type="date" pattern="yyyy-MM-dd" var="parsedDate" />
                                <fmt:formatDate value="${parsedDate}" type="date" pattern="dd/MM/yyyy" var="data" />
                                <input class="texto-enfase" type="datetime" id="i.nascimento" name="nascimento" value="${data}" disabled>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <section id="informacoes">
                <div class="template-grid">
                    <div id="retorno-pesquisa">
                        <p class="texto">Alterar dados pessoais</p>
                        <button class="botao-quadrado-p texto-enfase texto-claro" disabled>Habilitar Edição<p class="icone-pequeno"><%@include file="/assets/imagens/icone-editar.svg"%></p></button>
                    </div>
                </div>
                <div id="dados-editaveis" class="template-grid">
                    <div class="formulario-esquerda">
                        <div class="formulario-input">
                            <div class="input-icone">
                                <p class="icone-grande"><%@include file="/assets/imagens/icone-paciente.svg"%></p>
                            </div>
                            <div class="input-item">
                                <label for="nome" class="texto">Nome</label>
                                <input class="texto-enfase" type="text" id="i.nome" name="nome" value="<c:out value='${paciente.nome}'/>" maxlength="65">
                            </div>
                        </div>
                        <div class="formulario-input">
                            <div class="input-icone">
                                <p class="icone-grande"><%@include file="/assets/imagens/icone-telefone.svg"%></p>
                            </div>
                            <div class="input-item">
                                <label for="telefone" class="texto">Telefone</label>
                                <input class="texto-enfase" type="tel" id="i.telefone" name="telefone" value="<c:out value='${paciente.telefone}'/>" oninput="mascaraTelefone()" maxlength="16" pattern="(\([0-9]{2}\))\s([9]{1})\s([0-9]{4})-([0-9]{4})">
                            </div>
                            <div class="input-elemento">
                                <p class="icone-grande"><%@include file="/assets/imagens/icone-nao-verificado.svg"%></p>
                            </div>
                        </div>
                    </div>
                    <div class="formulario-direita">
                        <div class="formulario-input">
                            <div class="input-icone">
                                <p class="icone-grande"><%@include file="/assets/imagens/icone-paciente.svg"%></p>
                            </div>
                            <div class="input-item">
                                <label for="sobrenome" class="texto">Sobrenome</label>
                                <input class="texto-enfase" type="text" id="i.sobrenome" name="sobrenome" value="<c:out value='${paciente.sobrenome}'/>" maxlength="65">
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <section id="dados-sensiveis">
                <div class="template-grid">
                    <div id="retorno-pesquisa">
                        <p class="texto">Alterar dados sensíveis</p>
                        <button class="botao-quadrado-p texto-enfase texto-claro" disabled>Habilitar Edição<p class="icone-pequeno"><%@include file="/assets/imagens/icone-editar.svg"%></p></button>
                    </div>
                </div>
                <div id="confirmar-email" class="template-grid">
                    <div class="email-superior">
                        <p class="icone-grande icone-claro"><%@include file="/assets/imagens/icone-email.svg"%></p>
                        <p class="texto">E-mail Atual: <c:out value='${paciente.email}'/>"</p> <!-- Pegar o email atual da instituição com o jsp -->
                    </div>
                    <div class="email-conteudo">
                        <div class="input-email">
                            <label for="email" class="texto">Alterar E-mail</label>
                            <div class="formulario-email">
                                <div class="formulario-icone">
                                    <p class="icone-pequeno icone-claro"><%@include file="/assets/imagens/icone-email.svg"%></p>
                                </div>
                                <input class="texto-enfase" type="email" id="i.email" name="email" placeholder="novo.email@gmail.com" maxlength="100">
                            </div>
                        </div>
                        <div class="email-validar">
                            <div class="validar-conteudo">
                                <p class="icone-pequeno"><%@include file="/assets/imagens/icone-atencao.svg"%></p>
                                <p class="texto-sem-enfase">Enviar o token de verificação para este e-mail</p>
                            </div>
                            <div class="validar-conteudo">
                                <a class="texto-enfase">Enviar confirmação</a>
                                <p class="icone-pequeno"><%@include file="/assets/imagens/icone-redirecionar.svg"%></p>
                            </div>
                        </div>
                    </div>
                </div>
                <div id="redefinir-senha" class="template-grid">
                    <div class="senha-conteudo">
                        <div class="input-senhas">
                            <div id="senha-atual">
                                <label for="senha" class="texto">Nova Senha</label>
                                <div class="input-senha">
                                    <input class="texto-enfase" type="password" id="i.senha" name="senha" placeholder="********" maxlength="100">
                                    <p class="icone-pequeno"><%@include file="/assets/imagens/icone-olho-fechado.svg"%></p>
                                </div>
                            </div>
                            <div id="senha-nova">
                                <label for="novasenha" class="texto">Confirmar Senha</label>
                                <div class="input-senha">
                                    <input class="texto-enfase" type="password" id="novasenha" name="novasenha" placeholder="********" maxlength="100">
                                    <p class="icone-pequeno"><%@include file="/assets/imagens/icone-olho-fechado.svg"%></p>
                                </div>
                            </div>
                        </div>
                        <div class="senha-validacao">
                            <div class="validar-conteudo">
                                <p class="icone-pequeno"><%@include file="/assets/imagens/icone-atencao.svg"%></p>
                                <p class="texto-sem-enfase">Enviar confirmação para o e-mail cadastrado</p>
                            </div>
                            <div class="validar-conteudo">
                                <a href="#" class="texto-enfase texto-escuro">Enviar confirmação</a>
                                <p class="icone-pequeno"><%@include file="/assets/imagens/icone-redirecionar.svg"%></p>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="checkbox">
                    <input type="checkbox" required>
                    <p class="texto-sem-enfase">Li e estou de acordo com o <a href="#" class="texto-enfase texto-roxo">Termo de Uso e Política de Privacidade</a></p>
                </div>
                <div class="template-grid">
                    <div class="botoes">
                        <button class="botao-circular-m texto-enfase texto-claro" type="submit">Salvar alterações</button>
                        <button class="botao-circular-m texto-enfase texto-roxo" type="reset">Descartar alterações</button>
                    </div>
                </div>
            </section>
    	</main>
    </form>
</body>
</html>