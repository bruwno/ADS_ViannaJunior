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

        internal static string RetornarClasseIP(int[] endIP)
        {
            StringBuilder classifIP = new StringBuilder();
            int primOcteto = 0, segOcteto = 0, tercOcteto = 0, quartOcteto = 0;

            for (int i = 0; i <= endIP.Length; i++)
            {
                primOcteto = endIP[0];
                segOcteto = endIP[1];
                tercOcteto = endIP[2];
                quartOcteto = endIP[3];
            }

            if ((primOcteto >= 1) && (primOcteto <= 127))
            {
                classifIP.Append("[CLASSE ] O endereço IPv4 informado pertence a classe A.\n" +
                                 "[MÁSCARA] A máscara de sub-rede desta classe é 255.0.0.0\n");

                if ((primOcteto == 0) && (segOcteto == 0) && (tercOcteto == 0) && (quartOcteto == 0))
                {
                    classifIP.Append("[  OBS  ] Endereço reservado para máquinas que ainda não tiveram um IP completamente alocado.");
                }

                if (primOcteto == 127 && segOcteto == 0 && tercOcteto == 0 && quartOcteto == 1)
                {
                    classifIP.Append("[  OBS  ] Endereço reservado para o localhost.");
                }
            }
            else if ((primOcteto >= 128) && (primOcteto <= 191))
            {
                classifIP.Append("[CLASSE ] O endereço IPv4 informado pertence a classe B.\n" +
                                 "[MÁSCARA] A máscara de sub-rede desta classe é 255.255.0.0\n");
            }
            else if ((primOcteto >= 192) && (primOcteto <= 223))
            {
                classifIP.Append("[CLASSE ] O endereço IPv4 informado pertence a classe C.\n" +
                                 "[MÁSCARA] A máscara de sub-rede desta classe é 255.255.255.0\n");
            }
            else if ((primOcteto >= 224) && (primOcteto <= 239))
            {
                classifIP.Append("[CLASSE ] O endereço IPv4 informado pertence a classe D.\n" +
                                 "[  OBS  ] Esta classe é utilizada para Multicasting.");
            }
            else if ((primOcteto >= 240) && (primOcteto <= 255))
            {
                classifIP.Append("[CLASSE ] O endereço IPv4 informado pertence a classe E.\n" +
                                 "[  OBS  ] Esta classe é utilizada para Multicasting.");

                if ((primOcteto == 255) && (segOcteto == 255))
                {
                    classifIP.Append("\n[  OBS  ] Este endereço é reservado para broadcasting.");
                }
            }

            return classifIP.ToString();
        }
    }
}