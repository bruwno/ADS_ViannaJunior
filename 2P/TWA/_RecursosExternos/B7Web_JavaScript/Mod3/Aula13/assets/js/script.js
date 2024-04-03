// Manipulando eventos do teclado:

const input = document.querySelector("input");
let ul = document.querySelector("ul");

function handleKeyUp(e) {
    if (e.key === "Enter") {
        addItem();
    }
}

input.addEventListener("keyup", handleKeyUp);

function addItem() {
    let newLi = document.createElement("li");
    newLi.innerHTML = input.value;
    ul.appendChild(newLi);

    input.value = ""; // Limpando o input.
}
