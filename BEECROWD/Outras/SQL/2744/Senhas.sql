/* Objetivo: Transformar as senhas de texto puro para MD5.
 * Autor   : William Silva (https://github.com/bruwno)
 * Data    : 23/12/2023
 * Tipo    : 9 (SQL)
 * ID      : 2744
 * Nome    : Senhas
 * Link    : https://www.beecrowd.com.br/judge/pt/problems/view/2744
 *
 * Plataforma utilizada para montar a solução: https://coderpad.io/languages/postgresql/
 */

 -- Script da tabela
CREATE TABLE account (id INTEGER, name VARCHAR, login VARCHAR, password VARCHAR);
    INSERT INTO account (id, name, login, password) VALUES (1, 'Joyce P. Parry', 'Promeraw', 'noh1Oozei');
    INSERT INTO account (id, name, login, password) VALUES (2, 'Michael T. Gonzalez', 'Phers1942', 'Iath3see9bi');
    INSERT INTO account (id, name, login, password) VALUES (3, 'Heather W. Lawless', 'Hankicht', 'diShono4');
    INSERT INTO account (id, name, login, password) VALUES (4, 'Otis C. Hitt', 'Conalothe', 'zooFohH7w');
    INSERT INTO account (id, name, login, password) VALUES (5, 'Roger N. Brownfield', 'Worseente', 'fah7ohNg');

-- Solução
SELECT id, password, MD5(password)
    FROM account;