// Manipulando elementos
// Os elementos possuem atributos, outros elementos sendo seus filhos, etc.

// Selecionando o elemento:
let button = document.querySelector(".btn");

// Monitorando o evento do botão:
button.addEventListener("click", () => {
    clicked();
});

// Modificando propriedades do CSS inline:
function clicked() {
    const li = document.querySelector("li");
    li.style.backgroundColor = "#00F";
    li.style.fontSize = "30px";
}