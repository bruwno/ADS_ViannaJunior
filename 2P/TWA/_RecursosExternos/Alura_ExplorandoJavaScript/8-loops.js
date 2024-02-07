console.log("\nTrabalhando com loops");

const listaDeDestinos = new Array(
    `Salvador`,
    `São Paulo`,
    `Rio de Janeiro`,
);

const idadeComprador = 18;
const estaAcompanhado = false;
let temPassagemComprada = false;
const destino = "Salvador";

console.log("\nDestinos possíveis: ");
console.log(listaDeDestinos);

const podeComprar = (idadeComprador >= 18) || (estaAcompanhado == true);

// Perorrendo o array.
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