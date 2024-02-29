var letra = '';

function marianaConta(k) {
    for (var i = 1; i <= k; i++) {
        letra += `Mariana conta ${i} \n`
        letra += `Mariana conta ${i} \n`;
    
        for (var j = 1; j <= i; j++) {
            letra += `é ${j} `;
        }
        letra += `é! \n`;
        letra += `Ana, viva a Mariana, viva a Mariana\n\n`;
    }
    console.log(letra);
}

marianaConta(10)