/* 
 * AUTHOR: William Silva (https://github.com/unclWill)
 * DATE  : 03/06/2024 | MODIFIED: 28/06/2024
 */

CREATE DATABASE clube;

USE clube;

CREATE TABLE administradores (
	id INT PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(60) NOT NULL,
    sobrenome VARCHAR(60),
    cpf VARCHAR(14) UNIQUE NOT NULL,
    email VARCHAR(60) NOT NULL,
	login VARCHAR(30) NOT NULL,
    senha VARCHAR(70) NOT NULL,
    data_nascimento DATE NULL,
    data_registro DATETIME NOT NULL,
    data_ultimo_acesso DATETIME NULL
);

CREATE TABLE instrutores (
	id INT PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(60) NOT NULL,
	sobrenome VARCHAR(60),
    cpf VARCHAR(14) UNIQUE NOT NULL,
    email VARCHAR(60) NOT NULL,
	login VARCHAR(30) NOT NULL,
    senha VARCHAR(70) NOT NULL,
    salario DECIMAL(10,2) NOT NULL,
    especializacao ENUM('NENHUMA', 'NATACAO', 'FUTEBOL', 'VOLEIBOL', 'TENIS', 'ATLETISMO', 'CAPOEIRA', 'BASQUETE', 'XADREZ') NOT NULL,
	data_nascimento DATE NULL,
    data_registro DATETIME NOT NULL,
    data_ultimo_acesso DATETIME NULL
);

CREATE TABLE membros (
	id INT PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(60) NOT NULL,
	sobrenome VARCHAR(60) NOT NULL,
    cpf VARCHAR(14) UNIQUE NOT NULL,
    email VARCHAR(60) NOT NULL,
	login VARCHAR(30) NOT NULL,
    senha VARCHAR(70) NOT NULL,
	valor_associado DECIMAL(10,2) NOT NULL DEFAULT 0.00,
    tipo_associado ENUM('ANUAL', 'SEMESTRAL') NOT NULL,
	data_nascimento DATE NULL,
    data_registro DATETIME NOT NULL,
    data_ultimo_acesso DATETIME NULL
);

CREATE TABLE atividades (
	id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(60) NOT NULL,
    tipo_atividade ENUM('NATACAO', 'FUTEBOL', 'VOLEIBOL', 'TENIS', 'CORRIDA', 'CAPOEIRA', 'BASQUETE', 'XADREZ') NOT NULL,
	-- tipo_atividade ENUM('FUTEBOL', 'NATACAO', 'TENIS', 'VOLEIBOL', 'BASQUETEBOL', 'HANDEBOL', 'CORRIDA', 'XADREZ', 'DOMINO', 'PINGPONG') NOT NULL,
    descricao VARCHAR(100) NULL,
    data_atividade DATE NOT NULL,
    hora_atividade TIME NOT NULL,
    id_instrutor INT,
    FOREIGN KEY (id_instrutor) REFERENCES instrutores(id)
);

CREATE TABLE eventos (
	id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(60) NOT NULL,
    descricao VARCHAR(100) NULL,
    data_evento DATE NOT NULL,
    hora_evento TIME NOT NULL,
    id_instrutor INT,
    FOREIGN KEY (id_instrutor) REFERENCES instrutores(id)
);

CREATE TABLE inscricoes_atividades (
	id INT PRIMARY KEY AUTO_INCREMENT,
    id_membro INT,
    id_atividade INT NOT NULL,
    data_inscricao DATE NOT NULL,
    hora_inscricao TIME NOT NULL,
    atividade_avaliada TINYINT(0) NOT NULL,
    FOREIGN KEY (id_membro) REFERENCES membros(id),
    FOREIGN KEY (id_atividade) REFERENCES atividades(id)
);

CREATE TABLE inscricoes_eventos (
	id INT PRIMARY KEY AUTO_INCREMENT,
    id_membro INT,
    id_evento INT NOT NULL,
    data_inscricao DATE NOT NULL,
    hora_inscricao TIME NOT NULL,
    FOREIGN KEY (id_membro) REFERENCES membros(id),
    FOREIGN KEY (id_evento) REFERENCES eventos(id)
);

CREATE TABLE avaliacoes (
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_membro INT NOT NULL,
    id_atividade INT NOT NULL,
    id_instrutor INT NOT NULL,
    nota INT NOT NULL,
    descricao VARCHAR(60) NULL,
    presente TINYINT(0) NOT NULL,
    data_hora_avaliacao DATETIME NOT NULL,
    FOREIGN KEY (id_membro) REFERENCES membros(id),
    FOREIGN KEY (id_atividade) REFERENCES atividades(id)
);