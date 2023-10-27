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
    <link rel="stylesheet" type="text/css" href="../../styles/cadastro-instituicao-2.css">
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
        </div>

        <form action="inserir-endereco" method="post" autocomplete="on" id="content-form" class="template-grid">
        <input type="hidden" name="instituicao" value=1 />
            <div class="form-left">
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
                        <img src="../../images/icone-mapa.svg" alt="icone-mapa">
                    </div>
                    <div class="input-itens">
                        <label for="estado" class="text">Estado</label>
                        <input class="text-emphasis" list="estado" id="i.estado" name="estado" placeholder="Selecione o Estado" required>
                        <datalist id="estado">
                            <option value="Pegar estado do CEP">
                        </datalist>
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
    </main>
</body>
</html>