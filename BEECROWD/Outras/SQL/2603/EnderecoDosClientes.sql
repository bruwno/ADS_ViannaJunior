/* Objetivo: Exibir os nomes e os endereços dos clientes que moram em 'Porto Alegre'.
 * Autor   : William Silva (https://github.com/unclWill)
 * Data    : 26/09/2023
 * Tipo    : 9 (SQL)
 * ID      : 2603
 * Nome    : Endereço dos Clientes
 * Link    : https://www.beecrowd.com.br/judge/pt/problems/view/2603
 */

SELECT 
    name,street
FROM
    customers
WHERE
    city = 'Porto Alegre'