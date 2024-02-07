console.log(`Trabalhando com condicionais`);

const listaDeDestinos = new Array(
    `Salvador`,
    `São Paulo`,
    `Rio de Janeiro`,
);

const idadeComprador = 18;
const estaAcompanhado = false;
const temPassagemComprada = true;

console.log("Destinos possíveis: ");
console.log(listaDeDestinos);

// Operador lógico OR
if ((idadeComprador >= 18) || (estaAcompanhado)) {
    console.log("[Venda autorizada] Boa viagem!");
    listaDeDestinos.splice(1, 1);
} else {
    console.log("[Venda bloqueada] Comprador menor de idade.");
}

// Operador lógico AND
console.log("Embarque:");
if ((idadeComprador >= 18) || (temPassagemComprada) && (estaAcompanhado)) {
    console.log("Boa viagem!");
} else {
    console.log("Você não pode embarcar.");
}

console.log(listaDeDestinos);