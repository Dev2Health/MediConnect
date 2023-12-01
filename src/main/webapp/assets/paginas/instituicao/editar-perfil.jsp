<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <title>Editar Perfil | MediConnect</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" type="image/x-icon" href="./assets/imagens/favicon.ico">
    <style><%@include file="../../estilos/padroes.css"%></style>
    <style><%@include file="../../estilos/instituicao-editar-perfil.css"%></style>
</head>
<body>
    <%@include file="../../componentes/cabecalhos/editar-perfil.jsp"%>
    <main>
        <form action="atualizar-instituicao" method="post">
            <section id="informacoes">
                <div class="template-grid">
                    <div id="retorno-pesquisa">
                        <p class="texto">Alterar dados da instituição</p>
                        <button class="botao-quadrado-p texto-enfase texto-claro" disabled>Habilitar Edição<img src="./assets/imagens/icone-editar.svg"></button>
                    </div>
                </div>
                <div id="dados-formulario" class="template-grid">
                    <div class="formulario-esquerda">
                        <div class="formulario-input">
                            <div class="input-icone">
                                <img src="./assets/imagens/icone-instituicao.svg" alt="icone-instituicao">
                            </div>
                            <div class="input-item">
                                <label for="razao" class="texto">Razão Social</label>
                                <input class="texto-enfase" type="text" id="i.razao" name="razao" oninput="mascaraCep()" value="<c:out value='${instituicao.razaoSocial}'/>" maxlength="65" required>
                            </div>
                        </div>
                        <div class="formulario-input">
                            <div class="input-icone">
                                <img src="./assets/imagens/icone-cep.svg" alt="icone-cep">
                            </div>
                            <div class="input-item">
                                <label for="cep" class="texto">CEP</label>
                                <input class="texto-enfase" type="text" id="i.cep" name="cep" oninput="mascaraCep()" value="<c:out value='${endereco.cep}'/>" maxlength="9" required>
                            </div>
                            <div class="input-elemento">
                                <img src="./assets/imagens/icone-nao-verificado.svg">
                            </div>
                        </div>
                        <div class="formulario-input">
                            <div class="input-icone">
                                <img src="./assets/imagens/icone-mapa.svg" alt="icone-mapa">
                            </div>
                            <div class="input-item">
                                <label for="cidade" class="texto">Cidade</label>
                                <input class="texto-enfase" type="text" id="i.cidade" name="cidade" value="<c:out value='${endereco.cidade}'/>" maxlength="35" required>
                            </div>
                        </div>
                        <div class="formulario-input">
                            <div class="input-icone">
                                <img src="./assets/imagens/icone-logradouro.svg" alt="icone-logradouro">
                            </div>
                            <div class="input-item">
                                <label for="logradouro" class="texto">Logradouro</label>
                                <input class="texto-enfase" type="text" id="i.logradouro" name="logradouro" value="<c:out value='${endereco.logradouro}'/>" maxlength="70" required>
                            </div>
                        </div>
                    </div>
                    <div class="formulario-direita">
                        <div class="formulario-input">
                            <div class="input-icone">
                                <img src="./assets/imagens/icone-instituicao.svg" alt="icone-instituicao">
                            </div>
                            <div class="input-item">
                                <label for="fantasia" class="texto">Nome Fantasia</label>
                                <input class="texto-enfase" type="text" id="i.fantasia" name="fantasia" oninput="mascaraCep()" value="<c:out value='${instituicao.nomeFantasia}'/>" maxlength="65" required>
                            </div>
                        </div>
                        <div class="formulario-input">
                            <div class="input-icone">
                                <img src="./assets/imagens/icone-mapa.svg" alt="icone-mapa">
                            </div>
                            <div class="input-item">
                                <label for="estado" class="texto">Estado</label>
                                <input class="texto-enfase" list="estado" id="i.estado" name="estado" value="<c:out value='${endereco.estado}'/>" maxlength="35" required>
                                <datalist id="estado">
                                    <c:forEach var="estado" items="${estados}">
                                    <option value="<c:out value='${estado}'/>">
                                    </c:forEach>
                                </datalist>
                            </div>
                        </div>
                        <div class="formulario-input">
                            <div class="input-icone">
                                <img src="./assets/imagens/icone-logradouro.svg" alt="icone-bairro">
                            </div>
                            <div class="input-item">
                                <label for="bairro" class="texto">Bairro</label>
                                <input class="texto-enfase" type="text" id="i.bairro" name="bairro" value="<c:out value='${endereco.bairro}'/>" required>
                            </div>
                        </div>
                        <div class="formulario-input">
                            <div class="input-icone">
                                <img src="./assets/imagens/icone-numeros.svg" alt="icone-numero">
                            </div>
                            <div class="input-item">
                                <label for="numero" class="texto">Número</label>
                                <input class="texto-enfase" type="number" id="i.numero" name="numero" value="<c:out value='${endereco.numero}'/>" >
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <section id="dados-sensiveis">
                <div class="template-grid">
                    <div id="retorno-pesquisa">
                        <p class="texto">Alterar dados sensíveis</p>
                        <button class="botao-quadrado-p texto-enfase texto-claro" disabled>Habilitar Edição<img src="./assets/imagens/icone-editar.svg"></button>
                    </div>
                </div>
                <div id="confirmar-email" class="template-grid">
                    <div class="email-superior">
                        <img class="icone-claro" src="./assets/imagens/icone-email.svg" alt="icone-email">
                        <p class="texto">E-mail Atual: <c:out value='${instituicao.email}'/></p> <!-- Pegar o email atual da instituição com o jsp -->
                    </div>
                    <div class="email-conteudo">
                        <div class="input-email">
                            <label for="email" class="texto">Alterar E-mail</label>
                            <div class="formulario-email">
                                <div class="formulario-icone">
                                    <img class="icone-claro" src="./assets/imagens/icone-email.svg" alt="icone-email">
                                </div>
                                <input class="texto-enfase" type="email" id="i.email" name="email" placeholder="novo.email@gmail.com" maxlength="100" required>
                            </div>
                        </div>
                        <div class="email-validar">
                            <div class="validar-conteudo">
                                <img src="./assets/imagens/icone-atencao.svg" alt="icone-atencao">
                                <p class="texto-sem-enfase">Enviar o token de verificação para este e-mail</p>
                            </div>
                            <div class="validar-conteudo">
                                <a class="texto-enfase">Enviar confirmação</a>
                                <img src="./assets/imagens/icone-redirecionar.svg">
                            </div>
                        </div>
                    </div>
                </div>
                <div id="redefinir-senha" class="template-grid">
                    <div class="senha-conteudo">
                        <div class="input-senhas">
                            <div id="senha-atual">
                                <label for="senha" class="texto">Nova Senha</label>
                                <div class="input-senha">
                                    <input class="texto-enfase" type="password" id="i.senha" name="senha" placeholder="********" maxlength="100" required>
                                    <img src="./assets/imagens/icone-olho-fechado.svg" id="botao-senha">
                                </div>
                            </div>
                            <div id="senha-nova">
                                <label for="novasenha" class="texto">Confirmar Senha</label>
                                <div class="input-senha">
                                    <input class="texto-enfase" type="password" id="novasenha" name="novasenha" placeholder="********" maxlength="100" required>
                                    <img src="./assets/imagens/icone-olho-fechado.svg" id="botao-novasenha">
                                </div>
                            </div>
                        </div>
                        <div class="senha-validacao">
                            <div class="validar-conteudo">
                                <img src="./assets/imagens/icone-atencao.svg" alt="icone-atencao">
                                <p class="texto-sem-enfase">Enviar confirmação para o e-mail cadastrado</p>
                            </div>
                            <div class="validar-conteudo">
                                <a href="#" class="texto-enfase texto-escuro">Enviar confirmação</a>
                                <img src="./assets/imagens/icone-redirecionar.svg" alt="icone-redirecionar">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="checkbox">
                    <input type="checkbox">
                    <p class="texto-sem-enfase">Li e estou de acordo com o <a href="#" class="texto-enfase texto-azul">Termo de Uso e Política de Privacidade</a></p>
                </div>
                <div class="template-grid">
                    <div class="botoes">
                        <button class="botao-circular-m texto-enfase texto-claro" type="submit">Salvar alterações</button>
                        <button class="botao-circular-m texto-enfase texto-azul" type="reset">Descartar alterações</button>
                    </div>
                </div>
            </section>
        </form>
    </main>
</body>
</html>