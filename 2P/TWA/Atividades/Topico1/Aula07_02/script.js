const nome = "William";
const idade = 26;
const comidaFavorita = "Lasanha";
let timeDoCoaracao;
let linguagemFavorita;
let filmeFavorito;

var listaDeFilmes = new Array (
    "Star Wars - Uma Nova Esperança",
    "Matrix",
    "O Hobbit - Trilogia",
    "O Senhor dos Anéis - Trilogia"
)

console.log("Exibindo a lista de filmes: ")
for (i = 0; i < listaDeFilmes.length; i++) {
    console.log(listaDeFilmes[i]);
}

/* Tipos de dados em JS
 * Boolean, Number, String
 */
// Descobrindp o tipo da variável

console.log(typeof listaDeFilmes);
