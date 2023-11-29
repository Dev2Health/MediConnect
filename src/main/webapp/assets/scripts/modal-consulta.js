    function abrirModal(id) {
        // Construct the modal element ID using string manipulation
        var modalId = 'modal-' + id;
        var modal = document.getElementById(modalId);
        if (modal) {
            modal.style.display = 'flex';
        }
    }

function fecharModal(id) {
    var modalId = 'modal-' + id;
    var modal = document.getElementById(modalId);
    if (modal) {
        modal.style.display = 'none';
    }
}