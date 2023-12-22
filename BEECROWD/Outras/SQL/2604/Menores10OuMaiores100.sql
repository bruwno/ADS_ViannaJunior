/* Objetivo: Exibir o id e o nome dos produtos que custam menos que 10 e mais que 100.
 * Autor   : William Silva (https://github.com/unclWill)
 * Data    : 22/12/2023
 * Tipo    : 9 (SQL)
 * ID      : 2604
 * Nome    : Menores que 10 ou Maiores que 100
 * Link    : https://www.beecrowd.com.br/judge/pt/problems/view/2604
 */

-- Script
CREATE TABLE products (id NUMERIC, name VARCHAR, amount NUMERIC, price NUMERIC);
		INSERT INTO products (id, name, amount, price) VALUES (1, 'Two-door wardrobe', 100, 80);
        INSERT INTO products (id, name, amount, price) VALUES (2, 'Dining table', 1000, 560);
        INSERT INTO products (id, name, amount, price) VALUES (3, 'Towel holder', 10000, 5.50);
        INSERT INTO products (id, name, amount, price) VALUES (4, 'Computer desk', 350, 100);
        INSERT INTO products (id, name, amount, price) VALUES (5, 'Chair', 3000, 210.64);
        INSERT INTO products (id, name, amount, price) VALUES (6, 'Sinbgle bed', 750, 99);
        
-- Solução
SELECT id, name
        FROM products
        WHERE price < 10 OR price > 100;