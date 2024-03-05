var frutas = ["Banana", "Maçã", "Pêra", "Uva", "Melância" ];

for (var i = 0; i < frutas.length; i++) {
    if (frutas[i] == "Pêra" ) {
        break;
    }
}

frutas.forEach((fruta) => {
    if (fruta == "Pêra") {
        return;
    }
    console.log(fruta);
});