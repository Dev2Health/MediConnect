<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <title>Redefinir senha | MediConnect</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" type="image/x-icon" href="./assets/imagens/favicon.ico">
    <style><%@include file="../estilos/padroes.css"%></style>
    <style><%@include file="../estilos/esqueceu-senha.css"%></style>
</head>
<body>
    <%@include file="../componentes/cabecalhos/voltar.jsp"%>
    <main>
        <form action="">
            <div id="confirmar-email" class="template-grid">
                <div class="email-superior">
                	<p class="icone-pequeno icone-claro"><%@include file="/assets/imagens/icone-email.svg"%></p>
                    <p class="texto">Antes de prosseguir, informe seu endereço de e-mail abaixo</p>
                </div>
                <div class="email-conteudo">
                    <div class="input-email">
                        <label for="email" class="texto">E-mail atual</label>
                        <div id="formulario-email"> 
                            <div id="formulario-icone">
                            	<p class="icone-pequeno icone-claro"><%@include file="/assets/imagens/icone-email.svg"%></p>
                            </div>
                            <input class="texto-enfase" type="email" id="i.email" name="email" placeholder="seu.email@gmail.com" maxlength="100" required>
                        </div>
                    </div>
                    <div id="email-validar">
                        <div class="validar-conteudo">
                        	<p class="icone-pequeno"><%@include file="/assets/imagens/icone-atencao.svg"%></p>
                            <p class="texto-sem-enfase">Enviar o token de verificação para este e-mail</p>
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
                                <input class="texto-enfase" type="password" id="i.senha" name="senha" placeholder="********" maxlength="100" required>
                                <p class="icone-pequeno" id="botao-senha"><%@include file="/assets/imagens/icone-olho-fechado.svg"%></p>
                            </div>
                        </div>
                        <div id="senha-nova">
                            <label for="novasenha" class="texto">Confirmar Senha</label>
                            <div class="input-senha">
                                <input class="texto-enfase" type="password" id="novasenha" name="novasenha" placeholder="********" maxlength="100" required>
                                <p class="icone-pequeno" id="botao-novasenha"><%@include file="/assets/imagens/icone-olho-fechado.svg"%></p>
                            </div>
                        </div>
                    </div>
                    <div id="senha-validacao">
                        <div class="validar-conteudo">
                            <p class="icone-pequeno"><%@include file="/assets/imagens/icone-atencao.svg"%></p>
                            <p class="texto-sem-enfase">Enviar confirmação para o e-mail cadastrado:</p>
                        </div>
                        <div class="validar-conteudo">
                            <a href="#" class="texto-enfase texto-escuro">Enviar confirmação</a>
                            <p class="icone-pequeno"><%@include file="/assets/imagens/icone-redirecionar.svg"%></p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="template-grid">
                <div class="botoes">
                    <button type="submit" class="botao-circular-m texto-enfase texto-claro">Salvar Alterações</button>
                    <button type="reset" class="botao-circular-m texto-enfase texto-roxo">Descartar Alterações</button>
                </div>
            </div>
        </form>           
    </main>
    <script><%@include file="../scripts/esqueceu-sua-senha.js"%></script>
</body>
</html>