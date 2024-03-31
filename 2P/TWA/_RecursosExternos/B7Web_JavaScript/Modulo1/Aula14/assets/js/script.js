// Condicional ==
// Não compara o tipo de dados, apenas o valor.
let idade = "20";

if (idade == 20) {
    console.log("Tipos de dados diferentes <String> e <Number>, valores iguais.");
}

// Condicional ===
// Compara o tipo de dados e o valor, verificação estrita.
function verificaTipoEValor(valor1, valor2) {
    if (valor1 === valor2) {
        console.log("Tipo de dados e valor são iguais.");
    } else {
        console.log("Tipos diferentes, valores iguais.");
    }
}

verificaTipoEValor(20, 20); // Number e Number.
verificaTipoEValor("20", 20); // String e Number.
verificaTipoEValor("20", "20"); // String e String.