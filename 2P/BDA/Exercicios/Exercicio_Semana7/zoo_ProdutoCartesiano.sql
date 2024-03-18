/* 
Autor: William Silva (https://github.com/unclWill)
Data : 17/03/2024
*/

USE zoo;

-- QUESTÃO 01: Liste o nome do animal e de seus cuidadores (60 linhas retornadas).
SELECT DISTINCT
    a.nome, e.nome
FROM
    animais AS a,
    empregados AS e
WHERE
    a.idCuidador = e.idEmpregado;

-- QUESTÃO 02: Liste os nomes de todos os clientes que também são provedores(4 linhas retornadas).
SELECT DISTINCT
    c.nome, p.nome
FROM
    clientes AS c,
    provedores AS p
WHERE
    c.idCliente = p.idProvedor;

-- QUESTÃO 03: Liste o nome e data de saída dos animais que saíram do zoológico por falecimento(2 linhas retornadas).
SELECT DISTINCT
    a.nome, a.datasaida, e.tipoEvento
FROM
    animais AS a,
    eventoanimais AS e
WHERE
    a.idAnimal = e.idAnimal
        AND e.descricao = 'Falecimento';

-- QUESTÃO 04: Liste os nomes dos animais, a data de nascimento, o nome do seu cuidador e a descrição da medicação que tomou. (60 linhas retornadas).
SELECT DISTINCT
    a.nome, a.dataNascimento, e.nome, m.descricao
FROM
    animais AS a,
    empregados AS e,
    medicacao AS m
WHERE
    a.idCuidador = e.idEmpregado
        AND a.idMedicacao = m.idMedicacao;

-- QUESTÃO 05: Recupere os dados de todos os animais carnívoros que ainda estão no zoológico (17 linhas retornadas).
SELECT 
    a.*
FROM
    animais AS a,
    alimentacao AS al,
    especies AS e
WHERE
    a.idEspecie = e.idEspecie
        AND e.idAlimentacao = al.idAlimentacao
        AND al.nome = 'Carnívoros'
        AND a.dataSaida IS NULL;

-- QUESTÃO 06: Liste o nome e a espécie dos animais que fizeram translado (2 linhas retornadas).
SELECT DISTINCT
    a.nome, e.ordem
FROM
    animais AS a,
    especies AS e,
    eventoanimais AS evt,
    tipoeventos AS tpev
WHERE
    a.idEspecie = e.idEspecie
        AND a.idAnimal = evt.idAnimal
        AND evt.tipoEvento = tpev.idTipo
        AND tpev.descricao = 'translado';

-- QUESTÃO 07: Recupere o nome e estoque dos produtos fornecidos pelas ongs, assim como o nome dos clientes que fazem parte dessas ongs (2 linhas retornadas).
SELECT DISTINCT
    p.nome, p.estoque, c.nome
FROM
    produtos AS p,
    clientes AS c,
    provedores AS prv,
    sociedades AS s
WHERE
    p.idProvedor = prv.idProvedor
        AND c.tipoSociedade = prv.tipoSociedade
        AND prv.tipoSociedade = s.idTipoSociedade
        AND c.tipoSociedade = s.idTipoSociedade;