function showPassword() {
   var inputPassword = document.getElementById("password");
   var buttonPassword = document.getElementById("btn-password");

   if (inputPassword.type === "password") {
    inputPassword.setAttribute("type", "text");
    buttonPassword.src = "../images/icone-olho-aberto.svg";
   }
   else {
    inputPassword.setAttribute("type", "password");
    buttonPassword.src = "../images/icone-olho-fechado.svg";
   }
}