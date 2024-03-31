// ELSE-IF
let idade = 26;

function verificaFaixaEtaria(idade) {
    if (idade < 0 || idade > 120) {
        console.log("Idade inválida!");
    } else {
        if (idade >= 0 && idade <= 11) {
            console.log("Você é uma criança.");
        } else if (idade >= 12 && idade <= 18) {
            console.log("Você é um adolescente.");
        } else if (idade >= 18 && idade < 60) {
            console.log("Você é um adulto.");
        } else if (idade >= 60) {
            console.log("Você é um idoso.");
        }
    }
}

verificaFaixaEtaria(idade);