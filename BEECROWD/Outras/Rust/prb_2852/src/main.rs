/*
 * Objetivo: Ler dois valores de entrada e retornar a música correspondente à soma desses valores.
 * Autor   : William Silva (https://github.com/bruwno)
 * Data    : 31/01/2024
 * Tipo    : 1 (INICIANTE)
 * ID      : 2582
 * Nome    : System of a Download
 * Link    : https://www.beecrowd.com.br/judge/pt/problems/view/2582
 */

use std::io;

fn main() {
    let mut input = String::new();
    io::stdin()
        .read_line(&mut input)
        .expect("Erro ao ler entrada.");

    // Quantidade de testes que serão executados.
    let c: usize = input
        .trim()
        .parse()
        .expect("Ocorreu uma falha ao converter a primeira linha. Verifique se foram informados apena caracteres numéricos.");

    /*
    Devem ser informados dois valores para preencher o array, exemplo: 1 9
    */
    for _ in 0..c {
        let mut xy = String::new();
        io::stdin()
            .read_line(&mut xy)
            .expect("Erro ao ler os valores");

        let valores: Vec<i32> = xy
            .split_whitespace()
            .map(|s| s.parse().expect("Falha ao converter um dos números."))
            .collect();

        if valores.len() == 2 {
            let soma = valores[0] + valores[1];
            println!("{}", retornar_musica(soma as usize))
        }
    }
}

fn retornar_musica(num: usize) -> &'static str {
    let musicas = [
        "PROXYCITY",
        "P.Y.N.G.",
        "DNSUEY!",
        "SERVERS",
        "HOST!",
        "CRIPTONIZE",
        "OFFLINE DAY",
        "SALT",
        "ANSWER!",
        "RAR?",
        "WIFI ANTENNAS",
    ];

    musicas[num]
}
