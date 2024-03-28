namespace EXC02;

class Program
{
    static void Main(string[] args)
    {
        Console.WriteLine(SomaParesEntre(1, 5));
    }
    
    static int SomaParesEntre(int min, int max)
    {
        return SomaParesEntre(min, max, 0);
    }


    static int SomaParesEntre(int min, int max, int soma)
    {
        if (min > max) 
        {
            return soma;
        }
        if (min % 2 == 0)
        {
            soma += min;
        }
        return SomaParesEntre(min + 1, max, soma);
    }
    

    // Outra forma de resolver.
    static int SomaParesEntre(int min, int max)
    {
        if (min > max)
        {
            return 0;
        }
        return (min % 2 == 0 ? min : 0) + SomaParesEntre(min + 1, max);
    }
}
