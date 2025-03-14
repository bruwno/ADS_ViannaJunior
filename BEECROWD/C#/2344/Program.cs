/* Objetivo: Determinar a nota de um aluno, na faixa de conceito que vai de A a E com base na pontuação obtida na prova.
 * Autor   : William Silva (https://github.com/bruwno)
 * Data    : 13/03/2025
 * Tipo    : 1 (INICIANTE)
 * ID      : 2344
 * Nome    : Notas da Prova
 * Link    : https://www.beecrowd.com.br/judge/pt/problems/view/2344
 */

using System;

namespace _2344
{
    class URI
    {
        public static void Main(string[] args)
        {
            int nota = int.Parse(Console.ReadLine());
            Console.WriteLine(ConverterNota(nota));
        }

        public static char ConverterNota(int nota)
        {
            return nota == 0 ? 'E' :
                   nota <= 35 ? 'D' :
                   nota <= 60 ? 'C' :
                   nota <= 85 ? 'B' : 'A';
        }
    }
}