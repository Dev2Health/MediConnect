<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <title>Cadastrar Paciente | MediConnect</title>
    <meta charset="UTF-8"> 
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" type="image/x-icon" href="./assets/imagens/favicon.ico">
    <style><%@include file="../../estilos/padroes.css"%></style>
    <style><%@include file="../../estilos/paciente-cadastro.css"%></style>

</head>
<body>
     <%@include file="../../componentes/cabecalhos/cadastro.jsp"%>
    <main>
        <div class="template-grid">
            <h1 class="titulo">Informe seus dados</h1>
        </div>
      
        <form action="inserir-paciente"  method="post" id="conteudo-formulario" class="template-grid" enctype="multipart/form-data" autocomplete="off">
            <div class="formulario-esquerda">
                <div class="formulario-input">
                    <div class="input-icone">
                        <p class="icone-imagem"><%@include file="/assets/imagens/icone-paciente.svg"%></p>
                    </div>
                    <div class="input-item">
                        <label for="nome" class="texto">Nome</label>
                        <input class="texto-enfase" type="text" id="p.nome" name="nome" placeholder="Nome" maxlength="60" required>
                    </div>
                </div>
                <div class="formulario-input">
                    <div class="input-icone">
                        <p class="icone-imagem"><%@include file="/assets/imagens/icone-cpf.svg"%></p>
                    </div>
                    <div class="input-item">
                        <label for="cpf" class="texto">CPF</label>
                        <input class="texto-enfase" type="text" id="i.cpf" name="cpf" oninput="mascaraCpf()" placeholder="XXX.XXX.XXX-XX" maxlength="14" required>
                    </div>
                    <div class="input-elemento">
                        <p class="icone-"><%@include file="/assets/imagens/icone-nao-verificado.svg"%></p>
                    </div>
                </div>
                <div class="formulario-input">
                    <div class="input-icone">
                        <p class="icone-"><%@include file="/assets/imagens/icone-email.svg"%></p>
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
                        <label for="senha" class="texto">Senha</label>
                        <input class="texto-enfase" type="password" id="p.senha" name="senha" placeholder="*********" maxlength="100" required>
                    </div>
                    <div class="input-elemento">
                        <p class="icone-imagem" id="botao-senha" onclick="showPassword()"><%@include file="/assets/imagens/icone-olho-fechado.svg"%></p>
                    </div>
                </div>
            </div>
            <div class="formulario-direita">
                <div class="formulario-input">
                    <div class="input-icone">
                        <p class="icone-imagem"><%@include file="/assets/imagens/icone-paciente.svg"%></p>
                    </div>
                    <div class="input-item">
                        <label for="sobrenome" class="texto">Sobrenome</label>
                        <input class="texto-enfase" type="text" id="i.sobrenome" name="sobrenome" placeholder="Sobrenome" maxlength="60" required>
                    </div>
                </div>
                <div class="formulario-input">
                    <div class="input-icone">
                        <p class="icone-imagem"><%@include file="/assets/imagens/icone-calendario.svg"%></p>
                    </div>
                    <div class="input-item">
                        <label for="data" class="texto">Data de Nascimento</label>
                        <input class="texto-enfase" type="date" id="i.data" name="data" oninput="mascaraData()" data-placeholder="DD/MM/AAAA" required>
                    </div>
                </div>
                <div class="formulario-input">
                    <div class="input-icone">
                        <p class="icone-imagem"><%@include file="/assets/imagens/icone-telefone.svg"%></p>
                    </div>
                    <div class="input-item">
                        <label for="telefone" class="texto">Telefone</label>
                        <input class="texto-enfase" type="text" id="i.telefone" name="telefone" oninput="mascaraTelefone()" placeholder="(00) 9 9999-9999" maxlength="16" pattern="(\([0-9]{2}\))\s([9]{1})\s([0-9]{4})-([0-9]{4})" required>
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
                        <input class="texto-enfase" type="password" id="i.confirmar-senha" name="confirmar-senha" oninput="mascaraSenha()" placeholder="*********" maxlength="100" required>
                    </div>
                    <div class="input-elemento">
                        <p class="icone-imagem" id="btn-password" onclick="showPassword()"><%@include file="/assets/imagens/icone-olho-fechado.svg"%></p>
                    </div>
                </div>
                <div class="formulario-rodape">
                    <button type="submit" class="botao-circular-p texto-enfase texto-claro">Confirmar</button>
                    <button type="reset" class="botao-circular-p texto-enfase texto-escuro">Limpar</button>
                </div>
            </div>
        </form>
    </main>
</body>
</html>