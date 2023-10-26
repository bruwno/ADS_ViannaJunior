CREATE DATABASE empresa;
USE empresa;

CREATE TABLE EMPREGADO(CODIGO_EMPREGADO decimal(6),
					   NOME varchar(50),
                       CODIGO_CARGO decimal(5),
                       ENDERECO varchar(50),
                       BAIRRO varchar(20),
                       CIDADE varchar(20),
                       CODIGO_CHEFE decimal(6),
                       UF char(2),
                       DATA_NASC date,
                       SEXO char(1),
                       FILIACAO varchar(60),
                       SALARIO decimal(10));
                       
CREATE TABLE CARGO(CODIGO_CARGO varchar(30),
				   DESCRICAO_CARGO varchar(30),
                   SALARIO_MIN numeric(7),
                   SALARIO_MAX numeric(8),
                   NIVEL_GRADUACAO char(1));

CREATE TABLE DEPENDENTE(CODIGO_EMPREGADO decimal(6),
			            NOME_DEPENDENTE varchar(50),
						SEXO char(1),
                        DATA_NASC date,
                        PARENTESCO varchar(15));
             
CREATE TABLE DEPARTAMENTO(CODIGO_DEP decimal(3),
						  NOME_DEP varchar(30),
                          CODIGO_GERENTE decimal(6),
                          DATA_INICIO_GERENTE date,
                          DATA_CRIACAO date);
