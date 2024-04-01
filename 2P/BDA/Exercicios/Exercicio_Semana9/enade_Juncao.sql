-- QUESTÃO 01: Recupere o nome de todas as áreas.
SELECT nomeArea FROM area;

-- QUESTÃO 02: Recupere o nome dos municípios do estado de MG.
SELECT nomeMunicipio FROM municipio WHERE siglaUF = 'MG';

-- QUESTÃO 03: Liste os nomes das instituições privadas com fins lucrativos.(675 linhas retornadas).
SELECT nomeIES FROM ies WHERE codCategoria = 2;

-- QUESTÃO 04: Recupere os nomes da IES e o conceitoFaixa das IES que participaram do enade de 2017 cuja modalidade de educação é a distância.(516 linhas retornadas)
SELECT i.nomeIES, r.conceitoFaixa FROM ies AS i, resultado AS r WHERE r.anoEnade = 2017 AND r.codModalidade = 2 AND i.codIES = r.codIES;

-- QUESTÃO 05: Recupere o nome das ies e das áreas que obtiveram conceitoFaixa 5 da área de TECNOLOGIA EM ANÁLISE E DESENVOLVIMENTO DE SISTEMAS no enade de 2017.(12 linhas retornadas)
SELECT i.nomeIES, a.nomeArea
FROM ies AS i
INNER JOIN resultado AS r ON i.codIES = r.codIES
INNER JOIN area AS a ON r.codArea = a.codArea
WHERE r.conceitoFaixa = 5
AND a.nomeArea = 'TECNOLOGIA EM ANÁLISE E DESENVOLVIMENTO DE SISTEMAS';

-- QUESTÃO 06: Recupere o nome da ies, o nome da área e conceitoFaixa do enade de 2017 das ies situadas no município de Juiz de Fora que obtiveram nota 5.(18 linhas retornadas)
SELECT i.nomeIES, a.nomeArea, r.conceitoFaixa
FROM ies AS i
INNER JOIN resultado AS r ON i.codIES = r.codIES
INNER JOIN area AS a ON r.codArea = a.codArea
INNER JOIN municipio AS m ON r.codMunicipio = m.codMunicipio
WHERE r.conceitoFaixa = 5
AND m.nomeMunicipio = 'Juiz de Fora';

-- QUESTÃO 07: Recupere os nomes da IES,o conceitoContinuo e conceitoFaixa das IES do município de Juiz de Fora, cuja área seja TECNOLOGIA EM ANÁLISE E DESENVOLVIMENTO DE SISTEMAS.(2 linhas retornadas)
SELECT i.nomeIES, r.conceitoContinuo, r.conceitoFaixa
FROM ies AS i
INNER JOIN resultado AS r ON i.codIES = r.codIES
INNER JOIN municipio AS m ON r.codMunicipio = m.codMunicipio
INNER JOIN area AS a ON r.codArea = a.codArea
WHERE m.nomeMunicipio = 'Juiz de Fora'
AND a.nomeArea = 'TECNOLOGIA EM ANÁLISE E DESENVOLVIMENTO DE SISTEMAS';

-- QUESTÃO 08: Recupere os nomes da IES, os nomes das áreas, o número de inscritos, o número de participantes e o conceitoFaixa das IES que obtiveram conceitoFaixa menor que 3 no município de Juiz de Fora.(7 linhas retornadas)
SELECT i.nomeIES, a.nomeArea, r.numInscritos, r.numParticipantes, r.conceitoFaixa 
FROM ies AS i
INNER JOIN resultado AS r ON i.codIES = r.codIES
INNER JOIN municipio AS m ON r.codMunicipio = m.codMunicipio
INNER JOIN area AS a ON r.codArea = a.codArea
AND r.conceitoFaixa < 3
AND m.nomeMunicipio = 'Juiz de Fora';