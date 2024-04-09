let grade = document.querySelectorAll("td");
let jogada = sortearJogador();
let pos = 0;
let tabuleiro = [
    0,0,0,
    0,0,0,
    0,0,0
];
let jogador = "";
let partidaFinalizada = false;

grade.forEach(posicao => {
    posicao.setAttribute("posicao", pos++);

    posicao.addEventListener("click", event => {

        
        if (!partidaFinalizada && event.target.innerText == "") {
            if (jogada % 2 == 1) {
                event.target.innerText = "O";
                jogador = "O";
            } else {
                event.target.innerText = "X";
                jogador = "X";
            }
            jogada++;

            verificarEstadoDaGrade(grade, jogador);

        } else if (partidaFinalizada) {
            alert("A partida terminou, não são permitidas mais jogadas. Clique em Jogar novamente!");
        } else {
            alert("Jogada inválida!");
        }
    });
});

function verificarEstadoDaGrade(grade, jogador) {
    if (verificaDiagonalPrincipal(grade) || verificaDiagonalSecundaria(grade) || verificaHorizontal(grade) || verificarVertical(grade)) {
        alert(`[Fim de jogo] Vitória do jogador ${jogador}!`);
        partidaFinalizada = true;
        reiniciarPartida(grade);
    } else if (verificarEmpate(grade)) {
        alert("[Deu velha] Empate!");
        partidaFinalizada = true;
        reiniciarPartida(grade);
    }
}

function capturarSimbolos(grade) {
    let simbolos = [];
    grade.forEach(posicao => {
        simbolos.push(posicao.innerText);
    });
    return simbolos;
}

function verificaDiagonalPrincipal(grade) {
    let simbolo = capturarSimbolos(grade);
    if (simbolo[0] !== "" && simbolo[0] === simbolo[4] && simbolo[4] === simbolo[8]) {
        return true;
    }
    return false;
}

function verificaDiagonalSecundaria(grade) {
    let simbolo = capturarSimbolos(grade);
    if (simbolo[2] !== "" && simbolo[2] === simbolo[4] && simbolo[4] === simbolo[6]) {
        return true;
    }
    return false;
}

function verificaHorizontal(grade) {
    let simbolo = capturarSimbolos(grade);
    for (i = 0; i < simbolo.length; i += 3) {
        if (simbolo[i] !== "" && simbolo[i] === simbolo[i + 1] && simbolo[i + 1] === simbolo[i + 2]) {
            return true;
        }
    }
    return false;
}

function verificarVertical(grade) {
    let simbolo = capturarSimbolos(grade);
    for (i = 0; i < 3; i++) {
        if (simbolo[i] !== "" && simbolo[i] === simbolo[i + 3] && simbolo[i + 3] === simbolo[i + 6]) {
            return true;
        }
    }
    return false;
}

function verificarEmpate(grade) {
    let simbolo = capturarSimbolos(grade);
    let contaCasasVazias = 0;
    for (i = 0; i < grade.length; i++) {
        if (simbolo[i] === "") {
            contaCasasVazias++;
        }
    }
    if (contaCasasVazias == 0) {
        return true;
    } else {
        return false;
    }
}

function reiniciarPartida(grade) {
    let botaoReiniciar = document.createElement("button");
    botaoReiniciar.textContent = "Jogar novamente!";
    botaoReiniciar.id = "btn-reiniciar";

    botaoReiniciar.addEventListener("click", function () {
        limparGrade(grade);
        document.body.removeChild(botaoReiniciar);
        partidaFinalizada = false;
        jogada = sortearJogador();
        alternarTextoPrimeiroAJogar();
    });

    document.body.appendChild(botaoReiniciar);
}

function limparGrade(grade) {
    grade.forEach(posicao => {
        posicao.innerText = "";
    });
}

function sortearJogador() {
    return Math.floor(Math.random() * 2);
}

function alternarTextoPrimeiroAJogar() {
    let primeiroAJogar = document.querySelector("p");
    if (jogada % 2 == 1) {
        primeiroAJogar.innerHTML = "<p>Primeiro a jogar: O</p>";
    } else {
        primeiroAJogar.innerHTML = "<p>Primeiro a jogar: X</p>";
    }
}