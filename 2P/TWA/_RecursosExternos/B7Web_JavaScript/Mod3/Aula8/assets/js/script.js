// Manipulando elementos
// Os elementos possuem atributos, outros elementos sendo seus filhos, etc.

// Selecionando o elemento:
let button = document.querySelector(".btn");

// Monitorando o evento do botão:
button.addEventListener("click", () => {
    clicked();
});

// Exibindo o conteúdo dos atributos de um elemento:
function clicked() {
    const input = document.querySelector(".input");

    // getAttibute
    console.log(input.getAttribute("type"));
    if (input.hasAttribute("type")) {
        console.log("Atributo TYPE econtrado!")
    } else {
        console.log("Atributo TYPE não encontrado!");
    }

    // setAttibute
    input.setAttribute("placeholder", "Placeholder alterado!");
}

// Exibindo o conteúdo de um input ao alterar o seu atributo:
const input = document.querySelector(".input");
let buttonPasswd = document.createElement("button");
buttonPasswd.textContent = "Mostrar senha";
document.body.appendChild(buttonPasswd);

buttonPasswd.addEventListener("click", () => {
    showHidePassword();
});

function showHidePassword() {
    if (input.getAttribute("type") === "text") {
        input.setAttribute("type", "password");
        buttonPasswd.textContent = "Mostrar senha";
    } else {
        input.setAttribute("type", "text");
        buttonPasswd.textContent = "Ocultar senha";
    }

}