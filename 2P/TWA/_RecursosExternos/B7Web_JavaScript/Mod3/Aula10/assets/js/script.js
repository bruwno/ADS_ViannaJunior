// Manipulando elementos
// Os elementos possuem atributos, outros elementos sendo seus filhos, etc.

// Selecionando o elemento:
let button = document.querySelector(".btn");

// Monitorando o evento do botão:
button.addEventListener("click", () => {
    clicked();
});

// Listando a quantidade de classes associadas a um elemento:
function clicked() {
    const btn = document.querySelector("button");

    // Adicionando uma classe ao elemenro:
    btn.classList.add("verde");

    // Removendo um classe do elemento:
    btn.classList.remove("verde");

    // Verificando de um elemento contém uma classe específica:
    if (btn.classList.contains("verde")) {
        console.log("O elemento contém a classe VERDE");
        // Trocar entre classes:
        btn.classList.replace("azul", "verde");
    } else {
        console.log("O elemento não contém a classe VERDE");
        btn.classList.replace("verde", "azul");
    }

    // O toogle simplifica a ação de adicionar e remover classes:
    btn.classList.toggle("verde");

    console.log(btn.classList); // Exindo as classes.
}
