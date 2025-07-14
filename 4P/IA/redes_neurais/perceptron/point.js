function f(x) {
    return 0.3  * x + 0.2;
}

class Point {
    x = 0;
    y = 0;
    label = 0;
    bias;

    constructor(x, y) {
        this.x = x;
        this.y = y;
        this.label = this.getLabel();
        this.bias = 1;
    }

    getLabel() {
        const lineY = f(this.x);
        if(this.y > lineY) {
            return 1;
        }
        else {
            return -1;
        }
    }

    getPixelX() {
        const px = map(this.x, -1, 1, 0, width); // mapeia o valor que está no intervalo de 0 até a largura da tela.
        return px;
    }

    getPixelY() {
        const py = map(this.y, -1, 1, height, 0); // mapeia o valor que está no intervalo de 0 até a altura da tela.
        return py;
    }

    show() {
        stroke(0); // Cria o contorno do desenho.
        if(this.label === 1) {
            fill(0); // Preenche de preto
        }
        else {
            fill(255); // Senão preenche de branco.
        }
        const px = this.getPixelX();
        const py = this.getPixelY();
        ellipse(px, py, 22, 22);
    }

    debug() {
        console.log(`label: ${this.label} x ${this.x} y ${this.y}`)
    }
}