-- Revisão Álgebra Relacional e SQL
USE academia_ginastica;

/* 1. Crie e resolva uma consulta em SQL e Álgebra Relacional envolvendo junção interna com pelo menos 4 tabelas. */
-- Possibilidade 1(4 tabelas): Recupere o nome, sobrenome dos alunos que praticam Yoga.
SELECT a.nome, a.sobrenome
FROM aluno AS a 
INNER JOIN matricula AS m ON m.aluno_matricula = a.numMatricula 
INNER JOIN turma AS t ON t.idturma = m.turma_idturma 
INNER JOIN atividade AS atv ON atv.idatividade = t.atividade_idatividade 
WHERE atv.nome LIKE "%Yoga";

-- Possibilidade 2(5 tabelas): Recupere o nome dos alunos, o nome das atividades que eles praticam e o nome do seu instrutor.
SELECT a.nome, atv.nome, i.nome 
FROM aluno AS a 
INNER JOIN matricula AS m ON m.aluno_matricula = a.numMatricula 
INNER JOIN turma AS t ON t.idturma = m.turma_idturma 
INNER JOIN instrutor AS i ON i.idinstrutor = t.instrutor_idinstrutor 
INNER JOIN atividade AS atv ON atv.idatividade = t.atividade_idatividade; 

-- Possibilidade 3(4 tabelas): Recupere o nome do aluno, sua data de matrícula e o nome do seu instrutor.
SELECT a.nome, m.datamatricula, i.nome
FROM aluno AS a
INNER JOIN matricula AS m ON m.aluno_matricula = a.numMatricula
INNER JOIN turma AS t ON t.idturma = m.turma_idturma
INNER JOIN instrutor AS i ON i.idinstrutor = t.instrutor_idinstrutor;

/* 2. Crie e resolva uma consulta em SQL que contenha junção externa e ordenação. */
-- Possibilidade 1) Recupere o nome de todos os instrutores, caso eles deem aula para alguma turma, mostre também o id da turma e o horário. Ordene pelo horário de maneira ascendente.
SELECT i.nome, t.idturma, t.horario
FROM turma AS t RIGHT JOIN instrutor AS i ON i.idinstrutor = t.instrutor_idinstrutor
ORDER BY t.horario;

-- Possibilidade 2) Recupere o nome de todas as atividades, caso elas estejam associadas a alguma turma, traga também o código da turma.
SELECT a.nome, t.idturma
FROM atividade AS a LEFT JOIN turma AS t ON t.atividade_idatividade = a.idatividade
ORDER BY t.idturma;

-- Possibilidade 3) Recupere o nome de todos os alunos, caso eles estejam matriculados, traga também a data da matrícula.
SELECT a.nome, m.datamatricula 
FROM aluno AS a RIGHT JOIN matricula AS m ON a.numMatricula = m.aluno_matricula
ORDER BY a.nome;

/* 3. Crie e resolva uma consulta em SQL com consultas aninhadas. */
-- Possibilidade 1) Recupere o nome dos alunos que não praticam nenhuma atividade.
SELECT a.nome
FROM aluno AS a
INNER JOIN matricula AS m ON m.aluno_matricula = a.numMatricula
INNER JOIN turma AS t ON t.idturma = m.turma_idturma
WHERE t.atividade_idatividade NOT IN(SELECT idatividade FROM atividade);

-- Possibilidade 2: Recupere o nome dos instrutores que não estão vinculados a nenhuma turma.
SELECT nome 
FROM instrutor 
WHERE idinstrutor NOT IN(SELECT instrutor_idinstrutor FROM turma);

-- Possibilidade 3: Recupere o nome das atividades que não possuem alunos.
SELECT atv.nome
FROM atividade AS atv
INNER JOIN turma AS t ON t.atividade_idatividade = atv.idatividade
INNER JOIN matricula AS m ON m.turma_idturma = t.idturma
WHERE aluno_matricula NOT IN(SELECT numMatricula FROM aluno);
