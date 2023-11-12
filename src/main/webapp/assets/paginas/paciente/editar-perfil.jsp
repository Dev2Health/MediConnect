<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html lang="pt-br">

<head>

    <title>Editar perfil | Mediconnect</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" type="image/x-icon" href="../../images/favicon.ico">
    <link rel="stylesheet" type="text/css" href="../../styles/padroes.css">

</head>

<body>

    <header class="template-grid" id="content-header">

        <nav class="nav-bar">

            <img src="../../images/icone-voltar.svg" alt="icone-voltar">
            <a href="../../index.html" class="text link-dark">Voltar</a>

        </nav>

        <div>

            <img src="../../images/perfil-paciente.png" alt="foto-de-perfil">

        </div>

    </header>
    <main>
        <form>
            <section>
                <div class="form-left">

                    <div class="form-input">
                        <div class="input-icon">
                            <img src="../../images/icone-paciente.svg">
                        </div>
                        <div class="input-itens">
                            <label for="name" class="text">Nome</label>
                            <input class="text-emphasis" type="text" value="<c:out value='${paciente.nome}'/>"
                            id="p.nome" name="nome" disabled>
                        </div>

                    </div>
                    <div class="form-input">
                        <div class="input-icon">
                            <img src="../../images/icone-cpf.svg">
                        </div>
                        <div class="input-itens">
                            <label for="cpf" class="text">CPF</label>
                            <input class="text-emphasis" type="text" value="<c:out value='${paciente.cpf}'/>"
                            id="p.cpf" name="cpf" disabled>
                        </div>

                    </div>
                </div>
                <div class="form-right">

                    <div class="form-input">
                        <div class="input-icon">
                            <img src="../../images/icone-paciente.svg">
                        </div>
                        <div class="input-itens">
                            <label for="surname" class="text">Sobrenome</label>
                            <input class="text-emphasis" type="text" value="<c:out value='${paciente.sobrenome}'/>"
                            id="p.sobrenome" name="sobrenome" disabled>
                        </div>

                    </div>

                    <div class="form-input">
                        <div class="input-icon">
                            <img src="../../images/icone-paciente.svg">
                        </div>
                        <div class="input-itens">
                            <label for="date" class="text">Data de nascimento</label>
                            <fmt:parseDate value="${dataNascimento}" type="date"
                            pattern="yyyy-MM-dd" var="parsedDate" />
                            <fmt:formatDate value="${parsedDate}" type="date"
                            pattern="dd/MM/yyyy" var="data" />
                            <input class="text-emphasis" type="datetime" value="${data}" id="p.data" name="data" disabled/>
                        </div>
                    </div>

                </div>


            </section>

            <section>



                <div>
                    <p class="text">Alterar dado de contato</p>
                    <div>
                        <button class="btn-square-la" disabled>Habilitar edição</button>
                        <img src="../../images/icone-editar.svg">
                    </div>
                </div>

                <div class="form-left">

                    <div class="form-input">
                        <div class="input-icon">
                            <img src="../../images/icone-telefone.svg" alt="icone-telefone">
                        </div>
                        <div class="input-itens">
                            <label for="phone" class="text">Telefone</label>
                            <input class="text-emphasis" type="tel" value="<c:out value='${paciente.telefone}'/>" id="p.telefone" name="telefone" oninput="mascaraTelefone()" maxlength="16"
                                pattern="(\([0-9]{2}\))\s([9]{1})?([0-9]{4})-([0-9]{4})" required>
                        </div>
                        <div class="input-element">
                            <img src="../../images/icone-verificado.svg">
                        </div>
                    </div>

                </div>


            </section>

            <section>
                <div id="confirm-email" class="template-grid">
                    <div class="email-header">
                        <img src="../../images/icone-email.svg" alt="icone-email">
                        <p class="text">Antes de prosseguir, informe seu endereço de e-mail abaixo</p>
                    </div>
                    <div class="email-content">
                        <div class="input-email">
                            <label for="email" class="text">E-mail atual</label>
                            <div id="form-email">
                                <div id="form-icon">
                                    <img src="../../images/icone-email.svg" alt="icone-email">
                                </div>
                                <input class="text-emphasis" type="email" id="p.email" name="email"
                                    placeholder="seu.email@gmail.com">
                            </div>
                        </div>
                        <div id="email-validation">
                            <div class="validation-content">
                                <img src="../../images/icone-atencao.svg" alt="icone-atencao"> <!--Alterar para Icone-->
                                <p class="text-no-emphasis">Enviar o token de verificação para este e-mail</p>
                            </div>
                        </div>
                    </div>
                </div>
                <div id="redefine-password" class="template-grid">
                    <div class="password-content">
                        <div class="input-password">
                            <div id="current-password">
                                <label for="password" class="text">Nova Senha</label>
                                <div class="password-input">
                                    <input class="text-emphasis" type="password" id="password" name="password"
                                        placeholder="********">
                                    <img src="../../images/icone-olho-fechado.svg" id="btn-password"
                                        onclick="showPassword()">
                                </div>
                            </div>
                            <div id="new-password">
                                <label for="newpassword" class="text">Confirmar Senha</label>
                                <div class="password-input">
                                    <input class="text-emphasis" type="password" id="newpassword" name="newpassword"
                                        placeholder="********">
                                    <img src="../../images/icone-olho-fechado.svg" id="btn-new-password"
                                        onclick="showPasswordAgain()">
                                </div>
                            </div>
                        </div>
                        <div id="password-validation">
                            <div class="validation-content">
                                <img src="../../images/icone-atencao.svg" alt="icone-atencao">
                                <p class="text-no-emphasis">Enviar confirmação para o e-mail cadastrado</p>
                            </div>
                            <div class="validation-content">
                                <a href="#" class="text-emphasis link-dark">Enviar confirmação</a>
                                <img src="../../images/icone-redirecionar.svg" alt="icone-redirecionar">
                                <!--Alterar para Icone-->
                            </div>
                        </div>
                    </div>
                </div>
                <div>
                    <div>
                        <input type="checkbox">
                    </div>
                    <p class="text-no-emphasis">Li e estou de acordo com o <span class="text-emphasis">Termo de Uso e Política de Privacidade</span></p>
                </div>
                <div class="template-grid">
                    <div id="buttons">
                        <button class="btn-round-me text-emphasis link-light" type="submit">Salvar alterações</button>
                        <button class="btn-round-me text-emphasis link-purple" type="reset">Descartar alterações</button>
                    </div>
                </div>
            </section>
        </form>
    </main>
    <script src="../scripts/esqueceu-sua-senha.js"></script>
</body>
</body>

</html>