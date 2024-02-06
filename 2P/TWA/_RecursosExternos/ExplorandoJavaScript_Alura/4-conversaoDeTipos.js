console.log("Conversão de Tipos");

console.log("ano " + 2020);
console.log("20" + "10");
// Conversão explícita.
console.log(parseInt("20") + parseInt("10"));

// Conversão implícita. O interpretador automaticamente tenta converter as Strings
// para number a fim de realizar a operação, o que não ocorre com operações de SOMA, 
// uma vez que o operador + possui também a função de concatentar textos.
console.log("10" / "2");