import Vertice from "./Vertice.js";

class Aresta {
    vertices = [];
    nome = "";
    custo = 0;

    constructor(nome, verticeInicial = null, verticeFinal = null, custo) {
        this.nome = nome;
        this.custo = custo;

        if (verticeInicial && verticeFinal && verticeInicial instanceof Vertice && verticeFinal instanceof Vertice) {
            this.vertices = [verticeInicial, verticeFinal];
            verticeInicial.arestas.push(this);
            verticeFinal.arestas.push(this);
        }
    }

    obterVerticeOposto(vertice) {
        if (this.vertices[0] === vertice) {
            return this.vertices[1];
        } else if (this.vertices[1] === vertice) {
            return this.vertices[0];
        }

        return null;
    }
}

export default Aresta;