/* Objetivo : Guardar dados de contato.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 01/11/2023
 * Material : FP09 (Classes)
 * Slide    : 21
 * Exercício: 04
 */

/* 4) Faça um programa (método principal) para leitura, via teclado, dos dados de um contato de telefone.
 * Os dados a serem guardados na classe Contato são os seguintes: nome, endereço (logradouro, número, complemento, bairro, cidade,
 * UF), telefone e e-mail. Ao final, imprima estas informações na tela.
 */

 using System;

 namespace GuardarContatos
 {
    public class Contato
    {
        public string Nome;
        public Endereco Endereco;
        public long Telefone;
        public string Email;
    }
 }