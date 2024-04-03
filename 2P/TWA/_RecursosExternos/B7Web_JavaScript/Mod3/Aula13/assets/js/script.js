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
    let newLi = document.createElement("li"); // Criando o elemento li na ul.
    newLi.innerHTML = input.value; // Fazendo a nova li receber o valor do input.
    ul.appendChild(newLi); // Adicionando o elemento no documento.

    input.value = ""; // Limpando o input.
}

let btnDelete = document.createElement("button");
document.body.appendChild(btnDelete);
btnDelete.textContent = "Remover item";


function removeItem() {
    ul.removeChild(ul.lastElementChild);
}

btnDelete.addEventListener("click", () => {
    removeItem();
});