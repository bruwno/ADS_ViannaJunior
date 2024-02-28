-- Recupere os funcionários que trabalham no departamento 4.
SELECT * FROM funcionario WHERE dnr = 4;
-- Recupere os funcionários que ganham salário maior de 30000.
SELECT * FROM funcionario WHERE salario > 30000;
-- Recupere os funcionários do sexo masculino que possuem sobrenome Brito.
SELECT * FROM funcionario WHERE sexo = 'M' AND unome = 'Brito';
-- Recupere os funcionários que não possuem supervisor.
SELECT * FROM funcionario WHERE cpf_supervisor IS NULL;
-- Recupere os funcionários que possuem supervisor.
SELECT * FROM funcionario WHERE cpf_supervisor IS NOT NULL;

-- Selecionar apenas os distintos
SELECT DISTINCT sexo FROM funcionario; 
-- 
SELECT d.sexo FROM funcionario f, dependente AS d;


