let fruits = ["Maracujá", "Maçã", "Pêra", "Uva", "Laranja"];

// FILTER | Retorna todas as frutas quem o nome possuir mais de 4 letras.
longNameFruits = fruits.filter((item) => {
    return item.length > 4
});

console.log(longNameFruits);

// EVERY | Retorna true quando todos os itens do array satisfazem a condição.
let ok = fruits.every((value) => {
    return value.length > 3;
});

if (ok) {
    console.log("Todos são maiores que 3");
} else {
    console.log("Nem todos são maiores que 3");
}

// SOME | Retorna se algum item satisfaz a condição.
let someItem = fruits.some((value) => {
    return value.length > 3;
});

if (someItem) {
    console.log("Algum item é maior que 3");
} else {
    console.log("Nenhum item é maior que 3");
}

// INCLUDES | Procurar por um item específico no array.
const fruitName = "Uva";
if (fruits.includes(fruitName)) {
    console.log(`Tem ${fruitName} sim!`);
} else {
    console.log(`Não tem ${fruitName}...`);
}