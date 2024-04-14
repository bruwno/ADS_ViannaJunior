
namespace AgregComp.models
{
    public class Conta
    {
        private double saldo = 0.0;

        private IList<Transacao> transacoes = new List<Transacao>();

        public int Numero { get; set; }
        public double Saldo { get => saldo;}

        public void Depositar(double valor) 
        {
            saldo += valor;
            transacoes.Add(new Transacao
            {
                DataHora = DateTime.Now,
                Valor = valor,
                Tipo = Transacao.ETipo.Credito
            });
        }

        public void Sacar(double valor)
        {
            saldo -= valor;
            transacoes.Add(new Transacao
            {
                DataHora = DateTime.Now,
                Valor = valor,
                Tipo = Transacao.ETipo.Debito
            });
        }
    }
}