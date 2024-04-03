// É possível alterar popriedades de objetos apenas utilizando o seletor . (ponto).

let character = {
    name: "Hermes",
    age: 60,
    eyes: ["Preto", "Azul"],
    country: "Brasil",
    characteristics: {
        strength: 7,
        magicka: 5,
        stamina: 6
    }
}

character.name = "Renato";
character.characteristics.strength += 5;
character.eyes.push("Verde"); // Adicionando um novo valor no array dentro do objeto.

console.log(character);

// Array de objetos dentro de um objeto.
let character2 = {
    name: "Away",
    age: 60,
    cars: [
        { model: "Fiat 147", color: "Preto" },
        { model: "Ferrari F40", color: "Vermelha" }
    ]
}

console.log(character2);
let carColor = character2.cars[1].color; // Acessando a propriedade COLOR no array CARS dentro do objeto.
console.log(carColor);