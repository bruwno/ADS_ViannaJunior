/* Objetivo : Receber um array com um endereço IPv4 no formato decimal e convertê-lo para binário,
 *            e fornecer informações sobre a classificação deste IP.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 12/09/2023
 */

using System;
using System.Collections.Generic;
using System.Text;

namespace CalcSubredes
{
    internal class EnderecoIP
    {
        internal static List<string> ConverterParaBin(int octeto)
        {
            string octetoBin = Convert.ToString(octeto, 2).PadLeft(8, '0');
            List<string> listaDigitosBin = new List<string>();

            foreach (char bit in octetoBin)
            {
                listaDigitosBin.Add(bit.ToString());
            }

            return listaDigitosBin;
        }

        internal static void ExibirClasseDoIPDigitado(int[] endIP)
        {
            StringBuilder classifIP = new StringBuilder();
            string classe = string.Empty, mascara = string.Empty;
            int dimensaoArray = 0;
            int octeto1 = 0, octeto2 = 0, octeto3 = 0, octeto4 = 0;

            for (int i = 0; i <= endIP.Length; i++)
            {
                dimensaoArray = endIP.Length;

                switch (dimensaoArray)
                {
                    case 1:
                        octeto1 = endIP[0];
                        break;
                    case 2:
                        octeto1 = endIP[0];
                        octeto2 = endIP[1];
                        break;
                    case 3:
                        octeto1 = endIP[0];
                        octeto2 = endIP[1];
                        octeto3 = endIP[2];
                        break;
                    case 4:
                        octeto1 = endIP[0];
                        octeto2 = endIP[1];
                        octeto3 = endIP[2];
                        octeto4 = endIP[3];
                        break;
                }
            }

            if ((octeto1 >= 1) && (octeto1 <= 127))
            {
                classe = "A";
                mascara = "255.0.0.0";

                if ((octeto1 == 0) && (octeto2 == 0) && (octeto3 == 0) && (octeto4 == 0))
                {
                    classifIP.Append("[  OBS  ] Endereço reservado para máquinas que ainda não tiveram um IP completamente alocado.\n");
                }

                if (octeto1 == 127 && octeto2 == 0 && octeto3 == 0 && octeto4 == 1)
                {
                    classifIP.Append("[  OBS  ] Endereço reservado para o localhost.\n");
                }
            }
            else if ((octeto1 >= 128) && (octeto1 <= 191))
            {
                classe = "B";
                mascara = "255.255.0.0";
            }
            else if ((octeto1 >= 192) && (octeto1 <= 223))
            {
                classe = "C";
                mascara = "255.255.255.0";
            }
            else if ((octeto1 >= 224) && (octeto1 <= 239))
            {
                classe = "D";
                classifIP.Append("[  OBS  ] Esta classe é utilizada para Multicasting.\n");
            }
            else if ((octeto1 >= 240) && (octeto1 <= 255))
            {
                classe = "E";
                mascara = "Não definida.";
                classifIP.Append("[  OBS  ] Esta classe é experimental.");

                if ((octeto1 == 255) && (octeto2 == 255) && (octeto3 == 255) && (octeto4 == 255))
                {
                    classifIP.Append("\n[  OBS  ] Este endereço é reservado para broadcasting.\n");
                }
            }

            classifIP.Append($"[CLASSE ] O endereço IPv4 informado pertence à classe {classe}.\n" +
                             $"[MÁSCARA] A máscara de sub-rede desta classe é {mascara}\n");

            Console.WriteLine($"\n{classifIP.ToString()}");
        }
    }
}