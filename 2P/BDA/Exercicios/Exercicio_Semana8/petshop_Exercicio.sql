-- QUESTÃO 01: Recupere os tipos de serviços e valor, para os serviços que custam mais de R$50,00.(6 linhas retornadas)
SELECT DISTINCT tipo, valor FROM tipo_servico WHERE valor > 50.00;

-- QUESTÃO 02: Recupere o nome do animal juntamente com sua raça.(1008 linhas retornadas)
SELECT nome, raca FROM animal;

-- QUESTÃO 03: Recupere todas as informações dos animais que possuem alto nível de cuidados.(375 linhas retornadas)
SELECT a.* FROM animal AS a, raca AS r WHERE r.nivel_cuidados = 'Alto' AND a.raca = r.id;

-- QUESTÃO 04: Recupere o nome do cliente e o tipo de serviço que ele solicitou. Traga apenas os serviços que ainda não foram pagos.(469 linhas retornadas)
SELECT 
    c.nome, ts.tipo
FROM
    cliente AS c,
    animal AS a,
    tipo_servico AS ts,
    servico AS s
WHERE
    pago = 0 AND c.id = a.cliente
        AND s.animal = ts.tipo
        AND s.tipo_servico = ts.tipo;
        
-- QUESTÃO 05:
SELECT DISTINCT c.*, a.nome, r.nome, tipo
FROM cliente AS c, animal AS a, raca AS r, servico AS s, tipo_servico AS ts
WHERE c.id = a.cliente.id AND a.raca = r.id
AND a.id

        