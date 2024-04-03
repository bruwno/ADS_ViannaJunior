let fruits = ["Maçã", "Pêra", "Uva", "Laranja"];

fruits.sort(); // Ordena de forma alfabética.
fruits.reverse(); // Exibe o array ordenado de trás pra frente. Inverte a ordem dos itens.

console.log(fruits);


// Ordenando uma lista de objetos.
let cars = [
    { brand: "Fiat", year: 2022 },
    { brand: "BMW", year: 2018 },
    { brand: "Ferrai", year: 2024 },
    { brand: "Volvo", year: 2016 }
];

// Ordenando o array a partir de uma função personalizada, esta função recebe o ano do carro
// e compara se é maior, menor ou igual ao ano de algum outro objeto, dependendo do resultado
// do teste a função sort() avança o índice do item, retrocede ou transforma em 0.
let orderedCars = cars.sort((a, b) => {
    if (a.year > b.year) {
        return 1;
    } else if (a.year < b.year) {
        return -1;
    } else {
        return 0;
    }
});

// Simplificação da função anterior.
cars.sort((a, b) => {
    return a.year - b.year;
});

console.log(orderedCars);