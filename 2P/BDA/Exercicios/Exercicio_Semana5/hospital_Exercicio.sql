/* Exercícios de BDA
 * Autor: William Silva (https://github.com/unclWill)
 * Data : 03/03/2024
 */

USE hospital;

-- Tabela paciente
-- 1) Recupere as informações de todos os pacientes que não moram no centro.
SELECT * FROM paciente WHERE bairro != 'Centro';

-- Tabela doenca
-- 2) Recupere as informações das doenças que não possuem descrição.
SELECT * FROM doenca WHERE descricao IS NULL;

-- Tabela hospital
-- 3) Recupere as informações dos hospitais situados no bairro São Mateus da cidade de Juiz de Fora.
SELECT * FROM hospital WHERE bairro = 'São Mateus';

-- Tabela medico
-- 4) Recupere as informações dos médicos que moram na Av. Barão do Rio Branco.
SELECT * FROM medico WHERE rua = 'Av. Barão do Rio Branco';

-- Tabela paciente
-- 5) Recupere as informações dos pacientes que nasceram após 01/01/1990.
SELECT * FROM paciente WHERE datanasc > '1990-01-01';