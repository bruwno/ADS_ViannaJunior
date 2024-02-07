/* Objetivo: Converter uma entrada de tempo em segundos para horas, minutos e segundos.
 * Autor   : William Silva (https://github.com/unclWill)
 * Data    : 07/02/2024
 * Tipo    : 1 (INICIANTE)
 * ID      : 1019
 * Nome    : Conversão de Tempo
 * Link    : https://www.beecrowd.com.br/judge/pt/problems/view/1019
 */

const input = require('fs').readFileSync('/dev/stdin', 'utf8').trim();

const tempoEmSegundos = parseInt(input);

converterTempo(tempoEmSegundos);

function converterTempo(tempoEmSegundos) {
    const horas = Math.floor(tempoEmSegundos / 3600);
    const tempoRestante = tempoEmSegundos % 3600;
    const minutos = Math.floor(tempoRestante / 60);
    const segundos = tempoRestante % 60;
    console.log(`${horas}:${minutos}:${segundos}`);
}
