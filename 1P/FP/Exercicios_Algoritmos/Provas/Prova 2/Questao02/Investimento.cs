using System;

namespace Questao02
{
    public class Investimento
    {
        private double valor;
        private int tempoEmMeses;
   
        public double Valor
        {
            get {return valor;}
            set {valor = value;}
        }

        public int TempoEmMeses
        {
            get {return tempoEmMeses;}
            set {tempoEmMeses = value;}
        }
    }
}