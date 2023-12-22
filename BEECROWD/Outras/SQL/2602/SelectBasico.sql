/* Objetivo: Exibir o nome de todos os clientes cujo estado seja ‘RS’.
 * Autor   : William Silva (https://github.com/unclWill)
 * Data    : 26/09/2023
 * Tipo    : 9 (SQL)
 * ID      : 2602
 * Nome    : Select Básico
 * Link    : https://www.beecrowd.com.br/judge/pt/problems/view/2602
 */

SELECT 
    name 
FROM 
    customers 
WHERE 
    state = 'RS'