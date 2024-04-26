namespace Revisao;

class Program
{
    static void Main(string[] args)
    {
        // Classes e Objetos
        // Atributos e Encapsulamento (Controle de Estado)
        // Operações - Métodos (Ações Disponíveis)
        // Associações - Agregação - Composição (Estado Quando Relacionado a Tipo Importante)
        // Herança
        // Sobrescrita ou Sobreposição
        // Sobrecarga
        // Polimorfismo
        // Classes e métodos abstratos

        var c1 = new ContaCorrente();
        var c2 = new ContaCorrente();
        var p1 = new Pessoa();
        p1.Nome = "Ana";
        p1.Email = "ana@email.com";

        c1.Depositar(1000);
        Sacar(c1);
        c1.Transferir(100, c2);
        c1.Correntista = p1;

        Console.WriteLine($"Saldo: {c1.Saldo:C2}");
    }

    static void Sacar(Conta c)
    {
        Console.Write("Informe o valor do saque: ");
        c.Sacar(Convert.ToDouble(Console.ReadLine()));
    }

}
