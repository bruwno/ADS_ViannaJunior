/* Objetivo: Exibir os alunos com notas iguais ou superiores a 7.
 * Autor   : William Silva (https://github.com/unclWill)
 * Data    : 23/12/2023
 * Tipo    : 9 (SQL)
 * ID      : 2741
 * Nome    : Notas dos alunos
 * Link    : https://www.beecrowd.com.br/judge/pt/problems/view/2741
 *
 * Plataforma utilizada para montar a solução: https://coderpad.io/languages/postgresql/
 */

 -- Script da tabela
CREATE TABLE students (id INTEGER PRIMARY KEY, name VARCHAR, grade NUMERIC);
        INSERT INTO students (id, name, grade) VALUES (1, 'Terry B. Padilla', 7.3);
        INSERT INTO students (id, name, grade) VALUES (2, 'William S. Ray', 0.6);
        INSERT INTO students (id, name, grade) VALUES (3, 'Barbara A. Gongora', 5.2);
        INSERT INTO students (id, name, grade) VALUES (4, 'Julie B. Manzer', 6.7);
        INSERT INTO students (id, name, grade) VALUES (5, 'Teresa J. Axtell', 4.6);
        INSERT INTO students (id, name, grade) VALUES (6, 'Ben M. Dantzler', 9.6);

-- Solução
SELECT CONCAT('Approved: ', name) AS aluno_aprovado, grade
        FROM students
        WHERE grade >= 7.0
        ORDER BY grade DESC;