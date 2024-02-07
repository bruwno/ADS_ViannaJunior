console.log("\nTrabalhando com loops");

const listaDeDestinos = new Array(
    `Salvador`,
    `São Paulo`,
    `Rio de Janeiro`,
);

const idadeComprador = 17;
const estaAcompanhado = false;
let temPassagemComprada = false;
const destino = "Salvador";

console.log("\nDestinos possíveis: ");
console.log(listaDeDestinos);

const podeComprar = (idadeComprador >= 18) || (estaAcompanhado == true);

// Percorrendo o array com while.
let destinoExiste = false;
let contador = 0;
while (contador < 3) {
    if (listaDeDestinos[contador] == destino) {
        destinoExiste = true;
        break;
    }
    contador++;
}

console.log(`Destino existe: ${destinoExiste}`);

if (podeComprar && destinoExiste) {
    console.log("Boa viagem!");
} else {
    console.log("Não foi possível concluir a compra.");
}

// Percorrendo o array com for.
for (let i = 0; i < 3; i++) {
    if (listaDeDestinos[i] == destino) {
        destinoExiste = true;
    }
}