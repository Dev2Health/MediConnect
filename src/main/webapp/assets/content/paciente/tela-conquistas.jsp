<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="pt-br">

<head>
    <title>Conquistas | MediConnect</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" type="image/x-icon" href="../../images/favicon.ico">
    <link rel="stylesheet" type="text/css" href="../../styles/padroes.css">
</head>

<body>
    <header class="template-grid" id="content-header">
        <nav class="nav-bar">
            <img src="../../images/icone-voltar.svg" alt="icone-voltar">
            <a href="#" class="text link-dark">Voltar</a>
        </nav>
        <img src="../../images/logo-legendado.svg" alt="logo-mediconnect" class="header-logo">
    </header>

    <main>

        <section>
            <h2 class="title">Conquistas completas</h2>

            <c:forEach var="conquista" items="${conquistas}">
                <div><!--agrupamento-->
                    <input type="hidden" value="<c:out value='${conquista.id}'" />/>
                    <div><!--caixa-->
                        <div><!--icone-->
                            <img src="../../images/icone-<c:out value='${conquista.titulo}' />.svg" alt="icone-<c:out value='${conquista.titulo}' />">
                    </div>
                    <div><!--texto-->
                        <h2 class="subtitle"><c:out value='${conquista.titulo}' /></h2>
                        <p class="text-no-emphasis"><c:out value='${conquista.descricao}' /></p>
                    </div>
                    <div><!--nível-->
                        <div>
                            <p class="text-emphasis"><c:out value='${paciente-conquista.nível}' /></p>
                        </div>
                        <div>
                            <p class="text-emphasis">--/--</p>
                        </div>
                    </div>
                </div>
                <input type="range">
            </c:forEach>
        </section>

        <section>
            <h2 class="title">Conquistas em andamento</h2>

            <c:forEach var="conquista" items="${conquistas}">
                <div><!--agrupamento-->
                    <input type="hidden" value="<c:out value='${conquista.id}'" />/>
                    <div><!--caixa-->
                        <div><!--icone-->
                            <img src="../../images/icone-<c:out value='${conquista.titulo}' />.svg" alt="icone-<c:out value='${conquista.titulo}' />">
                    </div>
                    <div><!--texto-->
                        <h2 class="subtitle"><c:out value='${conquista.titulo}' /></h2>
                        <p class="text-no-emphasis"><c:out value='${conquista.descricao}' /></p>
                    </div>
                    <div><!--nível-->
                        <div>
                            <p class="text-emphasis"><c:out value='${paciente-conquista.nível}' /></p>
                        </div>
                        <div>
                            <p class="text-emphasis">--/--</p>
                        </div>
                    </div>
                </div>
                <input type="range">
            </div> 

        </section>
    </main>
    <footer>
        <div class="template-grid" id="footer-links">
            <div class="footer-mediconnect">
                <p class="text">MediConnect</p>
                <a href="../sobre-nos.html" class="text-no-emphasis link-light">Sobre nós</a>
                <a href="#section-home" class="text-no-emphasis link-light">Página inicial</a>
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