function maiorDeIdade(idade) {
    if (idade >= 18) {
        return true;
    } else {
        return false;
    }
}

let verificaIdade = maiorDeIdade(26);

console.log(`É maior de idade: ${(verificaIdade) ? "Sim" : "Não"}`);