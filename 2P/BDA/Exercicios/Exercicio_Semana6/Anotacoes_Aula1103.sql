/*Anotações aula BDA 11/03*/

-- 1)
SELECT pnome, unome, salario FROM empresa.funcionario;
-- 2)
SELECT DISTINCT sexo, salario FROM empresa.funcionario;
-- 3)
SELECT DISTINCT pnome, unome, salario FROM empresa.funcionario WHERE dnr = 5;
-- 4)
SELECT DISTINCT horas FROM empresa.trabalha_em WHERE fcpf = '98765432168' AND pnr = 30;
-- 5) 
SELECT DISTINCT horas FROM empresa.trabalha_em;
-- 6)
SELECT DISTINCT pnome, unome FROM empresa.funcionario WHERE sexo = 'F';