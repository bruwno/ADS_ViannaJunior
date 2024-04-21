using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Revisao
{
    class ContaCorrente : Conta
    {
        private double limite;
        public double Limite
        {
            get { return limite; }
            set { limite = value; }
        }

        public override void Sacar(double quantia)
        {
            if ((this.saldo + limite) < quantia)
                throw new Exception("Saldo insuficiente.");

            this.saldo -= quantia;
        }
    }
}