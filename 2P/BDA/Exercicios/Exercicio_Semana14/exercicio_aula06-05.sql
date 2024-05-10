USE empresa;

/* Achar a soma dos salários, a máxima, a mínima, e a média */
-- Arredondamento: ROUND(codigo, qtdCasasDecimais) ou TRUNCATE()
SELECT SUM(salario) AS soma_salarios, MAX(salario) AS valor_maximo, MIN(salario) AS valor_minimo, ROUND(AVG(salario),2) AS media_salarial 
FROM funcionario;

/* Achar a média dos salários de acordo com o departamento */
SELECT dnr, ROUND(AVG(salario),2) AS media_salarial 
FROM funcionario 
GROUP BY dnr
HAVING media_salarial >= 31000;

/* Recupere as informações do funcionário que possui o menor salário */
SELECT * FROM funcionario 
WHERE salario = (SELECT MIN(salario) FROM funcionario);

/* Recupere as informações do funcionário que possui o maior salário */
SELECT * FROM funcionario 
WHERE salario = (SELECT MAX(salario) FROM funcionario);

/* Recupere as informações do funcionário mais velho */
SELECT * FROM funcionario 
WHERE datanasc = (SELECT MIN(datanasc) FROM funcionario);

/* Recupere as informações do funcionário mais novo */
SELECT * FROM funcionario 
WHERE datanasc = (SELECT MAX(datanasc) FROM funcionario);

/*Recupere a quantidade de funcionários da empresa*/
SELECT COUNT(*) AS qtd_funcionarios
FROM funcionario;

SELECT COUNT(DISTINCT salario) AS salarios FROM funcionario; -- Trazendo apenas o salario.

/*Recupere os nomes e sobrenomes dos funcionários, juntamente com as suas idades */
SELECT pnome, unome, TIMESTAMPDIFF(YEAR, datanasc, CURDATE()) AS idade FROM funcionario;

/* Traga a média de idade dos funcionários */
SELECT AVG(idade)
FROM (SELECT TIMESTAMPDIFF(YEAR, datanasc, CURDATE()) AS idade FROM funcionario) AS nova_tabela;

/* Recupere o nome do departamento e a quantidade de funcionarios que ele possui, 
caso o departamento não tenha nenhum funcionário associado, exiba 0 na contagem */
SELECT dnome, COUNT(cpf) AS qtd_funcionarios
FROM departamento LEFT JOIN funcionario ON dnr = dnumero
GROUP BY dnumero;

/* Recupere o nome e sobrenome dos funcionários e a quantidade de dependentes
que eles tem, caso o funcionario não tenha nenhum dependente, exiba 0 na contagem */
SELECT f.pnome, f.unome, d.fcpf, COUNT(d.fcpf) FROM funcionario AS f
LEFT JOIN dependente AS d ON f.cpf = d.fcpf
GROUP BY f.cpf;
