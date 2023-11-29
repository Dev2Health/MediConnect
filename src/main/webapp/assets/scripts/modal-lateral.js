function alternarModal() {
    // Lógica para abrir o modal
    var barraLateral = document.querySelector('.barra-lateral');
    if (barraLateral.style.display == 'none') {
		barraLateral.style.display = 'flex';
	} else {
		barraLateral.style.display = 'none';
	}
}