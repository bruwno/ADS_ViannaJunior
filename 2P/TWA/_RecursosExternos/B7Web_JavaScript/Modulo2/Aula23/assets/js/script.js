let fruits = [
    "Maçã",
    "Uva",
    "Laranja",
    "Pêra"
];

// Adicionando um item ao array (push adiciona no final):
fruits.push("Tangerina");

// Remove o último item do array:
fruits.pop();

// Remove o primeiro item do array:
fruits.shift();

// Faz a junção de algum caractere específico no array, separando os seus elementos com este caractere.
let newFruits = fruits.join(', ');

console.log(newFruits);

// Alterando o item em um índice específico:
fruits[0] = "Pêra";

// Alterando o item do último elemento:
fruits[fruits.length - 1] = "Morango";
console.log(fruits);