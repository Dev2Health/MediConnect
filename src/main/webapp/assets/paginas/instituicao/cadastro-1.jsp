<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <title>Cadastrar Instituição | MediConnect</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" type="image/x-icon" href="../../images/favicon.ico">
    <link rel="stylesheet" type="text/css" href="../../styles/padroes.css">
    <link rel="stylesheet" type="text/css" href="../../styles/cadastro-instituicao-1.css">
</head>
<body>
    <header class="template-grid" id="content-header">
        <img src="../../images/logo-legendado.svg" alt="logo-mediconnect">
        <nav class="nav-bar">
            <a href="../cadastro-usuario.html" class="text link-dark">Voltar ao cadastro</a>
            <a href="#" class="btn-round-sm text link-light">Nos contacte</a>
        </nav>
    </header>
    <main>
        <div class="template-grid">
            <h1 class="title">Informe os dados da instituição</h1>
            <!-- Faltou fazer os ícones de navegação entre páginas -->
        </div>
        <form action="inserir-instituicao" method="post" autocomplete="on" id="content-form" class="template-grid">
            <div class="form-left">
                <div class="form-input">
                    <div class="input-icon">
                        <img src="../../images/icone-instituicao.svg" alt="icone-instituicao">
                    </div>
                    <div class="input-itens">
                        <label for="razao-social" class="text">Razão Social</label>
                        <input class="text-emphasis" type="text" id="i.razao" name="razao" oninput="mascaraRazao()" placeholder="Empresa Privada LTDA" required>
                    </div>
                </div>
                <div class="form-input">
                    <div class="input-icon">
                        <img src="../../images/icone-cnpj.svg" alt="icone-cnpj">
                    </div>
                    <div class="input-itens">
                        <label for="cnpj" class="text">CNPJ</label>
                        <input class="text-emphasis" type="text" id="i.cnpj" name="cnpj" oninput="mascaraCnpj()" placeholder="XX.XXX.XXX/XXXX-XX" maxlength="18" required>
                    </div>
                    <div class="input-element">
                        <img src="../../images/icone-nao-verificado.svg">
                    </div>
                </div>
                <div class="form-input">
                    <div class="input-icon">
                        <img src="../../images/icone-senha.svg" alt="icone-senha">
                    </div>
                    <div class="input-itens">
                        <label for="senha" class="text">Senha</label>
                        <input class="text-emphasis" type="password" id="i.senha" name="senha" oninput="mascaraSenha()" placeholder="********" required>
                    </div>
                    <div class="input-element">
                        <img src="../../images/icone-olho-fechado.svg">
                    </div>
                </div>
            </div>
            <div class="form-right">
                <div class="form-input">
                    <div class="input-icon">
                        <img src="../../images/icone-instituicao.svg" alt="icone-instituicao">
                    </div>
                    <div class="input-itens">
                        <label for="nome-fantasia" class="text">Nome Fantasia</label>
                        <input class="text-emphasis" type="text" id="i.fantasia" name="fantasia" oninput="mascaraFantasia()" placeholder="Nome Empresa" required>
                    </div>
                </div>
                <div class="form-input">
                    <div class="input-icon">
                        <img src="../../images/icone-email.svg" alt="icone-email">
                    </div>
                    <div class="input-itens">
                        <label for="email" class="text">E-mail</label>
                        <input class="text-emphasis" type="email" id="i.email" name="email" placeholder="seu.email@gmail.com" required>
                    </div>
                    <div class="input-element">
                        <img src="../../images/icone-nao-verificado.svg">
                    </div>
                </div>
                <div class="form-input">
                    <div class="input-icon">
                        <img src="../../images/icone-senha.svg" alt="icone-senha">
                    </div>
                    <div class="input-itens">
                        <label for="confirmar senha" class="text">Confirmar Senha</label>
                        <input class="text-emphasis" type="confirmar-senha" id="i.confirmar-senha" name="confirmar-senha" oninput="mascaraSenha()" placeholder="********">
                    </div>
                    <div class="input-element">
                        <img src="../../images/icone-olho-fechado.svg">
                    </div>
                </div>
                <div class="form-footer">
                    <button type="submit" class="btn-round-sm text-emphasis link-light">Continuar</button>
                    <button type="reset" class="btn-round-sm text-emphasis">Limpar</button>
                </div>
            </div>
        </form>
    </main>
</body>
</html>