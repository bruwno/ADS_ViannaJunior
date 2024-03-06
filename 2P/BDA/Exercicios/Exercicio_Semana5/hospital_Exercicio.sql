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
SELECT * FROM hospital WHERE bairro = 'São Mateus' AND cidade = 'Juiz de Fora';

-- Tabela medico
-- 4) Recupere as informações dos médicos que moram na Av. Barão do Rio Branco.
SELECT * FROM medico WHERE rua = 'Av. Barão do Rio Branco';

-- Tabela paciente
-- 5) Recupere as informações dos pacientes que nasceram após 01/01/1990.
SELECT * FROM paciente WHERE datanasc > '1990-01-01';

-- Tabela especialidade
-- 6) Recupere as informações da especialidade de nome Dermatologia
SELECT * FROM especialidade WHERE especialidade = 'Dermatologia';

-- Tabela diagnostico
-- 7) Recupere as informações do diagnóstico do paciente 12345678901.
SELECT * FROM diagnostico WHERE cpf = 12345678901;

-- Tabela medico_hospital
-- 8) Recupere as informações da tabela medico_hospital, cuja data de início do médico está entre 01/01/2000 até 08/02/2003.
SELECT * FROM medico_hospital WHERE dataInicio >= '2000-01-01' AND dataInicio <= '2003-02-08';