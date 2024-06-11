/* ALUNO: William Bruno da Silva
   PROVA: B
*/

/*QUESTÃO 1*/
SELECT v.* FROM veterinario AS v
WHERE ID_veterinario NOT IN(SELECT vet_id FROM consultas);

/*QUESTÃO 2*/
SELECT c.*, COUNT(a.Dono_ID) AS qtdAnimais FROM clientes AS c
LEFT JOIN animal AS a ON c.ID_cliente = a.Dono_ID
GROUP BY c.ID_cliente;

/*QUESTÃO 3*/
SELECT v.*, COUNT(c.vet_id) AS qtdConsultas FROM veterinario AS v
INNER JOIN consultas AS c ON c.vet_id = v.ID_veterinario
GROUP BY v.ID_veterinario
HAVING qtdConsultas > 2
ORDER BY qtdConsultas DESC;

/*QUESTAO 4*/
SELECT c.Nome, ROUND(AVG(s.Preco), 2) AS mediaServicos FROM servicos AS s
INNER JOIN consultas AS con ON s.ID_servico = con.id_servico
INNER JOIN animal AS a ON a.ID_animal = con.id_animal
INNER JOIN clientes AS c ON a.Dono_ID = c.ID_cliente
GROUP BY c.ID_cliente;

/*QUESTÃO 5*/
SELECT a.*, COUNT(c.id_animal) AS qtdConsultas FROM animal AS a
INNER JOIN consultas AS c ON a.ID_animal = c.id_animal
GROUP BY a.ID_animal;

/*QUESTÃO 6*/
CREATE VIEW relatorioConsultas AS
SELECT c.data_consulta, COUNT(c.id) AS qtdConsultas FROM consultas AS c
WHERE c.data_consulta IN(SELECT data_consulta FROM consultas)
GROUP BY data_consulta;

SELECT * FROM relatorioConsultas;

/*QUESTÃO 7*/
SELECT s.Nome, COUNT(con.id_servico) AS qtdServicos FROM servicos AS s
INNER JOIN consultas AS con ON s.ID_servico = con.id_servico
GROUP BY s.ID_servico
ORDER BY qtdServicos DESC;

/*QUESTÃO 8*/
SELECT a.Nome, c.Nome, v.Nome FROM clientes AS c
INNER JOIN animal AS a ON c.ID_cliente = a.Dono_ID
INNER JOIN consultas AS con ON a.ID_animal = con.id_animal
INNER JOIN veterinario AS v ON con.vet_id = v.ID_veterinario;
