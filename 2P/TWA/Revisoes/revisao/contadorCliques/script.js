
/*
Exercício 2: Criando um contador de cliques
Objetivo: criar um contador de cliques usando JavaScript e manipulação do DOM.
*/
let cont = 0;
let btnClique = document.getElementById("click-me");
let span = document.getElementById("counter");

btnClique.addEventListener("click", event => {
    span.textContent = ++cont;
});