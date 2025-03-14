/* Objetivo: Converter uma entrada de idade em dias para anos, meses e dias.
 * Autor   : William Silva (https://github.com/bruwno)
 * Data    : 07/02/2024
 * Tipo    : 1 (INICIANTE)
 * ID      : 1020
 * Nome    : Idade em Dias
 * Link    : https://www.beecrowd.com.br/judge/pt/problems/view/1020
 */

const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

rl.question('', (idadeEmDias) => {
    converterIdade(parseInt(idadeEmDias));
    rl.close();
});

function converterIdade(idadeEmDias) {
    const anos = Math.floor(idadeEmDias / 365);
    const diasRestantes = idadeEmDias % 365;
    const meses = Math.floor(diasRestantes / 30);
    const dias = diasRestantes % 30;
    console.log(`${anos} ano(s)\n${meses} mes(es)\n${dias} dia(s)`);
}

