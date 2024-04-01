// Chamando funções dentro de outras funções.

function addNumbers(a, b) {
    const squareRoot = x => x * x; //Arrow function para simplificar.
    return squareRoot(a) + squareRoot(b);
}

console.log(`Somas das Raízes: ${addNumbers(2, 2)}`);