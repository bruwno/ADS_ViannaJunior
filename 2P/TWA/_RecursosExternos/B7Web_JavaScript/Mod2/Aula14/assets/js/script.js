let ingredients = [
    "Agua",
    "Farinha",
    "Ovo",
    "Corante",
    "Açúcar"
];

// Adicionando um item ao Array:
// Primeira forma. Não é uma boa prática.
ingredients[5] = "Sal";

// Segunda forma. Mais correta e usual.
ingredients.push("Fermento"); // Adiciona um novo elemento no final do array.
ingredients.unshift("Sal"); // Adiciona um novo elemento ao início do array.

// Removendo um item de um array:
ingredients.pop(); // Remove o último item do array.
ingredients.shift(); // Remove o primeiro item do array.

// Dimensão do array.
console.log(`Total de ingredientes: ${ingredients.length}`);