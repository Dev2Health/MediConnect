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
    <%@include file="../../componentes/cabecalhos/logado.jsp"%>
    <main>
        <form class="template-grid" action="inserir-atendente" method="post">
            <div class="formulario-esquerda">
                <div class="formulario-input">
                    <div class="input-icone">
                        <img src="./assets/imagens/icone-paciente.svg" alt="icone-pessoa">
                    </div>
                    <div class="input-item">
                        <label for="nome" class="texto">Nome</label>
                        <input class="texto-enfase" type="text" name="nome" id="i.nome" placeholder="Primeiro Nome" maxlength="60" required>
                    </div>
                </div>
                <div class="formulario-input">
                    <div class="input-icone">
                        <img src="./assets/imagens/icone-paciente.svg" alt="icone-pessoa">
                    </div>
                    <div class="input-item">
                        <label for="sobrenome" class="texto">Sobrenome</label>
                        <input class="texto-enfase" type="text" name="sobrenome" id="i.sobrenome" placeholder="Sobrenome" maxlength="60" required>
                    </div>
                </div>
                <div class="formulario-input">
                    <div class="input-icone">
                        <img src="./assets/imagens/icone-ctps.svg" alt="icone-ctps">
                    </div>
                    <div class="input-item">
                        <label for="ctps" class="texto">CTPS</label>
                        <input class="texto-enfase" type="text" name="ctps" id="i.ctps" placeholder="XXX.XXX.XXX-XX" maxlength="11"></input>
                    </div>
                    <div class="input-elemento">
                        <img src="./assets/imagens/icone-nao-verificado.svg">
                    </div>
                </div>

                <div class="formulario-input">
                    <div class="input-icone">
                        <img src="./assets/imagens/icone-calendario.svg" alt="icone-numero-cadastro">
                    </div>
                    <div class="input-item">
                        <label for="cadastro" class="texto">Número de Cadastro</label>
                        <input class="texto-enfase" type="number" name="cadastro" id="i.cadastro" placeholder="XXXXXX">
                        <!-- Para o JavaScript, colocar o número máximo possível como 50. Talvez, precisará ser advindo do banco e mostrado com 'readonly' -->
                    </div>
                </div>
            </div>
            <div class="formulario-direita">
                <div id="posicao-foto">
                    <div class="perfil-foto">
                        <img src="./assets/imagens/icone-camera.svg" alt="icone-camera">
                    </div>
                </div>
                <div class="formulario-input">
                    <div class="input-icone">
                        <img src="./assets/imagens/icone-email.svg" alt="icone-email">
                    </div>
                    <div class="input-item">
                        <label for="email" class="texto">E-mail</label>
                        <input class="texto-enfase" type="email" name="email" id="i.email" placeholder="seu.email@gmail.com" maxlength="100" required></input>
                    </div>
                    <div class="input-elemento">
                        <img src="./assets/imagens/icone-nao-verificado.svg">
                    </div>
                </div>
                <div class="formulario-rodape">
                    <button type="submit" class="botao-circular-p texto-enfase texto-claro">Confirmar</button>
                    <button type="reset" class="botao-circular-p texto-enfase texto-azul">Descartar</button>
                </div>
        </form>
    </main>
</body>
</html>