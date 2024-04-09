
namespace EXC06_Apostila;

public class Produto
{
    private int codigo;
    private string descricao;
    private double preco;

    public Produto(int codigo, string descricao, double preco)
    {
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco = preco;
    }

    public int Codigo { get => codigo; set => codigo = value; }

    public string Descricao { get => descricao; set => descricao = value; }

    public double Preco { get => preco; set => preco = value; }

    public override string ToString()
    {
        return ($"#{Codigo} \t| {Descricao} \t| R$ {Preco:F2}");
    }
}