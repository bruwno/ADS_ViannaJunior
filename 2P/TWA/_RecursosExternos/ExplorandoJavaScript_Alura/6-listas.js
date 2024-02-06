// Documentação: https://developer.mozilla.org/pt-BR/docs/Web/JavaScript/Reference/Global_Objects/Array

console.log(`Trabalhando com listas`);

// Declaração de Arrays.
const listaDeDestinos = new Array(
    `Salvador`,
    `São Paulo`,
    `Rio de Janeiro`,
);

// Adicionando um item na lista dinamicamente, depois dela já ter sido decalarada.
listaDeDestinos.push(`Juiz de Fora`);
listaDeDestinos.push(`Belo Horizonte`);

console.log("Destinos possíveis: ");
console.log(listaDeDestinos);

// Removendo um item da lista com o método slice(). 
/* Os argumentos passados são o índice do item e quantos itens devem ser deletados.
 */
listaDeDestinos.splice(1, 1);
console.log(listaDeDestinos);

// Exibindo um índice específico da lista.
console.log(listaDeDestinos[1]);