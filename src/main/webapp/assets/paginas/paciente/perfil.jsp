<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <title>Perfil | MediConnect</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" type="image/x-icon" href="../../imagens/favicon.ico">
    <style><%@include file="../../estilos/padroes.css"%></style>
</head>

<body>
    <header id="content-header" class="template-grid">
        <nav class="nav-bar">
            <img src="../../imagens/icone-menu.svg" alt="icone-menu">
            <img src="../../imagens/logo.svg" alt="logo-mediconnect">
        </nav>
    </header>
    <main>
        <section id="section-home" class="template-grid">
            <div id="profile">
                <div id="profile-presentation">
                    <div class="profile-photo">
                        <img src="../../imagens/icone-camera.svg" alt="icone-camera"> <!--Icone deve ser azul-->
                    </div>
                    <div class="profile-edit">
                        <button class="btn-square-me text">Editar Perfil <img src="../../imagens/icone-editar.svg"
                                alt="icone-editar"></button>
                        <a href="./editar-perfil">Editar Perfil</a>
                        <a href="./deslogar" class="btn-square-me text">Deslogar</a>
                    </div>
                </div>
                <div id="profile-information"> <!-- Posição grid, flex space-between, fundo azul, color(text) branca -->
                    <div class="image-portion">
                        <img class="patient-icon" src="../../imagens/icone-paciente.svg" alt="icone-paciente">
                        <img  width="100px" height="100px"  src="<c:url   value="/uploadImage/${usuario.fotoPerfil}.png" />">
                    </div>
                    <div class="description-portion">
                        <h1 class="subtitle"><c:out value="${paciente.nome}"/> <c:out value="${paciente.sobrenome}"/></h1>
                        <p class="text"><c:out value="${paciente.email}" /></p>
                    </div>
                    <div>
                        <div>
                            <div></div><!--esta belissima div é para ser o nosso querido e amado bolinh verde-->
                            <img src="../../imagens/icone-selo-assiduo.svg" alt="icone-assiduo">
                            <p class="text-small">colocar selo assíduo</p>
                        </div>
                        <div>
                            <div></div>
                            <img src="../../imagens/icone-selo-pontual.svg" alt="icone-pontual">
                            <!--Socorro pq isso ta quebrado?-->
                            <p class="text-small">colocar selo pontual</p>
                        </div>
                    </div>
                </div>
            </div>
        </section>

<section>
            <h2 class="title">Conquistas completas</h2>

            <c:forEach var="conquista" items="${conquistas}">
                <div><!--agrupamento-->
                    <input type="hidden" value="<c:out value='${conquista.id}'/>" />
                    <div><!--caixa-->
                        <div><!--icone-->
                            <img src="../../imagens/icone-nosso-presente.svg" alt="icone-nosso-presente">
                    </div>
                    <div><!--texto-->
                        <h2 class="subtitle"><c:out value='${conquista.nome}' /></h2>
                        <p class="text-no-emphasis"><c:out value='${conquista.descricao}' /></p>
                    </div>
                    <div><!--nível-->
                        <div>
                            <c:if test="${pacienteConquista != null}">
                            <p class="text-emphasis"><c:out value='${pacienteConquista.nível}' /></p>
					        </c:if>
                        </div>
                        <div>
                            <p class="text-emphasis">--/--</p>
                        </div>
                    </div>
                </div>
            </c:forEach>

        </section>

        <section>
            <h1 class="subtitle">Consultas Próximas</h1>

            <div><!--agrupa todos os card-->

                <c:forEach var="consulta" items="${consultas}">
                <div><!--caixa inteira-->

                    <div><!--header da caixa-->

                        <div></div><!--aquelas duas coisinhas brancas-->
                        <div></div>

                        <div>
                            <p class="text-emphasis">Consulta - <c:out value="${consulta.id}" /></p>
                            <p class="text-emphasis"><c:out value='${consulta.status}' /></p>
                        </div>

                    </div>

                    <div><!--conteúdo da caixa-->

                        <div>
                            <div>
                                <div>
                                    <fmt:parseDate value="${consulta.data}" type="date"
								    pattern="yyyy-MM-dd" var="parsedDate" />
							        <fmt:formatDate value="${parsedDate}" type="date"
								    pattern="dd/MM/yyyy" var="data" />
                                    <p class="text-emphasis" type="date"><c:out value="${data}" /></p>
                                </div>
                                <div>
                                    <p class="text emphasis"><c:out value='${consulta.horario}' /></p>
                                </div>
                            </div>

                            <div>
                                <p class="text-no-emphasis"><c:out value='${consulta.descricao}' /><span
                                        class="text-emphasis">...ver mais</span></p>
                            </div>

                            <div>
                                <p class="text">Editar consulta</p>
                                <img src="../../imagens/icone-editar.svg" alt="icone-editar">
                            </div>

                        </div>
                    </div>

                </div>
                </c:forEach>
            </div>
            <a href="./consultas" class="btn-square-sm text">Ver todas <img src="../../imagens/icone-seta.svg"></a>
        </section>


    </main>

    <%@include file="../../componentes/rodape/rodape.jsp"%>


</body>

</html>