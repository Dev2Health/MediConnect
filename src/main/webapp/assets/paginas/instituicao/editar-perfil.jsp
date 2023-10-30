<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="pt-br">

<!--Só lembrando para revisar a coloração desta página-->

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

            <img src="../../images/perfil-instituicao.png" alt="logo-mediconnect" class="foto-de-perfil">

        </div>

    </header>

    <main>
        <form>
            <section>

                <div>
                    <p class="text">Alterar dados da instituição</p>
                    <div>
                        <button class="btn-square-la" disabled>Habilitar edição</button>
                        <img src="../../images/icone-editar.svg">
                    </div>
                </div>
                <form action="atualizar-instituicao" method="post" autocomplete="on" id="content-form" class="template-grid">
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
                                <img src="../../images/icone-cep.svg" alt="icone-cep">
                            </div>
                            <div class="input-itens">
                                <label for="cep" class="text">CEP</label>
                                <input class="text-emphasis" type="text" id="i.cep" name="cep" oninput="mascaraCep()" placeholder="XXXXX-XXX" maxlength="9" required>
                            </div>
                            <div class="input-element">
                                <img src="../../images/icone-nao-verificado.svg">
                            </div>
                        </div>
                        <div class="form-input">
                            <div class="input-icon">
                                <img src="../../images/icone-mapa.svg" alt="icone-mapa">
                            </div>
                            <div class="input-itens">
                                <label for="cidade" class="text">Cidade</label>
                                <input class="text-emphasis" type="text" id="i.cidade" name="cidade" placeholder="Cidade" required>
                            </div>
                        </div>
                        <div class="form-input">
                            <div class="input-icon">
                                <img src="../../images/icone-logradouro.svg" alt="icone-logradouro">
                            </div>
                            <div class="input-itens">
                                <label for="logradouro" class="text">Logradouro</label>
                                <input class="text-emphasis" type="text" id="i.logradouro" name="logradouro" placeholder="Rua Jardim das Flores" required>
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
                                <img src="../../images/icone-mapa.svg" alt="icone-mapa">
                            </div>
                            <div class="input-itens">
                                <label for="estado" class="text">Estado</label>
                                <input class="text-emphasis" list="estado" id="i.estado" name="estado" placeholder="Selecione o Estado" required>
                                <select id="estado">
                                    <option value="">(Selecione o estado)</option>
                                    <option value="Pegar estado do CEP">Pegar estado do CEP</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-input">
                            <div class="input-icon">
                                <img src="../../images/icone-logradouro.svg" alt="icone-bairro">
                            </div>
                            <div class="input-itens">
                                <label class="text" for="bairro" class="bairro">Bairro</label>
                                <input class="text-emphasis" type="text" id="i.bairro" name="bairro" placeholder="Nome" required>
                            </div>
                        </div>
                        <div class="form-input">
                            <div class="input-icon">
                                <img src="../../images/icone-numeros.svg" alt="icone-numero">
                            </div>
                            <div class="input-itens">
                                <label class="text" for="numero" class="numero">Número</label>
                                <input class="text-emphasis" type="number" id="i.numero" name="numero" placeholder="XXXX">
                            </div>
                        </div>
                        
                        <div class="form-footer">
                            <button type="submit" class="btn-round-sm text-emphasis link-light">Continuar</button>
                            <button type="reset" class="btn-round-sm text-emphasis">Limpar</button>
                        </div>
                    </div>
                </form>
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
                                <input class="text-emphasis" type="email" id="email" name="email"
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


</html>