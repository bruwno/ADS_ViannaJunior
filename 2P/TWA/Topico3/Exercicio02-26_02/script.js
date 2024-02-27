// Funções anônimas.
addEventListener('click', () => {
    console.log("Clicou!");
});

// Arrow function. (Função anônima)
addEventListener('click', function() {
    console.log("Clicou!");
});

// Função nomeada.
function exibeClicou() {
    console.log("Clicou!");;
}
addEventListener('click', exibeClicou);
addEventListener('scroll', exibeClicou);