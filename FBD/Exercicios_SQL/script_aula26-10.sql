-- Criando a base de dados faculdade.
CREATE DATABASE faculdade;
-- Selecionando o BD para uso.
USE faculdade;

-- Criando a tabela aluno.
CREATE TABLE aluno (
    matricula DECIMAL(5) PRIMARY KEY NOT NULL,
    nome VARCHAR(50) NOT NULL,
    data_nasc DATE,
    cod_curso CHAR(3)
);

-- Abrindo a descrição da tabela.
DESC aluno;

-- Criando a tabela curso.
CREATE TABLE curso (
    codcurso CHAR(3),
    nome VARCHAR(40),
    carga_horaria INT
);

-- Alterando dados
/*Comando CHANGE -----------------------------------*/
-- Alterando o nome e o tipo de uma coluna.
ALTER TABLE curso CHANGE COLUMN ch carga_horaria decimal(5);
-- Alterando apenas o nome da coluna.
ALTER TABLE curso CHANGE COLUMN nome nome_curso varchar(40);
-- Alterando apenas o tipo da coluna.
ALTER TABLE aluno CHANGE COLUMN	 codcurso codcurso char(5);

/*Comando MODIFY*/
-- Alterando o tipo da coluna com MODIFY.
ALTER TABLE aluno MODIFY COLUMN nome varchar(100);
-- Tornando o campo datanasc não nulo
ALTER TABLE aluno MODIFY COLUMN datanasc DATE NOT NULL;
-- Mesma coisa, mas utilizando o CHANGE.
ALTER TABLE aluno CHANGE COLUMN datanasc datanasc DATE NOT NULL;

/*Comando ADD*/
-- Adicionando as colunas rua, bairro, cidade e cep na tabela aluno.
ALTER TABLE aluno ADD rua varchar(50),
				  ADD cidade varchar(30),
                  ADD bairro varchar(25),
                  ADD cep decimal(8);

-- Adicionando a PK da tabela curso.
ALTER TABLE curso ADD PRIMARY KEY(codcurso, nome_curso);

-- Criando a FK da tabela aluno.
ALTER TABLE aluno ADD FOREIGN KEY(cod_curso) REFERENCES curso(cod_curso);

/*Comando DROP*/
-- Removendo uma coluna.
ALTER TABLE curso DROP carga_horaria;

-- Eliminando a PK.
ALTER TABLE curso DROP PRIMARY KEY;

-- Eliminando a tabela curso.
DROP TABLE curso;

-- Eliminando a base de dados com todas as tabelas que ela possui.
DROP DATABASE faculdade;

/*Comando ALTER*/
-- Colocando o valor padrão Juiz de Fora para a coluna cidade.
ALTER TABLE aluno ALTER cidade SET DEFAULT 'Juiz de Fora';
-- Colocando o valor padrão Centro no Bairro de três formas:
ALTER TABLE aluno ALTER bairro SET DEFAULT 'Centro';
-- Ou
ALTER TABLE aluno MODIFY bairro VARCHAR(25) DEFAULT 'Centro';
-- Ou
ALTER TABLE aluno CHANGE bairro bairro VARCHAR(25) DEFAULT 'Centro';

/*Inserção de dados, comando INSERT*/
-- Inserindo o curso de ADS.
INSERT INTO curso 
VALUES ('ADS', 'Análise e Desevolvimento de Sistemas', 80);

-- 
INSERT INTO aluno(matricula, nome, datanasc, codcurso) 
VALUES (1,'Fulano', '1997-06-18', 'ADS');

INSERT INTO aluno(matricula, nome, datanasc, codcurso)
VALUES (2, 'Beltrano', '1998-01-15', 'ADS');

INSERT INTO aluno(matricula, nome, datanasc, codcurso)
VALUES (3, 'Ciclano', '1999-05-04', 'ADS');