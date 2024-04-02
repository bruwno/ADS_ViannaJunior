/*
Exercício 3: Criando uma lista de tarefas
Objetivo: criar uma lista de tarefas usando JavaScript e manipulação do DOM. Para pegar os valores dos inputs use a propriedade value
*/

let errosTexto = document.createElement("h1");
errosTexto.style.color = "red";
errosTexto.style.fontSize = "17px";
document.body.appendChild(errosTexto);

let tarefa = document.getElementById("new-task");
let btnAddTarefa = document.getElementById("add-task");
let listaTarefas = document.getElementById("task-list");

btnAddTarefa.addEventListener("click", () => {
    if (tarefa.value === "") {
        errosTexto.innerText = "Insira uma tarefa no campo!";
    } else {
        listaTarefas.innerText += `${tarefa.value}\n`;
        tarefa.value = "";
        errosTexto.innerText = "";
    }
});

// Limpar a lista.
let btnLimparLista = document.createElement("button");
btnLimparLista.textContent = "Limpar lista";
document.body.appendChild(btnLimparLista);

btnLimparLista.addEventListener("click", () => {
    listaTarefas.innerText = "";
    errosTexto.innerText = "";
});