// Eventos: quando alguma coisa acontece.
let cont = 0;

function clicou(cont) {
    console.log(`Clicou ${cont} vezes...`);
}

// Selecionando o elemento:
let button = document.querySelector(".btn");

// Monitorando o evento de clique do botão:
button.addEventListener("click", () => {
    cont++;
    clicou(cont);
});