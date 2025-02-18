import NoB from "./NoB";

class BuscaProfundidade {

    static preOrdem(no) {
        if (no) {
            console.log(no.valor);
            this.preOrdem(no.filhoEsquerda);
            this.preOrdem(no.filhoDireita);
        } else {
            return;
        }
    }


}

export default BuscaProfundidade;