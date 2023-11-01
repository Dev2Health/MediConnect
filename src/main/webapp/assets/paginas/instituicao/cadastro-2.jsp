<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <title>Cadastrar Instituição | MediConnect</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" type="image/x-icon" href="webapp/assets/imagens/favicon.ico">
    <style><%@include file="../../estilos/padroes.css"%></style>
    <style><%@include file="../../estilos/instituicao-cadastro-2.css"%></style>
</head>
<body>
    <header class="template-grid" id="cabecalho">
        <img src="webapp/assets/imagens/logo-legendado.svg" alt="logo-mediconnect">
        <nav class="barra-navegacao">
            <a href="../cadastro-usuario.html" class="texto texto-escuro">Voltar ao cadastro</a>
            <a href="#" class="botao-circular-m texto texto-claro">Nos contacte</a>
        </nav>
    </header>
    <main>
        <div class="template-grid">
            <h1 class="titulo">Informe os dados da instituição</h1>
        </div>

        <form action="inserir-endereco" method="post" autocomplete="on" id="conteudo-formulario" class="template-grid">
        <input type="hidden" name="instituicao" value=1 />
            <div class="formulario-esquerda">
                <div class="formulario-input">
                    <div class="input-icone">
                        <img src="webapp/assets/imagens/icone-cep.svg" alt="icone-cep">
                    </div>
                    <div class="input-item">
                        <label for="cep" class="texto">CEP</label>
                        <input class="texto-enfase" type="text" id="i.cep" name="cep" oninput="mascaraCep()" placeholder="XXXXX-XXX" maxlength="9" required>
                    </div>
                    <div class="input-elemento">
                        <img src="webapp/assets/imagens/icone-nao-verificado.svg">
                    </div>
                </div>
                <div class="formulario-input">
                    <div class="input-icone">
                        <img src="webapp/assets/imagens/icone-mapa.svg" alt="icone-mapa">
                    </div>
                    <div class="input-item">
                        <label for="cidade" class="texto">Cidade</label>
                        <input class="texto-enfase" type="text" id="i.cidade" name="cidade" placeholder="Cidade" maxlength="35" required>
                    </div>
                </div>
                <div class="formulario-input">
                    <div class="input-icone">
                        <img src="webapp/assets/imagens/icone-logradouro.svg" alt="icone-logradouro">
                    </div>
                    <div class="input-item">
                        <label for="logradouro" class="texto">Logradouro</label>
                        <input class="texto-enfase" type="text" id="i.logradouro" name="logradouro" placeholder="Rua Jardim das Flores" maxlength="70" required>
                    </div>
                </div>
            </div>
            <div class="formulario-direita">
                <div class="formulario-input">
                    <div class="input-icone">
                        <img src="webapp/assets/imagens/icone-mapa.svg" alt="icone-mapa">
                    </div>
                    <div class="input-item">
                        <label for="estado" class="texto">Estado</label>
                        <input class="texto-enfase" list="estado" id="i.estado" name="estado" placeholder="Selecione o Estado" maxlength="35" required>
                        <datalist id="estado">
                            <option value="Pegar estado do CEP">
                        </datalist>
                    </div>
                </div>
                <div class="formulario-input">
                    <div class="input-icone">
                        <img src="webapp/assets/imagens/icone-logradouro.svg" alt="icone-bairro">
                    </div>
                    <div class="input-item">
                        <label for="bairro" class="texto">Bairro</label>
                        <input class="texto-enfase" type="text" id="i.bairro" name="bairro" placeholder="Nome" required>
                    </div>
                </div>
                <div class="formulario-input">
                    <div class="input-icone">
                        <img src="webapp/assets/imagens/icone-numeros.svg" alt="icone-numero">
                    </div>
                    <div class="input-item">
                        <label for="numero" class="texto">Número</label>
                        <input class="texto-enfase" type="number" id="i.numero" name="numero" placeholder="XXXX">
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