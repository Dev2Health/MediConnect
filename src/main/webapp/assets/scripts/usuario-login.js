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
   var inputConteudo = document.getElementById("email").value;
   var botao = document.getElementById("botao").disabled = true

   var regexEmail = /^((?!\.)[\w\-_.]*[^.])(@\w+)(\.\w+(\.\w+)?[^.\W])$/;

   if(regexEmail.test(inputConteudo)){
      
      document.getElementById("formulario").submit();


   }else{
      console.log("O email não está no padrão");
   }
   
   

   
}
