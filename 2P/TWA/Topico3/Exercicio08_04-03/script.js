var copasDoBrasil = [1958, 1962, 1970, 1994, 2002];

for (var i = 0; i < copasDoBrasil.length; i++) {
    console.log(`O Brasil ganhou a copa no ANO ${copasDoBrasil[i]}`);
}

//
copasDoBrasil.forEach((ano) => { // Parâmetros - fn callbak, índice, vetor inteiro
        console.log(`O Brasil ganhou a copa no ano de ${ano}`);
});