class Perceptron {
    weights;
    lr = 0.1; // Quanto mais próximo de 0 mais suave é o ajuste.

    constructor(numberWeights) {
        this.weights = new Array(numberWeights);
        this.weights.forEach((_, i) => {
            this.weights[i] = random(-1,1);
        });
    }

    train(inputs, target) {
        const guess = this.guess(inputs);
        const error = target - guess;

        for (let i = 0; i < this.weights.length; i++) {
            // lr é o Leanring Rate. Isso resolve o problema de over shoot.
            this.weights[i] += error * inputs[i] * this.lr;
        }
    }


    guess(inputs){
        let sum = 0;

        this.weights.forEach((weight, i) => {
            sum =+ weight * inputs[i];
        });

        return sign(sum);
    }
}

function sign(num) {
    return num >= 0 ? +1 : -1;
}