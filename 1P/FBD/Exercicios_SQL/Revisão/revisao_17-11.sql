-- Questã0 3
CREATE TABLE agencia (
    numero_agencia VARCHAR(5) PRIMARY KEY,
    nome_agencia VARCHAR(15),
    cidade_agencia VARCHAR(30)
);

-- Questão 4
/*Altere  o nome do atributo nome_agencia para nome*/
ALTER TABLE agencia CHANGE nome_agencia nome VARCHAR(15);

/*O atributo cidade_agencia do tipo caractere que poderá receber 25 caracteres*/
ALTER TABLE agencia MODIFY cidade_agencia VARCHAR(25);

/*Tabela cliente*/
/* 
o	Adicione o atributo uf do tipo caractere que poderá receber 2 caracteres;
o	Adicione o atributo cpf do tipo decimal com 11 digitos. O atributo cpf deverá ser chave candidata;
o	O atributo sexo não poderá receber o valo nulo.
o	Altere o nome do atributo rua_cliente para endereco.
*/
ALTER TABLE cliente ADD uf char(2),
					ADD cpf decimal(11) UNIQUE,
                    MODIFY sexo char(1),
                    CHANGE rua_cliente endereco VARCHAR(30);
                    
/*Tabela conta*/
/*o	Adicione o atributo data_abertura que deverá ser do tipo data.*/
ALTER TABLE conta ADD data_abertura DATE;

/*Tabela emprestimo*/
/*
o	Adicione o atributo ano_emprestimo que deverá ser do tipo ano com 4 digitos.
o	O atributo ano_emprestimo deverá receber o valor padrão 2017.
*/
-- Pode ser feito de duas formas
ALTER TABLE emprestimo ADD ano_emprestimo YEAR(4) DEFAULT '2017';
-- ou
ALTER TABLE emprestimo ADD ano_emprestimo YEAR(4);
ALTER TABLE emprestimo ALTER ano_emprestimo SET DEFAULT '2017';
ALTER TABLE emprestimo MODIFY ano_emprestimo YEAR(4) DEFAULT '2017';

/*Questão 5*/
/*Faça as seguintes inserções:*/
-- Tabela agencia
INSERT INTO agencia VALUES
(12345,'Metroplitana', 'Juiz de Fora'),
(23456,'Lago Sul', 'Juiz de Fora'),
(34567,'Zona Norte', 'Juiz de Fora'),
(45678,'Zona Sul', 'Juiz de Fora'),
(56789,'Park Sul', 'Juiz de Fora'),
(67890,'Cascatinha', 'Juiz de Fora'),
(78901,'São Mateus', 'Juiz de Fora');

/*Questão 6*/
/*6)	
Crie as seguintes chaves estrangeiras na tabela conta:
•	O atributo numero_agencia é a chave estrangeira da tabela conta. Este atributo referencia a tabela agencia na coluna numero_agencia.
•	O atributo numero_agencia é a chave estrangeira da tabela empréstimo. Este atributo referencia a tabela agencia na coluna numero_agencia.
Crie as chaves estrangeiras com on update cascade e on delete cascade.
*/
-- Tabela conta
ALTER TABLE conta ADD FOREIGN KEY(numero_agencia) REFERENCES agencia(numero_agencia) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE emprestimo ADD FOREIGN KEY(numero_agencia) REFERENCES agencia(numero_agencia) ON DELETE CASCADE ON UPDATE CASCADE;
