USE loja;

/*
QUESTÃO 01: Recupere todas as informações dos vendedores que não efetuaram nenhuma venda. Utilize junção externa ou not in.(8 linhas retornadas)
*/
SELECT v.* FROM vendedor AS v
WHERE cod_vendedor NOT IN(SELECT cod_vendedor FROM pedido);
-- OU
SELECT v.* FROM vendedor AS v
LEFT JOIN pedido AS p ON v.cod_vendedor = p.cod_vendedor
WHERE p.cod_vendedor IS NULL;

/*
QUESTÃO 02: Traga todas as informações dos clientes, juntamente com a quantidade de pedidos que eles efetuaram. (14 linhas retornadas)
*/
SELECT c.*, COUNT(p.Num_pedido) AS qtdPedidos FROM cliente AS c
INNER JOIN pedido AS p ON c.Cod_cliente = p.cod_cliente
GROUP BY c.Cod_cliente;

-- Exibindo apenas os clientes que fizeram mais de um pedido.
SELECT c.*, COUNT(p.Num_pedido) AS qtdPedidos FROM cliente AS c
INNER JOIN pedido AS p ON c.Cod_cliente = p.cod_cliente
GROUP BY c.Cod_cliente
HAVING qtdPedidos > 1;

-- Exibindo os cliente que não fizeram nenhum pedido.
SELECT c.* FROM cliente AS c
WHERE c.Cod_cliente NOT IN(SELECT cod_cliente FROM pedido);

/*
QUESTÃO 03: Recupere o número do pedido, o nome do cliente e o valor total. 
O valor total da compra deverá ser calculado multiplicando o valor de item pela quantidade comprada. 
Em seguida, deve-se somar todos os produtos que estão no pedido. (11 linhas retornadas).
Por exemplo: o pedido 1 contém 3 produtos de códigos 1,2 e 3. 
O produto 1 custa 19,79 e vendeu 6 unidades, o produto 2 custa 15,99 e vendeu 13 unidades, o produto 3 custa 1,68 e vendeu 3 unidades. 
Sendo assim, o preço total de cada produto é:
Produto 1) 19,79999 x 6 = 118,79
Produto 2) 15,99 x 13 = 207,87
Produto 3) 1,68 x 3 = 5,04
O preço total dos 3 produtos da venda 1 é: 118,79+207,87+5,04 = 331,71
*/
SELECT p.Num_pedido, cli.Nome_cliente, SUM(ip.valor_item * ip.quantidade) AS valorTotal FROM item_pedido AS ip
INNER JOIN pedido AS p ON p.Num_pedido = ip.num_pedido
INNER JOIN cliente AS cli ON cli.Cod_cliente = p.cod_cliente
GROUP BY p.Num_pedido;

/*
QUESTÃO 04: Recupere o nome do produto e a quantidade total de vendas realizadas de cada produto. Para os produtos que venderam mais de 100 unidades (7 linhas retornadas).
Por exemplo: o produto 1 vendeu 162 unidades. A quantidade total vendida deve ser calculada somando a coluna quantidade de cada produto. 
*/

/*
QUESTÃO 05: Recupere todas as informações do(s) produto(s) com maior valor unitário (1 linha retornada).
DICA: Utilize subconsulta
*/
SELECT * FROM produto
WHERE Valor_unitario = (SELECT MAX(Valor_unitario) FROM produto);

/*
QUESTÃO 06: Crie e exiba uma visão que recupere todas as informações dos clientes, caso ele tenha realizado algum pedido, recupere também o número do pedido(26 linhas retornadas).
*/
CREATE VIEW dados_cliente AS
SELECT c.*, p.Num_pedido FROM cliente AS c
LEFT JOIN pedido AS p ON c.Cod_cliente = p.cod_cliente;
