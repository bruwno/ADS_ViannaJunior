-- Questão 1
-- Tabela produto
CREATE TABLE produto(
	ProdutoId INT PRIMARY KEY,
    Descricao VARCHAR(64),
    PrecoCusto DECIMAL(6,2),
    PrecoVenda DECIMAL(6,2)
);

-- Questão 2
-- Tabela Cliente
ALTER TABLE cliente CHANGE Endereco Logradouro VARCHAR(64);
ALTER TABLE cliente ADD CONSTRAINT UNIQUE(cpf);
ALTER TABLE cliente ADD COLUMN Genero CHAR(1) DEFAULT 'M';

-- Tabela Produto
ALTER TABLE produto MODIFY Descricao VARCHAR(100);

-- Tabela Compra
ALTER TABLE compra DROP COLUMN DataEnt;

-- Questão 3
INSERT INTO produto(ProdutoId, Descricao, PrecoCusto, PrecoVenda)
VALUES
(1, 'Palavras Cruzadas', 15.23, 21.95),
(2,'Cubo mágico',7.45,11.49),
(3,'CD Linux',1.99,2.49),
(4,'Lenços',2.11,3.99),
(5,'Porta-retratos',7.54,9.95),
(6,'Ventilador pequeno',9.23,15.75),
(7,'Ventilador grande',13.36,19.95),
(8,'Escova de dentes',0.75,1.45),
(9,'Moeda romana',2.34,2.45),
(10,'Mochila',50,100),
(11,'Caixa de som',19.73,25.32);

-- Questão 4
-- Tabela carrinho
ALTER TABLE carrinho ADD CONSTRAINT fk_produto FOREIGN KEY (ProdutoId) REFERENCES produto(ProdutoId) ON DELETE CASCADE ON UPDATE CASCADE;
