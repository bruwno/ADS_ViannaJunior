/* DATA : 06/05/2024
 * AUTOR: William Silva (https://github.com/unclWill)
 */

USE seguros;

-- 1) Recupere os dados dos carros que não participaram de nenhum acidente.
SELECT c.* FROM carro AS c LEFT JOIN participou AS p ON c.placa = p.placa 
GROUP BY c.placa HAVING COUNT(p.placa) = 0;

-- 2) Recupere os dados do(s) carro(s) que teve(tiveram) o maior valor de dano, juntamente com o valor do dano.
SELECT c.*, p.valor_dano FROM carro AS c LEFT JOIN participou AS p ON c.placa = p.placa
WHERE p.valor_dano = (SELECT MAX(valor_dano) FROM participou);

-- 3) Recupere os dados do(s) carro(s) que teve(tiveram) o menor valor de dano, juntamente com o valor do dano.
SELECT c.*, p.valor_dano FROM carro AS c LEFT JOIN participou AS p ON c.placa = p.placa
WHERE p.valor_dano = (SELECT MIN(valor_dano) FROM participou);

-- 4) Recupere as informações do(s) carro(s) que participou(aram) do maior número de ocorrências.
SELECT c.*, oc.num_ocorrencias FROM carro AS c LEFT JOIN (SELECT placa, COUNT(*) AS num_ocorrencias FROM participou GROUP BY placa) AS oc ON c.placa = oc.placa
WHERE oc.num_ocorrencias = (SELECT MAX(num_ocorrencias) FROM (SELECT COUNT(*) AS num_ocorrencias FROM participou GROUP BY placa) AS max_oc);

-- 5) Recupere a soma, a média, o valor mínimo e o valor máximo do valor do dano ocasionado por cada veículo.
SELECT p.placa, SUM(valor_dano), AVG(valor_dano), MIN(valor_dano), MAX(valor_dano) FROM participou AS p GROUP BY placa;

-- 6) Recupere todos as informações do acidente mais antigo.
SELECT * FROM acidente WHERE data = (SELECT MIN(data) FROM acidente);

-- 7) Recuperar os dados do carro mais antigo que se envolveu em algum acidente.
SELECT c.modelo, c.ano, c.placa FROM carro AS c LEFT JOIN participou AS p ON c.placa = p.placa
LEFT JOIN acidente AS a ON p.numero_ocorrencia = a.numero_ocorrencia
WHERE c.ano = (SELECT MIN(ano) FROM carro);