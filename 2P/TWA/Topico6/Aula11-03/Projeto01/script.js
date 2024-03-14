// // Selecionar pelo nome da classe | Retorna um HTMLCollection 
// // Pega o primeiro elemento que corresponde à selação.
// let var1 = document.getElementsByClassName("small-heading");

// // Selecionar pelo seletor | Retorna um NodeList
// let var2 = document.querySelectorAll(".small-heading");

// // HTML Collection -> Não implemanta o forEach() - Isso torna o HTMLCollection mais custoso que o querySelectionAll.
// // Transformando o HTMLCollection em Array.
// let aux = Array.from(var1);

// aux.forEach(element => {
//     console.log(element);
// });

// // Implementa o forEach()
// var2.forEach(element => {
//     console.log(element);
// });

// // Selecionar todas as img de um site.
// let imgs = document.querySelectorAll("img");

// imgs.forEach(element => {
//   console.log(element);
// });

// // Selecionar o primeiro h2 do site
// let primeiroh2 = document.querySelector("h2");
// console.log(primeiroh2);

// let ultimop = document.querySelectorAll("p");
// ultimop[ultimop.length - 1];

// let ultimo = document.querySelector("p:last-of-type"); // ou ("p:last-child")
// ultimo;

// // CLASSLIST
// // Selecionando o primeiro h1 dentro de header
// let h1_header = document.querySelector("header > h1:first-child");

// let h2_header = document.querySelector("header > h2:first-of-type");

// // Retorna um DOMTokenList | São as classes do elemento
// h2_header.classList;

// // Adicionando novas classes à minha classList.
// h1_header.classList.add("small-heading");

// h1_header.classList.add("bold");

// // Adicionando a classe bgBlack à classList. | Pode ser utilizado para aplicar o modo noturno à página.
// document.body.classList.add("bgBlack");
// h1_header.classList;
// // Adiciona uma classe se ela não existir e remove se ela existir.
// document.classList.toggle("bgBlack");

// // Removendo classes da classList
// h1_header.classList.remove("small-heading");

// // Verificando se um objeto possui uma classe.
// h2_header.classList.contains("bold");

// // Alterando uma classe de um elemento.
// let artigo = document.querySelector("article");
// artigo.classList.replace("on", "off");

// Alterando a imagem via setAttribute
// let imagem = document.querySelector("img");
// console.log(imagem.attributes["height"]);

// imagem.setAttribute("src", "link-da-imagem");

// Alterando a cor do background e da fonte pelo JS
let backgroundColor = document.querySelector("article");
backgroundColor.setAttribute("style", "background-color:blue; color:yellow");

// Alterando todas as imagens de um site via JS
let imagem = document.querySelectorAll("img");

//imagem.removeAttribute("srcset");
// imagem.forEach(imagens => {
//   imagens.setAttribute("src", "https://www.galinhapintadinha.com.br/wp-content/uploads/2023/06/gpc-album-4-character-400x574.png");
// });

imagem.forEach(imgs => {
  imgs.addEventListener("click", ()=> {
    alert("Clicou!");
  });
})



