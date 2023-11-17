<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<header id="cabecalho" class="template-grid">
        <nav class="navegacao-barra">
            <img src="./assets/imagens/icone-menu.svg" alt="icone-menu">
            <img src="./assets/imagens/logo.svg" alt="icone-mediconnect">
        </nav>
        <nav class="navegacao-filtro">
            <div class="filtro">
                <div class="input-item">
                    <input class="texto-enfase" type="texto" id="pesquisar" name="pesquisar" placeholder="Pesquisar">
                </div>
                <div class="filtro-icone">
                    <img src="./assets/imagens/icone-lupa.svg" alt="icone-pesquisar">
                </div>
            </div>
            <button class="botao-quadrado-g texto">Filtrar <img src="./assets/imagens/icone-filtro.svg"></button>
        </nav>
    </header>