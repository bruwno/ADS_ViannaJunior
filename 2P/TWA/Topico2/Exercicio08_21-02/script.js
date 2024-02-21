// Atribua true para a variável darCredito, caso o cliente possua carro e casa e false caso o contrário.
var possuiCarro = true;
var possuiCasa = true;
var darCredito = (possuiCarro && possuiCasa) ? true : false;
console.log(`Conceder crédito: ${darCredito}`);
