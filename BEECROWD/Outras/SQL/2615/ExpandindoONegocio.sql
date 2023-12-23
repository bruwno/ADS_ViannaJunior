/* Objetivo: Exibir todas as cidades onde a locadora tem clientes, sem reptir os nomes.
 * Autor   : William Silva (https://github.com/unclWill)
 * Data    : 23/12/2023
 * Tipo    : 9 (SQL)
 * ID      : 2615
 * Nome    : Expandindo o Negócio
 * Link    : https://www.beecrowd.com.br/judge/pt/problems/view/2615
 *
 * Plataforma utilizada para montar a solução: https://coderpad.io/languages/postgresql/
 */

 -- Script da tabela
CREATE TABLE customers (id NUMERIC PRIMARY KEY, name VARCHAR, street VARCHAR, city VARCHAR);
      INSERT INTO customers (id, name, street, city) VALUES (1, 'Giovanna Goncalves Oliveira', 'Rua Mato Grosso', 'Canoas');
      INSERT INTO customers (id, name, street, city) VALUES (2, 'Kauã Azevedo Ribeiro', 'Travessa Ibiá', 'Uberlândia');
      INSERT INTO customers (id, name, street, city) VALUES (3, 'Rebeca Barbosa Santos', 'Rua Observatório Meteorológico', 'Salvador');
      INSERT INTO customers (id, name, street, city) VALUES (4, 'Sarah Carvalho Correia', 'Rua Antônio Carlos da Silva', 'Uberlândia');
      INSERT INTO customers (id, name, street, city) VALUES (5, 'João Almeida Lima', '  Rua Rio Taiuva', 'Ponta Grossa');
      INSERT INTO customers (id, name, street, city) VALUES (6, 'Diogo Melo Dias', 'Rua Duzentos e Cinqüenta', 'Várzea Grande');

-- Solução
SELECT DISTINCT city
FROM customers;