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

function mascaraEmail() {
   document.getElementById("botao").disabled = true;
   var inputConteudo = document.getElementById("email").value;
   

   var regexEmail = new RegExp ('[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}');

   regexEmail.test(inputConteudo);
   
      if(inputConteudo == true){
         document.getElementById("botao").disabled = false;
         
      }else{
         document.getElementById("botao").disabled = true;

      }
   


}
