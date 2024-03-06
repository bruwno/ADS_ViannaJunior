// Interaja com a array utilizando um loop, para cada ano mostrar no console a seguinte mensagem: "O Brasil ganhou a copa de ANO"

var copasDoBrasil = [1958, 1962, 1970, 1994, 2002];

// Opção 1
for (var i = 0; i < copasDoBrasil.length; i++) {
    console.log(`O Brasil ganhou a copa de ${copasDoBrasil[i]}`);
}

// Opção 2
copasDoBrasil.forEach((ano) => { // Parâmetros - fn callbak, índice, vetor inteiro
    console.log(`O Brasil ganhou a copa de ${ano}`);
});