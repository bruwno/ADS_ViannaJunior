// Tipos de dados.
// Tipo STRING
var variavel= "Texto";
variavel = 8;
variavel = 2.7;
variavel = 2e6;
variavel = true;
variavel = "Huguinho";
console.log(typeof variavel);

// Concatenação.
var pontos = 10;
var frase = 'O aluno fez ' + pontos + ' pontos';
console.log(frase);

var pontos = 10;
var pontos2 = "12";
var resultado = pontos + pontos2;
console.log(resultado);

// Caractere de Escape.
var aspas = "Este é o \n texto";
var aspas = "Este é o \"texto\"";

// Template String.
var pontos = 10;
var jogador = "Dili";
// POSSIBILIDADE 1: var resultado =jogador + " fez:\n" + pontos + " \"pontos\"" ;
// POSSIBILIDADE 2:
var resultado = `${jogador} fez:\n ${pontos} "pontos"` ;
console.log(resultado);

// Tipo NUMBER
var number = 12;
var numero3 = 12.0;
var numero3 = 3e-2; /* 3x 10² */
console.log(numero3);

// Operadores
var soma = 2 + 4;
var sub = 2 - 4;
var mult = 2 * 4;
var div = 2 / 4;
var expoente = 2 ** 4;
var mod = 2 % 4;

// Verificar se uma variável é número.
var numero = "15F"
console.log(isNaN(numero));


