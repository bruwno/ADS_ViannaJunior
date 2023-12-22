/* Objetivo: Exibir a mensagem Hello World! na tela.
 * Autor   : William Silva (https://github.com/unclWill)
 * Data    : 18/12/2023
 * Tipo    : 1 (INICIANTE)
 * ID      : 1000
 * Nome    : Hello World
 * Link    : https://www.beecrowd.com.br/judge/pt/problems/view/1000
 */

// Para Windows.
//var lines = require('fs').readFileSync(process.stdin.fd, 'utf8').split('\n');

var input = require('fs').readFileSync('/dev/stdin', 'utf8');
var lines = input.split('\n');

console.log("Hello World!");