let colors = ["Azul", "Verde", "Vermelho"];
// Percorrendo array com for.
for (i = 0; i < colors.length; i++) {
    console.log(colors[i]);
}

let ages = [10, 20, 30];
// Percorrendo array com forEach.
ages.forEach(age => {
    console.log(age);
})


let list = ["Teste", 50, "Capitão Blah!", true];
list.forEach(item => {
    console.log(item);
});

// Array armazenando array.
let names = ["William", "Maria", "Barnabé"];

let namesList = [
    "João", // Faz parte do primeiro array.
    ["Maria", "José"] // Faz parte do segundo array (contido no array principal).
];

let segundoItem = namesList[1][0]; // Array -> [1] Posição -> [0] === Maria.

console.log(segundoItem); // Acessando a matriz.

