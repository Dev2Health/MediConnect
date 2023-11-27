function abrirModal(id) {
    // Esconder todos os modais
    var modais = document.querySelectorAll('.modal');
    modais.forEach(function (modal) {
        modal.style.display = 'none';
    });

    // Mostrar apenas o modal correspondente à entidade específica
    var modal = document.getElementById(`modal-${id}`);
    if (modal) {
        modal.style.display = 'flex';
        carregarConteudo(id);
    }
}

function fecharModal(id) {
    var modal = document.getElementById(`modal-${id}`);
    if (modal) {
        modal.style.display = 'none';
    }
}

function carregarConteudo(id) {
    fetch(`assets/componentes/modais/consulta.jsp?id=${id}`)
        .then(response => response.text())
        .then(html => {
            var modalConteudo = document.getElementById(`modal-conteudo-${id}`);
            if (modalConteudo) {
                modalConteudo.innerHTML = html;
            }
        });
}