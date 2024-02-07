console.log("Atribuição de Variáveis");

const idade = 26;
let primeiroNome = "William";
const sobrenome = "Silva";

// Concatenação de Strings com espaço adicionado na mão.
console.log(primeiroNome + " " + sobrenome);

// Concatenção com o espaço adicionado automaticamente pelo interpretador.
console.log(primeiroNome, sobrenome);

// Interpolação de Strings.
console.log(`Meu nome é ${primeiroNome} ${sobrenome}`);

// Sobrescrita de variáveis.
/* A sobrescrita só é possível porque na decalaração da variável nome
 * foi utilizada a a palavra-chave let, que permite que o valor da variável 
 * seja alterado em tempo de execução.
 */
primeiroNome = primeiroNome + " " + sobrenome;

/* Não é uma boa prática permitir esta mutabilidade do código, o mais interessante é sempre que possível,
 * utilizar o const em detrimento do let, na declaração de variáveis.
 */
const nomeCompleto = primeiroNome + " " + sobrenome;
console.log(nomeCompleto);

// Um contador é um exemplo comum de uso do let.
let contador = 0;
contador++;
console.log(contador);