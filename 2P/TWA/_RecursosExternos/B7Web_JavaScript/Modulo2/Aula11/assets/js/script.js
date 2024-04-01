// Escopo de variáveis.

/* Variáveis criadas dentro de funções são de escopo local e só funcionam dentro da função,
 * na qual foram declaradas.
 *
 * Variáveis criadas fora de funções são de escopo global e funcionam em qualquer
 * parte do código à qual pertecem.
 */


let count = 0; // Variável de escopo global.

function add() {
    let count = 0; // Variável de escopo local.
    count++;
}

add();
add();

console.log(count);