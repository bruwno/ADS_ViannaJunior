/* ALUNO  : William Silva
 * DATA   : 05/02/2024
 * ASSUNTO: Revisão de Fundamentos de Bancos de Dados
 */
 
-- QUESTÃO 1 --
USE reserva;

-- QUESTÃO 2 --
CREATE TABLE cidade (
	codigocidade DECIMAL(4),
    nomecidade VARCHAR(40),
    PRIMARY KEY (codigocidade)
);

-- QUESTÃO 3 --
-- TABELA: aeronave
ALTER TABLE aeronave CHANGE COLUMN `fabricante` `nomefabricante` VARCHAR(20);
ALTER TABLE aeronave ADD COLUMN `capacidade` INT;
-- TABELA: assento
ALTER TABLE assento ALTER COLUMN `classe` SET DEFAULT 'Econômica';
ALTER TABLE assento ADD COLUMN `status` VARCHAR(15) DEFAULT 'Disponível';
-- TABELA: cidade
ALTER TABLE cidade MODIFY COLUMN `nomecidade` VARCHAR(40) NOT NULL;
-- TABELA: cliente
ALTER TABLE cliente MODIFY COLUMN `cpf` VARCHAR(13) UNIQUE;
ALTER TABLE cliente MODIFY COLUMN `endereco` VARCHAR(45);
-- TABELA: reserva
ALTER TABLE reserva MODIFY COLUMN `codigocliente` DECIMAL(5,0) NOT NULL;
-- TABELA: voo
ALTER TABLE voo MODIFY COLUMN `numerovoo` VARCHAR(6) NOT NULL;
ALTER TABLE voo ADD COLUMN `status` VARCHAR(15);

-- QUESTÃO 4 --
-- TABELA: cidade
INSERT INTO cidade (codigocidade, nomecidade) 
VALUES (1234, 'Rio de Janeiro'),
	   (2345, 'São Paulo'),
	   (3456, 'Belo Horizonte'),
	   (4567, 'Brasília'),
	   (5678, 'Juiz de Fora');
       
-- QUESTÃO 5 --
-- TABELA: voo
ALTER TABLE voo ADD CONSTRAINT fk_cidadeorigem FOREIGN KEY (cidadeorigem) REFERENCES cidade(codigocidade) ON UPDATE CASCADE ON DELETE CASCADE;
ALTER TABLE voo ADD CONSTRAINT fk_cidadedestino FOREIGN KEY (cidadedestino) REFERENCES cidade(codigocidade) ON UPDATE CASCADE ON DELETE CASCADE;

-- QUESTÃO 6 --
-- TABELA: aeronave
DELETE FROM aeronave WHERE nomefabricante = 'FABE';
-- TABELA: assento
DELETE FROM assento WHERE numeroassento = 'K8' AND classe = 'Primeira Classe';
-- TABELA: cliente
DELETE FROM cliente WHERE endereco = 'Olípio Costa, Rio de Janeiro - RJ' OR cpf = '20120120122';
-- TABELA: reserva
DELETE FROM reserva WHERE datareserva = '2014-12-08';
-- TABELA: voo
DELETE FROM voo WHERE status = 'Cancelado';

-- QUESTÃO 7 --
-- TABELA: aeronave
UPDATE aeronave SET anofabricacao = '2011' WHERE prefixo = 'PR-AZB';
UPDATE aeronave SET capacidade = '525' WHERE nomefabricante = 'BOING';
UPDATE aeronave SET capacidade = '215' WHERE nomefabricante = 'AIRBUS';
UPDATE aeronave SET capacidade = capacidade*1.15 WHERE nomefabricante = 'AIRBUS';
-- TABELA: assento
UPDATE assento SET status = 'Disponível' WHERE numeroassento = 'K06';
UPDATE assento SET classe = 'Primeira Classe' WHERE numeroassento = 'K06';
UPDATE assento SET status = 'Disponível';
-- TABELA: reserva
UPDATE reserva SET preco = preco*1.1 WHERE datareserva = '2014-12-01';