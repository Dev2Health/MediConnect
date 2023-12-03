<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <title>Entrar | MediConnect</title>
    <meta name="description" content="Para aproveitar os benefícios do MediConnect faça agora seu login ou crie uma conta em nosso sistema">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" type="image/x-icon" href="./assets/imagens/favicon.ico">
    <style><%@include file="../estilos/padroes.css"%></style>
    <style><%@include file="../estilos/usuario-login.css"%></style>
</head>
<body>
    <%@include file="../componentes/cabecalhos/voltar.jsp"%>
    <main class="template-grid">
        <div class="conteudo-esquerda">
           	<p class="ilustracao"><%@include file="/assets/imagens/ilustracao-login.svg"%></p>
        </div>
        <div class="conteudo-direita">
            <h1 class="titulo-especial">Olá! É bom ter você de volta!</h1>
            <form action="confirmar-login" id="formulario" autocomplete="off">
                <div class="formulario-input">
                    <div class="input-icone">
                    	<p class="input-imagem"><%@include file="/assets/imagens/icone-email.svg"%></p>
                    </div>
                    <div class="input-item">
                        <label for="email" class="texto">E-mail</label>
                        <input class="texto-enfase" type="email" id="email" name="email" placeholder="seu.email@gmail.com" maxlength="100" required>
                    </div>
                    <div class="input-elemento">
                    	<p class="input-imagem"><%@include file="/assets/imagens/icone-nao-verificado.svg"%></p>
                    </div>
                </div>
                <div class="formulario-input">
                    <div class="input-icone">
                    	<p class="input-imagem"><%@include file="/assets/imagens/icone-senha.svg"%></p>
                    </div>
                    <div class="input-item">
                        <label for="senha" class="texto">Senha</label>
                        <input class="texto-enfase" type="password" id="senha" name="senha" placeholder="*********" maxlength="100" required>
                    </div>
                    <div class="input-elemento">
                        <p class="input-imagem" id="botao-senha" onclick="mostrarSenha()"><%@include file="/assets/imagens/icone-olho-fechado.svg"%></p>
                    </div>
                </div>
                <div class="formulario-rodape">
                    <button type="submit" class="botao-circular-p texto-enfase texto-claro">Entrar</button>
                    <a href="./esqueceu-senha" class="texto-enfase texto-roxo">Esqueceu sua senha?</a>
                </div>
            </form>
        </div>
    </main>
    <script><%@include file="../scripts/usuario-login.js"%></script>
</body>
</html>