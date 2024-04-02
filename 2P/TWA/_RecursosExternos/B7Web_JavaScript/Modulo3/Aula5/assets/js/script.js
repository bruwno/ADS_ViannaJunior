// Manipulando elementos
// Os elementos possuem atributos, outros elementos sendo seus filhos, etc.

// Selecionando o elemento:
let button = document.querySelector(".btn");

function clicado() {
    const primeiraDiv = document.querySelector("#primeiraDiv");
    console.log(primeiraDiv.children[0].children); // Retorna os filhos imediatos do elemento.
    // Os childrens (filhos) são elementos que estão dentro de outros.

    // Selecionando a ul e exibindo os elementos que são estão contidos na nele. 
    const ul = primeiraDiv.querySelector("ul");
    console.log(ul);
}

// Monitorando o evento de clique do botão:
button.addEventListener("click", () => {
    clicado();
    click();
    anotherClick();
});

function click() {
    const primeiraDiv = document.querySelector("#primeiraDiv");
    const ul = primeiraDiv.querySelector("ul");
    //ul.innerHTML = ""; // Retorna o conteúdo do elemento.
    // Modificando elementos pelo JS via innerText:
    ul.innerHTML += "<li>Item alterado</li>";
    // Alterando itens pela sua posição:
    ul.children[0].innerHTML = "Item alterado com sucesso!"
    // Alterando apenas o texto do elemento:
    ul.children[1].innerText = "Outro item <strong>alterado</strong>"; // Não interpreta a tags.
}

function anotherClick() {
    const segundaDiv = document.querySelector("#segundaDiv");
    const ul = segundaDiv.querySelector("ul");
    // Pega o HTML da parte 'externa' do código:
    console.log(ul.outerHTML); // Exibe tanto o elemento pai quanto os filhos.
    ul.outerHTML = "<strong>Alterado!</strong>"
}