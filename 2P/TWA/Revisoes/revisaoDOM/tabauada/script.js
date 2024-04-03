let lista = document.querySelectorAll("li");
let resposta = document.querySelector(".resposta");


lista.forEach(num => {
    num.addEventListener("click", () => {
        let tabuada = "";
        for (let i = 1; i <= 10; i++) {
            tabuada += `${num.innerText} x ${i} = ${num.innerText * i}<br>`;
        }
        resposta.innerHTML = `<h1>Tabuada</h1>${tabuada}`;
    });
});