/* Autor: William Silva (https://github.com/unclWill)
 * Data : 13/04/2024
 */

-- 1. Recupere o parentesco dos dependentes. Elimine as linhas duplicadas.
SELECT DISTINCT parentesco FROM dependente;

-- 2. Recupere o nível de graduação dos cargos. Elimine as linhas duplicadas.
SELECT DISTINCT nivel_graduacao FROM cargo;

-- 3. Recupere os nomes e o sexo de todos os empregados lotados no departamento 306 cujos nomes contêm a letra “a” ordenados alfabeticamente.
SELECT nome, sexo FROM empregado WHERE codigo_dep = 306 AND nome LIKE '%a%' ORDER BY nome;

-- 4. Recupere a data de nascimento e o nome de todos os empregados do sexo feminino ordenados por data de nascimento descendentemente.
SELECT data_nasc, nome FROM empregado WHERE sexo = 'F' ORDER BY data_nasc DESC;

-- 5. Recupere o nome dos empregados não que tem dependente. Use NOT IN.
SELECT nome FROM empregado 
INNER JOIN dependente WHERE codigo_dep 

-- 6. Recupere todas as informações do(s) empregado(s) que não trabalham no Rio de Janeiro. Use NOT IN.
SELECT e.* FROM empregado AS e 
INNER JOIN departamento AS d ON e.codigo_dep = d.codigo_dep
WHERE `local` NOT IN('Rio de Janeiro');

-- 7. Recupere o nome dos cargos que estão ocupados por algum empregado. Use IN.
SELECT nome_cargo FROM cargo
WHERE codigo_cargo IN (SELECT codigo_cargo FROM empregado WHERE codigo_cargo IS NOT NULL);