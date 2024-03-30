// Ao clicar no botão + deve ser adicionado um novo grupo para adicionar um telefone
let btnAdicionarTelefone = document.querySelector(".btn-add");

btnAdicionarTelefone.addEventListener("click", event => {
    let phoneGroup = document.querySelector(".phoneGroup");
    let novoCampoTelefone = phoneGroup.cloneNode(true);
    phoneGroup.parentNode.insertBefore(novoCampoTelefone, phoneGroup.nextSibling);

});


// Ao clicar no botão Novo contato a classe btn-primary deve ser substituida por btn-success
let botaoNovoContato = document.getElementById("newContact");;

botaoNovoContato.addEventListener("click", event => {
    event.preventDefault();
    botaoNovoContato.classList.replace("btn-primary", "btn-success");
});