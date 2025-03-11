
let btnAjax = document.querySelector("#frmAjax > button");
//console.log(btnAjax);
btnAjax.addEventListener("click", (e) => {
    //e.preventDefault();
    let campos = document.querySelectorAll("#frmAjax > input");
    let url = `http://localhost:8080/v2/abastecer?cpGas=${campos[0].value}&cpAlc=${campos[1].value}`;

    fetch(url)
    .then((d) => {
        return d.text() // retorna o conteúdo de 'd' para o próximo then
    })
    .then((d) => {
        console.log(d);
        document.querySelector("#frmAjax span").innerText = d;
    })
});