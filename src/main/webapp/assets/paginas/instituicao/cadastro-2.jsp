<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <title>Cadastrar Instituição | MediConnect</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" type="image/x-icon" href="./assets/imagens/favicon.ico">
    <style><%@include file="../../estilos/padroes.css"%></style>
    <style><%@include file="../../estilos/instituicao-cadastro-2.css"%></style>
</head>
<body>
	<%@include file="../../componentes/cabecalhos/cadastro.jsp"%>
    <main>
        <div class="template-grid">
            <h1 class="titulo">Informe os dados da instituição</h1>
        </div>

        <form action="inserir-endereco" method="post" id="conteudo-formulario" class="template-grid">
        <input type="hidden" name="instituicao" value=1 />
            <div class="formulario-esquerda">
                <div class="formulario-input">
                    <div class="input-icone">
                        <p class="icone-imagem"><%@include file="/assets/imagens/icone-cep.svg"%></p>
                    </div>
                    <div class="input-item">
                        <label for="cep" class="texto">CEP</label>
                        <input class="texto-enfase" type="text" id="i.cep" name="cep" oninput="mascaraCep()" placeholder="XXXXX-XXX" maxlength="9" required>
                    </div>
                    <div class="input-elemento">
                    	<p class="icone-imagem"><%@include file="/assets/imagens/icone-nao-verificado.svg"%></p>
                    </div>
                </div>
                <div class="formulario-input">
                    <div class="input-icone">
                        <p class="icone-imagem"><%@include file="/assets/imagens/icone-mapa.svg"%></p>
                    </div>
                    <div class="input-item">
                        <label for="cidade" class="texto">Cidade</label>
                        <input class="texto-enfase" type="text" id="i.cidade" name="cidade" placeholder="Cidade" maxlength="35" required>
                    </div>
                </div>
                <div class="formulario-input">
                    <div class="input-icone">
                        <p class="icone-imagem"><%@include file="/assets/imagens/icone-logradouro.svg"%></p>
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
                        <p class="icone-imagem"><%@include file="/assets/imagens/icone-mapa.svg"%></p>
                    </div>
                    <div class="input-item">
                        <label for="estado" class="texto">Estado</label>
                        <input class="texto-enfase" list="lista-estados" id="i.estado" name="estado" placeholder="Selecione o Estado" maxlength="35" required>
                        <datalist id="lista-estados">
                        	<%-- Pegar o Estado a partir do CEP --%>
                            <option value="Acre">
                            <option value="Alagoas">
                            <option value="Amapá">
                            <option value="Amazonas">
                            <option value="Bahia">
                            <option value="Ceará">
                            <option value="Espírito Santo">
                            <option value="Goiás">
                            <option value="Maranhão">
                            <option value="Mato Grosso">
                            <option value="Mato Grosso do Sul">
                            <option value="Minas Gerais">
                            <option value="Pará">
                            <option value="Paraíba">
                            <option value="Paraná">
                            <option value="Pernambuco">
                            <option value="Piauí">
                            <option value="Rio de Janeiro">
                            <option value="Rio Grande do Norte">
                            <option value="Rio Grande do Sul">
                            <option value="Rondônia">
                            <option value="Roraima">
                            <option value="Santa Catarina">
                            <option value="São Paulo">
                            <option value="Sergipe">
                            <option value="Tocantins">
                            <option value="Distrito Federal">
                        </datalist>
                    </div>
                </div>
                <div class="formulario-input">
                    <div class="input-icone">
                        <p class="icone-imagem"><%@include file="/assets/imagens/icone-logradouro.svg"%></p>
                    </div>
                    <div class="input-item">
                        <label for="bairro" class="texto">Bairro</label>
                        <input class="texto-enfase" type="text" id="i.bairro" name="bairro" placeholder="Nome" required>
                    </div>
                </div>
                <div class="formulario-input">
                    <div class="input-icone">
                        <p class="icone-imagem"><%@include file="/assets/imagens/icone-numeros.svg"%></p>
                    </div>
                    <div class="input-item">
                        <label for="numero" class="texto">Número</label>
                        <input class="texto-enfase" type="number" id="i.numero" name="numero" placeholder="XXXX" min="1">
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