<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <title>Cadastrar Paciente | MediConnect</title>
    <meta name="description" content="..."> <!-- Alterar a descrição da página -->
    <meta charset="UTF-8"> 
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" type="image/x-icon" href="./assets/images/favicon.ico">
    <link rel="stylesheet" type="text/css" href="../../styles/padroes.css">
    <link rel="stylesheet" type="text/css" href="../../styles/cadastro-paciente.css">
</head>
<body>
    <header class="template-grid" id="content-header">
        <img src="../../images/logo-legendado.svg" alt="logo-mediconnect">
        <nav class="nav-bar">
            <a href="../cadastro-usuario.html" class="text link-dark">Voltar ao Cadastro</a>
            <a href="#" class="btn-round-sm text link-light">Nos contacte</a>
        </nav>
    </header>
    <main>
        <div class="template-grid">
            <h1 class="title">Informe seus dados</h1>
        </div>
        <form action="" autocomplete="on" id="content-form" class="template-grid">
            <div class="form-left">
                <div class="form-input">
                    <div class="input-icon">
                        <img src="../../images/icone-paciente.svg" alt="icone-nome">
                    </div>
                    <div class="input-itens">
                        <label for="name" class="text">Nome</label>
                        <input class="text-emphasis" type="text" id="p.nome" name="nome" placeholder="Nome" required>
                    </div>
                </div>
                <div class="form-input">
                    <div class="input-icon">
                        <img src="../../images/icone-cpf.svg" alt="icone-cpf">
                    </div>
                    <div class="input-itens">
                        <label for="cpf" class="text">CPF</label>
                        <input class="text-emphasis" type="text" id="p.cpf" name="cpf" oninput="mascaraCpf()" placeholder="XXX.XXX.XXX-XX" maxlength="14" required>
                    </div>
                    <div class="input-element">
                        <img src="../../images/icone-nao-verificado.svg">
                    </div>
                </div>
                <div class="form-input">
                    <div class="input-icon">
                        <img src="../../images/icone-email.svg" alt="icone-email">
                    </div>
                    <div class="input-itens">
                        <label for="email" class="text">E-mail</label>
                        <input class="text-emphasis" type="email" id="email" name="email" placeholder="seu.email@gmail.com" required>
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
                        <label for="password" class="text">Senha</label>
                        <input class="text-emphasis" type="password" id="p.email" name="email" placeholder="*********" maxlength="100" required>
                    </div>
                    <div class="input-element">
                        <img src="../../images/icone-olho-fechado.svg" id="btn-password" onclick="showPassword()">
                    </div>
                </div>
            </div>
            <div class="form-right">
                <div class="form-input">
                    <div class="input-icon">
                        <img src="../../images/icone-paciente.svg" alt="icone-sobrenome">
                    </div>
                    <div class="input-itens">
                        <label for="surname" class="text">Sobrenome</label>
                        <input class="text-emphasis" type="text" id="p.sobrenome" name="sobrenome" placeholder="Sobrenome" required>
                    </div>
                </div>
                <div class="form-input">
                    <div class="input-icon">
                        <img src="../../images/icone-calendario.svg" alt="icone-calendario">
                    </div>
                    <div class="input-itens">
                        <label for="date" class="text">Data de Nascimento</label>
                        <input class="text-emphasis" type="date" id="p.data" name="data" oninput="mascaraData()" data-placeholder="DD/MM/AAAA" required>
                    </div>
                </div>
                <div class="form-input">
                    <div class="input-icon">
                        <img src="../../images/icone-telefone.svg" alt="icone-telefone">
                    </div>
                    <div class="input-itens">
                        <label for="phone" class="text">Telefone</label>
                        <input class="text-emphasis" type="tel" id="p.telefone" name="telefone" oninput="mascaraTelefone()" placeholder="(00) 9 9999-9999" maxlength="16" pattern="(\([0-9]{2}\))\s([9]{1})?([0-9]{4})-([0-9]{4})" required>
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
                        <label for="password" class="text">Confirmar Senha</label>
                        <input class="text-emphasis" type="password" id="p.confirmar-senha" name="confirmar-senha" oninput="mascaraSenha()" placeholder="*********" maxlength="100" required>
                    </div>
                    <div class="input-element">
                        <img src="../../images/icone-olho-fechado.svg" id="btn-password" onclick="showPassword()">
                    </div>
                </div>
                <div class="form-footer">
                    <button type="submit" class="btn-round-sm text-emphasis link-light">Confirmar</button>
                    <button type="reset" class="btn-round-sm text-emphasis">Limpar</button>
                </div>
            </div>
        </form>
    </main>
    <script src="../../scripts/cadastro-paciente.js"></script>
</body>
</html>