/* 
O objetivo deste teste é criar um jogo da memória simples. Utilizando Letras.
Para isto utilize Javascript para desenvolver o que se pede.

Ao final envie comente o arquivo .js, então todas as respostas devem estar neste arquivo e o html e o css não devem ser alterados.

O jogo terá 5 letras: A, B, C, D, E. 

As letras serão repetidas 2 vezes no jogo, totalizando 10 cartas.

O jogador deverá clicar em duas cartas, se as cartas forem iguais, elas devem ser mantidas viradas (Seu valor aparecerá na tela). Se forem diferentes, as cartas devem ser viradas novamente (Aparecerá um X no lugar da carta).

- Questao 1: Crie um array com as letras do jogo. (0.2pts)

Crie um array com as cartas a serem jogadas, utilize letra maiuscula. O array deverá ter 10 cartas, sendo 2 de cada letra.

- Questao 2: Virada das cartas (0.4pts)

Selecione todas as cartas e adicione um evento de clique em cada carta. 
Ao clicar na carta, a carta deve ser "virada" e mostrado o seu valor.
Utilize o atributo posicao para identicar a carta clicada no array de cartas.

- Questao 3: Verificação de cartas (0.5pts)

Verifique se as duas cartas clicadas são iguais.
Se as cartas forem iguais, elas devem ser mantidas viradas.
Se as cartas forem diferentes, as cartas devem ser viradas novamente (O valor X deve ser exibido). 
Lembre que você pode usar variáveis para armazenar a carta clicada anteriormente.

- Questao 4: Aplique a classe referente a cada carta (0.4pts)

Ao virar a carta adicione a classe css correspondente a carta clicada (ex: A).
Ao desvirar a carta ela deve voltar ter somente a sua classe original (card).


- Questão extra: (0.5pts)

Aplique a função setTimeout para caso o par não seja igual que as cartas sejam desviradas somente após 1 segundo.

O método setTimeout permite executar um código após um tempo estipulado, que pode ser definido em milissegundos. O método executará o código apenas uma vez.

setTimeout(function, milliseconds);

O primeiro parâmetro é a função que será executada e o segundo é o tempo em milissegundos, lembrando que 1s é igual a 1000ms.
*/

let cartas = document.querySelectorAll(".card");
let letras = ["A", "B", "C", "D", "E", "A", "B", "C", "D", "E"];
let cartasClicadas = [];
let posicao = 0;
let paresDeCartas = 0;
let travarClique = false;

cartas.forEach(carta => {
    carta.setAttribute("posicao", posicao++);

    carta.addEventListener("click", event => {
        let clicada = event.target;
        posicao = parseInt(clicada.getAttribute("posicao"));
        cartasClicadas.push(clicada);

        if (travarClique) {
            return;
        }

        virarCartas(clicada, posicao);

        if (cartasClicadas.length == 2) {
            travarClique = true;
            verificarCartas(clicada);
        }
        verificarVitoria();
    });
});

function virarCartas(clicada, posicao) {
    if (!clicada.classList.contains(letras[posicao])) {
        clicada.classList.toggle(letras[posicao]);
        clicada.innerText = letras[posicao];
    }
}

function desvirarCartas(carta1, carta2) {
    for (let letra of letras) {
        carta1.classList.remove(letra);
        carta2.classList.remove(letra);
    }
    carta1.classList.add("card");
    carta2.classList.add("card");
    carta1.innerText = "X";
    carta2.innerText = "X";
}

function verificarCartas() {
    let carta1 = cartasClicadas[0];
    let carta2 = cartasClicadas[1];

    if (carta2.innerText !== "X" && carta1.innerText === carta2.innerText) {
        cartasClicadas = [];
        paresDeCartas++;
        travarClique = false;
    } else if (carta2.innerText !== "X" && carta1.innerText !== carta2.innerText) {
        travarClique = true;
        setTimeout(function () {
            desvirarCartas(carta1, carta2);
        }, 1000)
        cartasClicadas.pop();
        cartasClicadas.shift();
        travarClique = false;
    }
}

function verificarVitoria() {
    if (paresDeCartas === 5) {
        alert("Fim de jogo!");
    }
}