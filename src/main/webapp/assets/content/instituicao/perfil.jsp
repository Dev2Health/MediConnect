<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <title>Início | Mediconnect</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" type="image/x-icon" href="/assets/images/favicon.ico">
    <style><%@include file="../../styles/padroes.css"%></style>
    <style><%@include file="../../styles/pagina-inicial.css"%></style>
</head>
<body>
    <header id="content-header" class="template-grid">
        <nav class="nav-bar">
            <img src="../../images/icone-menu.svg" alt="icone-menu">
            <img src="../../images/logo.svg" alt="logo-mediconnect">
        </nav>
    </header>
    <main>
        <section id="profile">
            <div id="profile-presentation">
                <div class="profile-photo">
                    <img src="../../images/icone-camera.svg" alt="icone-camera">
                </div>
                <div class="profile-edit">
                    <button class="btn-square-me text-emphasis">Editar Perfil <img src="../../images/icone-editar.svg" alt="icone-editar"></button>
                </div>
            </div>
            <div class="template-grid">
                <div id="profile-information">
                    <div class="image-portion">
                        <img class="patient-icon" src="../../images/icone-instituicao.svg" alt="icone-instituicao">
                    </div>
                    <div class="description-portion">
                        <h2 class="subtitle">Intendência Distrital do Grande Garcia</h2>
                        <p class="text">endereço.email@gmal.com</p>
                    </div>
                </div>
            </div>
        </section>
        <section id="specialties">
            <div class="section-subtitle"> <!-- Display flex, justify center -->
                <h2 class="subtitle">Especialidades Atendidas</h2>
            </div>
            <div id="specialty" class="template-grid">
                <div class="card-specialty">
                    <p class="text-emphasis">Clínico Geral</p>
                    <div class="card-info">
                        <div class="info-professional">
                            <img src="../../images/icone-profissional.svg" alt="icone-profissional">
                            <p class="text">4</p>
                        </div>
                        <button class="btn-square-sm text-emphasis">Ver detalhes</button>
                    </div>
                </div>
                <div class="card-specialty">
                    <p class="text-emphasis">Oncologia</p>
                    <div class="card-info">
                        <div class="info-professional">
                            <img src="../../images/icone-profissional.svg" alt="icone-profissional">
                            <p class="text">2</p>
                        </div>
                        <button class="btn-square-sm text-emphasis">Ver detalhes</button>
                    </div>
                </div>
                <div class="card-specialty">
                    <p class="text-emphasis">Odontologia</p>
                    <div class="card-info">
                        <div class="info-professional">
                            <img src="../../images/icone-profissional.svg" alt="icone-profissional">
                            <p class="text">3</p>
                        </div>
                        <button class="btn-square-sm text-emphasis">Ver detalhes</button>
                    </div>
                </div>
            </div>
            <div class="see-all">
                <button href="./especialidades.jsp" class="btn-square-sm text-emphasis"> Ver todas <img src="../../images/icone-seta.svg" alt="icone-seta"></button>
            </div>
        </section>
        <section id="attendats">
            <div class="section-subtitle">
                <h2 class="subtitle">Atendentes Cadastrados</h2>
            </div>
            <div id="attendant" class="template-grid"> 
                <div class="cards-line">

                    <div class="card-attendant">
                        <div class="attendant-top">
                            <div class="attendant-image">
                                <img src="../../images/perfil-exemplo.jpg" alt="foto-de-perfil">
                            </div>
                            <div class="attendant-info">
                                <p class="text">Gleice Silva Pinheiro</p>
                                <p class="text-no-emphasis">Nº Cadastro 456456</p>
                            </div>
                        </div>
                        <div class="attendant-middle">
                            <img src="../../images/icone-informacoes.svg" alt="icone-informações">
                            <p class="text">Informações Gerais</p>
                        </div>
                        <div class="attendant-bottom"> 
                            <div class="bottom-info">
                                <p class="text-no-emphasis">Data de cadastro</p>
                                <p class="text-no-emphasis">18/04/2000</p>
                            </div>
                            <div class="bottom-info">
                                <p class="text-no-emphasis">CTPS</p>
                                <p class="text-no-emphasis">123.456.789-10</p>
                            </div>
                        </div>
                    </div>

                    <div class="card-attendant">
                        <div class="attendant-top">
                            <div class="attendant-image">
                                <img src="../../images/perfil-exemplo.jpg" alt="foto-de-perfil">
                            </div>
                            <div class="attendant-info">
                                <p class="text">Gleice Silva Pinheiro</p>
                                <p class="text-no-emphasis">Nº Cadastro 456456</p>
                            </div>
                        </div>
                        <div class="attendant-middle">
                            <img src="../../images/icone-informacoes.svg" alt="icone-informações">
                            <p class="text">Informações Gerais</p>
                        </div>
                        <div class="attendant-bottom"> 
                            <div class="bottom-info">
                                <p class="text-no-emphasis">Data de cadastro</p>
                                <p class="text-no-emphasis">18/04/2000</p>
                            </div>
                            <div class="bottom-info">
                                <p class="text-no-emphasis">CTPS</p>
                                <p class="text-no-emphasis">123.456.789-10</p>
                            </div>
                        </div>
                    </div>

                    <div class="card-attendant">
                        <div class="attendant-top">
                            <div class="attendant-image">
                                <img src="../../images/perfil-exemplo.jpg" alt="foto-de-perfil">
                            </div>
                            <div class="attendant-info">
                                <p class="text">Gleice Silva Pinheiro</p>
                                <p class="text-no-emphasis">Nº Cadastro 456456</p>
                            </div>
                        </div>
                        <div class="attendant-middle">
                            <img src="../../images/icone-informacoes.svg" alt="icone-informações">
                            <p class="text">Informações Gerais</p>
                        </div>
                        <div class="attendant-bottom"> 
                            <div class="bottom-info">
                                <p class="text-no-emphasis">Data de cadastro</p>
                                <p class="text-no-emphasis">18/04/2000</p>
                            </div>
                            <div class="bottom-info">
                                <p class="text-no-emphasis">CTPS</p>
                                <p class="text-no-emphasis">123.456.789-10</p>
                            </div>
                        </div>
                    </div>

                </div>
            </div>

            <div class="see-all">
                <button href="./especialidades.jsp" class="btn-square-sm text-emphasis"> Ver todas <img src="../../images/icone-seta.svg" alt="icone-seta"></button>
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