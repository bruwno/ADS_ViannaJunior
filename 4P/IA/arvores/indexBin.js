import ArvoreB from "./ArvoreB.js";
import BuscaLagura from "./BuscaLargura.js";
import BuscaProfundidade from "./BuscaProfundidade.js";
import No from "./NoB.js";

const noA = new No("A");
const noB = new No("B");
const noC = new No("C");
const noD = new No("D");
const noE = new No("E");
const noF = new No("F");
const noG = new No("G");
const noH = new No("H");
const noI = new No("I");

const arvore = new ArvoreB(noA);

noA.adicionarFilhoEsquerda(noB);
noA.adicionarFilhoDireita(noC);
noB.adicionarFilhoEsquerda(noD);
noC.adicionarFilhoEsquerda(noE);
noC.adicionarFilhoDireita(noF);
noC.adicionarFilhoDireita(noG);
noE.adicionarFilhoEsquerda(noH);
noE.adicionarFilhoDireita(noI);

console.log(arvore);

BuscaProfundidade.preOrdem();
BuscaProfundidade.inOrdem();
BuscaProfundidade.posOrdem();

BuscaLagura.buscaLargura(noA);