// Objetos -> estrutura que armazena dados relacionados de um mesmo item/objeto.
// Muito parecido com um dicionário. Chave, Valor.

// Propriedade (Chave): Dado (Valor)
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

console.log(`${character.name} tem ${character.age} anos de idade.`);

// Podemos criar objetos dentro de outros objetos.
console.log(`Magia: ${character.characteristics.magicka}`);

// Podemos criar arrays dentro de objetos.
console.log(`Cor dos olhos | Olho direito: ${character.eyes[0]} - Olho esquerdo: ${character.eyes[1]}`);