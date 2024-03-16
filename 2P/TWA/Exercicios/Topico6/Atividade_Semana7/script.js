/*
EXERCÍCIO: Crie um documento html que tenha um título h1 e três parágrafos, coloque a classe texto-regular no body do documento.

1) Crie dois botões: Aumentar texto e Diminuir texto
2) Ao clicar nos botões as classes devem ser aplicadas ao body de acordo com a seguinte lógica:
2.1) Botão aumentar: Se o texto estiver pequeno vai para regular e se o texto estiver regular vai para grande.
2.2) Botão diminuir: Se o texto estiver grande vai para regular e se o texto estiver regular vai para pequeno.
*/


let body = document.querySelector('body');
let btnAumentarTexto = document.getElementById('btnAumentarTexto');
let btnDiminuirText = document.getElementById('btnDiminuirTexto');

function aumentarTexto() {
    if (body.classList.contains('texto-pequeno')) {
        body.classList.replace('texto-pequeno', 'texto-regular');
    } else if (body.classList.contains('texto-regular')) {
        body.classList.replace('texto-regular', 'texto-grande');
    } else if (body.classList.contains('texto-grande')) {
        body.classList.replace('texto-grande', 'texto-regular');
    }
};

function diminuirTexto() {
    if (body.classList.contains('texto-regular')) {
        body.classList.replace('texto-regular', 'texto-pequeno');
    } else if (body.classList.contains('texto-pequeno')) {
        body.classList.replace('texto-pequeno', 'texto-regular');
    } else if (body.classList.contains('texto-grande')) {
        body.classList.replace('texto-grande', 'texto-regular');
    }
};

btnAumentarTexto.addEventListener('click', aumentarTexto);
btnDiminuirText.addEventListener('click', diminuirTexto);
