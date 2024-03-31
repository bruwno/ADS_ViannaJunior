let isMember = true;

let shipping = (isMember) ? 2.0 : 10.0;

console.log((isMember) ? "Você é membro" : "Você naõ é membro");
console.log(`Valor do frete: R$ ${shipping}`);