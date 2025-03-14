/* Objetivo: Exibir o nome de todos os clientes cujo estado seja ‘RS’.
 * Autor   : William Silva (https://github.com/bruwno)
 * Data    : 26/09/2023
 * Tipo    : 9 (SQL)
 * ID      : 2602
 * Nome    : Select Básico
 * Link    : https://www.beecrowd.com.br/judge/pt/problems/view/2602
 *
 * Plataforma utilizada para montar a solução: https://coderpad.io/languages/postgresql/
 */

SELECT name 
    FROM customers 
    WHERE state = 'RS';