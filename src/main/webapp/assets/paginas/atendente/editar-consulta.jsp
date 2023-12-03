<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <title>Editar Consulta | MediConnect</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" type="image/x-icon" href="./assets/imagens/favicon.ico">
    <style><%@include file="../../estilos/padroes.css"%></style>
    <style><%@include file="../../estilos/atendente-editar-consulta.css"%></style>
</head>
<body>
    <%@include file="../../componentes/cabecalhos/voltar.jsp"%>
    <main>
        <div class="template-grid">
            <div id="retorno-pesquisa">
                <p class="texto">Informações da Consulta</p>
                <button class="botao-quadrado-p texto-enfase texto-claro">Habilitar Edição<img src="./assets/imagens/icone-editar.svg"></button>
            </div>
        </div>
        <form class="template-grid">
            <div class="formulario-esquerda">
                <div id="presenca">
                    <div class="input-presenca">
                        <div class="icone-presenca">
                            <img src="./assets/imagens/icone-consulta.svg" alt="icone-status">
                        </div>
                        <div class="input-informacoes">
                            <label for="status" class="texto">Controle de Presença</label>
                            <input list="lista-status" class="texto-enfase" type="text" id="i.status" name="status" placeholder="(Alterar Status)" disabled>
                            <datalist id="lista-status">
                                <option value="Compareceu"></option>
                                <option value="Atrasou-se"></option>
                                <option value="Ausentou-se"></option>
                            </datalist>
                        </div>
                    </div>
                    <div class="checkbox">
                        <input type="checkbox" disabled>
                        <p class="texto-enfase texto-roxo">Compareceu no horário</p>
                        <!-- Talvez pensar em algo no futuro para o Javascript apenas mostrar essa informação após habilitar edição (display: hide) -->
                    </div>

                </div>
                <div id="comparecimento">
                    <div class="input-comparecimento">
                        <div class="icone-comparecimento">
                            <img src="./assets/imagens/icone-horario.svg" alt="icone-horario">
                        </div>
                        <div class="input-informacoes">
                            <label for="atraso" class="texto">Controle de Comparecimento</label>
                            <div class="informacoes-horarios">
                                <div>
                                    <p class="texto texto-roxo">Horário Previsto</p>
                                    <p class="texto-enfase texto-claro">13h30</p>
                                    <!-- ESSE TEXTO MOSTRA O VALOR DE HORÁRIO DA CONSULTA - PEGAR DO BANCO COM JSP -->
                                </div>
                                <div>
                                    <p class="texto texto-roxo">Atraso</p>
                                    <input class="texto-enfase" type="time" id="i.atraso" name="atraso" disabled>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="formulario-direita">
                <div class="input-data">
                    <label for="data" class="texto">Data Agendada</label>
                    <div class="formulario-data">
                        <div class="icone-data">
                            <img class="icone-claro" src="./assets/imagens/icone-calendario.svg" alt="icone-calendario">
                        </div>
                        <input class="texto-enfase" type="date" id="i.date" name="data" placeholder="DD/MM/AAAA" disabled>
                    </div>
                </div>
                <div class="input-profissionais">
                    <label for="profissional" class="texto">Alterar Profissional</label>
                    <div class="formulario-profissional">
                        <div class="icone-profissional">
                            <img class="icone-claro" src="./assets/imagens/icone-profissional.svg" alt="icone-profissional">
                        </div>
                        <input list="lista-profissional" class="texto-enfase" type="text" id="i.profissional" name="profissional" placeholder="(Selecionar)" disabled>
                        <datalist id="lista-profissional"> 
                            <option value="NOME PROFISSIONAL"></option>
                        </datalist>
                    </div>
                </div>
                <div class="input-horario">
                    <label for="horario" class="texto">Horário Previsto</label>
                    <div class="formulario-horario">
                        <div class="icone-horario">
                            <img class="icone-claro" src="./assets/imagens/icone-horario.svg" alt="icone-horario">
                        </div>
                        <input class="texto-enfase" type="time" id="i.horario" name="horario" placeholder="DD/MM/AAAA" disabled>
                    </div>
                </div>    
            </div>
            
            <div id="formulario-rodape">
                <button class="botao-circular-m texto-enfase texto-claro" type="submit">Salvar alterações</button>
                <button class="botao-circular-m texto-enfase texto-roxo" type="reset">Descartar alterações</button>
            </div>
            
        </form>
    </main>
</body>