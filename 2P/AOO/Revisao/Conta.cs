using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Revisao
{
    public abstract class Conta
    {
        public int Numero
        {
            get { return numero; }
            set
            {
                if (numero < 1000)
                    throw new Exception("Número da conta inválido!");

                numero = value;
            }
        }

        public double Saldo { get { return saldo; } }

        public void Depositar(double quantia)
        {
            this.saldo += quantia;
        }

        public abstract void Sacar(double quantia);

        public void Transferir(double quantia, Conta conta)
        {
            if (this.saldo < quantia)
                throw new Exception("Saldo insuficiente.");

            this.Sacar(quantia);
            conta.Depositar(quantia);
        }

        // COMPOSIÇÃO.
        public void Transferir(double quantia, params Conta[] contas)
        {
            if (this.saldo < (quantia * contas.Length))
                throw new Exception("Saldo insuficiente.");

            this.Sacar(quantia * contas.Length);

            foreach (var conta in contas)
                conta.Depositar(quantia);
        }

        private Pessoa? correntista;
        public Pessoa? Correntista
        {
            get { return correntista; }
            set { correntista = value; }
        }

        private int numero;
        protected double saldo = 0;
    }
}