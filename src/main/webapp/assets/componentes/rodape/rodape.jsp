<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <footer>
        <div class="template-grid" id="rodape-links">
            <div class="rodape-mediconnect">
                <p class="texto">MediConnect</p>
                <a href="./sobre" class="texto-sem-enfase texto-claro">Sobre nós</a>
                <a href="./index" class="texto-sem-enfase texto-claro">Página inicial</a>
            </div>
            <div class="rodape-contato">
                <p class="texto">Atendimento</p>
                <a href="#" class="texto-sem-enfase texto-claro">Contato</a>
                <a href="#" class="texto-sem-enfase texto-claro">Termos de Uso</a>
            </div>
            <div class="rodape-social">
                <p class="texto">Redes Sociais</p>
                <div class="social-whatsapp">
                	<p class="ilustracao"><%@include file="/assets/imagens/whatsapp-icon-seeklogo.com(1).svg"%></p>
                    <a href="#" class="texto-sem-enfase texto-claro">WhatsApp</a>
                </div>
                <div class="social-github">
                    <p class="ilustracao"><%@include file="/assets/imagens/logo-github.svg"%></p>
                    <a href="#" class="texto-sem-enfase texto-claro">GitHub</a>
                </div>
                <div class="social-instagram">
                    <p class="ilustracao"><%@include file="/assets/imagens/logo-instagram.svg"%></p>
                    <a href="#" class="texto-sem-enfase texto-claro">Instagram</a>
                </div>
            </div>
        </div>
        <div class="template-grid" id="rodape-comercial">
            <hr><br>
            <div class="comercial-conteudo">
            	<p><%@include file="/assets/imagens/logo-rodape.svg"%></p>
                <p class="texto-pequeno">2023 &copy Todos os direitos reservados</p>
            </div>
        </div>
    </footer>