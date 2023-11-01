<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <title>Editar perfil | MediConnect</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" type="image/x-icon" href="./assets/imagens/favicon.ico">
    <style><%@include file="../../estilos/padroes.css"%></style>
    <style><%@include file="../../estilos/instituicao-editar-perfil.css"%></style>
</head>
<body>
    <header class="template-grid" id="cabecalho">
        <nav class="barra-navegacao">
            <img src="./assets/imagens/icone-voltar.svg" alt="icone-voltar">
            <a href="../../../index.jsp" class="texto texto-escuro">Voltar</a>
        </nav>
        <img class="perfil-foto" src="./assets/imagens/perfil-instituicao.png" alt="logo-mediconnect">
    </header>
    <main>
        <form>
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
                            <div class="input-itens">
                                <label for="razao-social" class="text">Razão Social</label>
                                <input class="text-emphasis" type="text" value="<c:out value='${instituicao.razaoSocial}'/>"
                            id="i.razao" name="razao" disabled>
                            </div>
                        </div>
                        <div class="formulario-input">
                            <div class="input-icone">
                                <img src="./assets/imagens/icone-cep.svg" alt="icone-cep">
                            </div>
                            <div class="input-itens">
                                <label for="cep" class="text">CEP</label>
                                <input class="text-emphasis" type="text" value="<c:out value='${endereco.cep}'/>"
                            id="i.cep" name="cep" disabled>
                            </div>
                            <div class="input-elemento">
                                <img src="./assets/imagens/icone-nao-verificado.svg">
                            </div>
                        </div>
                        <div class="formulario-input">
                            <div class="input-icone">
                                <img src="./assets/imagens/icone-mapa.svg" alt="icone-mapa">
                            </div>
                            <div class="input-itens">
                                <label for="cidade" class="text">Cidade</label>
                                <input class="text-emphasis" type="text" value="<c:out value='${endereco.cidade}'/>"
                            id="i.cidade" name="cidade" disabled>
                            </div>
                        </div>
                        <div class="formulario-input">
                            <div class="input-icone">
                                <img src="./assets/imagens/icone-logradouro.svg" alt="icone-logradouro">
                            </div>
                            <div class="input-itens">
                                <label for="logradouro" class="text">Logradouro</label>
                                <input class="text-emphasis" type="text" value="<c:out value='${endereco.logradouro}'/>"
                            id="i.logradouro" name="logradouro" disabled>
                            </div>
                        </div>
                    </div>
                    <div class="formulario-direita">
                        <div class="formulario-input">
                            <div class="input-icone">
                                <img src="./assets/imagens/icone-instituicao.svg" alt="icone-instituicao">
                            </div>
                            <div class="input-itens">
                                <label for="nome-fantasia" class="text">Nome Fantasia</label>
                                <input class="text-emphasis" type="text" value="<c:out value='${endereco.nomeFantasia}'/>"
                            id="i.fantasia" name="fantasia" disabled>
                            </div>
                        </div>
                        <div class="formulario-input">
                            <div class="input-icone">
                                <img src="./assets/imagens/icone-mapa.svg" alt="icone-mapa">
                            </div>
                            <div class="input-itens">
                                <label for="estado" class="text">Estado</label>
                                <input class="text-emphasis" type="text" value="<c:out value='${endereco.estado}'/>"
                            id="i.estado" name="estado" disabled>
                                <select id="estado">
                                    <option value="">(Selecione o estado)</option>
                                    <option value="Pegar estado do CEP">Pegar estado do CEP</option>
                                </select>
                            </div>
                        </div>
                        <div class="formulario-input">
                            <div class="input-icone">
                                <img src="./assets/imagens/icone-logradouro.svg" alt="icone-bairro">
                            </div>
                            <div class="input-itens">
                                <label class="text" for="bairro" class="bairro">Bairro</label>
                                <input class="text-emphasis" type="text" value="<c:out value='${endereco.bairro}'/>"
                            id="i.bairro" name="bairro" disabled>
                            </div>
                        </div>
                        <div class="formulario-input">
                            <div class="input-icone">
                                <img src="./assets/imagens/icone-numeros.svg" alt="icone-numero">
                            </div>
                            <div class="input-itens">
                                <label class="text" for="numero" class="numero">Número</label>
                                <input class="text-emphasis" type="text" value="<c:out value='${endereco.numero}'/>"
                            id="i.numero" name="numero" disabled>
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
                        <p class="texto">E-mail Atual: </p> <!-- Pegar o email atual da instituição com o jsp -->
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