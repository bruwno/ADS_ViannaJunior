// Selecionando elementos.

// Selecionando pela tag (MENOS EFICIENTE):
let div = document.getElementsByTagName("div");

// Selecionando pelo id
let div2 = document.getElementById("div");

// Selecionando pela classe (CSS)
let botao = document.getElementsByClassName("btn");

// Selecionando pela query
let div3 = document.querySelector("#teste"); // Seleção usando o id.
let button2 = document.querySelector(".btn"); // Seleção pela classe.
let button3 = document.querySelector("h1"); // Seleção pelo nome da tag.

// Selecionando a lista (todos os elementos <li>):
let list = document.querySelectorAll("li"); // Retorna uma NodeList.

// Selecionando um <li> específico:
let listItem = document.querySelectorAll("#teste ul li"); // Usando os seletores CSS.