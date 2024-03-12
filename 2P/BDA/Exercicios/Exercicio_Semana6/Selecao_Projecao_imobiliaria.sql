/* Autor: William Silva (https://github.com/unclWill)
 * Data : 10/03/2024
 */
 
USE imobiliaria;
 
-- a) Selecione o nome e cidade dos clientes que não possuem telefone cadastrado.
SELECT DISTINCT nome_cliente, cidade FROM cliente WHERE telefone IS NULL;

-- b) Selecione nome, cpf e rg dos clientes que moram no centro.
SELECT DISTINCT nome_cliente, cpf, rg FROM cliente WHERE bairro = 'Centro';

-- c) Selecione o nome e a rua dos clientes que moram em São Paulo ou que tenham nascido após 01/01/1990(1990-01-01).
SELECT DISTINCT nome_cliente, rua FROM cliente WHERE cidade = 'São Paulo' AND datanasc > '1990-01-01';

-- d) Selecione o código dos clientes que possuem telefone cadastrado e que não tem data de nascimento cadastrada.
SELECT DISTINCT codigo_cliente FROM cliente WHERE telefone IS NOT NULL AND datanasc IS NULL;

-- e) Selecione os códigos dos imóveis que possuem tipo cadastrado.
SELECT DISTINCT codigo_imovel FROM imovel WHERE codigo_tipo IS NOT NULL;

-- f) Selecione o código e a descrição dos imóveis localizados no centro de Juiz de Fora.
SELECT DISTINCT codigo_imovel, descricao FROM imovel WHERE cidade = 'Juiz de Fora' AND bairro = 'Centro';

-- g) Selecione o código e a descrição dos imóveis situados no Rio de Janeiro ou Petrópolis.
SELECT DISTINCT codigo_imovel, descricao FROM imovel WHERE cidade = 'Rio de Janeiro' OR cidade = 'Petrópolis';

-- h) Selecione o nome e cpf do(s) proprietário(s) de nome João e sobrenome da Silva.
SELECT DISTINCT nome_proprietario, cpf FROM proprietario WHERE nome_proprietario = 'João' AND sobrenome = 'Silva';

-- i) Selecione as informações cujo tipo de imóvel é apartamento.
SELECT DISTINCT rua, bairro, cidade, cep, descricao FROM imovel WHERE codigo_tipo = 1;

-- j) Selecione todas as informações da tabela venda cujos valores dos imóveis sejam de R$150.000,00.
SELECT DISTINCT * FROM venda WHERE valor = 200000;

-- k) Selecione todas as informações da tabela venda, cujos imóveis estejam com o valor entre R$100.000,00 e R$200.000,00.
SELECT DISTINCT * FROM venda WHERE valor > 100000 AND valor < 200000;

-- l) Selecione todas as informações da tabela locação para os imóveis que estão sendo alugados por mais de R$2000,00.
SELECT DISTINCT * FROM locacao WHERE valor_total > 2000.00;
-- SELECT codigo_locacao, codigo_cliente, codigo_imovel, valor_locacao, valor_taxas, valor_iptu, valor_total, data_locacao FROM locacao WHERE valor_total > 2000.0;

-- m) Selecione todas as informações da tabela locação para os imóveis que estão sendo alugados por R$900,00.
SELECT DISTINCT * FROM locacao WHERE valor_total = 900.00;

/*
-- Criação da tabela venda
CREATE TABLE `venda` (
  `codigo_venda` decimal(4,0) NOT NULL,
  `codigo_cliente` decimal(4,0) NOT NULL,
  `codigo_imovel` decimal(3,0) NOT NULL,
  `valor` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`codigo_venda`));
*/