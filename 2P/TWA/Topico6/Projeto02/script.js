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

let atual = 0;

let imgs = document.querySelector('img');

imgs.setAttribute("src", imagens[atual]);

let proximo = document.getElementById('proximo');
proximo.addEventListener('click', event => {
    event.preventDefault();
    if (atual == imagens.length) {
        atual = 0;
    }
    imgs.setAttribute("src", imagens[atual++]);
});

let anterior = document.getElementById('anterior');
anterior.addEventListener('click', event => {
    event.preventDefault();
    if (atual == imagens.length) {
        atual = 0;
    }
    imgs.setAttribute("src", imagens[atual--])
})