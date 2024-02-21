// Atribua true para a variável darCredito, caso o cliente possua carro e casa e false caso o contrário.
function ehPar(num) {
    return num % 2 == 0;
}

function tocarMusicaPrimeiraParte() {
    // Primeira parte da música.
    for (i = 1; i <= 10; i++) {
        if (i == 1 && ehPar(i) == false) {
            console.log(`${i} elefante incomoda muita gente\n`);
        } else if (i > 1 && ehPar(i) == false) {
            console.log(`${i} elefantes incomodam muita gente\n`);
        }

        cont = 0;
        if (ehPar(i)) {
            console.log(`${i} elefantes`);
            while (cont < i) {
                console.log("incomodam");
                cont++;
            }
            console.log("muito mais\n");
        }
    }
}

function tocarMusicaSegundaParte() {
    // Segunda parte da música.
    for (i = 10; i >= 1; i--) {
        if (i > 1 && ehPar(i)) {
            console.log(`${i} elefantes incomodam muita gente\n`);
        }

        cont = 1;
        if (ehPar(i) == false) {
            if (i == 1) {
                console.log(`${i} elefante incomoda muito menos`);
            } else {
                console.log(`${i} elefantes`);
                while (cont <= i) {
                    console.log("incomodam");
                    cont++;
                }
                console.log("muito menos\n");
            }
        }
    }
}

tocarMusicaPrimeiraParte();
tocarMusicaSegundaParte();