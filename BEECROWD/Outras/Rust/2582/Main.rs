/*
 * Objetivo: Ler dois valores de entrada e retornar a música correspondente à soma desses valores.
 * Autor   : William Silva (https://github.com/bruwno)
 * Data    : 31/01/2024
 * Tipo    : 1 (INICIANTE)
 * ID      : 2582
 * Nome    : System of a Download
 * Link    : https://www.beecrowd.com.br/judge/pt/problems/view/2582
 */

use std::collections::HashMap;
use std::io;

fn main() {
    let mut input = String::new();
    io::stdin().read_line(&mut input).unwrap();
    let c: usize = input.trim().parse().unwrap();

    let mut armazena_somas: Vec<i32> = Vec::with_capacity(c);

    for _ in 0..c {
        let mut xy = String::new();
        io::stdin().read_line(&mut xy).unwrap();
        let xy: Vec<i32> = xy
            .trim()
            .split_whitespace()
            .map(|s| s.parse().unwrap())
            .collect();

        let x = xy[0];
        let y = xy[1];

        let soma = x + y;
        armazena_somas.push(soma);
    }

    exibir_musicas(&armazena_somas);
}

fn exibir_musicas(somas_armazenadas: &Vec<i32>) {
    let mut musicas: Vec<String> = Vec::with_capacity(somas_armazenadas.len());

    for &num in somas_armazenadas {
        musicas.push(retornar_musica(num));
    }

    for musica in musicas {
        println!("{}", musica);
    }
}

fn retornar_musica(num: i32) -> String {
    let musicas: HashMap<i32, &str> = [
        (0, "PROXYCITY"),
        (1, "P.Y.N.G."),
        (2, "DNSUEY!"),
        (3, "SERVERS"),
        (4, "HOST!"),
        (5, "CRIPTONIZE"),
        (6, "OFFLINE DAY"),
        (7, "SALT"),
        (8, "ANSWER!"),
        (9, "RAR?"),
        (10, "WIFI ANTENNAS"),
    ]
    .iter()
    .cloned()
    .collect();

    musicas[&num].to_string()
}