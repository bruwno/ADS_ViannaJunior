using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Revisao
{
    public class ContaPoupanca : Conta
    {
            public override void Sacar(double quantia)
    {
        if (this.saldo < quantia)
            throw new Exception("Saldo insuficiente.");

        this.saldo -= quantia;
    }
    }
}