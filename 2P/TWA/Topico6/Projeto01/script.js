// // Seletor de elemento por Id
// let citacao = document.getElementById("quote-by-author");

// citacao.innerText = "NOVO TEXTO";
// console.log(citacao);

// // Seletor de elementos de classe
// //let cabecalhosPequenos = document.getElementsByClassName("small-heading");
// //console.log(cabecalhosPequenos);

// // Seletor de tag
// let listas = document.getElementsByTagName("ul");
// console.log(listas);

// /*
// const animais = document.querySelector('.animais');
// const contato = document.querySelector('#contato');
// const ultimoItem = document.querySelector('.animais-lista li:last-child');
// const linkCSS = document.querySelector('[href^="https://"]');
// const primeiroUl = document.querySelector('ul');

// // Busca dentro do Ul apenas
// const navItem = primeiroUl.querySelector('li');
// */

// let citacao = document.querySelector("#quote-by-author");
// console.log(citacao);

// // Retorna, apenas, o primeiro elemento que tiver a classe
// let cabecalhosPeq = document.querySelector(".small-heading");
// console.log(cabecalhosPeq);

// let lista = document.querySelector("ul");
// console.log(lista);

// // Pega todos os elementos da classe.
// let cabecalhosPequenos = document.querySelectorAll(".small-heading"); // Retorna uma NodeList
// console.log(cabecalhosPequenos);

// // Todos os <li> filhos de <ul>
// let listaLi = document.querySelectorAll("ul > li");
// console(listaLi);

// // outerText -> pega o html (tag) e o texto
// let paragrafo = document.querySelector("p");
// paragrafo.outerText = "<h1> Modificado </h1>";

// // innerText -> pega o texto apenas
// paragrafo.innerTxet = "Modificado";

// // innerHTML -> html interno
// paragrafo.innerHTML = "";

let img = document.querySelector("img");
let artigo = document.querySelector("article");
let rodape = document.querySelector("footer");

// MANIPULANDO ELEMENTOS
//artigo.appendChild(img);
//artigo.insertBefore(img, rodape);
//artigo.removeChild("rodape");
//artigo.replaceChild(img, rodape);

// NOVOS ELEMENTOS
let novaDiv = document.createElement("div");
artigo.appendChild("Nova div");
novaDiv.className = "off";
