// Interaja com um loop nas frutas abaixo e pare ao encontrar Pera

var frutas = ["Banana", "Maçã", "Pêra", "Uva", "Melância"];

// Opção 1

for (var i = 0; i < frutas.length; i++) {
    if (frutas[i] == "Pêra") {
        break;
    }
}

// Opção 2
var encontrou = false;
frutas.forEach((fruta) => {
    if (!encontrou) {
        if (fruta === "Pêra") {
            encontrou = true;
        } else {
            console.log(fruta);
        }
    }
});