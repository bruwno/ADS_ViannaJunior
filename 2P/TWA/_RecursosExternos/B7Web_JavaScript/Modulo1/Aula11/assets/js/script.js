// Realizando operações com variáveis do tipo Number.
let x = 2;

x += 8;
console.log(x); // O resultado é uma operação matemática.

x -= 8;
console.log(x);

x *= 8;
console.log(x);

x /= 8;
console.log(x);

x %= 8;
console.log(x);

// Realizando operações com variáveis do tipo String.
let y = "2";

y += 8;
console.log(y); // O resultado é uma concatenação.

let nome = "William";
let sobrenome = "Silva";
let nomeCompleto = nome + " " + sobrenome;
console.log(nomeCompleto);

// Ordem de precedência, aplicada com o uso de parênteses.
let n1, n2, n3;
n1 = 10;
n2 = 15;
n3 = 20;

let operacao = n3 * (n1 + n2);
console.log(operacao);