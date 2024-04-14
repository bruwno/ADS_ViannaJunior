
namespace AgregComp.models
{
    public class Transacao
    {
        private DateTime dataHora;
        private double valor;

        public DateTime DataHora { get => dataHora; set => dataHora = value; }
        public double Valor { get => valor; set => valor = value; }
        public ETipo Tipo { get; set; }

        public enum ETipo
        {
            Credito = 0,
            Debito = 1
        }
    }
}