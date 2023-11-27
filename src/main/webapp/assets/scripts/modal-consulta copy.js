function abrirModal() {
    fetch('assets/componentes/modais/consulta.jsp')
        .then(response => response.text())
        .then(html => {
            document.getElementById('modal-conteudo').innerHTML = html;
            document.getElementById('modal').style.display = 'flex';
        });
}

function fecharModal() {
    document.getElementById('modal').style.display = 'none';
}