// 1. No array abaixo, qual o número que pega a Ferrari?
let carros = ["BMW", "Ferrari", "Mercedes-Benz"];
let x = 1;
console.log(carros[x]);

// 2. Troque a Ferrari por Audi.
carros[1] = "Audi";
console.log(carros);

// 3. Adicione Volvo à lista.
carros.push("Volvo");
console.log(carros);

// 4. Exiba quantos itens existem no array.
console.log(`O array carros possui: ${carros.length} itens`);