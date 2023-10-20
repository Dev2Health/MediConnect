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
        <section id="section-map" class="template-grid">
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
        <section id="section-cards" class="template-grid">
            <div id="cards">
                <div class="card-atendente">
                    <img src="../../images/icone-atendente.svg" alt="icone-atendente">
                    <h2 class="legenda">Atendente</h2>
                    <p class="text-no-emphasis">Veja os <span class="text-emphasis">atendentes</span> que atuam conosco na instituição ou consulte seus <span class="text-emphasis">dados</span></p>
                </div>
                <div class="card-especialidade">         
                    <img src="../../images/icone-especialidade.svg" alt="icone-especialidade">
                    <h2 class="legenda">Especialidades</h2>
                    <p class="text-no-emphasis">Veja as <span class="text-emphasis">especialidades</span> disponibilizadas pela instituição e seus respectivos <span class="text-emphasis">atendentes</span></p>
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