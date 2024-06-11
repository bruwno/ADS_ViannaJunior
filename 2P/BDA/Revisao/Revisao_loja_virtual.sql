USE loja_virtual;

/*
QUESTÃO 01: Recupere todas as informações dos clientes que não efetuaram nenhuma compra. Utilize junção externa ou not in. (8 linhas retornadas)
*/
SELECT c.* FROM cliente AS c
WHERE c.ClienteId NOT IN(SELECT ClienteId FROM compra);
-- OU
SELECT c.* FROM cliente AS c
LEFT JOIN compra AS cmp ON c.ClienteId = cmp.ClienteId
WHERE cmp.ClienteId IS NULL;

/*
QUESTÃO 02: Traga todas as informações dos produtos em que o preço de venda é pelo menos 60% a mais que o preço de custo. 
Ordene do maior para o menor preço de venda. (4 linhas retornadas)
*/
SELECT p.* FROM produto AS p
WHERE p.PrecoVenda >= p.PrecoCusto * 1.60
ORDER BY PrecoVenda DESC;

/*
QUESTÃO 03: Recupere o id da compra, o nome do cliente e o valor total (incluindo o frete). 
O valor total da compra deverá ser calculado multiplicando o valor de venda do produto pela quantidade comprada. 
Em seguida, deve-se somar todos os produtos adicionados no carrinho e em seguida o valor do frete (8 linhas retornadas).
Por exemplo: a compra 2 contém 4 produtos de ids 1,4,7 e 10. 
O produto 1 custa 21,95 e vendeu 1 unidade, o produto 4 custa 3,99 e vendeu 2 unidades, o produto 7 custa 19,95 e vendeu 2 unidades e o produto 10 custa 100 e vendeu 1 unidade. 
Sendo assim, o preço total de cada produto é:
Produto 1) 21,95 x 1 = 21,95
Produto 2) 3,99 x 2 = 7,98
Produto 3) 19,95 x 2 = 39,90
Produto 4) 100 x 1 = 100
O preço total dos 4 produtos da venda 2 + o valor do frete(0) é: 21,95+7,98+39,90+100+0 = 169,83
*/
SELECT cmp.CompraId, cli.PrimNome, cli.UltNome, SUM(quantidade * p.PrecoVenda) + frete AS valorTotal 
FROM compra AS cmp
INNER JOIN carrinho AS car ON cmp.CompraId = car.CompraId
INNER JOIN produto AS p ON car.ProdutoId = p.ProdutoId
INNER JOIN cliente as cli ON cmp.ClienteId = cli.ClienteId
GROUP BY cmp.CompraId;

/*
QUESTÃO 04: Recupere o nome do produto e a quantidade total de vendas realizadas de cada produto. Para os produtos que venderam mais de 2 unidades (6 linhas retornadas).
Por exemplo: o produto 1 vendeu 3 unidades. A quantidade total vendida deve ser calculada somando a coluna quantidade de cada produto. 
*/
SELECT p.Descricao, SUM(quantidade) AS qtdVendas 
FROM produto AS p
INNER JOIN carrinho AS c ON c.ProdutoId = p.ProdutoId
GROUP BY p.ProdutoId
HAVING qtdVendas > 2;

SELECT SUM(quantidade) AS qtdTotal
FROM carrinho;

/*
QUESTÃO 05: Recupere todas as informações do(s) produto(s) com menor preço de venda (1 linha retornada).
DICA: Utilize subconsulta
*/
SELECT * FROM produto
WHERE PrecoVenda = (SELECT MIN(PrecoVenda) FROM produto);

-- QUESTÃO 05.1: Recupere todas as informações do(s) produto(s) com maior preço de venda.
SELECT * FROM produto
WHERE PrecoVenda = (SELECT MAX(PrecoVenda) FROM produto);

-- QUESTÃO 05.2: Recupere o preço médio dos produtos disponíveis para venda.
SELECT AVG(PrecoVenda) AS MediaPrecoVenda
FROM produto;

/*
QUESTÃO 06: Crie e exiba uma visão que recupere todas as informações dos clientes, caso ele tenha realizado alguma compra, recupere também o id da compra (16 linhas retornadas).
*/
CREATE VIEW dados_clientes AS
SELECT c.*, cmp.CompraId FROM cliente AS c
LEFT JOIN compra AS cmp ON c.ClienteId = cmp.ClienteId;
