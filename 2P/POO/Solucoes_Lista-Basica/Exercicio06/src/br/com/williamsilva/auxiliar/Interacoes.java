package br.com.williamsilva.auxiliar;

public class Interacoes {
    public Interacoes() {}

    public String exibeInformacaoDescontoCarro1000() {
       return "|Concessionária| Carros 1.0 têm 10% de desconto no IPI!\n";
    }

    public String exibeDialogoInteracaoSelecionarModelo() {
        return "Escolha dentre os modelos disponíveis abaixo e personalize o seu carro novo!" +
                "\n* Valor bruto, sem aplicação de taxas. Conferir o valor final." +
                "\nDigite o número [ID] correspondente ao modelo";
    }

    public String exibeDialogoInteracaoEscolherAcessorios(String marca, String modelo) {
        return "\n|ACESSÓRIOS| Vamos escolher os acessórios do seu novo " + marca + " " + modelo +
                "\n(i) Para adicionar um acessório digite [S]im ou [N]ão para ignorar";
    }

    public String exibeDialogoInteracaoEscolherPintura() {
        return "\nEscolha o tipo de pintura do seu carro:" +
                "\n[1] Pintura Especial (R$ 2.500,00)" +
                "\n[2] Pintura Metálica (R$ 2.500,00)" +
                "\n[3] Pintura Comemorativa (R$ 2.500,00)" +
                "\n[4] Manter a Pintura Padrão (Grátis)";
    }
}
