//let form = document.querySelector("form");
// Selecionado um formulário
let form = document.forms[0];
let msgForm = document.createElement("div");
document.body.appendChild(msgForm); // Adicionando a div que exibriá as mensagens.

//O elemento pode ser manipulado utilizando a sua posição no array, o seu name ou o seu id.
form.addEventListener("submit", event => {
    event.preventDefault();
    let texto = form.elements["texto"];
    let numero = form.elements["numero"];
    console.log(texto.value, numero.value);
    msgForm.innerHTML = "";
    let erros = 0;

    if (numero.value < 100) {
        erros++;
        msgForm.innerHTML += "<p>O número deve ser maior que 100!</p>"
    }

    if (texto.value == "") {
        erros++;
        msgForm.innerHTML += "<p>O campo texto deve ser preenchido!</p>";
    }

    if (erros == 0) {
        form.submit();
    }

});

