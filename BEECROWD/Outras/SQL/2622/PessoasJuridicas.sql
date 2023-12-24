/* Objetivo: Exibir o nome dos clientes que sejam pessoa jurídica.
 * Autor   : William Silva (https://github.com/unclWill)
 * Data    : 23/12/2023
 * Tipo    : 9 (SQL)
 * ID      : 2622
 * Nome    : Pessoas Jurídicas
 * Link    : https://www.beecrowd.com.br/judge/pt/problems/view/2622
 *
 * Plataforma utilizada para montar a solução: https://coderpad.io/languages/postgresql/
 */

 -- Script da tabela
CREATE TABLE customers (id NUMERIC PRIMARY KEY, name VARCHAR(255), street VARCHAR(255), city VARCHAR(255), state CHAR(2), credit_limit NUMERIC);
    INSERT INTO customers (id, name, street, city, state, credit_limit) VALUES (1, 'Nicolas Diogo Cardoso', 'Acesso Um', 'Porto Alegre', 'RS', 475);
    INSERT INTO customers (id, name, street, city, state, credit_limit) VALUES (2, 'Cecília Olivia Rodrigues', 'Rua Sizuka Usuy', 'Cianorte', 'PR', 3170);
    INSERT INTO customers (id, name, street, city, state, credit_limit) VALUES (3, 'Augusto Fernando Carlos Eduardo Cardoso', 'Rua Baldomiro Koerich', 'Palhoça', 'SC', 1067);
    INSERT INTO customers (id, name, street, city, state, credit_limit) VALUES (4, 'Nicolas Diogo Cardoso', 'Acesso Um', 'Porto Alegre', 'RS', 475);
    INSERT INTO customers (id, name, street, city, state, credit_limit) VALUES (5, 'Sabrina Heloisa Gabriela Barros', 'Rua Engenheiro Tito Marques Fernandes', 'Porto Alegre', 'RS', 4312);
    INSERT INTO customers (id, name, street, city, state, credit_limit) VALUES (6, 'Joaquim Diego Lorenzo Araújo', '  Rua Vitorino', 'Novo Hamburgo', 'RS', 2314);

CREATE TABLE legal_person (id_customers NUMERIC PRIMARY KEY, cnpj CHAR(18), contact VARCHAR, 
    CONSTRAINT fk_customer
        FOREIGN KEY(id_customers) 
        REFERENCES customers(id));

    INSERT INTO legal_person (id_customers, cnpj, contact) VALUES (4, '85883842000191', '99767-0562');
    INSERT INTO legal_person (id_customers, cnpj, contact) VALUES (5, '47773848000117', '99100-8965');

-- Solução
SELECT customers.name
    FROM customers
    INNER JOIN legal_person ON legal_person.id_customers = customers.id;