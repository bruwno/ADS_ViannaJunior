// Exibindo o conteúdo de variáveis dentro de uma String.
let nome = "William";
let sobrenome = "Silva";

exibirNome(nome, sobrenome);

function exibirNome(nome, sobrenome) {
    let nomeCompleto = `${nome} ${sobrenome}`;
    console.log(`Nome: ${nomeCompleto}`);
}

// Operação matemática dentro de uma String.
let idade = 26;
let idadeString = `${idade + 2}`;
console.log(`Idade: ${idadeString} anos de idade.`);