class Rastreador {
    constructor(vertice, anterior = null, custoAresta = 0) {
        this.vertice = vertice;
        this.anterior = anterior;
        this.custoAtual = (anterior ? anterior.custoAtual : 0) + custoAresta;
    }

    funcaoAvaliacao() {
        return this.custoAtual + this.vertice.heuristica;
    }
}

export default Rastreador;