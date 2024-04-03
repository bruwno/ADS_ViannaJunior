// Estruturas condicionais.
let idade = calcularIdade(1997);

function calcularIdade(anoNascimento) {
    let data = new Date();
    return data.getFullYear() - anoNascimento;
}

function ehMaiorDeIdade(idade) {
    // if simplificado.
    return idade >= 18;
}

function verificaIdade(idade) {
    console.log(`Idade: ${idade} anos de idade.`);
    if (ehMaiorDeIdade(idade)) {
        console.log("É maior de idade!");
    } else {
        console.log("É menor de idade!");
    }
}

verificaIdade(idade);