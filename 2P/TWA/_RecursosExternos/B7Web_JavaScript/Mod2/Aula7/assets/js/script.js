/*
 Calcule a porcentagem entre 2 números.
 Exemplo: 25% de 40% é 10
 Fórmula da porcentagem: (a / b) * 100;
 Uso da função:

 let a = 40;
 let b = 10;

 let pct = calcPct(a, b);
 console.log(`${a}% de ${a} é ${pct}`);
 */

function calculaPorcentagem(a, b) {
    return (b / a) * 100;
}

let a = 40;
let b = 10;

let pct = calculaPorcentagem(a, b);

console.log(`${pct}% de ${a} é ${b}`);