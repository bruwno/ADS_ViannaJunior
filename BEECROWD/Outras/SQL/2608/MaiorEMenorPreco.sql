/* Objetivo: Exibir o maior e o menor preço dos produtos da trabela.
 * Autor   : William Silva (https://github.com/bruwno)
 * Data    : 23/12/2023
 * Tipo    : 9 (SQL)
 * ID      : 2608
 * Nome    : Maior e Menor Preço
 * Link    : https://www.beecrowd.com.br/judge/pt/problems/view/2608
 *
 * Plataforma utilizada para montar a solução: https://coderpad.io/languages/postgresql/
 */

 -- Script da tabela
CREATE TABLE products (id NUMERIC PRIMARY KEY, name VARCHAR, amount NUMERIC, price NUMERIC);
    INSERT INTO products (id, name, amount, price) VALUES (1, 'Two-doors wardrobe', 100, 800);
    INSERT INTO products (id, name, amount, price) VALUES (2, 'Dining table', 1000, 560);
    INSERT INTO products (id, name, amount, price) VALUES (3, 'Towel holder', 10000, 25.50);
    INSERT INTO products (id, name, amount, price) VALUES (4, 'Computer desk', 350, 320.50);
    INSERT INTO products (id, name, amount, price) VALUES (5, 'Chair', 3000, 210.64);
    INSERT INTO products (id, name, amount, price) VALUES (6, 'Single bed', 750, 460);

-- Solução
SELECT MAX(price) AS price, 
       MIN(price) AS price
    FROM products;