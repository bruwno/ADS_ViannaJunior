
public class Main
{
    public static void main(String[] args) {
        // DESPESAS
        Despesa desp1 = new Despesa(022024, "Água", 900.0, false);
        // IMÓVEIS
        Apartamento apt1 = new Apartamento(20, 200, "Hermes da Silva", 3);
        Cobertura cbt1 = new Cobertura(30, 340, "Renato Fanti", false, true);
        Casa csa1 = new Casa(357, 400, "Joselito Silva", 510);
        
        Condominio cond = new Condominio();
        cond.setNome("Pentagrama Moradias");
        cond.setEndereco("Rua Dalvo Trombeta, 357");
        cond.addDespesa(desp1);
        cond.addImovel(apt1);
        
        cond.pagarCondominio(apt1, 022024);
        
        System.out.println(cond.valorCondominio(022024));
        System.out.println(cond.relatorio(022024));
    }
}
