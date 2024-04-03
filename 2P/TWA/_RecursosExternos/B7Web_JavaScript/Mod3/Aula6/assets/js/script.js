// Manipulando elementos
// Os elementos possuem atributos, outros elementos sendo seus filhos, etc.

// Selecionando o elemento:
let button = document.querySelector(".btn");

// Monitorando o evento do botão:
button.addEventListener("click", () => {
    clicked();
    appendElement();
    prependElement();
});

function clicked() {
    const primeiraDiv = document.querySelector("#primeiraDiv");
    const ul = primeiraDiv.querySelector("ul");

    // Append adiciona um conteúdo ao já existente de um elemento.
    ul.children[0].append("(alterado)");
    // Faz o mesmo que o append, no entanto sobrescreve o conteúdo já existente.
    ul.children[0].innerHTML += "(alterado!)";
    console.log(ul);
}

// Adicionando um elemento ao documento HTML com o appendChild:
function appendElement() {
    //const primeiraDiv = document.querySelector("#primeiraDiv");
    const ul = document.querySelector("ul");
    // Com o appendChild:
    let newLi = document.createElement("li");
    newLi.innerText = "Item criado pelo appendChild()!";
    ul.appendChild(newLi);

    // Com o innerHTML:
    ul.innerHTML += "<li>Item criado pelo innerHTML!</li>";
}

// Adicionando um texto no começo do elemento:
function prependElement() {
    const ul = document.querySelector("ul");
    let newLi = document.createElement("li");
    newLi.innerText = "Item adicionado usando prepend()!";
    ul.prepend(newLi);
}