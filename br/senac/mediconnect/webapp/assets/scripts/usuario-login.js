function mostrarSenha() {
   const senha = document.getElementById("senha");
   const botao = document.getElementById("botao-senha");

   if (senha.type === "password") {
    senha.setAttribute("type", "text");
    botao.src = "../imagens/icone-olho-aberto.svg";
   }
   else {
    senha.setAttribute("type", "password");
    botao.src = "../imagens/icone-olho-fechado.svg";
   }
}