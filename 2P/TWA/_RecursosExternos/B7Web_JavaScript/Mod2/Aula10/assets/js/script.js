// Arrow function -> é um forma diferente de definir uma função.
const somar = (x, y) => {
    let resultado = x + y;
    return resultado;
}

// Ou
const multiplicar = (x, y) => x * y;

// Ou (Função com um único parâmetro)
const sobrenome = sobrenome => `William ${sobrenome}`;

console.log(somar(5, 10));
console.log(multiplicar(5, 10));
console.log(sobrenome("Silva"));