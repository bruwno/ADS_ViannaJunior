// Manipulando elementos
// Os elementos possuem atributos, outros elementos sendo seus filhos, etc.

// e define o parâmetro EVENT
function keyDown(e) {
    // Retornando a tecla que foi pressionada:
    console.log(e.code);
    // ou
    console.log(e.key); // Mais simplório.
}

function keyPress(e) {
    // Verificando se uma tecla específica foi pressionada:
    console.log("Tecla apertada: " + e.code);
    console.log(e.altKey);
}

function keyUp() {
    console.log("Soltou!");
}

// Observador do evento:
const input = document.querySelector("input");

input.addEventListener("keypress", keyPress);