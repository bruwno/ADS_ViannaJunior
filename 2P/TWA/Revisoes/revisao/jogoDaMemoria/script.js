/*
 Exercício 4: Criando um jogo de memória
 Objetivo: criar um jogo de memória usando JavaScript e manipulação do DOM.
 */

let cards = document.querySelectorAll(".card");
let cartasViradas = [];
let cartasPares = [];

let btnReiniciarJogo = document.createElement("button");
btnReiniciarJogo.textContent = "Reiniciar jogo";

cards.forEach(card =>
    card.addEventListener('click', function () {
        virarCarta(card);
    })
);

function virarCarta(card) {
    if (cartasViradas.length < 2 && !cartasViradas.includes(card) && !cartasPares.includes(card)) {
        card.classList.add('flip');
        cartasViradas.push(card);
        if (cartasViradas.length === 2) {
            verificarCombinacao();
        }
    }
}

function verificarCombinacao() {
    const [card1, card2] = cartasViradas;
    if (card1.dataset.card === card2.dataset.card) {
        card1.removeEventListener('click', virarCarta);
        card2.removeEventListener('click', virarCarta);
        cartasPares.push(card1, card2);
        if (cartasPares.length === cards.length) {
            alert('Parabéns! Você ganhou o jogo!');
            reiniciarJogo();
        }
    } else {
        cartasViradas.forEach(card => card.classList.remove('flip'));
    }
    cartasViradas = [];
}

function reiniciarJogo() {
    document.body.appendChild(btnReiniciarJogo);

    btnReiniciarJogo.addEventListener("click", () => {
        cards.forEach(card => {
            card.classList.remove('flip');
            card.addEventListener('click', function () {
                virarCarta(card);
            });
        });
        cartasViradas = [];
        cartasPares = [];
        btnReiniciarJogo.remove();
    });
}
