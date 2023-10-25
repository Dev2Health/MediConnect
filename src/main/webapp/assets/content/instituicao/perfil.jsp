<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <title>Perfil | MediConnect</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" type="image/x-icon" href="../../images/favicon.ico">
    <link rel="stylesheet" type="text/css" href="../../styles/padroes.css">
    <link rel="stylesheet" type="text/css" href="../../styles/perfil-instituicao.css">
</head>
<body>
    <header id="content-header" class="template-grid">
        <nav class="nav-bar">
            <img src="../../images/icone-menu.svg" alt="icone-menu">
            <img src="../../images/logo.svg" alt="logo-mediconnect">
        </nav>
    </header>
    <main>
        <section id="section-home" class="template-grid">
            <div id="perfil">
                <div id="perfil-apresentacao">
                    <div class="perfil-foto">
                        <img src="../../images/icone-camera.svg" alt="icone-camera"> <!--Icone deve ser azul-->
                    </div>
                    <div class="perfil-editar">
                        <button class="btn-square-me text">Editar Perfil <img src="../../images/icone-editar.svg" alt="icone-editar"></button>
                    </div>
                </div>
                <div id="perfil-info"> <!-- Posição grid, flex space-between, fundo azul, color(text) branca -->
                    <div class="imagem-porcao">
                        <img class="institution-icon" src="../../images/icone-instituicao.svg" alt="icone-instituicao">
                    </div>
                    <div class="descricao-porcao">
                        <h1 class="legenda"><c:out value='${instituicao.id}' /> <c:out value="${instituicao.fantasia}"/></h1>
                        <p class="text"><c:out value="${instituicao.email}" /></p>
                    </div>
                </div>
            </div>
        </section>
        <section id="section-map" class="template-grid"> <!--Especialidades-->
            <div id="map">
                <div class="map-header">
                    <div class="header-title">
                        <img class="institution-icon" src="../../images/icone-cep.svg" alt="icone-endereco">
                        <h2 class="legenda">Endereço</h2>
                    </div>
                    <div class="header-location">
                        <p class="text-emphasis"><c:out value="${instituicao.rua}"/>, <c:out value="${instituicao.numero}"/></p>
                        <p class="text-emphasis"><c:out value="${instituicao.cep}" /></p>
                    </div>
                </div>
                <div class="map-content">
                    <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3557.621338543637!2d-49.06705442456046!3d-26.915510076645507!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x94df18c6dc8c2135%3A0xbf12691fb17c4e25!2sSchool%20Senac%20Blumenau!5e0!3m2!1sen!2sbr!4v1697031740516!5m2!1sen!2sbr" referrerpolicy="no-referrer-when-downgrade"></iframe>
                </div>
            </div>
        </section>
        <section id="section-cards" class="template-grid"> <!--Atendentes-->
            <div><!--agrupamento de tudo-->
                <h2 class="subtitle">Atendentes Cadastrados</h2>
                <div>
                    <div><!--todos os cards-->
                        <div><!--card completo-->
                            <div><!--foto-->
                                <img src="../../images/perfil-exemplo.jpg" alt="foto-de-perfil">
                            </div>
                            <div><!--card-->
                                <div><!--Header-->
                                    <div><!--Textos-->
                                        <p class="text">Gleice Silva Pinheiro</p>
                                        <p class="text-no-emphasis">Nº Cadastro 456456</p>
                                    </div>
                                </div>
                                <div><!--divisão-->
                                    <img src="../../images/icone-informacoes.svg" alt="icone-informações">
                                    <p class="text">Informações Gerais</p>
                                </div>
                                <div><!--Conteúdo do card-->
                                    <div><!--Textos-->
                                        <div>
                                            <p class="text-no-emphasis">Data de cadastro</p>
                                            <p class="text-no-emphasis">Nº Cadastro 456456</p>
                                        </div>
                                        <div>
                                            <p class="text-no-emphasis">CTPS</p>
                                            <p class="text-no-emphasis">123.456.789-10</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div><!--card completo-->
                            <div><!--foto-->
                                <img src="../../images/perfil-exemplo.jpg" alt="foto-de-perfil">
                            </div>
                            <div><!--card-->
                                <div><!--Header-->
                                    <div><!--Textos-->
                                        <p class="text">João Carlos S. Alcântara</p>
                                        <p class="text-no-emphasis">Nº Cadastro 123123</p>
                                    </div>
                                </div>
                                <div><!--divisão-->
                                    <img src="../../images/icone-informacoes.svg" alt="icone-informações">
                                    <p class="text">Informações Gerais</p>
                                </div>
                                <div><!--Conteúdo do card-->
                                    <div><!--Textos-->
                                        <div>
                                            <p class="text-no-emphasis">Data de cadastro</p>
                                            <p class="text-no-emphasis">20/08/2008</p>
                                        </div>
                                        <div>
                                            <p class="text-no-emphasis">CTPS</p>
                                            <p class="text-no-emphasis">457.755.760-63</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div><!--card completo-->
                            <div><!--foto-->
                                <img src="../../images/perfil-exemplo.jpg" alt="foto-de-perfil">
                            </div>
                            <div><!--card-->
                                <div><!--Header-->
                                    <div><!--Textos-->
                                        <p class="text">Patrícia Melo dos Santos</p>
                                        <p class="text-no-emphasis">N° Cadastro 78789</p>
                                    </div>
                                </div>
                                <div><!--divisão-->
                                    <img src="../../images/icone-informacoes.svg" alt="icone-informações">
                                    <p class="text">Informações Gerais</p>
                                </div>
                                <div><!--Conteúdo do card-->
                                    <div><!--Textos-->
                                        <div>
                                            <p class="text-no-emphasis">Data de cadastro</p>
                                            <p class="text-no-emphasis">05/02/2012</p>
                                        </div>
                                        <div>
                                            <p class="text-no-emphasis">CTPS</p>
                                            <p class="text-no-emphasis">101.390.426-52</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <button class="btn-square-sm text">Ver todas <img src="../../images/icone-seta.svg"
                            alt="icone-seta"></button>
                </div>
            </div>
        </section>
    </main>
    <footer>
        <div class="template-grid" id="footer-links">
            <div class="footer-mediconnect">
                <p class="text">MediConnect</p>
                <a href="../sobre-nos.html" class="text-no-emphasis link-light">Sobre nós</a>
                <a href="../../../index.html" class="text-no-emphasis link-light">Página inicial</a>
            </div>
            <div class="footer-contact">
                <p class="text">Atendimento</p>
                <a href="#" class="text-no-emphasis link-light">Contato</a>
                <a href="#" class="text-no-emphasis link-light">Termos de Uso</a>
            </div>
            <div class="footer-social">
                <p class="text">Redes Sociais</p>
                <div class="social-whatsapp">
                    <img src="../../images/logo-whatsapp.svg">
                    <a href="#" class="text-no-emphasis link-light">WhatsApp</a>
                </div>
                <div class="social-github">
                    <img src="../../images/logo-github.svg">
                    <a href="#" class="text-no-emphasis link-light">GitHub</a>
                </div>
                <div class="social-instagram">
                    <img src="../../images/logo-instagram.svg">
                    <a href="#" class="text-no-emphasis link-light">Instagram</a>
                </div>
            </div>
        </div>
        <div class="template-grid" id="footer-commercial">
            <hr><br>
            <div class="commercial-content">
                <img src="../../images/logo-rodape.svg" alt="logo-mediconnect">
                <p class="text-small">2023 &copy Todos os direitos reservados</p>
            </div>
        </div>
    </footer>
</body>
</html>