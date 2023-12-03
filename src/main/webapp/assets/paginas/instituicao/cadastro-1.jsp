<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <title>Cadastrar Instituição | MediConnect</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" type="image/x-icon" href="./assets/imagens/favicon.ico">
    <style><%@include file="../../estilos/padroes.css"%></style>
    <style><%@include file="../../estilos/instituicao-cadastro-1.css"%></style>
</head>
<body>
    <%@include file="../../componentes/cabecalhos/cadastro.jsp"%>
    <main>
        <div class="template-grid">
            <h1 class="titulo">Informe os dados da instituição</h1>
        </div>
        <form action="inserir-instituicao" method="post" id="conteudo-formulario" class="template-grid" enctype="multipart/form-data" autocomplete="off">
            <div class="formulario-esquerda">
                <div class="formulario-input">
                    <div class="input-icone">
                    	<p class="icone-imagem"><%@include file="/assets/imagens/icone-instituicao.svg"%></p>
                    </div>
                    <div class="input-item">
                        <label for="razao" class="texto">Razão Social</label>
                        <input class="texto-enfase" type="text" id="i.razao" name="razao" oninput="mascaraRazao()" placeholder="Empresa Privada LTDA" maxlength="150" required>
                    </div>
                </div>
                <div class="formulario-input">
                    <div class="input-icone">
                        <p class="icone-imagem"><%@include file="/assets/imagens/icone-cnpj.svg"%></p>
                    </div>
                    <div class="input-item">
                        <label for="cnpj" class="texto">CNPJ</label>
                        <input class="texto-enfase" type="text" id="i.cnpj" name="cnpj" oninput="mascaraCnpj()" placeholder="XX.XXX.XXX/XXXX-XX" maxlength="18" required>
                    </div>
                    <div class="input-elemento">
                        <p class="icone-imagem"><%@include file="/assets/imagens/icone-nao-verificado.svg"%></p>
                    </div>
                </div>
                <div class="formulario-input">
                    <div class="input-icone">
                        <p class="icone-imagem"><%@include file="/assets/imagens/icone-senha.svg"%></p>
                    </div>
                    <div class="input-item">
                        <label for="senha" class="texto">Senha</label>
                        <input class="texto-enfase" type="password" id="i.senha" name="senha" oninput="mascaraSenha()" placeholder="********" maxlength="100" required>
                    </div>
                    <div class="input-elemento">
                        <p class="icone-imagem icone-senha"><%@include file="/assets/imagens/icone-olho-fechado.svg"%></p>
                    </div>
                </div>
            </div>
            <div class="formulario-direita">
                <div class="formulario-input">
                    <div class="input-icone">
                        <p class="icone-imagem"><%@include file="/assets/imagens/icone-instituicao.svg"%></p>
                    </div>
                    <div class="input-item">
                        <label for="fantasia" class="texto">Nome Fantasia</label>
                        <input class="texto-enfase" type="text" id="i.fantasia" name="fantasia" oninput="mascaraFantasia()" placeholder="Nome Empresa" maxlength="150" required>
                    </div>
                </div>
                <div class="formulario-input">
                    <div class="input-icone">
                        <p class="icone-imagem"><%@include file="/assets/imagens/icone-email.svg"%></p>
                    </div>
                    <div class="input-item">
                        <label for="email" class="texto">E-mail</label>
                        <input class="texto-enfase" type="email" id="i.email" name="email" placeholder="seu.email@gmail.com" maxlength="100" required>
                    </div>
                    <div class="input-elemento">
                        <p class="icone-imagem"><%@include file="/assets/imagens/icone-nao-verificado.svg"%></p>
                    </div>
                </div>
                <div class="formulario-input">
                    <div class="input-icone">
                        <p class="icone-imagem"><%@include file="/assets/imagens/icone-senha.svg"%></p>
                    </div>
                    <div class="input-item">
                        <label for="confirmar-senha" class="texto">Confirmar Senha</label>
                        <input class="texto-enfase" type="password" id="i.confirmar-senha" name="confirmar-senha" oninput="mascaraSenha()" maxlength="100" placeholder="********">
                    </div>
                    <div class="input-elemento">
                        <p class="icone-imagem icone-senha"><%@include file="/assets/imagens/icone-olho-fechado.svg"%></p>
                    </div>
                </div>
                <div class="formulario-rodape">
                    <button type="submit" class="botao-circular-p texto-enfase texto-claro">Continuar</button>
                    <button type="reset" class="botao-circular-p texto-enfase texto-escuro">Limpar</button>
                </div>
            </div>
        </form>
    </main>
</body>
</html>