let nome = "William";
let anoNascimento = 1997;

function calculaIdade(anoNascimento) {
    const data = new Date();
    return data.getFullYear() - anoNascimento;
}

function exibeIdade(anoNascimento) {
    return `${nome} tem ${calculaIdade(anoNascimento)} anos de idade.`;
}

let form = document.forms[0];

let mostraIdade = document.createElement("h2");
document.body.appendChild(mostraIdade);

form.addEventListener("submit", event => {
    event.preventDefault();
    let anoNascimento = form.elements["anoNascimento"].value;

    if (anoNascimento <= 0) {
        alert("Digite um ano válido!");
    } else {
        mostraIdade.innerText = exibeIdade(anoNascimento);
    }
});
