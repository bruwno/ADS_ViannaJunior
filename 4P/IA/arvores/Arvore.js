import No from "./No";

class Arvore {
    raiz = null;

    constructor(no) {
        if (no instanceof No) {
            this.raiz = no;
        } else {
            throw new Error("A raiz deve ser um nó!");
        }
    }
}

export default Arvore;