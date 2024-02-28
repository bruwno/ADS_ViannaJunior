/* Exercícios de BDA
 * Autor: William Silva (https://github.com/unclWill)
 * Data : 25/02/2024
 */
 
-- Exercício 1) Utilize o banco de dados empresa e faça o que se pede:
-- Utilizando a base de dados.
USE empresa;
 
-- Relação Funcionario
-- a) 	Selecione os funcionários em que o cpf do supervisor possui o valor nulo;
SELECT * FROM funcionario WHERE cpf_supervisor IS NULL;
-- b) 	Selecione os funcionários que não são do sexo feminino;
SELECT * FROM funcionario WHERE sexo = 'M';
-- c) 	Selecione os funcionários em que o cpf do supervisor não é nulo ou ganham mais que 35000;
SELECT * FROM funcionario WHERE cpf_supervisor IS NOT NULL OR salario > 35000;
-- d) 	Selecione os funcionários homens em que a data de nascimento é maior que 01/01/1962.
SELECT * FROM funcionario WHERE sexo = 'M' AND datanasc > '1962-01-01';
-- e) 	Selecione os funcionários que têm o sobrenome ‘Silva’ ou que o nome seja ‘Jorge’.
SELECT * FROM funcionario WHERE unome = 'Silva' OR pnome = 'Jorge';
-- f) 	Selecione os funcionários que não pertencem a nenhum departamento.
SELECT * FROM funcionario WHERE dnr IS NULL;

-- Relação Departamento
-- a)	Selecione os departamentos que possuem gerente.
SELECT * FROM departamento WHERE cpf_gerente IS NOT NULL;
-- b)	Selecione o departamento de nome Matriz;
SELECT * FROM departamento WHERE dnome = 'Matriz';
-- c)	Selecione o departamento que não possui data inicio gerente cadastrada.
SELECT * FROM departamento WHERE data_inicio_gerente IS NULL;

-- Relação Dependente
-- a)	Selecione as dependentes que são esposas;
SELECT * FROM dependente WHERE parentesco = 'Esposa';
-- b)	Selecione as dependentes que são esposas e filhas;
SELECT * FROM dependente WHERE parentesco = 'Filha';
-- c)	Selecione os dependentes em que o cpf do funcionário é 12345678966;
SELECT * FROM dependente WHERE fcpf = 12345678966;
-- d)	Selecione os dependentes que são homens ou filhos.
SELECT * FROM dependente WHERE sexo = 'M' OR parentesco = 'Filho';

-- Relação Projeto
-- a)	Selecione os projetos localizados em São Paulo;
SELECT * FROM projeto WHERE projlocal = 'São Paulo';
-- b)	Selecione os projetos localizados em São Paulo e que o departamento seja 5 ou os projetos localizados em São Paulo e que o departamento seja 1.
SELECT * FROM projeto WHERE projlocal = 'São Paulo' AND dnum = 5 OR dnum = 1;

-- Relação Localizacao_Dep
-- a)	Selecione os departamentos localizados em São Paulo;
SELECT * FROM localizacao_dep WHERE dlocal = 'São Paulo';
-- b)	Selecione os departamentos localizados em São Paulo e que possuem número 5 ou número 1.
SELECT * FROM localizacao_dep WHERE dlocal = 'São Paulo' AND dnumero = 5 OR dnumero = 1;

-- Relação Trabalha_em
-- a)	Selecione os empregados que trabalham mais de 20 horas;
SELECT * FROM trabalha_em WHERE horas > 20;
-- b)	Selecione os empregados que trabalham mais de 10 horas ou trabalham no projeto 3;
SELECT * FROM trabalha_em WHERE horas > 10 OR pnr = 3;
-- c)	Selecione os empregados em que o cpf é igual a 98765432168 e que trabalham no projeto 30.
SELECT * FROM trabalha_em WHERE fcpf = 98765432168 AND pnr = 30;
