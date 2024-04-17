/* Autor: William Silva (https://github.com/unclWill)
 * Data : 07/04/2024
 */
 
USE locadora;
 
-- QUESTÃO 01: Traga o nome de todos os filmes, os que foram locados por algum cliente, traga também o nome do cliente. 
-- Traga também o nome de todos os clientes, os que locaram ou não filmes, caso tenha locado o nome do filme deverá aparecer. (52 linhas retornadas)
SELECT f.titulo, c.nome_cliente 
FROM cliente AS c
LEFT JOIN locacao AS l ON c.codigo_cliente = l.codigo_cliente
LEFT JOIN filme AS f ON f.codigo_filme = l.codigo_filme
UNION
SELECT f.titulo, c.nome_cliente
FROM cliente AS c
RIGHT JOIN locacao AS l ON c.codigo_cliente = l.codigo_cliente
RIGHT JOIN filme AS f ON f.codigo_filme = l.codigo_filme;

-- QUESTÃO 02: Traga o nome dos gêneros que não estão em nenhum filme. (4 linhas retornadas)
SELECT g.nome_genero
FROM genero AS g
LEFT JOIN filme_genero AS fg ON fg.codigo_genero = g.codigo_genero
LEFT JOIN filme AS f ON fg.codigo_filme = f.codigo_filme
WHERE fg.codigo_genero IS NULL;

-- QUESTÃO 03: Traga o nome de todos os diretores. Caso ele tenha dirigido algum filme, traga o nome do filme. (23 linhas retornadas)
SELECT d.nome_diretor, f.titulo
FROM diretor AS d
LEFT JOIN filme_diretor AS fd ON d.codigo_diretor = fd.codigo_diretor
LEFT JOIN filme AS f ON f.codigo_filme = fd.codigo_filme;

-- QUESTÃO 04: Traga o nome e cpf de todos os clientes, caso ele tenha locado algum filme, traga o titulo do filme e a data de locação. (52 linhas retornadas)
SELECT c.nome_cliente, c.cpf, f.titulo, l.data_locacao
FROM cliente AS c
LEFT JOIN locacao AS l ON l.codigo_cliente = c.codigo_cliente
LEFT JOIN filme AS f ON f.codigo_filme = l.codigo_filme;


-- QUESTÃO 05: Traga o título dos filmes, juntamente com o nome dos atores que atuaram nele. (88 linhas retornadas)
SELECT f.titulo, a.nome_ator
FROM filme AS f
INNER JOIN filme_ator fa ON fa.codigo_filme = f.codigo_filme
INNER JOIN ator AS a ON fa.codigo_ator = a.codigo_ator;

-- QUESTÃO 06: Traga o nome dos clientes que alugaram filmes do gênero comédia. (13 linhas retornadas)
SELECT c.nome_cliente
FROM cliente AS c
INNER JOIN locacao AS l ON l.codigo_cliente = c.codigo_cliente
INNER JOIN filme AS f ON f.codigo_filme = l.codigo_filme
INNER JOIN filme_genero AS fg ON fg.codigo_filme = f.codigo_filme
INNER JOIN genero AS g ON g.codigo_genero = fg.codigo_genero
WHERE g.nome_genero = 'Comédia';

-- QUESTÃO 07: Traga o nome dos filmes que não foram locados por ninguém. (4 linhas retornadas)
SELECT f.titulo
FROM filme AS f
LEFT JOIN locacao AS l ON f.codigo_filme = l.codigo_filme
WHERE data_locacao IS NULL;