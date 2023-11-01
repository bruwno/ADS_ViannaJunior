/* Objetivo : Representar um cartão de crédito através de uma classe.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 31/10/2023
 * Material : FP09 (Classes)
 * Slide    : 20
 * Exercício: 01
 */

/* 1) Defina uma classe para representar as informações de um cartão de crédito. 
 * No método principal (Main) da classe Program, instancie dois objetos do tipo da classe criada, 
 * atribua valores a cada atributo dos objetos e imprima todos os atributos do segundo objeto instanciado.
 */

 using System;
 
 namespace CartaoCred
 {
    public class CartaoCredito
    {
        private long numCartao;
        private string titular;
        private int codSeg;
        private string dataExp;
        private string bandeira;

        public string Titular
        {
            get => titular;
            set => titular = value;
        }

        public long NumeroCartao
        {
            get => numCartao;
            set => numCartao = value;
        }

        public int CodSeg
        {
            get => codSeg;
            set => codSeg = value;
        }

        public string DataExpiracao  
        {
            get => dataExp;
            set => dataExp = value;
        }

        public string Bandeira
        {
            get => bandeira;
            set => bandeira = value;
        }

        public void ExibirDadosCartao()
        {
            Console.WriteLine("Informações do Cartão de Crédito\n");
            Console.WriteLine($"Titular    : {Titular}");
            Console.WriteLine($"Nº Cartão  : {NumeroCartao}");
            Console.WriteLine($"Cód. de Seg: {CodSeg}");
            Console.WriteLine($"Data Expir.: {DataExpiracao}");
            Console.WriteLine($"Bandeira   : {Bandeira}");
        }
        
    }
 }