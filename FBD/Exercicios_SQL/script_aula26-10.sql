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
    ch INT
);

-- Eliminando a tabela curso.
DROP TABLE curso;

-- Eliminando a base de dados com todas as tabelas que ela possui.
DROP DATABASE faculdade;