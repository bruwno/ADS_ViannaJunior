class ExibeIdade{
    public static void main(String[] args){
        // Tipos primitivos do Java:
        int idade = 26;
        double idadeNoAnoQueVem = idade + 1.0;
        boolean maiorDeIdade = idade > 18;
        char genero = 'M';
        byte mesNascimento = 06;
        short AnoNascimento = 1997;
        long populacaoJF = 650000;
        float valorDoDolarEmReais = 5.00f;

        System.out.println("A idade armazenada e " + idade + " anos.");
        System.out.println("A idade no ano que vem sera " + idadeNoAnoQueVem + " anos.");

        // Verificando se a pessoa e maior de idade.
        if (maiorDeIdade == true){
            System.out.println("Voce e maior de idade.");
        }
        else{
            System.out.println("Voce e menor de idade.");
        }

        // Exibindo o genero da pessoa.
        switch (genero){
            case 'M':
                System.out.println("Voce e do genero masculino.");
                break;
            case 'F':
                System.out.println("Voce e do genero feminino.");
                break;
        }

        // Imprimindo u marray de idades.
        int[] idades = new int[4];
        idades[0] = 15;
        idades[1] = 28;
        idades[2] = 17;
        idades[3] = 19;

        int qtdMaiorDeIdade = 0;
        int qtdMenorDeIdade = 0;
        for (int i = 0; i <= 3; i++){
            int idadeArr = idades[i];

            if (idadeArr > 18){
                qtdMaiorDeIdade++;
            }
            else{
                qtdMenorDeIdade++;
            }
        }
        System.out.println("QTD MAIORES DE IDADE: " + qtdMaiorDeIdade);
        System.out.println("QTD MENORES DE IDADE: " + qtdMenorDeIdade);

    }
}