import NoB from "./NoB.js";

class BuscaLagura {

    static buscaLargura(raiz) {
        if (!raiz) {
            return;
        }

        let fila = [raiz];
        let atual = null;
        while (fila.length > 0) {
            atual = fila.shift();

            console.log(atual.valor);
            
            if (atual.filhoEsquerda) {
                fila.push(atual.filhoEsquerda);
            }

            if (atual.filhoDireita) {
                fila.push(atual.filhoDireita);
            }
        }
    }
}

export default BuscaLagura;