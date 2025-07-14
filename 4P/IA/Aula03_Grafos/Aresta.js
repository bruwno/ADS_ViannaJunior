import Vertice from "./Vertice";

class Aresta{
    vertices = [];
    nome = "";
    custo = 0;

    constructor(verticeInicial = null, verticeFinal = null, custo){
        this.nome = nome;
        this.custo = custo;

        if(verticeInicial && verticeFinal
            && verticeInicial instanceof Vertice
            && verticeFinal instanceof Vertice){
            this.vertices = [verticeInicial,verticeFinal];
            verticeInicial.aresta.push(this);
            verticeFinal.aresta.push(this);
        }      
    }
}

export default Aresta;
