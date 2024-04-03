// Manipulando elementos
// Os elementos possuem atributos, outros elementos sendo seus filhos, etc.

// Selecionando o elemento:
let button = document.querySelector(".btn");

// Monitorando o evento do botão:
button.addEventListener("click", () => {
    usingBeforeAfter();
    usingBeforeAfterWithElementCreation();
    creatingElemeentUsingLoop();
});

// Adicionando itens ao redor de um elemento (antes ou depois):
function usingBeforeAfter() {
    const primeiraDiv = document.querySelector("#primeiraDiv");
    const ul = primeiraDiv.querySelector("ul");
    ul.after("Um texto DEPOIS/AFTER do elemento <ul>");
    ul.before("Um texto ANTES/BEFORE do elemento <ul>");
}

// Adicionando um elemento antes ou depois de outro:
function usingBeforeAfterWithElementCreation() {
    const primeiraDiv = document.querySelector("#primeiraDiv");
    const ul = primeiraDiv.querySelector("ul");
    const newButton = document.createElement("button");
    newButton.innerHTML = "Botão";
    ul.before(newButton);
    ul.after(newButton);
}

function creatingElemeentUsingLoop() {
    const primeiraDiv = document.querySelector("#primeiraDiv");
    const ul = primeiraDiv.querySelector("ul");

    let newUl = document.createElement("ul");
    // Criando vários elementos de uma vez:
    for (let i = 1; i <= 5; i++) {
        let newLi = document.createElement("li");
        newLi.innerHTML = "Item " + i + " adicionado no loop";
        newUl.append(newLi);
    }
    ul.after(newUl); // ou before
}