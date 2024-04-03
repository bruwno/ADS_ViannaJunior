// Manipulando elementos
// Os elementos possuem atributos, outros elementos sendo seus filhos, etc.

function keyDown() {
    console.log("Apertou!");
}

function keyPress() {
    console.log("Segurou!");
}

function keyUp() {
    console.log("Soltou!");
}

document.addEventListener("keyup", keyUp);