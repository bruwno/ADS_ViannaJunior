// A posição clicada deve ser marcada com O ou X. As posições marcadas não podem ser sobrescritas.

let grade = document.querySelectorAll("td");
let jogada = 1;
let pos = 0;

grade.forEach(posicao => {
    posicao.setAttribute("posicao", pos++);

    posicao.addEventListener("click", event => {
        if (event.target.innerText == "") {
            if (jogada % 2 == 1) {
                event.target.innerText = "O";
            } else {
                event.target.innerText = "X";
            }
            jogada++;
        } else {
            alert("Jogada inválida!");
        }
    });   
});

