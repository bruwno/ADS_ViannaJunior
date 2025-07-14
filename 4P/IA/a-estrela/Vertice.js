class Vertice {
    valor = "";
    arestas = [];
    heuristica = 0;

    constructor(valor, heuristica = 0) {
        this.valor = valor;
        this.heuristica = heuristica;
    }

    obterVizinhos() {
        const vizinhos = [];
        this.arestas.forEach(aresta => {
            const vizinho = aresta.obterVerticeOposto(this);
            if (vizinho) {
                vizinhos.push({ vertice: vizinho, aresta: aresta });
            }
        });

        return vizinhos;
    }
}

export default Vertice;