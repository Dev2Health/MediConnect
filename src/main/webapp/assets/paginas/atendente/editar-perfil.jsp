<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <title>Editar Perfil | Mediconnect</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" type="image/x-icon" href="./assets/imagens/favicon.ico">
    <style><%@include file="../../estilos/padroes.css"%></style>
    <style><%@include file="../../estilos/atendente-editar-perfil.css"%></style>
</head>
<body>
    <form action="atualizar-atendente" method="post" enctype="multipart/form-data">
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
            <section class="template-grid">
                <div id="retorno-pesquisa">
                    <p class="texto">Dados pessoais</p>
                </div>
                <div class="formulario-esquerda">
                    <div class="formulario-input">
                        <div class="input-icone">
                            <p class="icone-grande"><%@include file="/assets/imagens/icone-ctps.svg"%></p>
                        </div>
                        <div class="input-item">
                            <label for="ctps" class="texto">CTPS</label>
                            <input class="texto-enfase" type="text" id="i.ctps" name="ctps" maxlength="14" value="<c:out value='${atendente.ctps}'/>" disabled>
                        </div>
                    </div>
                </div>
                <div class="formulario-direita">
                    <div class="formulario-input">
                        <div class="input-icone">
                            <p class="icone-grande"><%@include file="/assets/imagens/icone-calendario.svg"%></p>
                        </div>
                        <div class="input-item">
                            <label for="data" class="texto">Data de Cadastro</label>
                            <input class="texto-enfase" type="datetime" value="<fmt:formatDate pattern = 'dd/MM/yyyy' value = '${data}'/>" id="i.data" name="data" placeholder="20/12/2000" disabled>
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
                        <p class="texto">E-mail Atual: <c:out value='${atendente.email}'/></p>
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
                    <input type="checkbox">
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