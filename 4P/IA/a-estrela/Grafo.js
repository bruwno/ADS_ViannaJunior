import Aresta from "./Aresta.js";
import Vertice from "./Vertice.js";

class Grafo {
    vertices = [];
    arestas = [];

    constructor() { }

    addVertice(valor, heuristica = 0) {
        const vertice = new Vertice(valor, heuristica);
        this.vertices.push(vertice);

        return vertice;
    }

    addAresta(nome, vertice1, vertice2, custo) {
        const aresta = new Aresta(nome, vertice1, vertice2, custo);
        this.arestas.push(aresta);

        return aresta;
    }

    encontrarVertice(valor) {
        return this.vertices.find(v => v.valor === valor);
    }
}

export default Grafo;