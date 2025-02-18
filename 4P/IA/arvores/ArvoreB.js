import NoB from "./NoB.js";

class ArvoreB {
    raiz = null;

    constructor(no) {
        if (no instanceof NoB) {
            this.raiz = no;
        } else {
            throw new Error("A raiz deve ser um nó!");
        }
    }
}

export default ArvoreB;