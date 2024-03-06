/*
var carro = {};
var pessoa = {};

carro.ano = 2020;
pessoa.nome = "Diogion";

pessoa.imprimeNome = function() {
    console.log(this.nome);
}

imprimeNome();
*/

// Em JS tudo é objeto / Coerção -> tudo é transformado em objeto.
var nome = "Diogin";
var nota = 3.456;

var notaArredondada = nota.toFixed();

console.log(notaArredondada);

// Array e Loops
/* O JS permite armazenar diferentes tipos de dados na mesma variável
 * além disso a alocação é dinâmica.
 */


var consoles = ["PS5","Switch","XBox","SteamDeck"];
/*
for (var i = 0; i < consoles.length; i++) {
    console.log(consoles[i]);
}
*/

// forEach
consoles.forEach((videoGame, indice, vetor) => { // Parâmetros - fn callbak, índice, vetor inteiro
    if (indice % 2 != 0) {
        console.log(indice, videoGame);
    }
});

/*Arrow Function com apenas um parâmetro não exige os parênteses*/

// FILA  -> FIFO (primeiro a chegar, primeiro a sair) SHIFT
// PILHA -> LIFO (último a chegar, primeiro a sair) PUSH, POP

var filaBanco = [];

filaBanco.push("Diogin");
filaBanco.push("Ráphaelzim");
filaBanco.push("Samuelzim");
filaBanco.push("Renanzim");

// Remover o primeiro elemento da fila:
console.log("Ordem de atendimento:");
console.log(filaBanco.shift());
console.log(filaBanco.shift());
console.log(filaBanco.shift());
console.log(filaBanco.shift());

var pilhaDePratos = [];

pilhaDePratos.push("Diogin");
pilhaDePratos.push("Raphaelzim");
pilhaDePratos.push("Samuelzim");
pilhaDePratos.push("Renanzim");

// Remover o último elemento da pilha
console.log("Ordem de lavagem");
pilhaDePratos.pop("Renanzim");
pilhaDePratos.pop("Samuelzim");
pilhaDePratos.pop("Raphaelzim");
pilhaDePratos.pop("Diogin");


