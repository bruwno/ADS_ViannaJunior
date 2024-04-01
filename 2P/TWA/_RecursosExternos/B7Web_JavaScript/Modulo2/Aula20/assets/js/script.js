let colors = [
    "preto",
    "branco",
    "azul",
    "vermelho"
];

// for comum
for (let i = 0; i < colors.length; i++) {
    console.log(`Cores ${colors[i]}`);
}

// alternativa -- Mais indicado para lidar com objetos.
for (let i in colors) {
    console.log(colors[i]);
}

// sintaxe próxima a do 'foreach'
for (let color of colors) {
    console.log(color)
}

// Percorrendo os dados de um array de objetos.
let cars = [
    { model: "Ferrari", color: colors[3] },
    { model: "Fiat Marea", color: colors[2] },
    { model: "Volwagen Fusca", color: colors[0] }
];

for (let car of cars) {
    console.log(`Modelo: ${car.model} - Cor: ${car.color}`);
}

// Alterando os nomes dos carros para caixa alta.
for (let i in cars) {
    cars[i].model = cars[i].model.toUpperCase();
}

for (let car of cars) {
    console.log(car.model);
}