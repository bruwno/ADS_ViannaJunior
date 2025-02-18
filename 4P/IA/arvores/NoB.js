class NoB {
    valor = "";
    filhoEsq = null;
    filhoDir = null;

    constructor(valor) {
        this.valor = valor;
    }

    adicionarFilhoEsquerda(no) {
        if (no instanceof NoB) {
            this.filhoEsq = no;
        } else {
            throw new Error("O filho deve ser um nó.");
        }
    }

    adicionarFilhoDireita(no) {
        if (no instanceof NoB) {
            this.filhoDir = no;
        } else {
            throw new Error("O filho deve ser um nó.");
        }
    }
}

export default NoB;