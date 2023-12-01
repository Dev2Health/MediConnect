<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <title>Cadastrar Atendente | MediConnect</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" type="image/x-icon" href="./assets/imagens/favicon.ico">
    <style><%@include file="../../estilos/padroes.css"%></style>
    <style><%@include file="../../estilos/instituicao-cadastrar-atendente.css"%></style>
</head>
<body>
   <%@include file="../../componentes/cabecalhos/voltar.jsp"%> 
    <main>
        <form class="template-grid" action="inserir-atendente" method="post">
            <div class="formulario-esquerda">
                <div class="formulario-input">
                    <div class="input-icone">
                        <p class="icone-grande"><%@include file="/assets/imagens/icone-paciente.svg"%></p>
                    </div>
                    <div class="input-item">
                        <label for="nome" class="texto">Nome</label>
                        <input class="texto-enfase" type="text" name="nome" id="i.nome" placeholder="Nome" maxlength="60" required>
                    </div>
                </div>
                <div class="formulario-input">
                    <div class="input-icone">
                        <p class="icone-grande"><%@include file="/assets/imagens/icone-paciente.svg"%></p>
                    </div>
                    <div class="input-item">
                        <label for="sobrenome" class="texto">Sobrenome</label>
                        <input class="texto-enfase" type="text" name="sobrenome" id="i.sobrenome" placeholder="Sobrenome" maxlength="60" required>
                    </div>
                </div>
                <div class="formulario-input">
                    <div class="input-icone">
                        <p class="icone-grande"><%@include file="/assets/imagens/icone-cpf.svg"%></p>
                    </div>
                    <div class="input-item">
                        <label for="email" class="texto">CPF</label>
                        <input class="texto-enfase" type="text" name="cpf" id="a.cpf" placeholder="XXX.XXX.XXX-XX" maxlength="14" required></input>
                    </div>
                    <div class="input-elemento">
                        <p class="icone-pequeno"><%@include file="/assets/imagens/icone-nao-verificado.svg"%></p>
                    </div>
                </div>
                <div class="formulario-input">
                    <div class="input-icone">
                        <p class="icone-grande"><%@include file="/assets/imagens/icone-ctps.svg"%></p>
                    </div>
                    <div class="input-item">
                        <label for="ctps" class="texto">CTPS</label>
                        <input class="texto-enfase" type="text" name="ctps" id="i.ctps" placeholder="XXX.XXX.XXX-XX" maxlength="14"></input>
                    </div>
                    <div class="input-elemento">
                        <p class="icone-pequeno"><%@include file="/assets/imagens/icone-nao-verificado.svg"%></p>
                    </div>
                </div>
                <div class="formulario-input">
                    <div class="input-icone">
                        <p class="icone-grande"><%@include file="/assets/imagens/icone-calendario.svg"%></p>
                    </div>
                    <div class="input-item">
                        <label for="email" class="texto">Data</label>
                        <input class="texto-enfase" type="date" name="data" id="a.data" required></input>
                    </div>
                </div>
            </div>
            <div class="formulario-direita">
                <div id="posicao-foto">
                    <div class="perfil-foto">
                        <p class="texto-pequeno texto-azul">Adicionar Foto</p>
                        <%-- Temos que dar a opção de upload de foto aqui dentro, provavelmente --%>
                    </div>
                </div>
                <div class="formulario-input">
                    <div class="input-icone">
                        <p class="icone-grande"><%@include file="/assets/imagens/icone-numeros.svg"%></p>
                    </div>
                    <div class="input-item">
                        <label for="cadastro" class="texto">Número de Cadastro</label>
                        <input class="texto-enfase" type="number" name="cadastro" id="i.cadastro" placeholder="XXXXXX">
                        <!-- Precisará advir do banco e ser mostrado com 'readonly' -->
                    </div>
                </div>
                <div class="formulario-input">
                    <div class="input-icone">
                        <p class="icone-grande"><%@include file="/assets/imagens/icone-email.svg"%></p>
                    </div>
                    <div class="input-item">
                        <label for="email" class="texto">E-mail</label>
                        <input class="texto-enfase" type="email" name="email" id="i.email" placeholder="seu.email@gmail.com" maxlength="100" required></input>
                    </div>
                    <div class="input-elemento">
                        <p class="icone-pequeno"><%@include file="/assets/imagens/icone-nao-verificado.svg"%></p>
                    </div>
                </div>
                <div class="formulario-input">
                    <div class="input-icone">
                        <p class="icone-grande"><%@include file="/assets/imagens/icone-senha.svg"%></p>
                    </div>
                    <div class="input-item">
                        <label for="email" class="texto">Senha</label>
                        <input class="texto-enfase" type="password" name="senha" id="a.senha" placeholder="Senha" maxlength="100" required></input>
                    </div>
                    <div class="input-elemento">
                        <p class="icone-pequeno"><%@include file="/assets/imagens/icone-olho-fechado.svg"%></p>
                    </div>
                </div>
                <div class="formulario-rodape">
                    <button type="submit" class="botao-circular-p texto-enfase texto-claro">Confirmar</button>
                    <button type="reset" class="botao-circular-p texto-enfase texto-azul">Descartar</button>
                </div>
             </div>
        </form>
    </main>
</body>
</html>