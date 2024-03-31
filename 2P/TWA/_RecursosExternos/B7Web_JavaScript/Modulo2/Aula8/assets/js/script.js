/*
 Calcule o preço do imóvel
 - m² = 3.000
 - Se tiver 1 quarto, o m² é 1x;
 - Se tiver 2 quartos, o m² é 1.2x;
 - Se tiver 3 quartos, o m² é 1.5x.
 */

function calcularMetragem(metragem, qtdQuartos) {
    let m2 = 3000;
    let preco = 0;

    switch (qtdQuartos) {
        case 1:
            preco = metragem * m2;
            break;
        case 2:
            preco = metragem * (m2 * 1.2);
            break;
        case 3:
            preco = metragem * (m2 * 1.5);
            break;
        default:
            preco = metragem * m2;
            break;
    }
    return preco;
}

let metragem = 123;
let qtdQuartos = 1;

let preco = calcularMetragem(metragem, qtdQuartos);
console.log(`A casa custa R$ ${preco}`);