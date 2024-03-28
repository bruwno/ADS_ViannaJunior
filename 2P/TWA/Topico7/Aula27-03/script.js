// Selecionado um formulário:
//let form = document.querySelector("form"); --> Pode ser assim, mas o mais correto é assim:
let form = document.forms[0];

let errorMessage = document.createElement("div");
document.body.appendChild(errorMessage); // Adicionando a div que irá exibir as mensagens.

//O elemento pode ser manipulado utilizando a sua posição no array, o seu atributo name ou o seu id.
form.addEventListener("submit", event => {
    event.preventDefault();
    let texto = form.elements["texto"];
    let numero = form.elements["numero"];
    console.log(texto.value, numero.value);
    errorMessage.innerHTML = "";
    let erros = 0;

    if (texto.value == "") {
        erros++;
        errorMessage.innerHTML += "<p>O campo texto deve ser preenchido!</p>";
    }

    if (numero.value < 100) {
        erros++;
        errorMessage.innerHTML += "<p>O número deve ser maior que 100!</p>"
    }

    if (erros == 0) {
        form.submit();
    }
});

document.addEventListener("DOMContentLoaded", function () {
    let nomeParagraph = document.getElementById("nome");
    let numParagraph = document.getElementById("numero");

    let tdElements = document.querySelectorAll("td");

    tdElements.forEach(td => {
        td.addEventListener("click", event => {
            window.alert("CLICADO!");
            let tdText = event.target.textContent.trim();
            if (event.target.id === "nome_td") {
                nomeParagraph.textContent += tdText;
            } else if (event.target.id === "numero_td") {
                numParagraph.textContent += tdText;
            }
        });
    });
});


