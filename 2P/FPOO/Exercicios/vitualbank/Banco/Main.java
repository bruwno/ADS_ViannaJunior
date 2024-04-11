
public class Main
{
    public static void main(String[] args) {
       ContaBancaria cb;
        cb = new Poupanca("123");
        System.out.println("Deseja criar conta (b)ancaria ou conta (e)especial (p)oupanca");
        String esc = "p";
        
        if (esc.equals("b")) {
            cb = new ContaBancaria("123");
        } else if (esc.equals("e")) {
                cb = new ContaEspecial("123", 1000);
        } else {
                cb = new Poupanca("123");            
        }
            
        cb.depositar(500);
        
        // Verificando se cb e um objeto do tipo Poupanca.
        if (cb instanceof Poupanca) { 
            ((Poupanca)cb).rendimento();
        }
        
        cb.sacar(200);
        cb.sacar(305);
        System.out.println(cb.getSaldo());
    }

}    
