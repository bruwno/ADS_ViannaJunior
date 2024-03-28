let imagens = [
    "img/1.png",
    "img/2.png",
    "img/6.png",
    "img/7.png",
    "img/9.png",
    "img/10.png",
    "img/12.png",
    "img/15.png",
    "img/17.png",
    "img/500.png",
];

let nomes = [
    "Bulbasaur",
    "Ivysaur",
    "Charizard",
    "Squirtle",
    "Blastoise",
    "Caterpie",
    "Butterfree",
    "Beedrill",
    "Pidgeotto",
    "Emboar"
];


let atual = 0;
let grupo = document.querySelector("div");

let nomePokemon = document.createElement("div");
grupo.appendChild(nomePokemon);
nomePokemon.innerText = nomes[atual];

let imgs = document.querySelector('img');

imgs.setAttribute("src", imagens[atual]);
// Inserindo o nome abaixo da imagem.
//let nome = document.getElementById("nome");

let proximo = document.getElementById('proximo');
proximo.addEventListener('click', event => {
    event.preventDefault();
    if (atual == imagens.length) {
        atual = 0;
    }
    nomePokemon.innerText = nomes[atual];
    imgs.setAttribute("src", imagens[atual++]);
});

let anterior = document.getElementById('anterior');
anterior.addEventListener('click', event => {
     event.preventDefault();
     if (atual <= 0) {
         atual = imagens.length;
     }
     nomePokemon.innerText = nomes[atual-1];
     imgs.setAttribute("src", imagens[--atual])
})