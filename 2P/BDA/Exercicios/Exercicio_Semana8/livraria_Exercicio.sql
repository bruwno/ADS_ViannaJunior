-- Questão 1: Recupere o nome e o ano de nascimento dos autores que ainda estão vivos.(10 linhas retornadas)
SELECT 
    nomeautor, anonascimento
FROM
    autor
WHERE
    anofalecimento IS NULL;
-- Questão 2: Recupere todos os dados das editoras situadas no Rio de Janeiro e que foram fundadas a mais de 30 anos.(1 linha retornada)
SELECT 
    *
FROM
    editora
WHERE
    anofundacao < 1994
        AND cidade = 'Rio de Janeiro';
-- Questão 3: Recupere todos os dados das editoras que publicaram livros que possuem o nome Sistema de Banco de Dados.(2 linhas retornadas)
SELECT 
    e.*
FROM
    editora AS e,
    livro AS l
WHERE
    l.nomelivro = 'Sistema de Banco de Dados'
        AND e.nomeeditora = l.nomeeditora;
-- Questão 4: Recupere o nome dos autores e o nome do livro que eles publicaram.(10 linhas retornadas)
SELECT 
    a.nomeautor, l.nomelivro
FROM
    autor AS a,
    livro AS l,
    autoria AS au
WHERE
    au.numlivro = l.numlivro
        AND a.numautor = au.numautor;
        
-- Questão 5: O nome do cliente e o nome do livro que ele comprou.(19 linhas retornadas)
SELECT 
    c.nomecli, l.nomelivro
FROM
    cliente AS c,
    livro AS l,
    vendas AS v
WHERE
    c.numcli = v.numcli
        AND l.numlivro = v.numlivro;