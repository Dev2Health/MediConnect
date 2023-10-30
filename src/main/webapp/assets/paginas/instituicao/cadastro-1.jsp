<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <title>Cadastrar Instituição | MediConnect</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" type="image/x-icon" href="../../imagens/favicon.ico">
    <style><%@include file="../../estilos/padroes.css"%></style>
    <style><%@include file="../../estilos/instituicao-cadastro-1.css"%></style>
</head>
<body>
    <header class="template-grid" id="cabecalho">
        <img src="../../imagens/logo-legendado.svg" alt="logo-mediconnect">
        <nav class="barra-navegacao">
            <a href="../cadastro-usuario.html" class="texto link-escuro">Voltar ao cadastro</a>
            <a href="#" class="botao-circular-m texto link-claro">Nos contacte</a>
        </nav>
    </header>
    <main>
        <div class="template-grid">
            <h1 class="titulo">Informe os dados da instituição</h1>
            <!-- Faltou fazer os ícones de navegação entre páginas -->
        </div>
        <form action="inserir-instituicao" method="post" autocomplete="on" id="conteudo-formulario" class="template-grid">
            <div class="formulario-esquerda">
                <div class="formulario-input">
                    <div class="input-icone">
                        <img src="../../imagens/icone-instituicao.svg" alt="icone-instituicao">
                    </div>
                    <div class="input-item">
                        <label for="razao" class="texto">Razão Social</label>
                        <input class="texto-enfase" type="text" id="i.razao" name="razao" oninput="mascaraRazao()" placeholder="Empresa Privada LTDA" maxlength="150" required>
                    </div>
                </div>
                <div class="formulario-input">
                    <div class="input-icone">
                        <img src="../../imagens/icone-cnpj.svg" alt="icone-cnpj">
                    </div>
                    <div class="input-item">
                        <label for="cnpj" class="texto">CNPJ</label>
                        <input class="texto-enfase" type="text" id="i.cnpj" name="cnpj" oninput="mascaraCnpj()" placeholder="XX.XXX.XXX/XXXX-XX" maxlength="18" required>
                    </div>
                    <div class="input-elemento">
                        <img src="../../imagens/icone-nao-verificado.svg">
                    </div>
                </div>
                <div class="formulario-input">
                    <div class="input-icone">
                        <img src="../../imagens/icone-senha.svg" alt="icone-senha">
                    </div>
                    <div class="input-item">
                        <label for="senha" class="texto">Senha</label>
                        <input class="texto-enfase" type="password" id="i.senha" name="senha" oninput="mascaraSenha()" placeholder="********" maxlength="100" required>
                    </div>
                    <div class="input-elemento">
                        <img src="../../imagens/icone-olho-fechado.svg">
                    </div>
                </div>
            </div>
            <div class="formulario-direita">
                <div class="formulario-input">
                    <div class="input-icone">
                        <img src="../../imagens/icone-instituicao.svg" alt="icone-instituicao">
                    </div>
                    <div class="input-item">
                        <label for="fantasia" class="texto">Nome Fantasia</label>
                        <input class="texto-enfase" type="text" id="i.fantasia" name="fantasia" oninput="mascaraFantasia()" placeholder="Nome Empresa" maxlength="150" required>
                    </div>
                </div>
                <div class="formulario-input">
                    <div class="input-icone">
                        <img src="../../imagens/icone-email.svg" alt="icone-email">
                    </div>
                    <div class="input-item">
                        <label for="email" class="texto">E-mail</label>
                        <input class="texto-enfase" type="email" id="i.email" name="email" placeholder="seu.email@gmail.com" maxlength="100" required>
                    </div>
                    <div class="input-elemento">
                        <img src="../../imagens/icone-nao-verificado.svg">
                    </div>
                </div>
                <div class="formulario-input">
                    <div class="input-icone">
                        <img src="../../imagens/icone-senha.svg" alt="icone-senha">
                    </div>
                    <div class="input-item">
                        <label for="confirmar-senha" class="texto">Confirmar Senha</label>
                        <input class="texto-enfase" type="password" id="i.confirmar-senha" name="confirmar-senha" oninput="mascaraSenha()" maxlength="100" placeholder="********">
                    </div>
                    <div class="input-elemento">
                        <img src="../../imagens/icone-olho-fechado.svg">
                    </div>
                </div>
                <div class="formulario-rodape">
                    <button type="submit" class="botao-circular-p texto-enfase link-claro">Continuar</button>
                    <button type="reset" class="botao-circular-p texto-enfase">Limpar</button>
                </div>
            </div>
        </form>
    </main>
</body>
</html>