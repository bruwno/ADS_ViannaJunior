console.log(`Trabalhando com condicionais`);

const listaDeDestinos = new Array(
    `Salvador`,
    `São Paulo`,
    `Rio de Janeiro`,
);

const idadeComprador = 17;
const estaAcompanhado = false;

console.log("Destinos possíveis: ");
console.log(listaDeDestinos);

if (idadeComprador >= 18) {
    console.log("[Venda autorizada] Comprador maior de idade.");
    listaDeDestinos.splice(1, 1);
} else if (idadeComprador < 18 && estaAcompanhado) {
    console.log("[Venda autorizada] Comprador menor de idade, acompanhado de um adulto.");
    listaDeDestinos.splice(1, 1);
} else {
    console.log("[Venda bloqueada] Comprador menor de idade.");
}

console.log(listaDeDestinos);