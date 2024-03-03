function ehPar(num) {
    return num % 2 == 0;
}

function tocarMusica(k = 10) {
    var letraCompleta = "";
    // Primeira parte.
    for (var i = 1; i <= k; i++) {
        var letra = "";

        if (i == 1 && !ehPar(i)) {
            letra += `${i} elefante incomoda muita gente\n`;
        } else if (i > 1 && !ehPar(i)) {
            letra += `${i} elefantes incomodam muita gente\n`;
        }

        if (ehPar(i)) {
            letra += `${i} elefantes `;
            for (var j = 0; j < i; j++) {
                letra += "incomodam";
                if (j != i - 1) {
                    letra += ", "
                }
            }
            letra += " muito mais\n\n";
        }
        letraCompleta += letra;
    }
    // Segunda parte.
    for (var i = k; i >= 1; i--) {
        var letra = "";

        if (i > 1 && ehPar(i)) {
            letra += `${i} elefantes incomodam muita gente\n`;
        }

        if (!ehPar(i)) {
            if (i == 1) {
                letra += `${i} elefante incomoda muito menos\n`;
            } else {
                letra += `${i} elefantes `;

                for (var j = 1; j <= i; j++) {
                    letra += "incomodam";
                    if (j != i) {
                        letra += ", ";
                    }
                }
                letra += " muito menos\n\n";
            }
        }
        letraCompleta += letra;
    }
    console.log(letraCompleta)
}

tocarMusica(10);